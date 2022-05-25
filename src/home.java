import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class home extends JFrame implements ActionListener{

	JPanel insertButtonPanel,insertTitlePanel,insertPanel,namePanel,panel2,priceLabelPanel,priceTextFieldPanel,nameMainPanel, priceMainPanel, stockLabelPanel, stockTextFieldPanel;
	JLabel nameLabel,priceLabel,stockLabel,insertTitleLabel;
	JTextField nameTextField,priceTextField,stockTextField;
	JButton insertButton;
	JButton insert = new JButton("Insert");
	JButton view = new JButton("View");
	JButton delete = new JButton("Delete");
	JButton update = new JButton("Update");
	
	public home() {
		JPanel insertPanel = new JPanel();
		JPanel viewPanel = new JPanel();
		JPanel deletePanel = new JPanel();
		JPanel updatePanel = new JPanel();
		
		Dimension dimensionSize = new Dimension(100, 30);
		
		
		insert.addActionListener(this);
		view.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		
		insert.setPreferredSize(dimensionSize);
		view.setPreferredSize(dimensionSize);
		delete.setPreferredSize(dimensionSize);
		update.setPreferredSize(dimensionSize);
		
		insertPanel.add(insert);
		viewPanel.add(view);
		deletePanel.add(delete);
		updatePanel.add(update);
		
		JPanel mainMenuPanel = new JPanel(new GridLayout(4,1));
		
		mainMenuPanel.add(insertPanel);
		mainMenuPanel.add(viewPanel);
		mainMenuPanel.add(deletePanel);
		mainMenuPanel.add(updatePanel);
		
		add(mainMenuPanel);
		
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
		if(e.getSource() == insert) {
			this.dispose();
			new insert();
		}else if(e.getSource() == update) {
			this.dispose();
			new update();
		}else if(e.getSource() == delete) {
			this.dispose();
			new delete();
		}else if(e.getSource() == view) {
			this.dispose();
			new view();
		}
		
	}


}
