package services.graphicService

import java.awt.*
import javax.swing.*
import javax.swing.border.Border

class GraphicBuilder private constructor() {

    fun getScaledIcon(path: String, width: Int, height: Int): Icon {
        val iIcon = ImageIcon(path)
        return ImageIcon(iIcon.image.getScaledInstance(width, height, Image.SCALE_DEFAULT))
    }

    fun setJPanel(panel: JPanel, x: Int, y: Int, width: Int, height: Int, color: Color?) {
        panel.setBounds(x, y, width, height)
        panel.background = color
    }

    fun setJLabel(label: JLabel, x: Int, y: Int, icon: Icon, cursor: Cursor? = null) {
        label.setSize(icon.iconWidth, icon.iconHeight)
        label.setLocation(x, y)
        label.icon = icon
        @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        label.cursor = cursor
    }

    fun setJLabel(label: JLabel, x: Int, y: Int, width: Int, height: Int, str: String?, fontColor: Color?, font: Font?) {
        label.setBounds(x, y, width, height)
        label.foreground = fontColor
        label.font = font
        label.text = str
    }

    fun setJFrame(frame: JFrame, width: Int, height: Int, title: String?, background: Color? = null) {
        frame.setSize(width, height)
        frame.setLocationRelativeTo(null)
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.title = title
        frame.background = background
        frame.isVisible = true
    }

    /**
     * Icon button
     */
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    fun setJButton(button: JButton, x: Int, y: Int, icon: Icon?, cursor: Cursor?) {
        button.setLocation(x, y)
        button.isContentAreaFilled = false
        button.border = null
        button.cursor = cursor
        button.isFocusable = false
        if (icon != null) {
            button.setSize(icon.iconWidth, icon.iconHeight)
            button.icon = icon
        }
    }

    /**
     * Button filled with icon
     */
    fun setJButton(button: JButton, x: Int,y: Int, width: Int, height: Int, cursor: Cursor?, background: Color?, isSolid: Boolean, icon: Icon? = null) {
        setJButton(button, x, y, icon, cursor)
        button.setSize(width, height)
        button.background = background
        button.isContentAreaFilled = isSolid
    }

    /**
     * Text button
     */
    fun setJButton(button: JButton, text: String?, x: Int, y: Int, width: Int, height: Int, cursor: Cursor?, font: Font?,
                   background: Color?, foreground: Color?, border: Border?, alignment: String?, isSolid: Boolean) {

        setJButton(button, x, y, width, height, cursor, background, isSolid)
        button.text = text
        button.font = font
        button.foreground = foreground
        button.border = border
        button.isContentAreaFilled = isSolid
        button.horizontalAlignment = when (alignment) {
            "LEFT" -> SwingConstants.LEFT
            "RIGHT" -> SwingConstants.RIGHT
            else -> SwingConstants.CENTER
        }
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