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

    fun getCantEatFood(name: String, menuList: List<Menu>): List<String> {
        while (true) {
            println("\n${name}(이)가 못 먹는 메뉴를 입력해주세요.")
            val input = Console.readLine()
            try {
                if (input == "") return listOf()
                Validator.validateFoodCount(input)
                Validator.validateMenu(input, menuList)
                return input.split(",").toList()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}