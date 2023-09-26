import game.Creature


fun main() {
    val creature = Creature()
    val player = creature.readPlayerInfo()
    do {
        var continueGame = true
        println("Выберите действие:")
        println("1 - Сражаться")
        println("2 - Показать информацию о существах")
        println("3 - Выйти из игры")

        val selection = readLine()
        val monster = creature.readMonsterInfo()
        when (selection) {
            "1" -> {
                creature.battle(player, monster)
                creature.exitGame()
            }

            "2" -> {
                creature.displayCreatureInfo(player, monster)
            }

            "3" -> {
                creature.exitGame()
                continueGame = false
            }

            else -> println("Некорректный выбор. Пожалуйста, выберите 1, 2 или 3.")
        }
    } while (continueGame)
}