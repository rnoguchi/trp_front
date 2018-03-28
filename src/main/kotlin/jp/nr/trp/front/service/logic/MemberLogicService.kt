package jp.nr.trp.front.service.logic

import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.service.entity.TMemberService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import javax.servlet.http.HttpSession

@Service
class MemberLogicService (
        val tMemberService: TMemberService
) {

    fun getMember(session: HttpSession, userDetails: UserDetails): TMember? {
        val tmpLSession = session.getAttribute("tmpLoginId")
        if (userDetails == null && tmpLSession == null) {
            return null
        }

        var member: TMember? = null
        if (userDetails != null) {
            member = tMemberService.selectByLoginId(userDetails.username)
        } else if (tmpLSession is TMember) {
            member = tMemberService.selectByTmpLoginId(tmpLSession.loginId)
        }
        return member
    }
}