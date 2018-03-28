package jp.nr.trp.front.service.entity

import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.repository.TMemberRepository
import org.springframework.stereotype.Service

@Service
class TMemberService(
        val tMemberRepository: TMemberRepository
) {
    fun selectByLoginId(loginId: String): TMember {
        return this.tMemberRepository.selectByLoginId(loginId)
    }

    fun selectByTmpLoginId(tmpLoginId: String): TMember {
        return this.tMemberRepository.selectByTmpLoginId(tmpLoginId)
    }
}