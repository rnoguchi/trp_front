package jp.nr.trp.front.handler.security

import jp.nr.trp.front.constants.ApplicationConstants
import jp.nr.trp.front.entity.TMember
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

        var session = request.getSession(true)
        var tMember = TMember()
        session.setAttribute(ApplicationConstants.SESSION_KEY_USER, tMember)

        response.sendRedirect(request.contextPath + "/journey/list")
    }
}