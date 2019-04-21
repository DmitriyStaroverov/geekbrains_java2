package lesson4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {



    public static void main(String[] args) {
        new MyWindow ();
    }

    private MyWindow() {
        setTitle ( "Java Chat" );
        setBounds ( 800, 300, 400, 400 );

        ImageIcon icon = new ImageIcon ( "src/img/hashtag.png" );
        setIconImage ( icon.getImage () );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );

        JPanel centralPanel = new JPanel (  );
        JPanel bottomPanel = new JPanel (  );

        centralPanel.setBackground ( Color.gray );
        bottomPanel.setBackground ( Color.green );

        centralPanel.setLayout ( new BorderLayout (  ) );
        centralPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        bottomPanel.setLayout ( new BorderLayout ( 3, 3 ) );
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        add ( centralPanel,BorderLayout.CENTER );
        add ( bottomPanel,BorderLayout.SOUTH );

        JTextArea jta = new JTextArea (  );
        JScrollPane jsp = new JScrollPane ( jta );
        jta.setEditable ( false );
        centralPanel.add ( jsp, BorderLayout.CENTER );

        JTextField jtf = new JTextField ( );
        jtf.setPreferredSize ( new Dimension ( 300,28 ) );

        JButton jbtSend = new JButton ( "Send" );
        bottomPanel.add ( jtf, BorderLayout.CENTER );
        bottomPanel.add ( jbtSend, BorderLayout.EAST );

        jbtSend.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append ( jtf.getText () + "\n" );
                jtf.setText ( "" );
                jtf.grabFocus ();
            }
        } );

        jtf.addKeyListener ( new KeyAdapter () {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode () == KeyEvent.VK_ENTER){
                    jta.append ( jtf.getText () + "\n" );
                    jtf.setText ( "" );
                    jtf.grabFocus ();
                }
            }
        } );



        setVisible ( true );
        jtf.grabFocus ();
    }

    private void sendMsg(String msg ){

    }
}
