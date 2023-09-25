import game.creature.Monster
import game.creature.Player


fun main() {
    val player = Player("Player", 15, 10, 20, 30)
    val monster = Monster("Monster", 15, 10, 15, 30)

    println(player.attackMessage())
    println(monster.attackMessage())
    println()
    while (player.healthPoints > 0 && monster.healthPoints > 0) {
        monster.damageTaking(player, monster)
        player.damageTaking(monster, player)
        if (player.healthPoints < 10) {
            player.healthRegeneration(player.healthPoints)
            println("${player.name} имеет меньше 10 очков здоровья и воспользовался регенерацией.")
        }
    }
    when {
        monster.isDead() -> println("${monster.name} умер! Игрок одержал победу в этом поединке!")
        player.isDead() -> println("${player.name} проиграл в этом поединке! У игрока - ${player.healthPoints} очков здоровья.")
    }
}