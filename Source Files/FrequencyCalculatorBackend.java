/**
 * Name: Huy Nguyen
 * Email: hqnguyen.cs@gmail.com
 * 
 * This file contains the required class constructor and method
 * in order to provide the functionality of the frequency calculator
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.util.Map;
import java.util.TreeMap;

/**
 * This class provides the functionality of the frequency calculator
 * 
 * Instance Variables:
 * inputField - The input field of the frequency calculator
 * outputField - The output field of the frequency calculator
 */
public class FrequencyCalculatorBackend extends KeyAdapter {

    /** Instance Variables */

    private JFormattedTextField inputField;
    private JLabel outputField;

    public FrequencyCalculatorBackend(JFormattedTextField inputField, JLabel outputField) {

        this.inputField = inputField;
        this.outputField = outputField;

    }
    
    /**
     * This method updates the number of each character and
     * adjusts the output accordingly every time a key is released.
     * 
     * @param e The key event representing the release of a key
     */
    @Override
    public void keyReleased(KeyEvent e) {

        //https://stackoverflow.com/questions/922528/how-can-i-sort-map-values-by-key-in-java
        //https://www.w3schools.com/html/html_table_borders.asp
        //https://www.w3schools.com/html/html_css.asp

        TreeMap<Character, Integer> characterCount
                = new TreeMap<Character, Integer>();

        String input = inputField.getText();
        String output = "<html><style>table { border: 1px solid #EEF0F2; }"
                + " th { border: 1px solid #EEF0F2; } td { border: 1px solid"
                + " #EEF0F2; } </style><table><tr>";

        // Count Characters

        for (int i = 0; i < input.length(); i++) {

            char character = input.charAt(i);

            if (characterCount.containsKey(character)) {

                characterCount.put(character, characterCount.get(character) + 1);

            } else {

                characterCount.put(character, 1);

            }

        }

        //https://stackoverflow.com/questions/4234985/how-to-for-each-the-hashmap
        //https://stackoverflow.com/questions/2420742/make-a-jlabel-wrap-its-text-by-setting-a-max-width
        //https://stackoverflow.com/questions/1090098/newline-in-jlabel
        //https://www.w3schools.com/html/html_tables.asp

        // Update Output

        int i = 1;

        
        //https://stackoverflow.com/questions/46898/how-do-i-efficiently-iterate-over-each-entry-in-a-java-map

        for (Map.Entry<Character, Integer> chars : characterCount.entrySet()) {

            output += " <td> " + chars.getKey() + " : " + chars.getValue() + " </td> ";

            if (i != 0 && i % 15 == 0) {
             
                output += "</tr><tr>";

            }


            i++;

        }

        output += "</table></html>";

        outputField.setText(output);

    }

}
