package org.logSpin.process

@SuppressWarnings("unused")
class InfoFileSearchHelper {
    static def search(logPath, object) {
        def keys = object[0]
        def fileWriter = new FileWriter("report.txt")
        logPath.each { path ->
            File file = new File(path)
            file.filterLine {
                line ->
                    any(keys, line)
            }.writeTo(fileWriter)
        }
    }

    /**
     * If line contain any of the keys, then return true, and remove the key form keys
     * @param keys
     * @param line
     * @return whether line contain any of the keys
     */
    static boolean any(ArrayList<String> keys, String line) {
        def needRemove = null
        keys.any {
            if (line.contains(it)) {
                needRemove = it
            }
        }
        if (needRemove != null) {
            keys.remove needRemove
        }
    }
}

new InfoFileSearchHelper()