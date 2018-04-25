package jp.nr.trp.front.service.entity

import jp.nr.trp.front.entity.TJourneyTimeline
import jp.nr.trp.front.repository.TJourneyTimelineRepository
import org.springframework.stereotype.Service

@Service
class TJourneyTimelineService(
        val tJourneyTimelineRepository: TJourneyTimelineRepository
) {

    fun selectTimelineByJourneyId(journeyId: Long): MutableList<TJourneyTimeline> {
        return tJourneyTimelineRepository.selectTimelineByJourneyId(journeyId)
    }

    fun selectById(id: Long): TJourneyTimeline {
        return tJourneyTimelineRepository.selectById(id)
    }

    fun insert(entity: TJourneyTimeline): TJourneyTimeline {
        tJourneyTimelineRepository.insert(entity)
        return entity;
    }

    fun update(entity: TJourneyTimeline): TJourneyTimeline {
        tJourneyTimelineRepository.update(entity)
        return entity;
    }
}