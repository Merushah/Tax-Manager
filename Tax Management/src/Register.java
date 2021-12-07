import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class Register implements ActionListener{
	private static JFrame frame;
	private static JTextField nameid;
	private static JTextField ageid;
	private static JTextField addd;
	private static JTextField number;
	private static JTextField email;
	private static JTextField userid;
	private static JLabel text1;
	private static JPasswordField password;
	private static JButton fin;
	private static ButtonGroup gender;
	private static JRadioButton male;
	private static JRadioButton female;
	
	
	Register(){
        frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Register Page");
        frame.setLayout(null);
        
        
        JLabel name = new JLabel("Name:");
        name.setBounds(10,20,80,25);
        frame.add(name);
        
        nameid = new JTextField();
        nameid.setBounds(100,20,165,25);
        frame.add(nameid);
        
        JLabel age = new JLabel("Age:");
        age.setBounds(10,50,80,25);
        frame.add(age);
        
        ageid = new JTextField();
        ageid.setBounds(100,50,165,25);
        frame.add(ageid);
        
        JLabel gen = new JLabel("Gender:");
        gen.setBounds(10,80,80,25);
        frame.add(gen);
        
        male = new JRadioButton("Male");
        male.setBounds(100,80,165,25);
        female = new JRadioButton("Female");
        female.setBounds(100,100,165,25);
        frame.add(male);
        frame.add(female);
        gender = new ButtonGroup();
        
        male.addActionListener(this);
        female.addActionListener(this);
        
        gender.add(female);
        gender.add(male);
        
        JLabel add = new JLabel("Address:");
        add.setBounds(10,130,80,25);
        frame.add(add);
        
        addd = new JTextField();
        addd.setBounds(100,130,370,25);
        frame.add(addd);
        
        
        JLabel num = new JLabel("Contact No :");
        num.setBounds(10,160,80,25);
        frame.add(num);  
        
        number = new JTextField();
        number.setBounds(100,160,165,25);
        frame.add(number);
        
        
        JLabel ema = new JLabel("Email Id :");
        ema.setBounds(10,190,80,25);
        frame.add(ema);  
        
        email = new JTextField();
        email.setBounds(100,190,165,25);
        frame.add(email);
        
        JLabel use = new JLabel("User Id :");
        use.setBounds(10,220,80,25);
        frame.add(use);  
        
        userid = new JTextField();
        userid.setBounds(100,220,165,25);
        frame.add(userid);
        
        JLabel pass = new JLabel("Password :");
        pass.setBounds(10,250,80,25);
        frame.add(pass);  
        
        password = new JPasswordField();
        password.setBounds(100,250,165,25);
        frame.add(password);
        
        
        
        fin = new JButton("Register");
        fin.setBounds(10,300,100,25);
        fin.setFocusable(false);
        fin.addActionListener(this);
        
        frame.add(fin);
        
        text1 = new JLabel();
        text1.setBounds(10,280,300,35);
        text1.setFont(new Font(null,Font.PLAIN,20));
        frame.add(text1);
        
        frame.setVisible(true);
        
        
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fin) {
			
		int gen = 0;
		if(male.isSelected()) {
			gen = 1;
		}
		else if(female.isSelected()) {
			gen = 0;
		}
		try {
			Connection con = Connec.createC();
			String q = "INSERT INTO User(Name, Age, Gender, Address, Number, Emailid, Userid, pass) values(?,?,?,?,?,?,?,?) ";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, nameid.getText());
			pstmt.setInt(2, Integer.parseInt(ageid.getText()));
			pstmt.setInt(3,gen);
			pstmt.setString(4, addd.getText());
			pstmt.setInt(5, Integer.parseInt(number.getText()));
			pstmt.setString(6, email.getText());
			pstmt.setString(7, userid.getText());
			pstmt.setString(8, password.getText());
			
			pstmt.executeUpdate();
			
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		    Welcome wel = new Welcome();
		    frame.dispose();
		}	
		
	}	
	}

