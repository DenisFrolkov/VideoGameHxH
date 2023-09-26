package game.creature

import game.Fighting

class Player(name: String, attack: Int, range: Int, defense: Int, healthPoints: Int) :
    Fighting(name, attack, range, defense, healthPoints) {
    fun attackMessage(): String {
        return "Имя - $name, Атака - $attack, Защита - $defense, Здоровье - $healthPoints\n"
    }
}