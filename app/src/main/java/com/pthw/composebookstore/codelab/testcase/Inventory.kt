package com.pthw.composebookstore.codelab.testcase

/**
 * Created by P.T.H.W on 18/09/2023.
 */
fun main() {
    val cheeseInventory = Inventory<Ingredient.Cheese>().newInventory()
    cheeseInventory.addIngredient(Ingredient.Cheese)
    println(cheeseInventory.count())
}

sealed class Ingredient {
    object Cheese : Ingredient()
    object Flour : Ingredient()
    object Egg : Ingredient()
    object Onion : Ingredient()
}

class Inventory<INGREDIENT: Ingredient> {
    val contents : MutableList<INGREDIENT> = mutableListOf()

    fun  addIngredient(ingredient: INGREDIENT) {
        contents.add(ingredient)
    }

    fun count()  = contents.size

    fun  newInventory() = Inventory<INGREDIENT>()
}
