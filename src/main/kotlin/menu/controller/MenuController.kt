package menu.controller

import camp.nextstep.edu.missionutils.Randoms
import menu.model.Coach
import menu.model.Menu
import menu.view.InputView
import menu.view.OutputView

class MenuController {
    private val inputView = InputView
    private val outputView = OutputView
    private val menuList = mutableListOf<Menu>()
    private val recommendCategories = mutableListOf<String>()

    init {
        val japaneseFood = listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")
        val koreanFood = listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")
        val chineseFood = listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")
        val asianFood = listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")
        val westernFood = listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")

        japaneseFood.forEach { menuList.add(Menu(1, it)) }
        koreanFood.forEach { menuList.add(Menu(2, it)) }
        chineseFood.forEach { menuList.add(Menu(3, it)) }
        asianFood.forEach { menuList.add(Menu(4, it)) }
        westernFood.forEach { menuList.add(Menu(5, it)) }
    }

    fun start() {
        outputView.printStartMessage()
        val coachList = inputView.getCoachNames()

        for (coach in coachList) {
            val cantEatFood = inputView.getCantEatFood(coach.name, menuList)
            coach.cantEat = cantEatFood
        }

        recommendMenu(coachList)

        println("메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | ${recommendCategories.joinToString(" | ")} ]")
        for (coach in coachList) {
            println("[ ${coach.name} | ${coach.recommend.joinToString(" | ")} ]")
        }

        println("추천을 완료했습니다.")
    }

    private fun recommendMenu(coachList: List<Coach>) {
        val categories = mutableListOf<Int>()

        repeat(5) {
            var category: Int
            while (true) {
                category = Randoms.pickNumberInRange(1, 5)
                if (categories.count { it == category } != 2) {
                    categories.add(category)
                    when (category) {
                        1 -> recommendCategories.add("일식")
                        2 -> recommendCategories.add("한식")
                        3 -> recommendCategories.add("중식")
                        4 -> recommendCategories.add("아시안")
                        5 -> recommendCategories.add("양식")
                    }
                    break
                }
            }

            val menus = menuList.filter { it.type == category }.map { it.name }

            for (coach in coachList) {
                while (true) {
                    val menu = Randoms.shuffle(menus)[0]
                    if (menu !in coach.recommend) {
                        coach.recommend.add(menu)
                        break
                    }
                }
            }
        }
    }
}