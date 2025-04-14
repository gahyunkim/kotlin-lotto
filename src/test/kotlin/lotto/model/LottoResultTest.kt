package lotto.model

import lotto.model.LottoTest.Companion.lottoOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoResultTest {
    @Test
    fun `당첨번호와 몇개가 일치하는지 확인할 수 있다`() {
        val lottos: List<Lotto> =
            listOf(
                Lotto(lottoOf(1, 2, 3, 4, 5, 6)),
                Lotto(lottoOf(2, 3, 4, 5, 6, 7)),
            )
        val winningNumbers = lottoOf(1, 2, 3, 10, 11, 12)
        val bonusNumber = LottoNumber.from(13)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottoResults = LottoResult.of(lottos, winningLotto)
        val ranks = lottoResults.getRankCount()

        println(ranks)

        assertAll(
            { assertThat(ranks[Rank.FIFTH]).isEqualTo(1) },
        )
    }

    @Test
    fun `당첨여부에 따라 수익률을 계산할 수 있다`() {
        val lottos: List<Lotto> =
            listOf(
                Lotto(lottoOf(1, 2, 3, 4, 5, 6)),
                Lotto(lottoOf(2, 3, 4, 5, 6, 7)),
            )
        val winningNumbers = lottoOf(1, 2, 3, 4, 5, 12)
        val bonusNumber = LottoNumber.from(13)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottoResults = LottoResult.of(lottos, winningLotto)
        val amount = 2
        val profits = lottoResults.getProfitRate(amount)

        assertThat(profits).isEqualTo(775.0)
    }
}
