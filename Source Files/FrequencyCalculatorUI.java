/**
 * Name: Huy Nguyen
 * Email: hqnguyen.cs@gmail.com
 * 
 * This file contains the required classes and constructors
 * to produce the user interface of the frequency calculator
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class produces the primary viewing 
 * frame for the frequency calculator 
 * 
 * Static Variables:
 * BASE_DIMENSIONS - The dimensions of the frame
 * BACKGROUND_COLOR - The background color of the frame
 * FOREGROUND_COLOR - The foreground color of the frame
 * FONT - The font of the elements of the frame
 * 
 */
public class FrequencyCalculatorUI extends JFrame {

    /** Static Variables */

    private static final Dimension BASE_DIMENSIONS
            = new Dimension(1366, 768);
    private static final Color BACKGROUND_COLOR
            = Color.decode("#13293D");
    private static final Color FOREGROUND_COLOR
            = Color.decode("#EEF0F2");
    private static final Font FONT
            = new Font("Helvetica", Font.BOLD, 35);

    /**
     * This class produces the primary viewing 
     * panel of the frequency calculator
     */
    public class MainPanel extends JPanel {
    
        /**
         * This constructor produces a viewing panel, adding the 
         * necessary input and output fields to a JPanel
         * 
         * @param parent The Parent UI Frame
         */
        public MainPanel(FrequencyCalculatorUI parent) {

            // Alter Appearance
            
            setBackground(parent.getBackground());
            setForeground(parent.getForeground());
            setBorder(BorderFactory.createLineBorder(getBackground(), 20));
            

            setFont(parent.getFont());

            setLayout(new BorderLayout(0, 10));

            setSize(parent.getSize());

            // Add Necessary Fields

            final OutputLabel output = new OutputLabel(this);
            final InputField input = new InputField(output, this);

            add(input, BorderLayout.CENTER);
            add(output, BorderLayout.SOUTH);
    
        } 

    }

    /**
     * This class produces the input field for the frequency calculator
     */
    public class InputField extends JFormattedTextField {
    
        /**
         * This constructor produces an input field, altering
         * the appearance and function of a JFormattedTextField
         * 
         * @param output The output label
         * @param parent The parent UI panel
         */
        public InputField(OutputLabel output, MainPanel parent) {

            super();
            
            // Alter Appearance

            setBackground(parent.getBackground());
            setForeground(parent.getForeground());
            
            setFont(parent.getFont());

            setHorizontalAlignment(JFormattedTextField.CENTER);

            setPreferredSize(new Dimension(800, 100));
            
            // Alter Function

            addKeyListener(new FrequencyCalculatorBackend(this, output));
            
        }
    
    }
    
    /**
     * This class produces the output label for the frequency calculator
     */
    public class OutputLabel extends JLabel {

        /**
         * This constructor produces an output label, 
         * altering the appearance of a JLabel
         * 
         * @param parent The parent UI panel
         */
        public OutputLabel(MainPanel parent) {
    
            super("", JLabel.CENTER);

            // Alter Appearance
            
            setBackground(parent.getBackground());
            setForeground(parent.getForeground());

            setFont(parent.getFont());

            setPreferredSize(new Dimension(800, 500));

        }

    }
    
    /**
     * This constructor produces a viewing frame, altering
     * the appearance and functionality of a JFrame
     */
    public FrequencyCalculatorUI() {

        // Alter Appearance

        setBackground(BACKGROUND_COLOR);
        setForeground(FOREGROUND_COLOR);
        
        setFont(FONT);
        
        setSize(BASE_DIMENSIONS);        
        setResizable(false);

        setTitle("Frequency Calculator");
        
        // Alter Function

        add(new MainPanel(this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } 

}
