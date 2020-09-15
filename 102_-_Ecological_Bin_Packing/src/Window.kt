import services.graphicService.GraphicBuilder
import services.graphicService.GraphicResource
import java.awt.Color
import javax.swing.*

class Window : JFrame() {
    val gr = GraphicResource.service
    val gb: GraphicBuilder? = GraphicBuilder.service

    val textField1 = JTextField()
    val textField2 = JTextField()
    val textField3 = JTextField()
    val textField4 = JTextField()
    val textField5 = JTextField()
    val textField6 = JTextField()
    val textField7 = JTextField()
    val textField8 = JTextField()
    val textField9 = JTextField()

    init {

        createPacking1()

        setSize(1280, 720)
        setLocationRelativeTo(null)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        setLayout(null)
        getContentPane().setBackground(Color.BLACK)
        setVisible(true)

    }

    private fun createPacking1() {

        //load resources
        val iBrownBin: Icon? = gb?.getScaledIcon("src/resources/brownBin.png", 200, 400)

        //main panel
        val panel = JPanel()
        gb?.setJPanel(panel, 32, 32, 384, 528, gr?.GRAY)
        panel.layout = null
        add(panel)

        //title
        val lTitle = JLabel()
        gb?.setJLabel(lTitle, 96, 438, 244, 75, "Packing 1", gr?.DARK_WHITE, gr?.FUENTE_TITULO)
        panel.add(lTitle)

        //textfield 1
        gb?.setJTextField(textField1, 32, 400, 100, 32, "Brown bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
                gr?.BORDE_GRIS, "CENTER")
        panel.add(textField1)

        //textfield 2
        gb?.setJTextField(textField2, 143, 400, 100, 32, "Green bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDE_GRIS, "CENTER")
        panel.add(textField2)

        //textfield 3
        gb?.setJTextField(textField3, 252, 400, 100, 32, "Clear bottles", gr?.MEGALIGHT_GRAY, gr?.BLACK, gr?.DARK_WHITE,
            gr?.BORDE_GRIS, "CENTER")
        panel.add(textField3)

        //brown bin
        val lBrownBin = JLabel()
        if (iBrownBin != null) {
            gb?.setJLabel(lBrownBin, 32, 32, iBrownBin)
        }
        panel.add(lBrownBin)

    }

}