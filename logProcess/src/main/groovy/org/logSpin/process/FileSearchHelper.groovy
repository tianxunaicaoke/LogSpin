package org.logSpin.process

import org.logSpin.Request
import org.logSpin.Response

@SuppressWarnings("unused")
class InfoFileSearchHelper {
    static Response search(logPath, object) {
        def keys = object[0]
        def fileWriter = new FileWriter("report.txt")
        def response  = new Response()
        logPath.each { path ->
            File file = new File(path)
            file.filterLine {
                line -> any(keys, line)
            }.writeTo(fileWriter)
        }
        return response
    }

    static boolean any(ArrayList<Request> keys, String line) {
        keys.any {
            if (!it.isValued() && line.contains(it.getKey())) {
                it.setValue(getValue(line, it.getKey()))
                it.setValued(true)
                return true
            }
        }
    }

    static String getValue(String line, key) {
        line.replace(key, "@")
                .find("[@].*")
                .replace("@", "")
                .replace(":", "")
                .find("[^ ].*")
                .find("[^ ]*")
    }
}

new InfoFileSearchHelper()