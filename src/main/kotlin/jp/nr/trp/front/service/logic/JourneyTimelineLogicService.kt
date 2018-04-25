package jp.nr.trp.front.service.logic

import jp.nr.trp.front.dto.TimelineDto
import jp.nr.trp.front.entity.TJourneyTimeline
import jp.nr.trp.front.form.journey.DetailForm
import jp.nr.trp.front.service.entity.TJourneyTimelineService
import jp.nr.trp.front.util.TrpDateUtil
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.time.LocalDateTime
import javax.servlet.http.HttpSession

@Service
class JourneyTimelineLogicService (
        val tJourneyTimelineService: TJourneyTimelineService
) : BaseLogicService() {

    fun updateJournery(detailForm: DetailForm, userDetails: UserDetails?, session: HttpSession): MutableList<TJourneyTimeline>? {

        if (CollectionUtils.isEmpty(detailForm.timelineList)) {
            return null
        }

        val entityList = tJourneyTimelineService.selectTimelineByJourneyId(detailForm.id.toLong())
        detailForm.timelineList.forEach { form ->
            var isUpdated = false
            entityList.forEach { entity ->
                if (entity.journeyId == form.journeyId.toLong()) {
                    isUpdated = true
                    tJourneyTimelineService.update(convertEntity(entity, form))
                }
            }
            if (!isUpdated) {
                var entity = TJourneyTimeline();
                entity.journeyId = detailForm.id.toLong()
                tJourneyTimelineService.insert(convertEntity(entity, form))
            }
        }
        return tJourneyTimelineService.selectTimelineByJourneyId(detailForm.id.toLong())
    }

    private fun convertEntity(entity: TJourneyTimeline, form: TimelineDto): TJourneyTimeline {
        entity.title = form.title
        entity.description = form.description
        entity.startDate = LocalDateTime.parse(form.startDate, TrpDateUtil.dateFormatYYYYMMDDHHmmss)
        entity.endDate = LocalDateTime.parse(form.endDate, TrpDateUtil.dateFormatYYYYMMDDHHmmss)
        return entity
    }
}