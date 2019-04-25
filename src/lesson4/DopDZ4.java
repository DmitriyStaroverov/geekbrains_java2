package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DopDZ4 extends JFrame {

    JTextField jtf1;
    JTextField jtf2;
    JTextField jtf3;

    public static void main(String[] args) {
        new DopDZ4 ().setVisible ( true );
    }

    DopDZ4() {
        setTitle ( "DopDZ4" );
        setBounds ( 800, 300, 400, 400 );

        ImageIcon icon = new ImageIcon ( "src/img/hashtag.png" );
        setIconImage ( icon.getImage () );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );

        setLayout ( new GridLayout ( 4,1, 20, 15) );

        jtf1 = new JTextField ( );
        jtf2 = new JTextField ( );
        jtf3 = new JTextField ( );
        jtf1.setPreferredSize ( new Dimension ( 300,28 ) );
        jtf2.setPreferredSize ( new Dimension ( 300,28 ) );
        jtf3.setPreferredSize ( new Dimension ( 300,28 ) );
        jtf1.setBorder ( BorderFactory.createTitledBorder ( "1" ) );
        jtf2.setBorder ( BorderFactory.createTitledBorder ( "2" ) );
        jtf3.setBorder ( BorderFactory.createTitledBorder ( "3" ) );
        jtf1.setEditable ( false );
        jtf2.setEditable ( false );
        jtf3.setEditable ( false );
        add ( jtf1 );
        add ( jtf2 );
        add ( jtf3 );

        JButton jbtSend = new JButton ( "Send" );

        add(jbtSend);

        jbtSend.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEnabled ( false );
                new DopForm ().setLocation ( getX ()+10, getY ()+10 );
            }
        } );
    }

}

class DopForm extends DopDZ4{
    public DopForm() {
        super();
        setVisible ( true );
        setDefaultCloseOperation ( WindowConstants.HIDE_ON_CLOSE );


    }
}