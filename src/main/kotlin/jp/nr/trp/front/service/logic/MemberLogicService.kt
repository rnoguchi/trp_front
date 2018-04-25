package jp.nr.trp.front.service.logic

import jp.nr.trp.front.constants.ApplicationConstants
import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.service.entity.TMemberService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import javax.servlet.http.HttpSession

@Service
class MemberLogicService (
        val tMemberService: TMemberService
) : BaseLogicService() {

    fun getMember(session: HttpSession, userDetails: UserDetails?): TMember? {
        val guest = session.getAttribute(ApplicationConstants.SESSION_KEY_USER)
        if (userDetails != null) {
            return tMemberService.selectByLoginId(userDetails.username)
        } else if (guest is TMember) {
            return tMemberService.selectByLoginId(guest.loginId)
        }
        throw Exception("not exists user")
    }
}