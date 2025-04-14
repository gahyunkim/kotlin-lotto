package lotto.model

class WinningLotto(
    val winningNumbers: List<LottoNumber>,
    val bonusNumber: LottoNumber,
) {
    init {
        require(!winningNumbers.contains(bonusNumber)) { "보너스 볼은 당첨번호와 중복될 수 없습니다 " }
    }
}
