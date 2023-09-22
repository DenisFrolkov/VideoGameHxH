package game

import kotlin.random.Random

open class Creature(val name: String, val attack: Int, var range: Int, val defense: Int, var healthPoints: Int) {
    private var healingCount = 0
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

    fun isDead(): Boolean {
        return healthPoints == 0
    }

}
