class PizzaPeter (
    neapolitianPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitianPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {

    var otrChelPeter = 0.0

    override fun drinkSale() {
        println("Вы будетете кофе?")
        println("1. Да\n2. Нет")
        var b = readln()
        if (b == "1") {
            coffeeCount++
            totalCoffeeCost += 200
            println("С вас 200 рублей за кофе\n")

            when{
                neapolitanPizzaCount > 0 -> coffeNeapPizza++
                romanPizzaCount > 0 -> coffeRomanPizza++
                sicilianPizzaCount > 0 -> coffeSicialPizza++
                tyroleanPizzaCount > 0 -> coffeTyroLPizza++
            }
        } else if (b == "2"){
            otrChelPeter++
        }
        else{
            println("Неверный выбор")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитической пиццы в Санкт-Петербург")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку Тирольской пиццы в Санкт-Петербурге")
    }
    override fun showStatistics() {
        super.showStatistics()
        if(coffeeCount > 0) {
            obshchelPeter = (coffeeCount / (coffeeCount + otrChelPeter)) * 100
            println("Продано кофе: $coffeeCount")
            println("Заработок с кофе: $totalCoffeeCost")
            println("Статистика заказа кофе $obshchelPeter")
            var pizzaWithMAxCoffe = getMaxCoffeePizza()
            println("Чаще всего заказывают кофе к $pizzaWithMAxCoffe пицце\n")
        }
        val money = neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice + totalCoffeeCost
        println("Всего заработано денег: $money\n")
    }
    private fun getMaxCoffeePizza(): String {
        // Создаем карту, связывающую типы пиццы с количеством заказанных кофе
        val maxCoffeeMap = mapOf(
            "Неаполитанской" to coffeNeapPizza,
            "Римской" to coffeRomanPizza,
            "Сицилийской" to coffeSicialPizza,
            "Тирольской" to coffeTyroLPizza
        )

        // Используем функцию maxByOrNull для нахождения записи с максимальным значением
        val maxCoffeePizza = maxCoffeeMap.maxByOrNull { it.value }

        // Возвращаем тип пиццы с максимальным количеством заказанных кофе, или "Нет данных", если картa пуста
        return maxCoffeePizza?.key ?: "Нет данных"
    }

}