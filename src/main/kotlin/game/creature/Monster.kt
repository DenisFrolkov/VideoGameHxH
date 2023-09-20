package game.creature

import game.Creature

class Monster(attack: Int, defense: Int, healthpPoints: Int) : Creature(attack, defense, healthpPoints) {
    val name = "Monster"
}