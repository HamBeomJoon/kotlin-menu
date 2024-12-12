package menu.utils

object Validator {
    fun validateCoachCount(input: String) {
        require(input.split(",").size in 2..5) { Constants.ERROR_COACH_COUNT }
    }

    fun validateCoachName(input: String) {
        input.split(",").map {
            require(it.length in 2..4) { Constants.ERROR_COACH_NAME }
        }
    }
}