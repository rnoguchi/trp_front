package jp.nr.trp.front.service.logic

import jp.nr.trp.front.dto.LoginUser
import jp.nr.trp.front.entity.TMember
import jp.nr.trp.front.service.entity.TMemberService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class AuthService(
        val tMemberService: TMemberService
) : UserDetailsService {

    private val logger: Logger = LoggerFactory.getLogger(AuthService::class.java)

    @Override
    override fun loadUserByUsername(loginId: String?): UserDetails {

        if (loginId == null || StringUtils.isEmpty(loginId)) {
            throw UsernameNotFoundException("loginId is blank")
        }

        try {
            var member: TMember =
                    tMemberService.selectByLoginId(loginId) ?: throw UsernameNotFoundException("User not found for login id: " + loginId)

            return LoginUser(member)

        } catch (e: Exception) {
            logger.error("It can not be acquired User", e)
            throw UsernameNotFoundException("It can not be acquired User")
        }
    }

}