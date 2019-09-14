package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Okno extends JFrame implements ActionListener {

	Magic magic = new Magic();
	
	private JButton guzik;
	private JLabel odp;
	private JLabel ob;
	
	public Okno() {
		setSize(500,400);
		setTitle("Magic 8 Ball");
		setLayout(null);
		
		
		
		guzik = new JButton("Ask");
		guzik.setBounds(20, 75, 100, 100);
		guzik.addActionListener(this);
		add(guzik);
		
		odp = new JLabel();
		odp.setBounds(50,300,300,40);	
		add(odp);
		

		ob=new JLabel(new ImageIcon(getClass().getClassLoader().getResource("magic8.jpg")));
		ob.setBounds(130, 10, 350, 300);
		add(ob);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(guzik)) {
		odp.setText(magic.los());	
		}
	}
	
	
	
}
