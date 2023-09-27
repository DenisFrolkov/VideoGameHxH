package game

import game.creature.Monster
import game.creature.Player
import kotlin.random.Random

/**
 * Класс Creature представляет игровую сущность и управляет игровым процессом.
 * Он содержит методы для проведения битвы, создания игрока и монстра,
 * а также для отображения информации о существах и завершения игры.
 */
class Creature
{
/**
 * Функция для проведения битвы между игроком и монстром.
 *
 * @param player Игрок
 * @param monster Монстр
 */
    fun battle(player: Player, monster: Monster) {
        while (player.healthPoints > 0 && monster.healthPoints > 0) {
            monster.damageTaking(player, monster)
            player.damageTaking(monster, player)
            if (player.healthPoints < 10) {
                println("${player.name} имеет меньше 10 очков здоровья. Воспользоваться регенирацией? 1 - Да 2 - Нет")
                val selection = readLine()
                when (selection) {
                    "1" -> player.healthRegeneration(player.healthPoints)
                }
            }
        }
        when {
            monster.isDead() -> println("${monster.name} умер! ${player.name} одержал победу в этом поединке!")
            player.isDead() -> println("${player.name} проиграл в этом поединке! У ${player.name} - ${player.healthPoints} очков здоровья.")
        }
    }

    /**
     * Функция для ввода информации о игроке.
     *
     * @return Созданный объект игрока
     */
    fun readPlayerInfo(): Player {
        println("Заполните информацию о своем игроке!")
        val name: String?
        var attack: Int?
        var range: Int?
        var defense: Int?
        var healthPoints: Int?


        println("Введите имя игрока:")
        name = readLine() ?: "Игрок"
        do {
            println("Введите силу атаки игрока (сила атаки должна быть больше 1 и меньше 30):")
            attack = readLine()?.toIntOrNull()
        } while (attack == null || attack <= 1 || attack >= 30)

        do {
            println("Введите урон наносимый игроком (урон должен быть больше 1 и меньше 15):")
            range = readLine()?.toIntOrNull()
        } while (range == null || range <= 1 || range >= 15)

        do {
            println("Введите защиту игрока (защита должна быть больше 1 и меньше 20):")
            defense = readLine()?.toIntOrNull()
        } while (defense == null || defense <= 1 || defense >= 20)

        do {
            println("Введите здоровье игрока (здоровье должно быть больше 1 и меньше 20):")
            healthPoints = readLine()?.toIntOrNull()
        } while (healthPoints == null || healthPoints <= 1 || healthPoints >= 20)

        return Player(name, attack, range, defense, healthPoints)
    }

    /**
     * Функция для выбора информации о монстре (самостоятельно или случайно).
     *
     * @return Созданный объект монстра
     */
    fun selectionMonsterInfo(): Monster {
        do {
            val fillingIinfo = true
            println("Заполнить информацию о характеристиках монстра самостоятельно или случайно? 1 - Самостоятельно 2 - Случайно")
            val selection = readLine()
            when (selection) {
                "1" -> {
                    return readMonsterInfo()

                }

                "2" -> {
                    val name = "Монстр"
                    val attack = Random.nextInt(30)
                    val range = Random.nextInt(15)
                    val defense = Random.nextInt(30)
                    val healthPoints = Random.nextInt(30)

                    return Monster(name, attack, range, defense, healthPoints)
                }

                else -> println("Некорректный выбор. Пожалуйста, выберите 1 - Самостоятельно или 2 - Случайно.")
            }
        } while (fillingIinfo)
        return Monster("Монстр", Random.nextInt(30), Random.nextInt(15), Random.nextInt(20), Random.nextInt(20))
    }

    /**
     * Функция для ввода информации о монстре.
     *
     * @return Созданный объект монстра
     */
    fun readMonsterInfo(): Monster {
        println("Заполните информацию о монстре!")
        val name: String?
        var attack: Int?
        var range: Int?
        var defense: Int?
        var healthPoints: Int?


        println("Введите имя монстра:")
        name = readLine() ?: "Монстр"
        do {
            println("Введите силу атаки монстра (сила атаки должна быть больше 1 и меньше 30):")
            attack = readLine()?.toIntOrNull()
        } while (attack == null || attack <= 1 || attack >= 30)

        do {
            println("Введите урон наносимый монстром (урон должен быть больше 1 и меньше 15):")
            range = readLine()?.toIntOrNull()
        } while (range == null || range <= 1 || range >= 15)

        do {
            println("Введите защиту монстра (защита должна быть больше 1 и меньше 20):")
            defense = readLine()?.toIntOrNull()
        } while (defense == null || defense <= 1 || defense >= 20)

        do {
            println("Введите здоровье монстра (здоровье должно быть больше 1 и меньше 20):")
            healthPoints = readLine()?.toIntOrNull()
        } while (healthPoints == null || healthPoints <= 1 || healthPoints >= 20)

        return Monster(name, attack, range, defense, healthPoints)
    }

    /**
     * Функция для вывода информации о существах (игроке и монстре).
     *
     * @param player Игрок
     * @param monster Монстр
     */
    fun displayCreatureInfo(player: Player, monster: Monster) {
        println("Информация о существах:")

        println(player.attackMessage())
        println(monster.attackMessage())
    }
}

