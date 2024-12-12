package menu.view

import camp.nextstep.edu.missionutils.Console
import menu.model.Coach
import menu.model.Menu
import menu.utils.Constants
import menu.utils.Validator

object InputView {
    fun getCoachNames(): List<Coach> {
        while (true) {
            println(Constants.INPUT_COACH_NAME)
            val input = Console.readLine()
            try {
                Validator.validateCoachCount(input)
                Validator.validateCoachName(input)
                val coachList = mutableListOf<Coach>()
                for (name in input.split(",")) {
                    coachList.add(Coach(name = name, cantEat = null))
                }
                return coachList
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}