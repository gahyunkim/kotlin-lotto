package lotto.model

class LottoGenerator(
    private val numberGenerator: NumberGenerator,
) {
    private fun createLotto(): List<Int> {
        return numberGenerator.generate()
    }

    fun createLottos(amount: Int): List<Lotto> {
        return List(amount) {
            createLotto().map { LottoNumber.from(it) }
        }.map { Lotto(it) }
    }
}
