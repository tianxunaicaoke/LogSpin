package org.logSpin.process

import org.logSpin.Observable
import org.logSpin.Response

class FileUtil {

    /**
     * To check if the line contain one of the keys, Then set key to already found.
     * @param keys
     * @param line
     * @param action
     * @return Response
     */
    static Response checkOnce(keys, line, action) {
        def r = keys.find {
            if (!it.isAlreadyFound() && (line.contains(it.getKey()) || line ==~ it.key)
                    && (it.getVariant() == null || it.getVariant() != null && line.contains(it.getVariant()))) {
                it.setAlreadyFound(true)
                return true
            }
        }
        action(line, r)
    }

    /**
     * To check if the line contain one of the keys.
     * @param keys
     * @param line
     * @param action
     * @return Response
     */
    static Response checkAllByRegex(keys, line, action) {
        def r = keys.find {
            line ==~ it.key
        }
        action(line, r)
    }

    /**
     * To check if the line contain one of the keys.
     * @param keys
     * @param line
     * @param action
     * @return Response
     */
    static Response checkAll(keys, line, action) {
        def r = keys.find {
            (line.contains(it.key) || line ==~ it.key) && line.contains(it.variant)
        }
        action(line, r)
    }

    /**
     * To check if the line contain the keys.
     * @param keys
     * @param line
     * @param action
     * @return Response
     */
    static List<Response> checkAlls(keys, line, action) {
        List<Response> responses = new ArrayList<>();
        keys.forEach{
            if((line.contains(it.key) || line ==~ it.key) && line.contains(it.variant)){
                responses.add(action(line,it))
            }
        }
        if(responses.isEmpty())
            null
        else
            responses
    }

    /**
     * Check the file under the logPath, find the line match the request, then invoke action, and notify to invoker.
     * @param logPath
     * @param keys
     * @param check
     * @param observable
     * @param action
     * @return
     */
    static def forEachLineOfFile(logPath, keys, check, observable, action) {
        logPath.each {
            path ->
                File file = new File(path as String)
                file.eachLine {
                    line, number ->
                        def value = check(keys, line, action)
                        if (value instanceof Response) {
                            observable.next(value)
                        }else if(value instanceof ArrayList){
                            value.forEach({ it -> observable.next(it) })
                        }
                        value
                }
        }
    }

    static def forEachLineOfFile(logPath, List<Observable<String>> observables) {
        logPath.each {
            path ->
                File file = new File(path as String)
                file.eachLine {
                    line, number ->
                        observables.each {
                            observable -> observable.next(line)
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

    /**
     * Use regex to get the first data behind the key
     * @param line
     * @param key
     * @return value
     */
    static String getData(line, key) {
        getValue(line,key).find("[0-9\\.]*");
    }
}
