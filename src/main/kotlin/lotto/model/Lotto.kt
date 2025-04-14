package lotto.model

data class Lotto(val numbers: List<LottoNumber>) {
    init {
        require(numbers.isNotEmpty()) { "로또는 비어있을 수 없다" }
        require(numbers.size == 6) { "로또는 6개의 숫자를 가진다" }
        require(numbers.toSet().size == 6) { "로또 숫자는 중복될 수 없다" }
    }

    fun compareLotto(winningLotto: Lotto): Int {
        return numbers.count { it in winningLotto.numbers }
    }

    fun compareBonus(winningBonus: LottoNumber): Boolean {
        return numbers.contains(winningBonus)
    }
}
