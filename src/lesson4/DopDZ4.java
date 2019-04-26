package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DopDZ4 {

    public static void main(String[] args) {
        new MyWind ();

    }

}

class MyWind extends JFrame {

    public JLabel jlName;

    public JLabel jlSurName;

    public MyWind() {
        setTitle ( "DopDZ4" );
        setBounds ( 800,300,400,400 );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        JPanel jPanel = new JPanel ( new GridLayout ( 1,2 ) );
        jlName = new JLabel ( "Name" );
        jlSurName = new JLabel ( "SurName" );
        jPanel.add ( jlName );
        jPanel.add ( jlSurName );
        add ( jPanel,BorderLayout.NORTH );
        JButton jButton = new JButton ( "Send" );
        DopForm dopForm = new DopForm ( this );
        jButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                dopForm.setVisible ( true );
            }
        } );
        add ( jButton,BorderLayout.SOUTH );
        setVisible ( true );

    }
}

class DopForm extends JFrame{

    JFrame parentFrame;

    public DopForm(MyWind parentFrame) {
        this.parentFrame = parentFrame;
        setTitle ( "DopDZ4" );
        setBounds ( 800,300,400,400 );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        JPanel jPanel = new JPanel ( new GridLayout ( 1,2 ) );
        JTextField jTextField = new JTextField (  );
        JTextField jTextField1= new JTextField (  );
        jPanel.add ( jTextField );
        jPanel.add ( jTextField1 );
        add ( jPanel,BorderLayout.NORTH );
        JButton jButton = new JButton ( "Send2" );
        jButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.jlName.setText ( jTextField.getText () );
                parentFrame.jlSurName.setText ( jTextField1.getText () );
                setVisible ( false );
            }
        } );
        add ( jButton,BorderLayout.SOUTH );
    }
}