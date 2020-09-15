package services.graphicService

import java.awt.*
import javax.swing.*
import javax.swing.border.Border

class GraphicBuilder private constructor() {

    fun getScaledIcon(path: String, width: Int, height: Int): Icon {
        val iIcono = ImageIcon(path)
        return ImageIcon(iIcono.image.getScaledInstance(width, height, Image.SCALE_DEFAULT))
    }

    fun setJPanel(panel: JPanel, x: Int, y: Int, width: Int, height: Int, color: Color?) {
        panel.setBounds(x, y, width, height)
        panel.background = color
    }

    fun setJLabel(label: JLabel, x: Int, y: Int, icon: Icon, cursor: Cursor? = null) {
        label.setSize(icon.iconWidth, icon.iconHeight)
        label.setLocation(x, y)
        label.icon = icon
        label.cursor = cursor
    }

    fun setJLabel(label: JLabel, x: Int, y: Int, width: Int, height: Int, str: String?, fontColor: Color?, font: Font?) {
        label.setBounds(x, y, width, height)
        label.foreground = fontColor
        label.font = font
        label.text = str
    }

    fun setJFrame(frame: JFrame, width: Int, height: Int, title: String?) {
        frame.setSize(width, height)
        frame.setLocationRelativeTo(null)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.title = title
        frame.isVisible = true
    }

    fun getJButton(x: Int, y: Int, icono: Icon?, cursor: Cursor?): JButton {
        val button = JButton()
        button.isContentAreaFilled = false
        button.border = null
        button.setLocation(x, y)
        button.cursor = cursor
        button.isFocusable = false
        if (icono != null) {
            button.icon = icono
            button.setSize(icono.iconWidth, icono.iconHeight)
        }
        return button
    }

    fun getJButton(
        x: Int,
        y: Int,
        ancho: Int,
        alto: Int,
        cursor: Cursor?,
        icono: Icon?,
        colorFondo: Color?,
        esSolido: Boolean
    ): JButton {
        val button = getJButton(x, y, icono, cursor)
        button.setSize(ancho, alto)
        button.background = colorFondo
        button.isContentAreaFilled = esSolido
        return button
    }

    fun getJButton(
        texto: String?,
        x: Int,
        y: Int,
        ancho: Int,
        alto: Int,
        cursor: Cursor?,
        icono: Icon?,
        fuente: Font?,
        colorFondo: Color?,
        colorFuente: Color?,
        borde: Border?,
        direccion: String?,
        esSolido: Boolean
    ): JButton {
        val button = getJButton(x, y, ancho, alto, cursor, icono, colorFondo, esSolido)
        button.text = texto
        button.font = fuente
        button.foreground = colorFuente
        button.border = borde
        button.isContentAreaFilled = esSolido
        when (direccion) {
            "l" -> button.horizontalAlignment = SwingConstants.LEFT
            "r" -> button.horizontalAlignment = SwingConstants.RIGHT
            else -> {
            }
        }
        return button
    }

    fun setJTextField(textField: JTextField, x: Int, y: Int, width: Int, height: Int, text: String?, foreground: Color?, background: Color?,
        caret: Color?, border: Border?, alignment: String?) {

        textField.setBounds(x, y, width, height)
        textField.text = text
        textField.foreground = foreground
        textField.background = background
        textField.caretColor = caret
        textField.border = border
        textField.horizontalAlignment = when (alignment) {
            "CENTER" -> 0
            "RIGHT" ->  4
            "TOP" ->  1
            "BOTTOM" ->  3
            else ->  2
        }
    }

    companion object {
        var service: GraphicBuilder? = null
            get() {
                if (field == null) field = GraphicBuilder()
                return field
            }
            private set
    }
}