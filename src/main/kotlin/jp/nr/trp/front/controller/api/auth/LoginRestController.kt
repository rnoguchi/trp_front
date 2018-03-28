package jp.nr.trp.front.controller.api.auth

import jp.nr.trp.front.form.auth.LoginForm
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/login")
class LoginRestController {

    @PostMapping("/auth")
    fun auth(@ModelAttribute form: LoginForm, model: Model): String {
        return "success"
    }
}