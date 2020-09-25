package org.logSpin.process

import java.lang.reflect.Array

@SuppressWarnings("unused")
class InfoFileSearchHelper {
    static def search(SearchBean searchBean) {
        searchBean.getPath().each { path ->
            File file = new File(path)
            file.filterLine {
                line ->
                    any(searchBean.getKeys(), line)
            }.writeTo(new FileWriter("report.txt"))
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