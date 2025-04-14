package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `숫자가 6개인 로또를 한개 생성할 수 있다`() {
        val lottoGenerator = LottoGenerator(RandomNumberGenerator())
        assertThat(lottoGenerator.createLottos(1).size).isEqualTo(1)
    }

    @Test
    fun `로또를 생성할 수 있다`() {
        val fixedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoGenerator = LottoGenerator(TestNumberGenerator(fixedNumbers))
        val lotto = lottoGenerator.createLottos(1)

        val expected = Lotto(fixedNumbers.map { LottoNumber.from(it) })
        assertThat(lotto.contains(expected)).isTrue()
    }
}
