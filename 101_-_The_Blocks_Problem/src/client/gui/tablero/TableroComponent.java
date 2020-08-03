package client.gui.tablero;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TableroComponent {
    
    private int[][] tablero; //tablero
    
    private final String[] options = {"Si", "No, deseo dibujar la escena"};
    private int num1, num2;
    private String accion1, accion2, instruccion;
    
    public TableroComponent(int length){
        tablero = new int[length][length];

        for(int i=0; i<length-1; i++){
            for(int j=0; j<length; j++){
                tablero[i][j]= -1;
            }
        }
        for(int j=0; j<length; j++){
            tablero[length-1][j]= j+1;
        }
    }
    
    public void recibirInstruccion() {
        String stringAnswer = JOptionPane.showInputDialog(null, "Ingrese instrucción", "Brazo robótico", JOptionPane.QUESTION_MESSAGE);
        if(stringAnswer != null){
            instruccion = stringAnswer.toLowerCase();

            if(stringAnswer.length()>15 || stringAnswer.length()<13){
                JOptionPane.showMessageDialog(null, "Instrucción no válida", "ERROR", JOptionPane.ERROR_MESSAGE);
                recibirInstruccion();
            }else{
                interpretarInstruccion(stringAnswer);

                if(num1>tablero[0].length || num1<1 || num2>tablero[0].length || num2<1 || accion1.equals("error") || accion2.equals("error")){
                    System.out.println( accion1 + num1 + accion2 + num2);//TEMPORAL
                    JOptionPane.showMessageDialog(null, "Instrucción no válida", "ERROR", JOptionPane.ERROR_MESSAGE);
                    recibirInstruccion();
                }else{
                    ejecutarInstruccion();

                    int intAnswer = JOptionPane.showOptionDialog(null, "¿Desea enviar otra instrucción al brazo robótico?",
                            "Pregunta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if(intAnswer == 0) 
                        recibirInstruccion();
                }
            }
        }
    }
    
    private void interpretarInstruccion(String instruccion){
        num1 = getValor(1);
        num2 = getValor(2);
        accion1 = getAccion(1);
        accion2 = getAccion(2);
    }
    
    private void ejecutarInstruccion(){
        if(accion1.equals("move") && accion2.equals("onto")){
            moveOnto();
        }else if(accion1.equals("move") && accion2.equals("over")){
            moveOver();
        }else if(accion1.equals("pile") && accion2.equals("onto")){
            pileOnto();
        }else if(accion1.equals("pile") && accion2.equals("onto")){
            pileOnto();
        }
    }
    
    private int getValor(int num){
        boolean izquierda=false, derecha=false;
        int i =- 1;
        String temp = instruccion;
        
        while(i == -1){
            if(num == 1){
                //por la izquierda
                if(isNumeric(temp.substring(0, 1))){
                    izquierda=true;
                }else{
                    temp=temp.substring(1);//recorta el primer caracter
                }
                //por la derecha
                if(isNumeric(temp.substring(temp.length()-1, temp.length())) && temp.length()<3){
                    derecha=true;
                }else{
                    temp=temp.substring(0, temp.length()-1);//recorta el ultimo caracter
                }
            }else if(num == 2){
                //por la izquierda
                if(isNumeric(temp.substring(0, 1)) && temp.length()<3){
                    izquierda=true;
                }else{
                    temp=temp.substring(1);//recorta el primer caracter
                }
                //por la derecha
                if(isNumeric(temp.substring(temp.length()-1, temp.length()))){
                    derecha=true;
                }else{
                    temp=temp.substring(0, temp.length()-1);//recorta el ultimo caracter
                }
            }
            //Verifica si se puede extraer el número a lo extrae, cierra el ciclo y lo retorna
            if(izquierda && derecha){
                i=Integer.parseInt(temp);
            }
        }
        return i;
    }

    private String getAccion(int num){
        switch(num){
            case 1:
                if(instruccion.contains("move")){
                    return "move";
                }else if(instruccion.contains("pile")){
                    return "pile";
                }
                break;
            case 2:
                if(instruccion.contains("onto")){
                    return "onto";
                }else if(instruccion.contains("over")){
                    return "over";
                }
                break;
        }
        return "error";
    }
    
    /**
     * coloca bloque a sobre b
     */
    private void moveOnto(){
        if(num1 != num2){
            int[] index1 = new int[3];//i, j, valor
            int[] index2 = new int[3];
            
            for(int i=0; i<tablero.length; i++){
                for(int j=0; j<tablero.length; j++){
                    if(tablero[i][j]==num1){
                        index1[0] = i;
                        index1[1] = j;
                        index1[2] = tablero[i][j];
                    }else if(tablero[i][j]==num2){
                        index2[0] = i;
                        index2[1] = j;
                        index2[2] = tablero[i][j];
                    }
                }
            }
            if(tablero[index2[0]-1][index2[1]] == -1){
                tablero[index1[0]][index1[1]] = -1;
                tablero[index2[0]-1][index2[1]] = index1[2];
            }else{
                JOptionPane.showMessageDialog(null, "Espacio no disponible", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Son el mismo bloque", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void moveOver(){
        /*
    }
        if(num1 != num2){
            int coordJLibre = c.bloque[num2].getJ(), encontrado=0;
            for(int x=0; x<25; x++){
                for(int i=0; i<c.numeroBloques; i++){
                    if(c.bloque[i].getJ() == coordJLibre){
                        coordJLibre-=1;
                    }
                }
            }
            c.bloque[num1].setI(c.bloque[num2].getI());
            c.bloque[num1].setJ(coordJLibre);
        }
        */
    }
    
    private void pileOnto(){
        /*
    }
        if(num1 != num2){
            for(int i=0; i<c.bloque.length; i++){
                if(i!=num2 && c.bloque[i].getI() == c.bloque[b].getI() && c.bloque[i].getJ() < c.bloque[num2].getJ()){
                    c.bloque[i].setI(i);
                    c.bloque[i].setJ(c.numeroBloques);
                }
            }
            /*
            for(int i=0; i<bloques.length; i++){
                if(i!=b && bloques[i].i==bloques[a].i && bloques[i].j<bloques[a].j){
                    bloques[i].i=bloques[b].i;
                    bloques[i].j=bloques[a].j-bloques[i].j;
                    bloques[i].j=bloques[b].j-bloques[i].j;
                }
            }*//*
            pileOver();
        }*/
    }
    
    private void pileOver(){/*
        for(int j=c.bloque[num1].getJ(); j>-1; j--){
            for(int i=c.numeroBloques; i<c.bloque.length; i++){
                if(c.bloque[i].getI() == c.bloque[num1].getI() && c.bloque[i].getJ() == j){
                    moveOver();
                }
            }
        }
        /*int max = numeroBloques;
        for(int i =0; i<bloques.length; i++){
            if(bloques[i].i==num2 && bloques[i].j<=max){
                max=bloques[i].j-1;
            }
        }
        if(num1!=num2){
            for(int i=0; i<bloques.length; i++){
                if(i!=b  && bloques[i].i==bloques[num1].i && bloques[i].j<=bloques[num1].j){
                    bloques[i].i= i;
                    bloques[i].j+= max -(bloques[num1].j + 1);
                }
            }
        }*/
    }
    
    private boolean isNumeric(String cadena){
    	try{
            Integer.parseInt(cadena);
            return true;
    	}catch(NumberFormatException nfe){
            return false;
    	}
    }

    public JPanel obtenerDibujo() {
        return new TableroTemplate(tablero);
    }
    
}