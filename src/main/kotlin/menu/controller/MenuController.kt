package menu.controller

import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView
    private val outputView = OutputView

    fun start() {
        outputView.printStartMessage()
        inputView.getCoachNames()

    }
}