package lotto.model

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 21, 30, 45])
    fun `로또 숫자는 1이상 45이하이다`(numbers: Int) {
        assertDoesNotThrow { LottoNumber.from(numbers) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2, 48, 50, 59])
    fun `로또 숫자는 음수이거나 45를 넘을 수 없다`(numbers: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(numbers) }
    }
}
