import java.awt.Color
import java.util.Scanner
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

fun main() {
    val frame = JFrame()

    val panel1 = JPanel()
    panel1.setSize(384, 624)
    panel1.setLocation(32, 32)
    panel1.setLayout(null)
    panel1.setBackground(Color(80, 80, 80))
    frame.add(panel1)

    val textField1 = JTextField()
    textField1.setText("Brown bottles")
    textField1.setSize(85, 32)
    textField1.setLocation(32, 560)
    panel1.add(textField1)

    val textField2 = JTextField()
    textField2.setText("Green bottles")
    textField2.setSize(100, 32)
    textField2.setLocation(149, 560)
    panel1.add(textField2)

    val textField3 = JTextField()
    textField3.setText("Clear bottles")
    textField3.setSize(100, 32)
    textField3.setLocation(328, 568)
    frame.add(textField3)

    val textField4 = JTextField()
    textField4.setText("Brown bottles")
    textField4.setSize(100, 32)
    textField4.setLocation(460, 568)
    frame.add(textField4)

    val textField5 = JTextField()
    textField5.setText("Green bottles")
    textField5.setSize(100, 32)
    textField5.setLocation(592, 568)
    frame.add(textField5)

    val textField6 = JTextField()
    textField6.setText("Clear bottles")
    textField6.setSize(100, 32)
    textField6.setLocation(724, 568)
    frame.add(textField6)

    val textField7 = JTextField()
    textField7.setText("Brown bottles")
    textField7.setSize(100, 32)
    textField7.setLocation(856, 568)
    frame.add(textField7)

    val textField8 = JTextField()
    textField8.setText("Green bottles")
    textField8.setSize(100, 32)
    textField8.setLocation(988, 568)
    frame.add(textField8)

    val textField9 = JTextField()
    textField9.setText("Clear bottles")
    textField9.setSize(100, 32)
    textField9.setLocation(1120, 568)
    frame.add(textField9)

    val input = Scanner(System.`in`)

    val packing1 = Packing(input)
    val packing2 = Packing(input)
    val packing3 = Packing(input)

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
    println("${combinations.get(0)} $min")

    frame.setSize(1280, 720)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setLayout(null)
    frame.getContentPane().setBackground(Color.BLACK)
    frame.setVisible(true)

}

class Packing {

    val brownBottles: Int
    val greenBottles: Int
    val clearBottles: Int

    constructor (input : Scanner){
        brownBottles = input.nextInt()
        greenBottles = input.nextInt()
        clearBottles = input.nextInt()
    }
}