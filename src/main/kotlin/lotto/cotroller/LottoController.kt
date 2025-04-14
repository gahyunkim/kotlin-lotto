package lotto.cotroller

import lotto.model.LottoGenerator
import lotto.model.LottoNumber
import lotto.model.LottoResult
import lotto.model.Purchase
import lotto.model.RandomNumberGenerator
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val price = inputView.inputPrice()
        val amount = Purchase(price).getAmount()
        outputView.printAmount(amount)

        val numberGenerator = RandomNumberGenerator()

        val lottos = LottoGenerator(numberGenerator).createLottos(amount)
        outputView.printLotto(lottos)

        val winningNumber = inputView.inputWinningNumber().map { LottoNumber.from(it) }
        val bonusNumber = inputView.inputBonusNumber()

        val winning = WinningLotto(winningNumber, LottoNumber.from(bonusNumber))

        val lottoResults = LottoResult.of(lottos, winning)

        val rankCounts = lottoResults.getRankCount()
        outputView.printStatistics(rankCounts)

        val profitRate = lottoResults.getProfitRate(amount)
        outputView.printProfitRate(profitRate)
    }
}
