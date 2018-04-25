package jp.nr.trp.front.config

import jp.nr.trp.front.interceptor.CheckSessionInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig(
        val checkSessionInterceptor: CheckSessionInterceptor
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(checkSessionInterceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry)
    }
}