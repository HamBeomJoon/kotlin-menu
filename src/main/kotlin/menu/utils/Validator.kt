package menu.utils

import menu.model.Menu

object Validator {
    fun validateCoachCount(input: String) {
        require(input.split(",").size in 2..5) { Constants.ERROR_COACH_COUNT }
    }

    fun validateCoachName(input: String) {
        input.split(",").map {
            require(it.length in 2..4) { Constants.ERROR_COACH_NAME }
        }
    }

    fun validateFoodCount(input: String) {
        require(input.split(",").size in 0..2) { Constants.ERROR_FOOD_COUNT }
    }

    fun validateMenu(input: String, menuList: List<Menu>) {
        val inputMenus = input.split(",").map { it.trim() }
        val menuNames = menuList.map { it.name }
        require(inputMenus.all { it in menuNames }) { Constants.ERROR_INVALID_MENU }
    }
}