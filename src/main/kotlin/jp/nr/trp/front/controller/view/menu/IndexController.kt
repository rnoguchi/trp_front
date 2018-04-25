package jp.nr.trp.front.controller.view.menu

import jp.nr.trp.front.annotation.NonAuth
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpSession

@Controller
class IndexController(
        var session: HttpSession
        ) {

    @NonAuth
    @RequestMapping("/menu")
    fun index(@AuthenticationPrincipal userDetails: UserDetails?): String {

        return "forward:/journey/list";
    }
}
