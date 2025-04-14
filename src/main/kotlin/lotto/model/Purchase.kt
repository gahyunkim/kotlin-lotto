package lotto.model

class Purchase(private val price: Int) {
    init {
        require(price % 1000 == 0) { "로또 구입 금액은 1000원으로 나눠져야 합니다" }
        require(price > 0) { " 로또 금액은 0원 초과여야 합니다" }
    }

    fun getAmount(): Int {
        return price / 1000
    }
}
