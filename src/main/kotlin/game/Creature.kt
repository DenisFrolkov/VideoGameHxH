package game

import game.creature.Monster
import game.creature.Player
import kotlin.random.Random

class Creature {
    fun battle(player: Player, monster: Monster) {
        while (player.healthPoints > 0 && monster.healthPoints > 0) {
            monster.damageTaking(player, monster)
            player.damageTaking(monster, player)
            if (player.healthPoints < 10) {
                println("${player.name} имеет меньше 10 очков здоровья. Воспользоваться регенирацией? 1 - Да 2 - Нет")
                val selection = readLine()
                when(selection){
                    "1" -> player.healthRegeneration(player.healthPoints)
                }
            }
        }
        when {
            monster.isDead() -> println("${monster.name} умер! ${player.name} одержал победу в этом поединке!")
            player.isDead() -> println("${player.name} проиграл в этом поединке! У ${player.name} - ${player.healthPoints} очков здоровья.")
        }
    }

    fun readPlayerInfo(): Player {
        println("Введите имя игрока:")
        val name = readLine() ?: "Игрок"

        println("Введите силу атаки игрока:")
        val attack = readLine()?.toIntOrNull() ?: Random.nextInt(30)

        println("Введите урон наносимый игрока:")
        val range = readLine()?.toIntOrNull() ?: Random.nextInt(10)

        println("Введите защиту игрока:")
        val defense = readLine()?.toIntOrNull() ?: Random.nextInt(20)

        println("Введите здоровье игрока:")
        val healthPoints = readLine()?.toIntOrNull() ?: Random.nextInt(20)

        return Player(name, attack, range, defense, healthPoints)
    }

    fun readMonsterInfo(): Monster {
        val name = "Монстр"
        val attack = Random.nextInt(30)
        val range = Random.nextInt(10)
        val defense = Random.nextInt(20)
        val healthPoints = Random.nextInt(20)

        return Monster(name, attack, range, defense, healthPoints)
    }

    fun displayCreatureInfo(player: Player, monster: Monster) {
        println("Информация о существах:")
        println(player.attackMessage())
        println(monster.attackMessage())
    }

    fun exitGame() {
        println("Программа завершена.")
        System.exit(0)
    }
}
