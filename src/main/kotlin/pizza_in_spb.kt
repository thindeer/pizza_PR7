import java.util.function.IntToDoubleFunction

class Pizza_in_spb(
    // Цены на различные виды пиццы передаются в конструктор
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), coffee {
    // Переменные для учета статистики по продажам напитков
    override var coffeeCount = 0 // количество людей, выбравших кофе
    override var noCoffeeCount = 0 // количество людей, отказавшихся от кофе
    override var coffeeTotalMoney = 0 // общая сумма денег от продажи кофе


    // Реализация функции продажи напитков
    override fun drinkSale() {
        println("Вы будете пить кофе?")
        println("1. Да\n2. Нет")
        // Считываем ответ от пользователя
        if (readln() == "1") {
            println("С вас 200 рублей")
            // Увеличиваем статистику продажи кофе
            coffeeCount++
            coffeeTotalMoney += 200
        } else {
            // Увеличиваем статистику отказов от кофе
            noCoffeeCount++
        }
    }

    // Реализация функций продажи различных видов пиццы
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++ // увеличиваем статистику продажи неаполитанской пиццы
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++ // увеличиваем статистику продажи римской пиццы
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++ // увеличиваем статистику продажи сицилийской пиццы
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++ // увеличиваем статистику продажи тирольской пиццы
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    // Функции для получения дополнительной информации о продажах
    override fun getAdditionalMoney(): Int {
        return coffeeTotalMoney // возвращаем общую сумму денег от продажи кофе
    }

    override fun getAdditionalStatistics() {
        val totalDrinksCount = coffeeCount + noCoffeeCount
        val coffeePercentage = if (totalDrinksCount > 0) {
            // Рассчитываем процент людей, выбравших кофе
            (coffeeCount.toDouble() / totalDrinksCount) * 100
        } else {
            0.0
        }
        println("Процент людей, покупающих кофе: $coffeePercentage%")
    }
}
