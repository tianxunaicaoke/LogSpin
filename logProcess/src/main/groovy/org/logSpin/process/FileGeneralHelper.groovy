package org.logSpin.process

import org.logSpin.Observable
import org.logSpin.Request
import org.logSpin.Response

@SuppressWarnings("unused")
class FileGeneralHelper {
    static def findLine(logPath, object) {
        def keys = object[0] as List<Request>
        def observable = object[1] as Observable<Response>
        FileUtil.forEachLineOfFile(logPath, keys, FileUtil.&checkAllByRegex, observable) {
            line, r ->
                def response = null
                if (r) {
                    response = new Response()
                    response.key = r.getKey()
                    response.value = line
                }
                return response
        }
    }

    static def findLine(logPath, List<Observable<String>> observables) {
        FileUtil.forEachLineOfFile(logPath,observables)
    }
}
