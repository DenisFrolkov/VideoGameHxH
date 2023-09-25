package game

import kotlin.random.Random

open class Creature(
    val name: String,
    val attack: Int,
    private var range: Int,
    val defense: Int,
    var healthPoints: Int
) {
    private var healingCount = 0
    private val maxHealth = healthPoints

    init {
        require(healthPoints >= 0) { "Здоровье отрицательное, вы уже мертвы" }
    }

    fun damageTaking(attackerAttack: Creature, defenderDefense: Creature) {
        val attackModifier = calculateAttackModifier(attackerAttack.attack, defenderDefense.defense)
        val successfulHit = rollDice(attackModifier)
        if (successfulHit) {
            val damage = Random.nextInt(range) + 1
            println("$name подвергся атаке ${attackerAttack.name} и получил урон в размере $damage единиц. Текущее здоровье $name: $healthPoints")
            healthPoints -= damage
            if (healthPoints < 0) {
                healthPoints = 0
            }
        } else {
            println("$name избежал атаки ${attackerAttack.name} благодаря своей защите.")
        }
    }

    private fun calculateAttackModifier(attackerAttack: Int, defenderDefense: Int): Int {
        val attackModifier = (attackerAttack - defenderDefense + 1)
        return if (attackModifier < 1) 1 else attackModifier
    }

    private fun rollDice(numDice: Int): Boolean {
        val random = Random
        for (i in 1..numDice) {
            val roll = random.nextInt(6) + 1
            if (roll == 5 || roll == 6) {
                return true
            }
        }
        return false
    }

    fun healthRegeneration(healthPoints: Int) {
        if (healthPoints < maxHealth && healingCount < 4) {
            val healingAmount = (maxHealth * 0.3).toInt()
            if (healthPoints + healingAmount <= maxHealth) {
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
