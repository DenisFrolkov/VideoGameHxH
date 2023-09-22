package game

import kotlin.random.Random

open class Creature(val name: String, val attack: Int, var range: Int, val defense: Int, var healthPoints: Int) {
    init {
        require(healthPoints >= 0) { "Здоровье отрицательное, вы уже мертвы" }
    }

    fun damageRange(range: Int): Int {
        return Random.nextInt(range)
    }
    fun damageTaking(range: Int){
        healthPoints -= range
        if (healthPoints < 0){
            healthPoints = 0
        }
    }

    fun regeneration(healthPoints: Int) {
        val healingAmount = (this.healthPoints * 0.3).toInt()
        if (this.healthPoints + healingAmount <= this.healthPoints) {
            this.healthPoints += healingAmount
        }
    }

    fun isDead(): Boolean {
        return healthPoints == 0
    }

}
