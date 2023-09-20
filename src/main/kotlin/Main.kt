import game.creature.Monster
import game.creature.Player

fun main() {
    val player = Player(40, 20, 30)
    val monster = Monster(20, 25, 30)

    println("${player.name}: Атака - ${player.attack}, Защита - ${player.defense}, Здоровье - ${player.healthpPoints}")
    println("${monster.name}: Атака - ${monster.attack}, Защита - ${monster.defense}, Здоровье - ${monster.healthpPoints}")

    // Пример атаки и исцеления игрока
    monster.damageTaking(player.attack)
    println("${monster.name} получил урон от ${player.name}. Здоровье монстра: ${monster.healthpPoints}")

    player.regeneration()
    println("${player.name} исцелился. Здоровье игрока: ${player.healthpPoints}")

    // Проверка на смерть монстра
    if (monster.isDead()) {
        println("${monster.name} умер!")
    }
}