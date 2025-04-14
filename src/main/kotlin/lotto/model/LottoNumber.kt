package lotto.model

class LottoNumber private constructor(val value: Int) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { LOTTO_RANGE_ERROR_MESSAGE }
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_RANGE_ERROR_MESSAGE = "로또숫자는 1부터 45 사이여야 합니다"

        private val CACHE: Map<Int, LottoNumber> =
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return CACHE[value] ?: throw IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE)
        }
    }
}
