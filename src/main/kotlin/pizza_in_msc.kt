import java.util.function.IntToDoubleFunction

class Pizza_in_msc(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Check_photo{
    // Переменные для учета статистики по показу фотографий чеков
    override var yesPhotoCount = 0 // количество клиентов с фотографией чека
    override var noPhotoCount = 0 // количество клиентов без фотографии чека
    override var checkCount = 0 // общее количество показов фотографии чека
    override var totalDiscountAmount = 0 // общая сумма предоставленных скидок

    override fun showCheck_photo() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1"){
            println("Вам будет скидка 50 рублей с покупки")
            // Увеличиваем статистику показов фотографии чека и сумму скидок
            checkCount++
            totalDiscountAmount += 50
            yesPhotoCount++
        } else {
            // Увеличиваем статистику отказов от показа фотографии чека
            noPhotoCount++
        }
    }

    // Реализация функций продажи различных видов пиццы
    override fun neapolitanPizzaSale(){
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale(){
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale(){
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale(){
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    // Функции для получения дополнительной информации о продажах
    override fun getAdditionalMoney(): Int {
        return -totalDiscountAmount // возвращаем общую сумму предоставленных скидок
    }

    override fun getAdditionalStatistics() {
        val totalCheckDisplays = yesPhotoCount + noPhotoCount
        val photoPercentage = if (totalCheckDisplays > 0) {
            // Рассчитываем процент людей, показывающих фотографию чека
            (yesPhotoCount.toDouble() / totalCheckDisplays) * 100
        } else {
            0.0
        }
        println("Процент людей, показывающих чек: $photoPercentage%")
    }
}
