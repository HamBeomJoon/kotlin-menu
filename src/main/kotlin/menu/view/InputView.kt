package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.utils.Constants
import menu.utils.Validator

object InputView {
    fun getCoachNames(): List<String> {
        while (true) {
            println(Constants.INPUT_COACH_NAME)
            val input = Console.readLine()
            try {
                Validator.validateCoachCount(input)
                Validator.validateCoachName(input)
                return input.split(",")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}