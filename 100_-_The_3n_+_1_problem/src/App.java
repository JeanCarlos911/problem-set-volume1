import javax.swing.JOptionPane;

public class App{
    private int minimo, maximo, resultado;
    private final String[] options = {"Si", "No"};
    
    public static void main(String[] args){
        App app = new App();
    }
    
    public App(){
        ejecutar();
    }
    
    private void ejecutar(){
        recibirValores();
        evaluar();
        int x = JOptionPane.showOptionDialog(null, "¿Desea ejecutar de nuevo?", "Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        switch(x){
            case 0:
                ejecutar();
                break;
            case 1:
                System.exit(0);
        }
    }
    
    private void recibirValores(){
        do{
            minimo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese i"));
            if(minimo<1 || minimo>9999){
                JOptionPane.showMessageDialog(null, "Valor insertado no válido", "Error", 0);
            }else
                break;
        }while(true);
        
        do{
            maximo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese j"));
            if(maximo<1 || maximo>10000 || minimo>maximo){
                JOptionPane.showMessageDialog(null, "Valor insertado no válido", "Error", 0);
            }else
                break;
        }while(true);
    }
    
    private void evaluar(){
        calcularResultado();
        mostrarResultado();
    }
    
    private void calcularResultado(){
        resultado = 0;
        int n, contador;
        
        for(int i=minimo; i<=maximo; i++){
            n = i;
            contador=0;
            while(n!=1){
                if(n%2==0){
                    n/=2;
                    contador+=1;
                }else{
                    n=3*n+1;
                    contador+=1;
                }
            }
            contador+=1;
            if(contador>resultado){
                resultado=contador;
            }
        }
    }
    
    private void mostrarResultado(){
        JOptionPane.showMessageDialog(null, String.format("%d %d %d", minimo, maximo, resultado), "Output", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
