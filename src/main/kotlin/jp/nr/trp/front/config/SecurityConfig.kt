package jp.nr.trp.front.config

import jp.nr.trp.front.handler.security.TrpAuthenticationFailureHandler
import jp.nr.trp.front.handler.security.TrpAuthenticationSuccessHandler
import jp.nr.trp.front.service.logic.AuthService
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig(
        val service: AuthService,
        val failureHandler: TrpAuthenticationFailureHandler,
        val successHandler: TrpAuthenticationSuccessHandler
        ) : WebSecurityConfigurerAdapter() {

    @Override
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "/javascript/**",
                "/webjars/**")
    }

    @Override
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .anyRequest()
                .permitAll()

        http.formLogin()
                .loginProcessingUrl("/auth/login")
                .loginPage("/login")
                .failureHandler(failureHandler)
                .successHandler(successHandler)
                .usernameParameter("loginId")
                .passwordParameter("password")
                .and()

        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")

    }

    @Override
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(service).passwordEncoder(BCryptPasswordEncoder())
    }
}