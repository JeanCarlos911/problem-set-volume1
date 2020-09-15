import java.util.Scanner

fun main() {
    val frame = Window()
}

fun calculate(num1: Int, num2: Int, num3: Int, num4: Int, num5: Int, num6: Int, num7: Int, num8: Int, num9: Int): String{

    val packing1 = Packing(num1, num2, num3)
    val packing2 = Packing(num4, num5, num6)
    val packing3 = Packing(num7, num8, num9)

    var total: Int
    var min = 0
    val combinations: MutableList<String> = mutableListOf()

    for(a in 1..3){
        for(b in 1..3){
            for(c in 1..3){
                if(a != b && b != c && a != c) {
                    total = when(a) {
                        1 -> packing2.brownBottles + packing3.brownBottles
                        2 -> packing2.greenBottles + packing3.greenBottles
                        else -> packing2.clearBottles + packing3.clearBottles
                    } + when(b) {
                        1 -> packing1.brownBottles + packing3.brownBottles
                        2 -> packing1.greenBottles + packing3.greenBottles
                        else -> packing1.clearBottles + packing3.clearBottles
                    } + when(c) {
                        1 -> packing1.brownBottles + packing2.brownBottles
                        2 -> packing1.greenBottles + packing2.greenBottles
                        else -> packing1.clearBottles + packing2.clearBottles
                    }
                    when {
                        combinations.isEmpty() -> {
                            min = total
                            combinations.add(code(a, b, c))
                        }
                        min > total -> {
                            min = total
                            combinations.clear()
                            combinations.add(code(a, b, c))
                        }
                        min == total -> {
                            combinations.add(code(a, b, c))
                        }
                    }
                }
            }
        }
    }
    combinations.sort()
    return "${combinations[0]} $min"

}

fun code(a: Int, b: Int, c: Int): String {
    return (when (a) {
                1 -> "B"
                2 -> "G"
                else -> "C"
            } + when (b) {
                1 -> "B"
                2 -> "G"
                else -> "C"
            } + when (c) {
                1 -> "B"
                2 -> "G"
                else -> "C"
            })

}

class Packing {

    val brownBottles: Int
    val greenBottles: Int
    val clearBottles: Int

    constructor (a: Int, b: Int, c: Int){
        brownBottles = a
        greenBottles = b
        clearBottles = c
    }
}