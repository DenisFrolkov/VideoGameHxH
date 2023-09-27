package game.creature

import game.Fighting

/**
 * Класс, представляющий игрока в игре.
 *
 * @property name Имя игрока.
 * @property attack Сила атаки игрока.
 * @property range Урон, наносимый игроком.
 * @property defense Уровень защиты игрока.
 * @property healthPoints Количество очков здоровья игрока.
 */
class Player(name: String, attack: Int, range: Int, defense: Int, healthPoints: Int) :
    Fighting(name, attack, range, defense, healthPoints) {

    /**
     * Возвращает строку с информацией об игроке.
     *
     * @return Строка с данными об имени игрока, силе атаки, защите и текущем здоровье.
     */
    fun attackMessage(): String {
        return "Имя - $name, Атака - $attack, Защита - $defense, Здоровье - $healthPoints\n"
    }
}