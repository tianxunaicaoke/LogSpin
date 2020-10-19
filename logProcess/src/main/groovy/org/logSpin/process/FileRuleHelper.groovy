package org.logSpin.process

import org.logSpin.Observable
import org.logSpin.Request
import org.logSpin.Response

@SuppressWarnings("unused")
class FileRuleHelper {
    static def findExist(logPath, object) {
        def keys = object[0] as List<Request>
        def observable = object[1] as Observable<Response>
        FileUtil.forEachLineOfFile(logPath, keys, FileUtil.&checkOnce, observable) {
            line, r ->
                def response = null
                if (r) {
                    response = new Response()
                    response.key = r.getKey()
                    response.exist = true
                }
                return response
        }
    }
}
