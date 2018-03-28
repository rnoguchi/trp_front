package jp.nr.trp.front.dto

import jp.nr.trp.front.entity.TMember
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User

class LoginUser(member: TMember) :
        User(member.loginId, member.password, AuthorityUtils.createAuthorityList("ROLE_USER")){

    private val loginUser: TMember = member

    fun getUser(): TMember {
        return loginUser
    }
}