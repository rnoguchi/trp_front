package jp.nr.trp.front.controller.view.journey

import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.form.journey.DetailForm
import jp.nr.trp.front.service.entity.TJourneyService
import jp.nr.trp.front.service.logic.JourneyLogicService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession
import javax.validation.Valid

@Controller
@RequestMapping("/journey")
class DetailController(
        var session: HttpSession,
        val tJourneyService: TJourneyService,
        val journeyLogicService: JourneyLogicService
) {

    @RequestMapping("/detail")
    fun detail(@ModelAttribute detailForm: DetailForm, result: BindingResult, model: Model): String {

        if (result.hasErrors()) {
            return "journey/detail"
        }

        if (!StringUtils.isEmpty(detailForm.id)) {
            var entity: TJourney? = tJourneyService.selectById(detailForm.id.toLong())
            if (entity != null) {
                detailForm.id = entity.id.toString()
                detailForm.title = entity.title
                detailForm.description = entity.description
            }
        }

        return "journey/detail"
    }

    @PostMapping("/detail/update")
    fun update(@AuthenticationPrincipal userDetails: UserDetails
               , @ModelAttribute @Valid detailForm: DetailForm
               , result: BindingResult, model: Model): String {

        if (result.hasErrors()) {
            return detail(detailForm, result, model)
        }

        journeyLogicService.updateJournery(detailForm, userDetails, session)

        return "redirect:/journey/list"
    }
}