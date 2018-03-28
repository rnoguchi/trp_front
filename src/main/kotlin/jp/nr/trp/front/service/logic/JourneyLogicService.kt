package jp.nr.trp.front.service.logic

import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.form.journey.DetailForm
import jp.nr.trp.front.service.entity.TJourneyService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import javax.servlet.http.HttpSession

@Service
class JourneyLogicService(
        val tJourneyService: TJourneyService,
        val memberLogicService: MemberLogicService
) {

    fun getJourneyList(session: HttpSession, userDetails: UserDetails): List<TJourney>? {
        val tmpLSession = session.getAttribute("tmpLoginId")
        if (userDetails == null && tmpLSession == null) {
            return null
        }

        var journeyList: List<TJourney>? = null
        if (userDetails != null) {
            journeyList = tJourneyService.selectMyJourneryByLoginId(userDetails.username)
        } else if (tmpLSession is TMember) {
            journeyList = tJourneyService.selectMyJourneryByTmpLoginId(tmpLSession.loginId)
        }

        return journeyList
    }

    fun updateJournery(detailForm: DetailForm, userDetails: UserDetails, session: HttpSession): TJourney {

        var entity: TJourney? = null
        if (!StringUtils.isEmpty(detailForm.id)) {
            entity = tJourneyService.selectById(detailForm.id.toLong())
        }

        var isUpdate = true;

        // 新規登録
        if (entity == null) {
            entity = TJourney()
            isUpdate = false
            var member: TMember? = memberLogicService.getMember(session, userDetails) ?: throw Exception("not exists member")
            entity.memberId = member?.id
        }

        entity.title = detailForm.title
        entity.description = detailForm.description

        if (isUpdate) {
            tJourneyService.update(entity)
        } else {
            tJourneyService.insert(entity)
        }

        return entity
    }
}