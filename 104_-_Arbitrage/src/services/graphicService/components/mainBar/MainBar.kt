package services.graphicService.components.mainBar

import services.graphicService.defaultCursor
import services.graphicService.semiDarkGray3
import services.graphicService.semiDarkGrayBlue
import services.graphicService.setProperties
import java.awt.Image
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.*
import kotlin.system.exitProcess

class MainBar(screenWidth: Int): JPanel(), MouseListener {
    private val mainPanel = JPanel()

    private var iLogo = ImageIcon()
    private val iBtExitOn = ImageIcon("src/services/graphicService/components/mainBar/btExitOn.png")
    private val iBtExitOff = ImageIcon("src/services/graphicService/components/mainBar/btExitOff.png")

    private val lLogo = JLabel()

    private val btExit = JButton()

    init {
        mainPanel.setProperties(0, 0, screenWidth, 28, semiDarkGrayBlue, null)
        add(mainPanel)

        btExit.setProperties(screenWidth - 48, 0, iBtExitOff, defaultCursor)
        btExit.addMouseListener(this)
        mainPanel.add(btExit)

        mainPanel.add(lLogo)

        setProperties(0, 0, screenWidth, 29, semiDarkGray3, null)
    }

    fun setLogo(icon: ImageIcon) {
        iLogo = ImageIcon(icon.image.getScaledInstance(16, 16, Image.SCALE_DEFAULT))
        lLogo.setProperties(5, 5, iLogo)
    }

    override fun mouseClicked(e: MouseEvent?) {
        if(e?.source == btExit) {
            JOptionPane.showMessageDialog(null, "Application closed successfully", "Exit", JOptionPane.INFORMATION_MESSAGE)
            exitProcess(0)
        }
    }

    override fun mousePressed(e: MouseEvent?) {
    }

    override fun mouseReleased(e: MouseEvent?) {
    }

    override fun mouseEntered(e: MouseEvent?) {
        if(e?.source == btExit)
            btExit.icon = iBtExitOn
    }

    override fun mouseExited(e: MouseEvent?) {
        if(e?.source == btExit)
            btExit.icon = iBtExitOff
    }
}