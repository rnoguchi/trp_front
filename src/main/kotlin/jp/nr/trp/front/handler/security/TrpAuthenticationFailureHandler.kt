package jp.nr.trp.front.handler.security

import jp.nr.trp.front.constants.Messages
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TrpAuthenticationFailureHandler : AuthenticationFailureHandler {

    @Override
    override fun onAuthenticationFailure(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            exception: AuthenticationException?) {

        if (request == null || response == null) {
            throw Exception("request or response is null")
        }

        var errorId = ""
        if (exception is BadCredentialsException) {
            errorId = Messages.LOGIN_ERROR
        }

        response.sendRedirect(request.contextPath + "/login-error")
    }
}