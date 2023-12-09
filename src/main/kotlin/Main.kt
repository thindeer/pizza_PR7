import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Инициализация объектов для городов Москва и Санкт-Петербург
    val petersPizzaCity = Pizza_in_spb(
        175.0, 241.5, 167.5, 215.0
    )
    val moscowsPizzaCity = Pizza_in_msc(
        neapolitanPizzaPrice = 215.0,
        romanPizzaPrice = 250.5,
        sicilianPizzaPrice = 180.5,
        tyroleanPizzaPrice = 240.0
    )

    while (true) {
        // Вывод меню выбора города
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n\n0. Выход из программы")

        // Считывание выбора пользователя
        val selectedCity = when (readln()) {
            "1" -> moscowsPizzaCity
            "2" -> petersPizzaCity
            "0" -> break // Выход из программы при выборе "0"
            else -> {
                println("Ошибка")
                continue
            }
        }
        // Вывод меню выбора пиццы
        println("Выберите пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Показать статистику")
        // Обработка выбора пользователя для конкретного города
        selectPizza(selectedCity)
    }
}

// Функция для обработки выбора пиццы
private fun selectPizza(selectedCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            selectedCity.neapolitanPizzaSale() // Продажа неаполитанской пиццы
            selectAdditionalService(selectedCity) // Выбор дополнительных услуг
        }

        "2" -> {
            selectedCity.romanPizzaSale() // Продажа римской пиццы
            selectAdditionalService(selectedCity) // Выбор дополнительных услуг
        }

        "3" -> {
            selectedCity.sicilianPizzaSale() // Продажа сицилийской пиццы
            selectAdditionalService(selectedCity) // Выбор дополнительных услуг
        }

        "4" -> {
            selectedCity.tyroleanPizzaSale() // Продажа тирольской пиццы
            selectAdditionalService(selectedCity) // Выбор дополнительных услуг
        }

        "0" -> selectedCity.showStatistics() // Показ статистики для конкретного города
        else -> {
            println("Ошибка")
            exitProcess(1)
        }
    }
}

// Функция для обработки выбора дополнительных услуг
fun selectAdditionalService(selectedCity: PizzaCity) {
    when (selectedCity) {
        is Check_photo -> selectedCity.showCheck_photo() // Показ фотографии чека
        is coffee -> selectedCity.drinkSale() // Продажа напитков
    }
}
