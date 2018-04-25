package jp.nr.trp.front.service.logic

import jp.nr.trp.front.constants.ApplicationConstants
import jp.nr.trp.front.entity.TMember
import org.springframework.security.core.userdetails.UserDetails
import javax.servlet.http.HttpSession

open class BaseLogicService() {
    fun getUserId(session: HttpSession, userDetails: UserDetails?): String {
        val guest = session.getAttribute(ApplicationConstants.SESSION_KEY_USER)
        if (userDetails != null) {
            return userDetails.username;
        } else if (guest is TMember) {
            return guest.loginId;
        }
        throw Exception("illegal session");
    }
}