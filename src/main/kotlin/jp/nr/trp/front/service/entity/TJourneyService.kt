package jp.nr.trp.front.service.entity

import jp.nr.trp.front.entity.TJourney
import jp.nr.trp.front.repository.TJourneyRepository
import org.springframework.stereotype.Service

@Service
class TJourneyService(
        val tJourneyRepository: TJourneyRepository
) {

    fun selectMyJourneryByLoginId(loginId: String): List<TJourney> {
        return tJourneyRepository.selectMyJourneyByLoginId(loginId)
    }

    fun selectMyJourneryByTmpLoginId(tmpLoginId: String): List<TJourney> {
        return tJourneyRepository.selectMyJourneyByTmpLoginId(tmpLoginId)
    }

    fun selectById(id: Long): TJourney {
        return tJourneyRepository.selectById(id)
    }

    fun insert(entity: TJourney): TJourney {
        tJourneyRepository.insert(entity)
        return entity;
    }

    fun update(entity: TJourney): TJourney {
        tJourneyRepository.update(entity)
        return entity;
    }
}