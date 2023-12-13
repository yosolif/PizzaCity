class PIzzaKizlar (
    neapolitianPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitianPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), CheckPhoto, Drink,SauceOption{

    var otrChelPeter = 0.0
    var otrChelMos = 0.0
    var otrChelSous = 0.0

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
    override fun offerSauce(){
        println("Выберите соус:")
        println("1. Томатный 50 рублей\n2. Горчичный 65 рублей\n3. Соус не нужен")
        var c = readln()
        if (c == "1") {
            sauceCountTomato++
            revenueFromTomatoSauce += 50
            println("С вас 50 рублей за соус Томатный\n")

            when{
                neapolitanPizzaCount > 0 -> TomatoNeapPizza++
                romanPizzaCount > 0 -> TomatoRomanPizza++
                sicilianPizzaCount > 0 -> TomatoSicialPizza++
                tyroleanPizzaCount > 0 -> TomatoTyroLPizza++
            }
        } else if (c == "2"){
            sauceCountMustard++
            revenueFromMustardSauce += 65
            println("С вас 65 рублей за горчицу\n")
            when{
                neapolitanPizzaCount > 0 -> MustNeapPizza++
                romanPizzaCount > 0 -> MustRomanPizza++
                sicilianPizzaCount > 0 -> MustSicialPizza++
                tyroleanPizzaCount > 0 -> MustTyroLPizza++
            }
        } else if (c == "3"){
            println("Приятного аппетита")
            otrChelSous++
        }
        else{
            println("Неверный выбор")
        }
        totalSauceRevenue = revenueFromTomatoSauce + revenueFromMustardSauce
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитической пиццы в Кизляре ежи!")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Кизляре ежи!")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Кизляре ежи!")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку Тирольской пиццы в Кизляре ежи!")
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
        if (shownCheckCount > 0) {
            obshchelMos = (shownCheckCount / (shownCheckCount + otrChelMos)) * 100
            println("Показано чеков : $shownCheckCount")
            println("Сумма скидок: $totalDiscountAmount")
            println("Статистика показа чеков $obshchelMos")
            var pizzaWithMAxCheck = getMaxCheckPizza()
            println("Чаще всего показывают чек к $pizzaWithMAxCheck пицце\n")
        }
        if (sauceCountTomato > 0){
            obshchelST = (sauceCountTomato / (sauceCountTomato + otrChelSous))*100
            println("Продано томатных соусов: $sauceCountTomato")
            println("Заработок с томатного соуса: $revenueFromTomatoSauce")
            println("Статистика заказа томатного соуса $obshchelST")
            var pizzaWithMAxCoffe = getMaxTomatoPizza()
            println("Чаще всего заказывают томатный соус к $pizzaWithMAxCoffe пицце\n")
        }
        if (sauceCountMustard > 0){
            obshchelSM = (sauceCountMustard / (sauceCountMustard + otrChelSous))*100
            println("Продано горчичных соусов: $coffeeCount")
            println("Заработок с горчичного соуса: $revenueFromMustardSauce")
            println("Статистика заказа горчичного соуса $obshchelSM")
            var pizzaWithMAxCoffe = getMaxMustardPizza()
            println("Чаще всего заказывают горчичный соус к $pizzaWithMAxCoffe пицце\n")
        }

        val money = (neapolitanPizzaCount * neapolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyroleanPizzaCount * tyroleanPizzaPrice) + totalCoffeeCost - totalDiscountAmount + revenueFromTomatoSauce + revenueFromMustardSauce
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

    private fun getMaxTomatoPizza(): String {
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

    private fun getMaxMustardPizza(): String {
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

