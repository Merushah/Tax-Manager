import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Welcome implements ActionListener{
	private static JFrame frame;
	private static JButton Cal;
	private static JButton Res;
	private static JLabel text;
	private static JTextField profit;
	private static JRadioButton male;
	private static JRadioButton female;
	private static ButtonGroup gender;
	private static JTextField ageid;
	Welcome(){
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Welcome");
        
        JLabel use = new JLabel("Welcome");
        use.setBounds(380,10,80,25);
        use.setFont(new Font(null,Font.PLAIN,15));
        frame.add(use);
        
        JLabel label = new JLabel("Gender");
        label.setBounds(10,40,80,25);
        frame.add(label);
        
        male = new JRadioButton("Male");
        male.setBounds(100,40,165,25);
        female = new JRadioButton("Female");
        female.setBounds(100,60,165,25);
        gender = new ButtonGroup();

        male.addActionListener(this);
        female.addActionListener(this);
        
        gender.add(female);
        gender.add(male);

        
        frame.add(male);
        frame.add(female);
        
        JLabel age = new JLabel("Age");
        age.setBounds(10,100,80,25);
        frame.add(age);
        
        ageid = new JTextField();
        ageid.setBounds(100,100,165,25);
        frame.add(ageid);

        JLabel pro = new JLabel("Profit:");
        pro.setBounds(10,140,80,25);
        frame.add(pro);
        
        profit = new JTextField();
        profit.setBounds(100,140,165,25);
        frame.add(profit);
        
        Cal = new JButton("Calculate Tax");
        Cal.setBounds(10,190,150,25);
        Cal.setFocusable(false);
        Cal.addActionListener(this);
        frame.add(Cal);
        
        Res = new JButton("Reset");
        Res.setBounds(200,190,150,25);
        Res.setFocusable(false);
        Res.addActionListener(this);
        frame.add(Res);
        
        text = new JLabel();
        text.setBounds(10,250,500,35);
        text.setFont(new Font(null,Font.PLAIN,20));
        frame.add(text);
        
        frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int gend = 0;
		int age = Integer.parseInt(ageid.getText());
		int income = Integer.parseInt(profit.getText());
		int tax = 0;
		if(e.getSource()==Cal) {
			
			if(male.isSelected()) {
				gend = 0;
			}
			else if(female.isSelected()) {
				gend = 0;
			}
			
			switch (gend) {
			case 0: {
				if(age <60){
	                if(income<=250000){
	                    tax = 0;
	                }
	                else if(income>250000 && income<=500000){
	                    tax = (income*5)/100;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
	            else if(age>=60 && age<=80){
	                if(income<=300000){
	                    tax = 0;
	                }
	                else if(income>300000 && income<=500000){
	                    tax = (income*5)/100;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
	            else if(age>80){
	                if(income<=500000){
	                    tax = 0;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
			}
			case 1: {
				if(age <60){
	                if(income<=250000){
	                    tax = 0;
	                }
	                else if(income>250000 && income<=500000){
	                    tax = (income*5)/100;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
	            else if(age>=60 && age<=80){
	                if(income<=300000){
	                    tax = 0;
	                }
	                else if(income>300000 && income<=500000){
	                    tax = (income*5)/100;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
	            else if(age>80){
	                if(income<=500000){
	                    tax = 0;
	                }
	                else if(income>500000 && income<=1000000){
	                    tax = (income*20)/100;
	                }
	                else if(income>1000000 && income<=Integer.MAX_VALUE){
	                    tax = (income*30)/100;
	                }
	            }
				
			}
			text.setText("Amount of Tax to be Paid is : " + String.valueOf(tax));
			}
	    }
		if(e.getSource()==Res) {
			ageid.setText("");
			profit.setText("");
			text.setText("");
			
		}
	}
}

