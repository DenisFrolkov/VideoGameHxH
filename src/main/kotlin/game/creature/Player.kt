package game.creature

import game.Creature

class Player(attack: Int, defense: Int, healthpPoints: Int) : Creature(attack, defense, healthpPoints) {
    val name = "Player"
}