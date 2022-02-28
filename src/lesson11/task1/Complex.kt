@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    val isNegative = "-" in s
    val delimeter: String
    if (isNegative) {
        delimeter = "-"
    } else {
        delimeter = "+"
    }
    val parts = s.split(delimeter, "i")
    val re = parts[0].toDouble()
    var im = parts[1].toDouble()
    if (isNegative) {
        im = -im
    }
    return Complex(re, im)
}

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {

    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(this.re + other.re, this.im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(-this.re, -this.im)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(this.re - other.re, this.im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex {
        val a = this.re
        val b = this.im
        val c = other.re
        val d = other.im
        val re = (a * c - b * d)
        val im = (b * c + a * d)
        return Complex(re, im)
    }

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val a = this.re
        val b = this.im
        val c = other.re
        val d = other.im
        val re = (a * c + b * d) / (c * c + d * d)
        val im = (b * c - a * d) / (c * c + d * d)
        return Complex(re, im)
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        if (other !is Complex) {
            return false
        }
        if (other == null) {
            return false
        }
        return this.re == other.re && this.im == other.im
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String = "$re+${im}i"
    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }
}
