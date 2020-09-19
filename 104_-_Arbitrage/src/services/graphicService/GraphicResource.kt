package services.graphicService

import java.awt.Color
import java.awt.Cursor
import java.awt.Font
import javax.swing.BorderFactory
import javax.swing.border.Border

//----------------------------------------COLOUR PALETTES------------------------------------------------------------
//basic
val red = Color(255, 0, 0)
val white = Color(255, 255, 255)

//standard
val black = Color(0, 0, 0)
val darkGray = Color(70, 70, 70)
val gray = Color(83, 83, 83)
val lightGray = Color(100, 100, 100)
val megaLightGray = Color(120, 120, 120)
val megaDarkWhite = Color(180, 180, 180)
val darkWhite = Color(210, 210, 210)

//green complementary cake
val lightGreen = Color(193, 255, 171)
val green = Color(122, 179, 102)
val greenCake = Color(212, 255, 196)
val purple = Color(179, 84, 167)
val lightPurple = Color(255, 171, 245)

//specials
val cyan = Color(72, 206, 247)
val darkCyan = Color(70, 147, 171)
val darkOcher = Color(169, 105, 0)
val mustard = Color(255, 225, 0)
val darkBlueGray = Color(58, 117, 181)
val blueGray = Color(82, 125, 181)

//-----------------------------------------FONTS------------------------------------------------------------------------
//standard
val fontTitle = Font("Gill Sans MT Condensed", Font.PLAIN, 64)
val fontTitleProblem = Font("Arial", Font.BOLD, 24)
val fontSubtitle = Font("Gill Sans MT Condensed", Font.PLAIN, 32)
val fontTitleGame = Font("Imprint MT Shadow", Font.PLAIN, 72)
val fontVersion = Font("Arial", Font.PLAIN, 14)
val fontOption = Font("Arial Narrow", Font.PLAIN, 18)

//----------------------------------------CURSORS-----------------------------------------------------------------------
//standard
val defaultCursor = Cursor(0)
val crosshairCursor = Cursor(1)
val textCursor = Cursor(2)
val waitCursor = Cursor(3)
val nResizeCursor = Cursor(8)
val eResizeCursor = Cursor(11)
val handCursor = Cursor(12)
val moveCursor = Cursor(13)

//----------------------------------------BORDERS-----------------------------------------------------------------------
//standard
val blackBorder: Border = BorderFactory.createLineBorder(black, 2, true)
val grayBorder: Border = BorderFactory.createLineBorder(gray, 2, true)
val darkGrayBorder: Border = BorderFactory.createLineBorder(darkGray, 2, true)
