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
    val combinations = ArrayList<String>()

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
                    if(combinations.size == 0) {
                        min = total
                        combinations.add(
                            when (a) {
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
                            }
                        )
                    }else if (min < total) {
                        min = total
                        combinations.removeAll(combinations)
                        combinations.add(
                            when (a) {
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
                            }
                        )
                    }else if (min == total) {
                        combinations.add(
                            when (a) {
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
                            }
                        )
                    }
                }
            }
        }
    }
    combinations.sort()
    return "${combinations[0]} $min"

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