package lotto.view

import lotto.model.Lotto
import lotto.model.Rank

class OutputView {
    fun printAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printLotto(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.numbers.map { it.value })
        }
    }

    fun printStatistics(rankCounts: Map<Rank, Int>) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원) - ${rankCounts[Rank.FIFTH] ?: 0}개")
        println("4개 일치 (50000원) - ${rankCounts[Rank.FOURTH] ?: 0}개")
        println("5개 일치 (1500000원) - ${rankCounts[Rank.THIRD] ?: 0}개")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${rankCounts[Rank.SECOND] ?: 0}개")
        println("6개 일치 (2000000000원) - ${rankCounts[Rank.FIRST] ?: 0}개")
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${profitRate}입니다.")
    }
}
