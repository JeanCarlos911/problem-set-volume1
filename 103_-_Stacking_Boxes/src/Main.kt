import java.lang.NumberFormatException
import javax.swing.JOptionPane
import kotlin.system.exitProcess

fun main(){
    val numBox = nextInt(1, 30, "enter the number of boxes", "Input", JOptionPane.QUESTION_MESSAGE)
    val numDimensions = nextInt(1, 15, "Enter the dimension of the boxes", "Input", JOptionPane.QUESTION_MESSAGE)

    val arrayOfBox: MutableList<Box> = mutableListOf()

    for(i in 1..numBox) {
        arrayOfBox.add(Box(i))  //I list and create the boxes

        //enter the values of each box
        for(j in 1..numDimensions) {
            arrayOfBox[i - 1].addNumber(nextInt(1, 3000, "Enter length of dimension $j of box $i", "Input",
                    JOptionPane.QUESTION_MESSAGE))
        }

        arrayOfBox[i - 1].sort()    //organize the contents of the boxes from smallest to largest
        arrayOfBox[i - 1].calculateWeight()     //calculate the weight of each box
    }

    arrayOfBox.sortBy { it.weight }     //organize the boxes by weight

    //look for the longest list
    val path = searchBestPath(arrayOfBox)

    //return to the user the best combination
    var orderBox = ""
    for(i in 0 until path.size){
        orderBox += "${path[i]} "
    }
    JOptionPane.showMessageDialog(null, "number of boxes that meet the condition: ${path.size}\n" +
            "order of the boxes: $orderBox")
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

fun searchPathStartingAt(selectBoxIndex: Int, listOfBox: MutableList<Box>, finalList: MutableList<Box>): MutableList<Box> {
    if(listOfBox[selectBoxIndex].weight != listOfBox.getWeights().last()) {
        var nextWeight = 0
        for(i in selectBoxIndex until listOfBox.size) {
            if (listOfBox[i].weight > listOfBox[selectBoxIndex].weight) {
                nextWeight = listOfBox[i].weight
                break
            }
        }
        var temp: MutableList<Box>
        var maxSize: Int? = null
        var maxSizeIndex: Int? = null
        for(i in 0 until listOfBox.size) {
            if(listOfBox[i].weight >= nextWeight && listOfBox[selectBoxIndex].canBeWithinOf(listOfBox[i])) {
                temp = searchPathStartingAt(i, listOfBox, mutableListOf())
                if(maxSize == null || temp.size > maxSize) {
                    maxSize = temp.size
                    maxSizeIndex = i
                }
            }
        }
        if(maxSizeIndex != null) {
            searchPathStartingAt(maxSizeIndex, listOfBox, finalList)
        }
    }
    finalList.add(listOfBox[selectBoxIndex])
    finalList.sortBy { it.weight }
    return finalList
}

fun searchBestPath(arrayOfBox: MutableList<Box>): MutableList<Int> {
    var maxSize = 0
    var bestPath: MutableList<Box> = mutableListOf()

    for(i in 0  until arrayOfBox.size) {
        val path = searchPathStartingAt(i, arrayOfBox, mutableListOf())
        if(path.size > maxSize) {
            maxSize = path.size
            bestPath = path
        }
    }
    bestPath.sortBy { it.weight }

    val bestPathNumbers: MutableList<Int> = mutableListOf()
    for(i in 0 until bestPath.size) {
        bestPathNumbers.add(bestPath[i].number)
    }
    return bestPathNumbers
}

fun Box.canBeWithinOf(box: Box): Boolean {
    for(i in 0 until this.numbers.size) {
        if(this.numbers[i] >= box.numbers[i]) {
            return false
        }
    }
    return true
}

fun nextInt(min: Int, max: Int, message: String, title: String, messageType: Int): Int {
    val value: Int
    return try {
        value = JOptionPane.showInputDialog(null, message, title, messageType).toInt()
        if(value < min || value > max) {
            throw InvalidInputException()
        } else value
    }catch (invalidInput: InvalidInputException) {
        JOptionPane.showMessageDialog(null, "Please enter a value from $min until $max", "Error",
                JOptionPane.ERROR_MESSAGE)
        nextInt(min, max, message, title, messageType)
    } catch (numberFormat: NumberFormatException) {
        JOptionPane.showMessageDialog(null, "Please enter an integer number", "Error", JOptionPane.ERROR_MESSAGE)
        nextInt(min, max, message, title, messageType)
    } catch (nullException: NullPointerException) {
        JOptionPane.showMessageDialog(null, "application closed successfully", "Exit", JOptionPane.INFORMATION_MESSAGE)
        exitProcess(0)
    }
}