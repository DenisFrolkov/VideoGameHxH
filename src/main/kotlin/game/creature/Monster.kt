package game.creature

import game.Fighting

/**
 * Класс, представляющий монстра в игре.
 *
 * @property name Имя монстра.
 * @property attack Сила атаки монстра.
 * @property range Урон, наносимый монстром.
 * @property defense Уровень защиты монстра.
 * @property healthPoints Количество очков здоровья монстра.
 */
class Monster(name: String, attack: Int, range: Int, defense: Int, healthPoints: Int) :
    Fighting(name, attack, range, defense, healthPoints) {

    /**
     * Возвращает строку с информацией об атаке монстра.
     *
     * @return Строка с данными об имени монстра, силе атаки, защите и текущем здоровье.
     */
    fun attackMessage(): String {
        return "Имя - $name, Атака - $attack, Защита - $defense, Здоровье - $healthPoints\n"
    }
}