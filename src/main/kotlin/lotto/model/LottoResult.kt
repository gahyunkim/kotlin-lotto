package lotto.model

class LottoResult private constructor(private val lottoResults: List<Rank>) {
    companion object {
        fun of(
            lottos: List<Lotto>,
            winningLotto: WinningLotto,
        ): LottoResult {
            val ranks =
                lottos.map { lotto ->
                    val count = lotto.compareLotto(Lotto(winningLotto.winningNumbers))
                    val matchBonus = lotto.compareBonus(winningLotto.bonusNumber)
                    Rank.valueOf(count, matchBonus)
                }
            return LottoResult(ranks)
        }
    }

    fun getRankCount(): Map<Rank, Int> {
        return lottoResults.groupingBy { it }.eachCount()
    }

    fun getProfitRate(amount: Int): Double {
        val totalReward = lottoResults.sumOf { it.winningMoney }
        return totalReward.toDouble() / (amount * 1000)
    }
}
