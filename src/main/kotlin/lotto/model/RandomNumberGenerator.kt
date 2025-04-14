package lotto.model

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }
}
