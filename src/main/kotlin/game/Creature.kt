package game
open class Creature(var attack: Int, var defense: Int, var healthpPoints: Int){
    init {
        require(healthpPoints >= 0) { "Здоровье отрицательное, вы уже мертвы" }
    }

    fun damageTaking(damage: Int){
        healthpPoints -= damage
        if (healthpPoints < 0){
            healthpPoints = 0
        }
    }

    fun regeneration() {
        val healingAmount = (healthpPoints * 0.3).toInt()
        if (healthpPoints + healingAmount <= healthpPoints) {
            healthpPoints += healingAmount
        }
    }

    fun isDead(): Boolean {
        return healthpPoints == 0
    }
}
