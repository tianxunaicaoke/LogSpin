package org.logSpin.process

import org.logSpin.Observable
import org.logSpin.Request
import org.logSpin.Response

@SuppressWarnings("unused")
class FileInfoHelper {
    static def search(logPath, object) {
        def keys = object[0] as List<Request>
        def observable = object[1] as Observable<Response>
        FileUtil.forEachLineOfFile(keys, observable, logPath) {
            line, r ->
                def response = null
                if (r) {
                    response = new Response()
                    response.key = r.getKey()
                    response.value = FileUtil.getValue(line, r.getKey())
                }
                return response
        }
    }
}

