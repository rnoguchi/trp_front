package jp.nr.trp.front.controller.view.journey

import jp.nr.trp.front.annotation.NonAuth
import jp.nr.trp.front.constants.ApplicationConstants
import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.repository.TMemberRepository
import jp.nr.trp.front.service.logic.JourneyLogicService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.CollectionUtils
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/journey")
class ListController(
        var session: HttpSession,
        val journeyLogicService: JourneyLogicService,
        val tMemberRepository: TMemberRepository
) {

    @NonAuth
    @RequestMapping("/list")
    fun list(@AuthenticationPrincipal userDetails: UserDetails?, model: Model): String {

        if (userDetails == null) {
            val guestMember = session.getAttribute(ApplicationConstants.SESSION_KEY_USER)
            if (guestMember == null) {
                genGuestSession()
            }
        }

        val journeyList: List<TJourney>? = journeyLogicService.getJourneyList(session, userDetails)

        if (CollectionUtils.isEmpty(journeyList)) {
            return "redirect:/journey/detail";
        }

        model.addAttribute("journeyList", journeyList)

        return "journey/list";
    }

    private fun genGuestSession() {
        var tMember = TMember()
        tMember.loginId = UUID.randomUUID().toString()
        tMember.nickname = ApplicationConstants.GUEST_NAME
        tMemberRepository.insert(tMember)
        session.setAttribute(ApplicationConstants.SESSION_KEY_USER, tMember)
    }
}