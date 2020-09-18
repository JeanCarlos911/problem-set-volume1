import java.lang.NumberFormatException
import javax.swing.JOptionPane
import kotlin.system.exitProcess

fun main(){
    val numBox = nextInt(1, 30, "Ingrese el número de cajas", "Input", JOptionPane.QUESTION_MESSAGE)
    val numDimensions = nextInt(1, 15, "Ingrese la dimensión de las cajas", "Input", JOptionPane.QUESTION_MESSAGE)

    val arrayOfBox: MutableList<Box> = mutableListOf()

    for(i in 1..numBox) {
        arrayOfBox.add(Box(i))  //enumero y creo las cajas

        //ingresa los valores de cada caja
        for(j in 1..numDimensions) {
            arrayOfBox[i - 1].addNumber(nextInt(1, 3000, "Ingrese longitud de la dimensión $j de la caja $i", "Input",
                    JOptionPane.QUESTION_MESSAGE))
        }

        arrayOfBox[i - 1].sort()    //organizo el contenido de las cajas de menor a mayor
        arrayOfBox[i - 1].calculateWeight()     //calculo el peso de cada caja
    }

    arrayOfBox.sortBy { it.weight }     //organizo por peso las cajas

    //calculo todos los paths candidatos
    val path = searchBestPath(arrayOfBox)

    //retorno el mejor path
    var orderBox = ""
    for(i in 0 until path.size){
        orderBox += "${path[i] + 1} "
    }
    JOptionPane.showMessageDialog(null, "numero de cajas que cumplen con la condición: ${path.size}\n" +
            "orden de las cajas: $orderBox")
}

fun MutableList<Box>.getWeights(): MutableList<Int> {
    val temp: MutableList<Int> = mutableListOf()

    for(i in this) {
        if(!temp.contains(i.weight)) {
            temp.add(i.weight)
        }
    }
    return temp
}

/**
 * @param previousBox caja anterior
 * @param remainingBoxes cajas restantes
 * @param weights pesos de las cajas
 * @return length of path
 */
fun searchPathStartingAt(selectBoxIndex: Int, listOfBox: MutableList<Box>, finalList: MutableList<Box>): MutableList<Box> {
    if(listOfBox[selectBoxIndex].weight != listOfBox.getWeights().last()) {
        var nextWeight: Int = 0
        for(i in selectBoxIndex until listOfBox.size) {
            if(listOfBox[i].weight > listOfBox[selectBoxIndex].weight) {
                nextWeight = listOfBox[i].weight
                break;
            }
            var insideABox = false
            val nextBoxesIndex: MutableList<Int> = mutableListOf()
            for(i in 0 until listOfBox.size) {
                if(listOfBox[i].weight == nextWeight) {
                    if(listOfBox[selectBoxIndex].canBeWithinOf(listOfBox[i])) {
                        insideABox = true;
                        searchPathStartingAt(i, listOfBox, finalList)
                    }
                }
            }
            finalList.add(listOfBox[selectBoxIndex])
            finalList.sortBy { it.weight }
            return finalList
        }
    }else {
        finalList.add(listOfBox[selectBoxIndex])
        finalList.sortBy { it.weight }
        return finalList
    }

}

fun searchBestPath(arrayOfBox: MutableList<Box>): MutableList<Int> {
    var maxSize = 0
    var bestPath: MutableList<Int> = mutableListOf()
    var deleted = 0

    while(true) {
        val path = searchPathStartingAt(0, arrayOfBox, mutableListOf())
        if(path.size > maxSize) {
            maxSize = path.size
            for(i in 0 until path.size) {
                path[i] += deleted
            }
            bestPath = path
        }
        deleted++
        arrayOfBox.removeAt(0)
        if(arrayOfBox.size == 0) {
            break
        }
    }
    return bestPath
}

fun Box.canBeWithinOf(box: Box): Boolean {
    for(i in 0 until this.numbers.size) {
        if(this.numbers[i] >= box.numbers[i]) {
            return false
        }
    }
    return true
}

/**
 * pide entrada entera en un rango a través de JOptionPane
 */
fun nextInt(min: Int, max: Int, message: String, title: String, messageType: Int): Int {
    val value: Int
    return try {
        value = JOptionPane.showInputDialog(null, message, title, messageType).toInt()
        if(value < min || value > max) {
            throw InvalidInputException()
        } else value
    }catch (invalidInput: InvalidInputException) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese un valor a partir de $min hasta $max", "Error",
                JOptionPane.ERROR_MESSAGE)
        nextInt(min, max, message, title, messageType)
    } catch (numberFormat: NumberFormatException) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese un número entero", "Error", JOptionPane.ERROR_MESSAGE)
        nextInt(min, max, message, title, messageType)
    } catch (nullException: NullPointerException) {
        exitProcess(0)
    }
}