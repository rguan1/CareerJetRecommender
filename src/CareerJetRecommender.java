package careerjetrecommender;

/**
 * Run this class to run the GUI. 
 * @author dzungnguyen
 */
public class CareerJetRecommender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
}
