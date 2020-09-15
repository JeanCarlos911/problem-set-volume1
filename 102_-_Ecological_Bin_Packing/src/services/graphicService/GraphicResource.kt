package services.graphicService

import java.awt.Color
import java.awt.Cursor
import java.awt.Font
import javax.swing.BorderFactory

class GraphicResource private constructor() {
    //----------------------------------------PALETAS DE COLORES--------------------------------------------------------
    //basico
    val RED = Color(255, 0, 0)

    //estandar
    val BLACK = Color(0, 0, 0)
    val DARK_GRAY = Color(70, 70, 70)
    val GRAY = Color(83, 83, 83)
    val LIGHT_GRAY = Color(100, 100, 100)
    val MEGALIGHT_GRAY = Color(120, 120, 120)
    val DARK_WHITE = Color(180, 180, 180)

    //paleta verde pastel complementario
    val VERDE_CLARO = Color(193, 255, 171)
    val VERDE = Color(122, 179, 102)
    val VERDE_PASTEL = Color(212, 255, 196)
    val MORADO = Color(179, 84, 167)
    val MORADO_CLARO = Color(255, 171, 245)

    //especiales
    val CYAN = Color(72, 206, 247)
    val CYAN_OSCURO = Color(70, 147, 171)
    val OCRE_OSCURO = Color(169, 105, 0)
    val MOSTAZA = Color(255, 225, 0)
    val AZUL_GRIS_OSCURO = Color(58, 117, 181)
    val AZUL_GRIS = Color(82, 125, 181)

    //----------------------------------------FUENTES-------------------------------------------------------------------
    //fuentes estandar
    val FUENTE_TITULO = Font("Gill Sans MT Condensed", Font.PLAIN, 64)
    val FUENTE_SUBTITULO = Font("Gill Sans MT Condensed", Font.PLAIN, 32)
    val FUENTE_TITULO_JUEGO = Font("Imprint MT Shadow", Font.PLAIN, 72)
    val FUENTE_VERSION = Font("Arial", Font.PLAIN, 14)
    val FUENTE_OPCION = Font("Arial Narrow", Font.PLAIN, 18)

    //----------------------------------------CURSORES------------------------------------------------------------------
    //cursores estandar
    val CURSOR_DEFECTO = Cursor(0)
    val CURSOR_CRUZ = Cursor(1)
    val CURSOR_TEXTO = Cursor(2)
    val CURSOR_ESPERAR = Cursor(3)
    val CURSOR_N_RESIZE = Cursor(8)
    val CURSOR_E_RESIZE = Cursor(11)
    val CURSOR_MANO = Cursor(12)
    val CURSOR_MOVER = Cursor(13)

    //----------------------------------------BORDERS--------------------------------------------------------------------
    //bordes estandar
    val BORDER_BLACK = BorderFactory.createLineBorder(BLACK, 2, true)
    val BORDER_GRAY = BorderFactory.createLineBorder(GRAY, 2, true)
    val BORDER_DARK_GRAY = BorderFactory.createLineBorder(DARK_GRAY, 2, true)

    companion object {
        var service: GraphicResource? = null
            get() {
                if (field == null) field = GraphicResource()
                return field
            }
            private set
    }
}