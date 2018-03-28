package jp.nr.trp.front

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrpFrontApplication

fun main(args: Array<String>) {
    runApplication<TrpFrontApplication>(*args)
}
