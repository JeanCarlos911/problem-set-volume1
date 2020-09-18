import services.graphicService.*
import javax.swing.JLabel
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField

class Window(title: String) : JFrame() {
    val runBox = JTextField()
    val resultBox = JTextField()

    init {
        val lTitle = JLabel()
        lTitle.setProperties(0, 7, 1280, 32, title, RED, FONT_TITLE_PROBLEM, "CENTER")
        add(lTitle)

        val lIn = JLabel()
        lIn.setProperties(50, 50, 400, 32, "IN", RED, FONT_TITLE_PROBLEM)
        add(lIn)

        val lOut = JLabel()
        lOut.setProperties(1150, 50, 400, 32, "OUT", RED, FONT_TITLE_PROBLEM)
        add(lOut)

        val pLeft = JPanel()
        pLeft.setProperties(32, 100, 568, 532, WHITE, null, BORDER_BLACK)
        add(pLeft)

        val pRight = JPanel()
        pRight.setProperties(664, 100, 568, 532, WHITE, null, BORDER_BLACK)
        add(pRight)

        runBox.setProperties(5, 5, 560, 524)
        pLeft.add(runBox)

        pLeft.repaint()
        setProperties(1280, 720, null, WHITE)
    }
}