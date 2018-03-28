package jp.nr.trp.front.controller.view.journey

import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.service.logic.JourneyLogicService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.CollectionUtils
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/journey")
class ListController(
        var session: HttpSession,
        val journeyLogicService: JourneyLogicService
) {

    @RequestMapping("/list")
    fun list(@AuthenticationPrincipal userDetails: UserDetails, model: Model): String {

        val journeyList: List<TJourney>? = journeyLogicService.getJourneyList(session, userDetails)

        if (CollectionUtils.isEmpty(journeyList)) {
            return "redirect:/journey/detail";
        }

        model.addAttribute("journeyList", journeyList)

        return "journey/list";
    }
}