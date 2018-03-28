package jp.nr.trp.front

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@ContextConfiguration
class TrpFrontApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun testEnc() {
		val enc = BCryptPasswordEncoder()
		System.out.print("パスワード★     " + enc.encode("test") + "      ★パスワード")
	}
}
