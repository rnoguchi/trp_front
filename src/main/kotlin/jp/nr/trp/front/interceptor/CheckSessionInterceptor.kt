package jp.nr.trp.front.interceptor

import jp.nr.trp.front.annotation.NonAuth
import jp.nr.trp.front.constants.ApplicationConstants
import jp.nr.trp.front.entity.TMember
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CheckSessionInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        // 静的コンテンツは検査しない
        if (handler is ResourceHttpRequestHandler) {
            return true;
        }

        val hm = handler as HandlerMethod
        val method = hm.method
        val annotation = method.getAnnotation(NonAuth::class.java)
        if (annotation != null) {
            return true
        }

        var session = request.getSession()
        val sessionObj: Any? = session.getAttribute(ApplicationConstants.SESSION_KEY_USER)
        if (sessionObj == null || sessionObj !is TMember || StringUtils.isEmpty(sessionObj.loginId)) {
            response.sendRedirect("/menu")
        }
        return true
    }
}