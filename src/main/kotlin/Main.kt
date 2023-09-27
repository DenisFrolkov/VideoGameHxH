import game.Creature

/**
 * Основная функция программы, управляющая игровым процессом.
 */
fun main() {
    // Создание объекта Creature, который будет управлять игрой
    val creature = Creature()

    // Чтение информации об игроке
    val player = creature.readPlayerInfo()

    // Выбор информации о монстре (случайно или пользовательски заданной)
    val monster = creature.selectionMonsterInfo()

    // Флаг, определяющий, продолжается ли игра
    var continueGame = true

    // Основной цикл игры
    while (continueGame) {
        // Вывод меню действий для игрока
        println("Выберите действие:")
        println("1 - Сражаться")
        println("2 - Показать информацию о существах")
        println("3 - Выйти из игры")

        // Считывание выбора игрока
        val selection = readLine()

        // Обработка выбора игрока
        when (selection) {
            "1" -> {
                // Игрок выбрал сражаться, выполняется битва
                creature.battle(player, monster)

                // Проверка, завершена ли игра после битвы (кто-то мертв)
                if (player.isDead() || monster.isDead()) {
                    continueGame = false
                }
            }

            "2" -> {
                // Игрок выбрал показ информации о существах
                creature.displayCreatureInfo(player, monster)
            }

            "3" -> {
                // Игрок выбрал выйти из игры, завершение игры
                continueGame = false
            }

            else -> println("Некорректный выбор. Пожалуйста, выберите 1, 2 или 3.")
        }
    }

    // Вывод сообщения о завершении программы
    println("Программа завершена.")
}
