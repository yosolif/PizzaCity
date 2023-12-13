class PizzaMoscow(
    neapolitianPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(neapolitianPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), CheckPhoto {

    var otrChelMos = 0.0

    override fun showCheckPhoto() {
        println("У вас есть фото чека")
        println("1. Да\n2. Нет")
        var a = readln()
        if (a == "1") {
            shownCheckCount++
            totalDiscountAmount += 50

            when{
                neapolitanPizzaCount > 0 -> checkNeapPizza++
                romanPizzaCount > 0 -> checkRomanPizza++
                sicilianPizzaCount > 0 -> checkSicialPizza++
                tyroleanPizzaCount > 0 -> checkTyroLPizza++
            }
        }else if (a == "2"){
            otrChelMos++
        }
        else{
            println("Неверный выбор")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитической пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку Тирольской пиццы в Москве")
    }

    override fun showStatistics() {
        super.showStatistics()
        if (shownCheckCount > 0) {
            obshchelMos = (shownCheckCount / (shownCheckCount + otrChelMos)) * 100
            println("Показано чеков : $shownCheckCount")
            println("Сумма скидок: $totalDiscountAmount")
            println("Статистика показа чеков $obshchelMos")
            var pizzaWithMAxCheck = getMaxCheckPizza()
            println("Чаще всего показывают чек к $pizzaWithMAxCheck пицце\n")
        }
        val money = (neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice ) - totalDiscountAmount

        println("Всего заработано денег: $money\n")
    }
    private fun getMaxCheckPizza(): String {
        // Создаем карту, связывающую типы пиццы с количеством заказанных кофе
        val maxCheckMap = mapOf(
            "Неаполитанской" to coffeNeapPizza,
            "Римской" to coffeRomanPizza,
            "Сицилийской" to coffeSicialPizza,
            "Тирольской" to coffeTyroLPizza
        )

        // Используем функцию maxByOrNull для нахождения записи с максимальным значением
        val maxCheckPizza = maxCheckMap.maxByOrNull { it.value }

        // Возвращаем тип пиццы с максимальным количеством заказанных кофе, или "Нет данных", если картa пуста
        return maxCheckPizza?.key ?: "Нет данных"
    }

}