package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
    companion object {
        fun lottoOf(vararg numbers: Int): List<LottoNumber> {
            return numbers.map { LottoNumber.from(it) }
        }
    }

    @Test
    fun `로또는 6개의 숫자를 가진다`() {
        val lottoNumbers =
            lottoOf(1, 2, 3, 4, 5, 6)

        assertDoesNotThrow { Lotto(lottoNumbers) }
    }

    @Test
    fun `로또는 중복된 숫자를 가질 수 없다`() {
        val lottoNumbers =
            lottoOf(1, 1, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    @Test
    fun `로또의 크기는 6개보다 크거나 작을 수 없다`() {
        val lottoNumbers =
            lottoOf(1, 1, 3, 4, 5, 6, 7)

        val lottoNumbers2 = lottoOf(1, 2, 3, 4, 5)

        assertAll(
            { assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) } },
            { assertThrows<IllegalArgumentException> { Lotto(lottoNumbers2) } },
        )
    }

    @Test
    fun `로또는 비어있을 수 없다`() {
        val lottoNumbers =
            lottoOf()

        assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }
    }
}
