import java.lang.NumberFormatException
import javax.swing.JOptionPane

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


    filter(arrayOfBox, numBox, numDimensions)   //descarto las de mayor peso con numeros menores o repetidos

    //retorno las cajas restantes
    var orderBox = ""
    for(i in arrayOfBox){
        orderBox += "${i.number} "
    }
    JOptionPane.showMessageDialog(null, "numero de cajas que cumplen con la condición: ${arrayOfBox.size}\n" +
            "orden de las cajas: $orderBox")
}

fun filter(arrayOfBox: MutableList<Box>, numBox: Int, numDimensions: Int) {
    for(i in 0 until numBox - 1) {
        for(j in 0 until numDimensions) {
            if(arrayOfBox[i].numbers[j] >= arrayOfBox[i + 1].numbers[j]) {
                arrayOfBox.removeAt(i + 1)
                filter(arrayOfBox, numBox - 1, numDimensions)
                return
            }
        }
    }
}

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
    }
}