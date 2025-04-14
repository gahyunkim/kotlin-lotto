package lotto.model

class TestNumberGenerator(
    private val fixedNumbers: List<Int>,
) : NumberGenerator {
    override fun generate(): List<Int> = fixedNumbers
}
