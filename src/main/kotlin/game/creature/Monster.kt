package game.creature

import game.Creature

class Monster(name: String, attack: Int,range: Int, defense: Int, healthPoints: Int) : Creature(name, attack,range, defense, healthPoints) {
    fun attackMessage(): String {
        return "Имя - $name, Атака - $attack, Защита - $defense, Здоровье - $healthPoints"
    }
}