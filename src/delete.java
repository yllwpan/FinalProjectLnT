import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import config.connect;
public class delete extends JFrame implements ActionListener{
	
	JPanel insertButtonPanel,insertTitlePanel,insertPanel,namePanel,panel2,priceLabelPanel,priceTextFieldPanel,nameMainPanel, priceMainPanel, stockLabelPanel, stockTextFieldPanel;
	JLabel nameLabel,priceLabel,stockLabel,insertTitleLabel;
	JTextField nameTextField,priceTextField,stockTextField;
	JButton insertButton;
	JTextField codeTextField = new JTextField();
	public connect con;
	
	public delete() {
		Dimension dimensionSize = new Dimension(100, 30);
		insertPanel = new JPanel(new GridLayout(5,2,10,10));
		
		//title
		insertTitleLabel = new JLabel("Delete Menu");
		insertTitlePanel = new JPanel();
		insertTitlePanel.add(insertTitleLabel);
		
		// insert name
		JPanel namePanel = new JPanel();
		panel2 = new JPanel();
		nameLabel = new JLabel("Nama Menu");
		nameTextField = new JTextField();
		nameTextField.setPreferredSize(dimensionSize);
		panel2.add(nameLabel);
		namePanel.add(nameTextField);
		nameTextField.addActionListener(this);
		namePanel.add(panel2);
		namePanel.add(nameTextField);
		
		// insert button
		insertButtonPanel = new JPanel();
		insertButton = new JButton("Delete");
		insertButtonPanel.add(insertButton);
		insertButton.addActionListener(this);
		
		JPanel insertMainPanel = new JPanel(new GridLayout(5,1));
		
		insertMainPanel.add(insertTitlePanel);
		insertMainPanel.add(namePanel);
		insertMainPanel.add(insertButtonPanel);
		add(insertMainPanel);
		setup();
	}
	
	void setup() {
		setVisible(true);
		setResizable(false);
		setSize(400, 400);
		setLocationRelativeTo(null);
//		setLocation(300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My First GUI");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertButton) {
			
			
//			System.out.println(code);
			
			con = new connect();
			con.getAllData();
			con.deleteMenu(nameTextField.getText());
			JOptionPane.showMessageDialog(insertButton, "Product deleted successfully");
			this.dispose();
			new home();
		}
		
	}

}
