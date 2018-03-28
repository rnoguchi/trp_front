package jp.nr.trp.front.controller.view.auth

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {

    @RequestMapping("/")
    fun index(): String {
        return "redirect:/messages";
    }

    @GetMapping("/login")
    fun login(): String {
        return "auth/login"
    }

    @GetMapping("/login-error")
    fun loginError(model: Model): String {
        model.addAttribute("loginError", true)
        return "auth/login"
    }
}