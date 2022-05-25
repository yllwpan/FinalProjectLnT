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
public class insert extends JFrame implements ActionListener{
	Random rand = new Random();
	JPanel insertButtonPanel,insertTitlePanel,insertPanel,namePanel,panel2,priceLabelPanel,priceTextFieldPanel,nameMainPanel, priceMainPanel, stockLabelPanel, stockTextFieldPanel;
	JLabel nameLabel,priceLabel,stockLabel,insertTitleLabel;
	JTextField nameTextField,priceTextField,stockTextField;
	JButton insertButton;
	public connect con;
	
	public insert() {
		Dimension dimensionSize = new Dimension(100, 30);
		insertPanel = new JPanel(new GridLayout(5,2,10,10));
		
		//title
		insertTitleLabel = new JLabel("Insert Menu");
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
		

		// insert price
		JPanel pricePanel = new JPanel();
		priceMainPanel = new JPanel();
		priceLabelPanel = new JPanel();
		priceTextFieldPanel = new JPanel();
		priceLabel = new JLabel("Harga ");
		priceTextField = new JTextField();
		priceTextField.setPreferredSize(dimensionSize);
		priceTextField.addActionListener(this);
		priceLabelPanel.add(priceLabel);
		priceTextFieldPanel.add(priceTextField);
		priceMainPanel.add(priceLabelPanel);
		priceMainPanel.add(priceTextFieldPanel);
		insertPanel.add(priceLabelPanel);
		insertPanel.add(priceTextFieldPanel);
		pricePanel.add(priceLabelPanel);
		pricePanel.add(priceTextFieldPanel);

		// insert stock
		JPanel stockPanel = new JPanel();
		stockLabelPanel = new JPanel();
		stockTextFieldPanel = new JPanel();
		stockLabel = new JLabel("Stock");
		stockTextField = new JTextField();
		stockTextField.setPreferredSize(dimensionSize);
		stockTextField.addActionListener(this);
		stockLabelPanel.add(stockLabel);
		stockTextFieldPanel.add(stockTextField);
		insertPanel.add(stockLabelPanel);
		insertPanel.add(stockTextFieldPanel);
		stockPanel.add(stockLabelPanel);
		stockPanel.add(stockTextFieldPanel);
		
		// insert button
		insertButtonPanel = new JPanel();
		insertButton = new JButton("Register");
		insertButtonPanel.add(insertButton);
		insertButton.addActionListener(this);
		
		JPanel insertMainPanel = new JPanel(new GridLayout(5,1));
		
		insertMainPanel.add(insertTitlePanel);
		insertMainPanel.add(namePanel);
		insertMainPanel.add(pricePanel);
		insertMainPanel.add(stockPanel);
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
			String code;
			Integer codeNum;
			
			//generate random menu code
			codeNum = rand.nextInt(999)+1;
			code = String.format("PD-%03d" , codeNum);
//			System.out.println(code);
			int price = Integer.parseInt(priceTextField.getText());
			int stock = Integer.parseInt(stockTextField.getText());
			
			con = new connect();
			con.getAllData();
			con.insertData(code, nameTextField.getText(), price, stock);
			JOptionPane.showMessageDialog(insertButton, "Product saved successfully");
			this.dispose();
			new home();
		}
		
	}

}
