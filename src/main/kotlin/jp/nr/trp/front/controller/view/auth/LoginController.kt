package jp.nr.trp.front.controller.view.auth

import jp.nr.trp.front.annotation.NonAuth
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {

    @NonAuth
    @RequestMapping("/")
    fun index(): String {
        return "auth/login"
    }

    @NonAuth
    @GetMapping("/login")
    fun login(): String {
        return "auth/login"
    }

    @NonAuth
    @GetMapping("/login-error")
    fun loginError(model: Model): String {
        model.addAttribute("loginError", true)
        return "auth/login"
    }
}