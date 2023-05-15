/**
 * Name: Huy Nguyen
 * Email: hqnguyen.cs@gmail.com
 * 
 * This file starts up the frequency calculator
 */

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

/**
 * This class starts up the frequency calculator
 */
public class FrequencyCalculator {
    
    /**
     * This method starts up the frequency calculator
     * 
     * @param args Standard main method arguments
     * @throws InvocationTargetException 
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {

        //https://stackoverflow.com/questions/5473828/java-swing-gui-best-practices-from-a-code-standpoint
        
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {

                final FrequencyCalculatorUI UI = new FrequencyCalculatorUI();
                UI.setVisible(true);

             }

        });

    }

}
