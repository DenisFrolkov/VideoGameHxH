import game.creature.Monster
import game.creature.Player
import kotlin.random.Random


fun main() {
    val player = Player("Player", 10,10, 20, 30)
    val monster = Monster("Monster", 10,21, 20, 50)

    println(player.attackMessage())
    println(monster.attackMessage())
    // Пример боя
    while (player.healthPoints > 0 && monster.healthPoints > 0) {
        val playerDamage = player.damageRange(player.range)
        monster.damageTaking(playerDamage)
        println("${monster.name} получил урон - $playerDamage от ${player.name}. Здоровье монстра: ${monster.healthPoints}")
        val randomMonster = Random.nextInt(player.range)
        player.damageTaking(randomMonster)
        println("${monster.name} получил урон - $randomMonster от ${monster.name}. Здоровье игрока: ${player.healthPoints}")
        if (player.healthPoints < 10){
            player.regeneration(player.healthPoints)
        }
    }
    when {
        monster.isDead() -> println("${monster.name} умер! Игрок одержали победу в этом поединке!")
        player.isDead() -> println("Игрок проиграли в этом поединке! У игрока - ${player.healthPoints} очков здоровья.")
    }
}