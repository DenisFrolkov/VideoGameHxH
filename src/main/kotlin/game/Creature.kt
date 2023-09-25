package game

import kotlin.random.Random

open class Creature(val name: String, val attack: Int, var range: Int, val defense: Int, var healthPoints: Int) {
    private var healingCount = 0
    init {
        require(healthPoints >= 0) { "Здоровье отрицательное, вы уже мертвы" }
    }


    fun damageTaking(attacker: Creature) {
        val attackModifier = calculateAttackModifier(attacker.range)
        val successfulHit = rollDice(attackModifier)
        if (successfulHit) {
            val damage = Random.nextInt(attacker.range) // Произвольное значение из параметра Урон атакующего
            println("$name получил урон - $damage от атаки. Здоровье $name: $healthPoints")
            healthPoints -= damage
            if (healthPoints < 0) {
                healthPoints = 0
            }
        } else {
            println("Атака ${attacker.name} не удалась против $name.")
        }
    }

    private fun calculateAttackModifier(range: Int): Int {
        val attackModifier = (range - defense + 1)
        return if (attackModifier < 1) 1 else attackModifier
    }

    fun regeneration(healthPoints: Int){
        val maxHealth = 30
        if(healthPoints < maxHealth && healingCount < 4){
            val healingAmount = (maxHealth * 0.3).toInt()
            if (healthPoints + healingAmount <= maxHealth){
                this.healthPoints += healingAmount
            } else {
                this.healthPoints = maxHealth
            }
            healingCount++
        }
    }

    fun rollDice(numDice: Int): Boolean {
        val random = Random
        for (i in 1..numDice) {
            val roll = random.nextInt(6) + 1 // Бросаем кубик с цифрами от 1 до 6
            if (roll == 5 || roll == 6) {
                return true // Удар считается успешным при выпадении 5 или 6 на кубике
            }
        }
        return false // Если не выпало 5 или 6 на всех кубиках, удар не успешен
    }


    fun isDead(): Boolean {
        return healthPoints == 0
    }

}
