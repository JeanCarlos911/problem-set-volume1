import services.graphicService.*
import services.graphicService.components.mainBar.MainBar
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.*
import kotlin.system.exitProcess

class Window(title: String) : JFrame(), MouseListener {
    private val runBox = JTextArea()
    private val resultBox = JTextArea()

    private val iLogo = ImageIcon("resources/logo.png")
    private val iBtRunOn = ImageIcon("resources/btRunOn.png")
    private val iBtRunOff = ImageIcon("resources/btRunOff.png")
    private val iBtCleanOn = ImageIcon("resources/btCleanOn.png")
    private val iBtCleanOff = ImageIcon("resources/btCleanOff.png")

    private val btRun = JButton()
    private val btClean = JButton()

    init {
        isUndecorated = true

        val mainBar = MainBar(1280)
        mainBar.setLogo(iLogo)
        add(mainBar)

        val pLeft = JPanel()
        pLeft.setProperties(32, 100, 568, 564, megaDarkGray, null, semiDarkGray2Border)
        add(pLeft)

        val pRight = JPanel()
        pRight.setProperties(664, 100, 569, 564, megaDarkGray, null, semiDarkGray2Border)
        add(pRight)

        val lTitle = JLabel()
        lTitle.setProperties(0, 32, 1280, 32, title, darkWhite, fontTitleProblem, "CENTER")
        add(lTitle)

        val lIn = JLabel()
        lIn.setProperties(50, 50, 400, 32, "IN", darkWhite, fontTitleProblem)
        add(lIn)

        val lOut = JLabel()
        lOut.setProperties(1150, 50, 400, 32, "OUT", darkWhite, fontTitleProblem)
        add(lOut)

        runBox.setProperties(7, 7, 558, 554, null, darkWhite, megaDarkGray, white)
        pLeft.add(runBox)

        resultBox.setProperties(7, 7, 558, 554, null, darkWhite, megaDarkGray, white)
        resultBox.isEditable = false
        pRight.add(resultBox)

        btRun.setProperties(627, 120, iBtRunOff)
        btRun.addMouseListener(this)
        add(btRun)

        btClean.setProperties(627, 160, iBtCleanOff)
        btClean.addMouseListener(this)
        add(btClean)

        setProperties(1280, 720, null, semiDarkGrayBlue)
    }

    override fun mouseClicked(e: MouseEvent?) {
        if(e?.source == btRun)
            resultBox.text = calculate(runBox.text)

        if(e?.source == btClean)
            resultBox.text = ""
    }

    override fun mousePressed(e: MouseEvent?) {
    }

    override fun mouseReleased(e: MouseEvent?) {
    }

    override fun mouseEntered(e: MouseEvent?) {
        if(e?.source == btRun)
            btRun.icon = iBtRunOn

        if(e?.source == btClean)
            btClean.icon = iBtCleanOn
    }

    override fun mouseExited(e: MouseEvent?) {
        if(e?.source == btRun)
            btRun.icon = iBtRunOff

        if(e?.source == btClean)
            btClean.icon = iBtCleanOff
    }
}