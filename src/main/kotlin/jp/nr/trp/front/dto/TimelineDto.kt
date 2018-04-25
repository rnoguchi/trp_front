package jp.nr.trp.front.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class TimelineDto {
    var id: String = ""

    var journeyId: String = ""

    var startDate: String = ""

    var endDate: String = ""

    @NotBlank
    @Size(max=200)
    var title: String = ""

    @NotBlank
    @Size(max=2000)
    var description: String = ""
}