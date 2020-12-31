
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.commons.codec.digest.DigestUtils;




public class GUI implements ActionListener {

    private static String HWID = null;

    public JFrame frame;
    public JLabel label;
    public JButton button;
    public JPanel panel;
    public JButton copyButton;
    public JLabel credits;

    public GUI() {

         frame = new JFrame();
         credits = new JLabel("Vulcan HWID v1.0 by:_KA1");
         label = new JLabel(" ");
         button = new JButton("Get HWID");
         button.addActionListener(this);
         copyButton = new JButton("Copy HWID");
         copyButton.addActionListener(this);



        // hwid label + get hwid button
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(300, 390, 300, 390));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);
        panel.add(button);
        panel.add(credits);



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Vulcan HWID");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        centerWindow(frame);


    }


    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        frame.setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }


    public static void main(String[] args) {
        new GUI();


    }

    @Override
    public void actionPerformed(ActionEvent e) {




        final String var0 = String.valueOf(System.getenv("os")) + System.getProperty("os.name") + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.language") + System.getenv("SystemRoot") + System.getenv("HOMEDRIVE") + System.getenv("PROCESSOR_LEVEL") + System.getenv("PROCESSOR_REVISION") + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");

        final String HWID = DigestUtils.sha512Hex(var0);;

        label.setText("HWID: " + HWID );

        panel.add(copyButton);






    }
}
