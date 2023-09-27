package game

import kotlin.random.Random

open class Fighting( // Класс, представляющий сущность, способную участвовать в битве
    val name: String,
    val attack: Int,
    private var range: Int,
    val defense: Int,
    var healthPoints: Int
) {
    private var healingCount = 0 // Переменная, используется для определения количества использованных регенираций
    private val maxHealth = healthPoints // Переменная, для определения максимального здоровья

    /**
     * Обработка атаки и нанесение урона сущности.
     *
     * @param attackerAttack Атакующая сущность.
     * @param defenderDefense Защитная сущность.
     */
    fun damageTaking(attackerAttack: Fighting, defenderDefense: Fighting) {
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

    /**
     * Рассчитывает модификатор атаки на основе силы атаки атакующего и уровня защиты защищающегося.
     *
     * @param attackerAttack Сила атаки атакующего.
     * @param defenderDefense Уровень защиты защищающегося.
     * @return Модификатор атаки, который используется для определения успешности атаки.
     *         Если модификатор меньше 1, возвращается 1, чтобы гарантировать успешность атаки.
     */
    private fun calculateAttackModifier(attackerAttack: Int, defenderDefense: Int): Int {
        val attackModifier = (attackerAttack - defenderDefense + 1)
        return if (attackModifier < 1) 1 else attackModifier
    }

    /**
     * Бросает кубики с заданным количеством бросков и возвращает `true`,
     * если хотя бы один бросок показал 5 или 6. В противном случае возвращает `false`.
     *
     * @param numDice Количество бросков кубика
     * @return `true`, если выпало 5 или 6 хотя бы на одном броске, иначе `false`
     */
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

    /**
     * Выполняет регенерацию здоровья. Если текущее здоровье меньше максимального и
     * количество прошедших регенераций меньше 4, то здоровье увеличивается на 30% от максимального,
     * но не более чем до максимального значения здоровья.
     *
     * @param healthPoints Текущее количество здоровья
     */
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

    /**
     * Проверяет, мертв ли персонаж (здоровье равно нулю).
     *
     * @return `true`, если персонаж мертв, иначе `false`
     */
    fun isDead(): Boolean {
        return healthPoints == 0
    }
}
