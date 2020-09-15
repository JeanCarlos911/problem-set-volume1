import services.graphicService.GraphicBuilder
import services.graphicService.GraphicResource
import java.awt.event.ActionListener
import java.lang.Exception
import javax.swing.*

class Window : JFrame() {
    private val gr = GraphicResource.service
    private val gb: GraphicBuilder? = GraphicBuilder.service

    private val iBrownBin: Icon? = gb?.getScaledIcon("src/resources/brownBin.png", 82, 109)
    private val iGreenBin: Icon? = gb?.getScaledIcon("src/resources/greenBin.png", 81, 112)
    private val iWhiteBin: Icon? = gb?.getScaledIcon("src/resources/whiteBin.png", 85, 110)

    private val textField1 = JTextField()
    private val textField2 = JTextField()
    private val textField3 = JTextField()
    private val textField4 = JTextField()
    private val textField5 = JTextField()
    private val textField6 = JTextField()
    private val textField7 = JTextField()
    private val textField8 = JTextField()
    private val textField9 = JTextField()

    init {
        layout = null

        addBtCalculate()
        createPacking1()
        createPacking2()
        createPacking3()

        gb?.setJFrame(this, 1280, 720, "Bin Packing Problem", gr?.BLACK)

    }

    private fun addBtCalculate() {
        val btCalculate = JButton()
        gb?.setJButton(btCalculate, "calculate", 600, 600, 80, 32, gr?.CURSOR_MANO, gr?.FUENTE_OPCION,
            gr?.GRAY, gr?.DARK_WHITE, gr?.BORDER_DARK_GRAY, "CENTER", true)
        btCalculate.addActionListener(ActionListener {
            try {
                JOptionPane.showMessageDialog(this, calculate(textField1.text.toInt(), textField2.text.toInt(), textField3.text.toInt(),
                    textField4.text.toInt(), textField5.text.toInt(), textField6.text.toInt(), textField7.text.toInt(), textField8.text.toInt(),
                    textField9.text.toInt()), "Answer", JOptionPane.INFORMATION_MESSAGE)
            } catch (cannotConvertException: Exception){
                JOptionPane.showMessageDialog(this, "Wrong values", "Error", JOptionPane.ERROR_MESSAGE)
            }
        })
        add(btCalculate)
    }

    private fun createPacking1() {

        //main panel
        val panel = JPanel()
        gb?.setJPanel(panel, 32, 32, 384, 528, gr?.GRAY)
        panel.layout = null
        add(panel)

        //title
        val lTitle = JLabel()
        gb?.setJLabel(lTitle, 96, 438, 244, 75, "Packing 1", gr?.DARK_WHITE, gr?.FUENTE_TITULO)
        panel.add(lTitle)

        //text field 1
        gb?.setJTextField(textField1, 200, 72, 100, 32, "Brown bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
                gr?.BORDER_GRAY, "CENTER")
        panel.add(textField1)

        //text field 2
        gb?.setJTextField(textField2, 200, 204, 100, 32, "Green bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField2)

        //text field 3
        gb?.setJTextField(textField3, 200, 339, 100, 32, "Clear bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField3)

        //brown bin
        val lBrownBin = JLabel()
        if (iBrownBin != null) {
            gb?.setJLabel(lBrownBin, 80, 32, iBrownBin)
        }
        panel.add(lBrownBin)

        //green bin
        val lGreenBin = JLabel()
        if (iGreenBin != null) {
            gb?.setJLabel(lGreenBin, 80, 164, iGreenBin)
        }
        panel.add(lGreenBin)

        //clear bin
        val lWhiteBin = JLabel()
        if (iWhiteBin != null) {
            gb?.setJLabel(lWhiteBin, 80, 300, iWhiteBin)
        }
        panel.add(lWhiteBin)

    }

    private fun createPacking2() {

        //main panel
        val panel = JPanel()
        gb?.setJPanel(panel, 448, 32, 384, 528, gr?.GRAY)
        panel.layout = null
        add(panel)

        //title
        val lTitle = JLabel()
        gb?.setJLabel(lTitle, 96, 438, 244, 75, "Packing 2", gr?.DARK_WHITE, gr?.FUENTE_TITULO)
        panel.add(lTitle)

        //text field 1
        gb?.setJTextField(textField4, 200, 72, 100, 32, "Brown bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField4)

        //text field 2
        gb?.setJTextField(textField5, 200, 204, 100, 32, "Green bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField5)

        //text field 3
        gb?.setJTextField(textField6, 200, 339, 100, 32, "Clear bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField6)

        //brown bin
        val lBrownBin = JLabel()
        if (iBrownBin != null) {
            gb?.setJLabel(lBrownBin, 80, 32, iBrownBin)
        }
        panel.add(lBrownBin)

        //green bin
        val lGreenBin = JLabel()
        if (iGreenBin != null) {
            gb?.setJLabel(lGreenBin, 80, 164, iGreenBin)
        }
        panel.add(lGreenBin)

        //clear bin
        val lWhiteBin = JLabel()
        if (iWhiteBin != null) {
            gb?.setJLabel(lWhiteBin, 80, 300, iWhiteBin)
        }
        panel.add(lWhiteBin)

    }

    private fun createPacking3() {

        //main panel
        val panel = JPanel()
        gb?.setJPanel(panel, 864, 32, 384, 528, gr?.GRAY)
        panel.layout = null
        add(panel)

        //title
        val lTitle = JLabel()
        gb?.setJLabel(lTitle, 96, 438, 244, 75, "Packing 3", gr?.DARK_WHITE, gr?.FUENTE_TITULO)
        panel.add(lTitle)

        //text field 1
        gb?.setJTextField(textField7, 200, 72, 100, 32, "Brown bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField7)

        //text field 2
        gb?.setJTextField(textField8, 200, 204, 100, 32, "Green bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField8)

        //text field 3
        gb?.setJTextField(textField9, 200, 339, 100, 32, "Clear bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDER_GRAY, "CENTER")
        panel.add(textField9)

        //brown bin
        val lBrownBin = JLabel()
        if (iBrownBin != null) {
            gb?.setJLabel(lBrownBin, 80, 32, iBrownBin)
        }
        panel.add(lBrownBin)

        //green bin
        val lGreenBin = JLabel()
        if (iGreenBin != null) {
            gb?.setJLabel(lGreenBin, 80, 164, iGreenBin)
        }
        panel.add(lGreenBin)

        //clear bin
        val lWhiteBin = JLabel()
        if (iWhiteBin != null) {
            gb?.setJLabel(lWhiteBin, 80, 300, iWhiteBin)
        }
        panel.add(lWhiteBin)

    }

}