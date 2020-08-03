package client.gui;

import client.gui.tablero.TableroComponent;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Ventana extends JFrame{
    
    private TableroComponent tablero; //El tablero de bloques
    private final String[] options = {"Si","No"};
    
    public Ventana(){
        iniciarMenuPrincipal();
    }
    
    public void iniciarMenuPrincipal(){
        JOptionPane.showMessageDialog(null, "El propósito de este programa es controlar un brazo robotico que mueve "+
                "la posicion de los bloques segun instrucciones dadas", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
        
        int answer = JOptionPane.showOptionDialog(null, "Desea iniciar una nueva simulacion?", "Manu principal", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if(answer==0){
            mostrarTutorial();
            programarTablero();
            
        }else{
            answer = JOptionPane.showOptionDialog(null, "¿Desea salir del programa?", "Manu principal", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch(answer){
                case 0:
                    System.exit(0);
                case 1:
                    iniciarMenuPrincipal();
            }
        }
    }

    private void programarTablero() {
        int length = parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de bloques de la escena, recuerde que debe ser un valor mayor"
                + " a 0 y menor a 25", "Creando escena", JOptionPane.QUESTION_MESSAGE));
        
        if(length < 1 || length > 24){
            JOptionPane.showMessageDialog(null, "Valor ingresado no válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            programarTablero();
        }else{
            tablero = new TableroComponent(length);
            tablero.recibirInstruccion();
            
            add(tablero.obtenerDibujo());
            
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Escenario de bloques");
            setSize(32 + 34*length + 32, 32 + 25*length + 32);
            setLayout(null);
            setLocationRelativeTo(null);
            setVisible(true);
            
        }
    }
    
    private void mostrarTutorial(){
        JOptionPane.showMessageDialog(null, 
            "          INSTRUCCIONES QUE RECIBE EL BRAZO ROBÓTICO:\n\n" +
            "- move a onto b: coloca bloque a sobre b.\n" +
            "- move a over b: coloca a en la cima de la pila que contenga a b.\n" +
            "- pile a onto b: coloca la pila de bloques  que  están  sobre  a,\n" +
            "     incluyendo a a sobre el bloque b todos los bloques arriba de\n" +
            "     b son colocados en sus posiciones iniciales antes de  que la\n" +
            "     pila se transporte.\n" +
            "- pile a over b: coloca la pila de bloques que están sobre a, in-\n" +
            "    cluyendo a a en la cima de la pila que  contiene a b sin  mo-\n" +
            "    dificar el orden.", "Tutorial de uso del brazo robotico", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
