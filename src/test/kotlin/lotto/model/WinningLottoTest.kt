package lotto.model

import lotto.model.LottoTest.Companion.lottoOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `보너스볼과 당첨번호가 중복될 수 없다`() {
        val winningNumbers = lottoOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber.from(1)

        assertThrows<IllegalArgumentException> { WinningLotto(winningNumbers, bonusNumber) }
    }
}
