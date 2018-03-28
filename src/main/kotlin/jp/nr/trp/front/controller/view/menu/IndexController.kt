package jp.nr.trp.front.controller.view.menu

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping("/menu")
    fun index(): String {
        return "/menu/index";
    }
}