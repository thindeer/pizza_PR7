abstract class PizzaCity(
    private val neapolitanPizzaPrice: Double, private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double, private val tyroleanPizzaPrice: Double
){
    protected var neapolitanPizzaCount = 0
    protected var romanPizzaCount = 0
    protected var sicilianPizzaCount = 0
    protected var tyroleanPizzaCount = 0

    private var money = 0.0
    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()
    protected abstract fun getAdditionalMoney() : Int
    protected abstract fun getAdditionalStatistics()

    fun showStatistics(){
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")
        getAdditionalStatistics()

        money = sicilianPizzaCount * sicilianPizzaPrice +
                neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice

        println("Всего заработано денег: ${money + getAdditionalMoney()}")
    }
}