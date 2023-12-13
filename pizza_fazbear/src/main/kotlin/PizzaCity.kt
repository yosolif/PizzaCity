abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
)
{
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var coffeeCount = 0
    var totalCoffeeCost = 0

    var shownCheckCount = 0
    var totalDiscountAmount = 0.0

    var obshchelPeter = 0.0
    var obshchelMos = 0.0

    var coffeNeapPizza = 0
    var coffeRomanPizza = 0
    var coffeSicialPizza = 0
    var coffeTyroLPizza = 0

    var checkNeapPizza = 0
    var checkRomanPizza = 0
    var checkSicialPizza = 0
    var checkTyroLPizza = 0

    var TomatoNeapPizza = 0
    var TomatoRomanPizza = 0
    var TomatoSicialPizza = 0
    var TomatoTyroLPizza = 0

    var MustNeapPizza = 0
    var MustRomanPizza = 0
    var MustSicialPizza = 0
    var MustTyroLPizza = 0

    var sauceCountTomato = 0
    var sauceCountMustard = 0
    var revenueFromTomatoSauce = 0
    var revenueFromMustardSauce = 0
    var totalSauceRevenue = 0

    var obshchelST = 0.0
    var obshchelSM = 0.0

    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()


    open fun  showStatistics(){
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы:$romanPizzaCount")
        println("Продано тирольской пиццы:$tyroleanPizzaCount\n")
    }
}