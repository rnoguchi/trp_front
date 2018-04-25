package jp.nr.trp.front.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TrpDateUtil() {

    companion object {

        private val date: LocalDateTime? = null

        init {
            // 日付カスタマイズ
        }

        @JvmStatic fun get(): LocalDateTime {
            if (date != null) {
                return date
            } else {
                return LocalDateTime.now()
            }
        }

        @JvmStatic val dateFormatYYYYMMDDHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    }
}