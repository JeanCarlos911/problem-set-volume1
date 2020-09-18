package services.graphicService

import java.awt.*
import javax.swing.*
import javax.swing.border.Border

fun getScaledIcon(path: String, width: Int, height: Int): ImageIcon {
    val iIcon = ImageIcon(path)
    return ImageIcon(iIcon.image.getScaledInstance(width, height, Image.SCALE_DEFAULT))
}

fun JPanel.setProperties(x: Int, y: Int, width: Int, height: Int, color: Color?, layoutManager: LayoutManager?, border: Border? = null) {
    this.setBounds(x, y, width, height)
    this.background = color
    this.border = border
    this.layout = layoutManager
}

/**
 * icon label
 */
fun JLabel.setProperties(x: Int, y: Int, icon: Icon, cursor: Cursor? = null) {
    this.setSize(icon.iconWidth, icon.iconHeight)
    this.setLocation(x, y)
    this.icon = icon
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    this.cursor = cursor
}

/**
 * text label
 */
fun JLabel.setProperties(x: Int, y: Int, width: Int, height: Int, str: String?, fontColor: Color?, font: Font?, hAlignment: String? = "LEFT") {
    this.setBounds(x, y, width, height)
    this.foreground = fontColor
    this.font = font
    this.text = str
    this.horizontalAlignment = when(hAlignment) {
        "CENTER" -> SwingConstants.CENTER
        "RIGHT" -> SwingConstants.RIGHT
        else -> SwingConstants.LEFT
    }
}

fun JFrame.setProperties(width: Int, height: Int, layoutManager: LayoutManager?, background: Color? = null, title: String? = null) {
    this.setSize(width, height)
    this.setLocationRelativeTo(null)
    this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    this.title = title
    this.layout = layout
    this.background = background
    this.isVisible = true
}

/**
 * Icon button
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
fun JButton.setProperties(x: Int, y: Int, icon: Icon?, cursor: Cursor?) {
    this.setLocation(x, y)
    this.isContentAreaFilled = false
    this.border = null
    this.cursor = cursor
    this.isFocusable = false
    if (icon != null) {
        this.setSize(icon.iconWidth, icon.iconHeight)
        this.icon = icon
    }
}

/**
 * Button filled with icon
 */
fun JButton.setProperties( x: Int,y: Int, width: Int, height: Int, cursor: Cursor?, background: Color?, isSolid: Boolean, icon: Icon? = null) {
    this.setProperties(x, y, icon, cursor)
    this.setSize(width, height)
    this.background = background
    this.isContentAreaFilled = isSolid
}

/**
 * Text button
 */
fun JButton.setProperties(text: String?, x: Int, y: Int, width: Int, height: Int, cursor: Cursor?, font: Font?, background: Color?, foreground: Color?,
          border: Border?, alignment: String?, isSolid: Boolean) {
    setProperties(x, y, width, height, cursor, background, isSolid)
    this.text = text
    this.font = font
    this.foreground = foreground
    this.border = border
    this.isContentAreaFilled = isSolid
    this.horizontalAlignment = when (alignment) {
        "LEFT" -> SwingConstants.LEFT
        "RIGHT" -> SwingConstants.RIGHT
        else -> SwingConstants.CENTER
    }
}

fun JTextField.setProperties(x: Int, y: Int, width: Int, height: Int, text: String? = "", foreground: Color? = BLACK, background: Color? = WHITE,
         caret: Color? = BLACK, border: Border? = null, hAlignment: String? = "LEFT") {
    this.setBounds(x, y, width, height)
    this.text = text
    this.foreground = foreground
    this.background = background
    this.caretColor = caret
    this.border = border
    this.horizontalAlignment = when (hAlignment) {
        "CENTER" -> SwingConstants.CENTER
        "RIGHT" ->  SwingConstants.RIGHT
        else ->  SwingConstants.LEFT
    }

}
