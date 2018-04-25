package jp.nr.trp.front.controller.view.journey

import jp.nr.trp.front.dto.TimelineDto
import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.form.journey.DetailForm
import jp.nr.trp.front.service.entity.TJourneyService
import jp.nr.trp.front.service.entity.TJourneyTimelineService
import jp.nr.trp.front.service.logic.JourneyLogicService
import jp.nr.trp.front.service.logic.JourneyTimelineLogicService
import jp.nr.trp.front.util.TrpDateUtil
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.CollectionUtils
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
        val journeyLogicService: JourneyLogicService,
        val tJourneyTimelineService: TJourneyTimelineService,
        val journeyTimelineLogicService: JourneyTimelineLogicService
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


                val journeyTimelineList = tJourneyTimelineService.selectTimelineByJourneyId(entity.id)
                journeyTimelineList.stream().forEach {entity ->
                    var formDto = TimelineDto()
                    formDto.id = entity.id.toString()
                    formDto.journeyId = entity.journeyId.toString()
                    formDto.title = entity.title
                    formDto.description = entity.description
                    formDto.startDate = TrpDateUtil.dateFormatYYYYMMDDHHmmss.format(entity.startDate)
                    formDto.endDate = TrpDateUtil.dateFormatYYYYMMDDHHmmss.format(entity.endDate)
                    detailForm.timelineList.add(formDto)
                }
            }
        }

        if (CollectionUtils.isEmpty(detailForm.timelineList)) {
            var emptyDto = TimelineDto()
            detailForm.timelineList.add(emptyDto)
        }

        return "journey/detail"
    }

    @PostMapping("/detail/update")
    fun update(@AuthenticationPrincipal userDetails: UserDetails?
               , @ModelAttribute @Valid detailForm: DetailForm
               , result: BindingResult, model: Model): String {

        if (result.hasErrors()) {
            return detail(detailForm, result, model)
        }

        journeyLogicService.updateJournery(detailForm, userDetails, session)

        journeyTimelineLogicService.updateJournery(detailForm, userDetails, session)

        return "redirect:/journey/list"
    }
}