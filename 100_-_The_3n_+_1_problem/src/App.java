import javax.swing.JOptionPane;

public class App{
    private int min, max, answer;
    private final String[] options = {"Yes", "No"};
    
    public static void main(String[] args){
        App app = new App();
    }
    
    public App(){
        receiveValues();
        calculate();
        showAnswer();
        int x = JOptionPane.showOptionDialog(null, "Do you want to run again?", "Main", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        switch(x){
            case 0:
                ejecutar();
                break;
            case 1:
                System.exit(0);
        }
    }

    private void receiveValues(){
        do{
            min = Integer.parseInt(JOptionPane.showInputDialog("Enter i"));
            if(min <1 || min >9999){
                JOptionPane.showMessageDialog(null, "Invalid inserted value", "Error", JOptionPane.ERROR_MESSAGE);
            }else
                break;
        }while(true);
        
        do{
            max = Integer.parseInt(JOptionPane.showInputDialog("Enter j"));
            if(max <1 || max >10000 || min > max){
                JOptionPane.showMessageDialog(null, "Invalid inserted value", "Error", JOptionPane.ERROR_MESSAGE);
            }else
                break;
        }while(true);
    }

    private void calculate(){
        answer = 0;
        int n, cont;
        
        for(int i = min; i<= max; i++){
            n = i;
            cont = 0;
            while(n != 1){
                if(n%2 == 0){
                    n /= 2;
                    cont += 1;
                }else{
                    n = 3*n + 1;
                    cont+ = 1;
                }
            }
            cont += 1;
            if(cont > answer)
                answer = cont;
        }
    }
    
    private void showAnswer(){
        JOptionPane.showMessageDialog(null, String.format("%d %d %d", min, max, answer), "Output", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
