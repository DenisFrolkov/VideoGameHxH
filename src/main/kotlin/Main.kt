import game.creature.Monster
import game.creature.Player


fun main() {
    val player = Player("Player", 30,6, 20, 30)
    val monster = Monster("Monster", 30,6, 20, 30)

    println(player.attackMessage())
    println(monster.attackMessage())
    println()
    // Пример боя
    while (player.healthPoints > 0 && monster.healthPoints > 0) {
        monster.damageTaking(player)
        player.damageTaking(monster)
        if (player.healthPoints < 10){
            player.regeneration(player.healthPoints)
            println("Здоровье ${player.name} меньше 10, он воспользовался регенирацией")
        }
    }
    when {
        monster.isDead() -> println("${monster.name} умер! Игрок одержали победу в этом поединке!")
        player.isDead() -> println("Игрок проиграли в этом поединке! У игрока - ${player.healthPoints} очков здоровья.")
    }
}