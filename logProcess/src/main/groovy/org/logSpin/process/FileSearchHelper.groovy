package org.logSpin.process

import org.logSpin.Request
import org.logSpin.Response

@SuppressWarnings("unused")
class FileSearchHelper {
    static Response search(logPath, object) {
        def keys = object[0]
        def response = new Response()
        def fileWriter = new FileWriter("report.txt")
        try {
            logPath.each { path ->
                File file = new File(path as String)
                file.eachLine {
                    line ->
                        String value = checkOnce(keys as ArrayList<Request>, line)
                        if (value != null) {
                            fileWriter.write(value)
                            fileWriter.append("\n")
                            fileWriter.flush()
                        }
                }
            }
        } finally {
            fileWriter.close()
        }
        return response
    }

    static String checkOnce(ArrayList<Request> keys, String line) {
        Request r = keys.find {
            if (!it.isValued() && line.contains(it.getKey())) {
                it.setValued(true)
                return true
            }
        }
        return r == null ? null : getValue(line, r.getKey())
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

