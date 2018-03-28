package jp.nr.trp.front.form.journey

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

class DetailForm {

    @Pattern(regexp="[0-9]*")
    var id: String = ""

    @NotBlank
    @Size(max=200)
    var title: String = ""

    @NotBlank
    @Size(max=2000)
    var description: String = ""
}
