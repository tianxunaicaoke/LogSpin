package org.logSpin.process

import org.logSpin.Request
import org.logSpin.Response

class FileUtil {

    /**
     * To check if the line contain one of the keys, Then set key to already found.
     * @param keys
     * @param line
     * @return Response
     */
    static Response checkOnce(keys, line, action) {
        Request r = keys.find {
            if (!it.isAlreadyFound() && line.contains(it.getKey())) {
                it.setAlreadyFound(true)
                return true
            }
        }
        action(line, r)
    }

    /**
     * Check the file under the logPath, find the line match the request, then invoke action, and notify to invoker.
     * @param keys
     * @param observable
     * @param logPath
     * @param action
     * @return
     */
    static def forEachLineOfFile(keys, observable, logPath, action) {
        logPath.each {
            path ->
                File file = new File(path as String)
                file.eachLine {
                    line ->
                        def value = checkOnce(keys, line, action)
                        if (value) {
                            observable.next(value)
                        }
                }
        }
    }

    /**
     * Use regex to get the first value behind the key
     * @param line
     * @param key
     * @return value
     */
    static String getValue(line, key) {
        line.replace(key, "@")
                .find("[@].*")
                .replace("@", "")
                .replace(":", "")
                .find("[^ ].*")
                .find("[^ ]*")
    }
}
