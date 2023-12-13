import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaPeter(175.0, 241.5, 167.5, 215.0)
    val pizzaMoscow = PizzaMoscow(215.0, 250.5, 180.5, 240.0)
    val pizzaRostov = PIzzaKizlar(49.0, 60.5, 69.5, 79.0)
    var currentPizzaCity: PizzaCity

    while (true) {
        println("Добрый день! Выбираем город")
        println("1. Москва\n2. Санкт-Петербург\n3. Кизляр\n0. Выход программы")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaRostov
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("Выберите пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n3. Сицилийская пицца\n4. Тирольская пицца\n0. Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSale()
            selectAddService(currentPizzaCity)
        }

        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}
private fun selectAddService(currentPizzaCity: PizzaCity) {
    if (currentPizzaCity is CheckPhoto) {
        currentPizzaCity.showCheckPhoto()
    }
    if (currentPizzaCity is Drink) {
        currentPizzaCity.drinkSale()
    }
    if (currentPizzaCity is SauceOption) {
        currentPizzaCity.offerSauce()
    }
}
