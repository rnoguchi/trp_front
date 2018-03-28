package jp.nr.trp.front.handler.security

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TrpAuthenticationSuccessHandler : AuthenticationSuccessHandler {

    @Override
    override fun onAuthenticationSuccess(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            authentication: Authentication?) {

        if (request == null || response == null) {
            throw Exception("request or response is null")
        }

        response.sendRedirect(request.contextPath + "/journey/list")
    }
}