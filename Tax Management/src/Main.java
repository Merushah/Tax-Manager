import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main implements ActionListener{
	private static JPanel panel;
	private static JFrame frame;
	private static JTextField userid;
	private static JPasswordField passid;
	private static JButton login;
	private static JLabel text;
	private static JButton register;
	
	public static void main(String[] args) {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Login Page");

        panel.setLayout(null);

        JLabel label = new JLabel("User Id");
        label.setBounds(10,20,80,25);
        panel.add(label);

        userid = new JTextField();
        userid.setBounds(100,20,165,25);
        panel.add(userid);

        JLabel password = new JLabel("Password");
        password.setBounds(10,50,80,25);
        panel.add(password);

        passid = new JPasswordField();
        passid.setBounds(100,50,165,25);
        panel.add(passid);

        text = new JLabel();
        text.setBounds(10,120,300,35);
        text.setFont(new Font(null,Font.PLAIN,20));
        panel.add(text);

        login = new JButton("Login");
        login.setBounds(10,90,80,25);
        login.setFocusable(false);
        login.addActionListener(new Main());
        panel.add(login);
        
        register = new JButton("Register");
        register.setBounds(100,90,110,25);
        register.setFocusable(false);
        register.addActionListener(new Main());
        panel.add(register);

        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String user = userid.getText();
			String pass = passid.getText();
			String passw = "";
			
			try {
				Connection con = Connec.createC();
				String q = "select * from user where Userid = ? ";
				PreparedStatement  ps = con.prepareStatement(q);
				ps.setString(1, user);
				ResultSet set = ps.executeQuery();
				if(set.next()) {
				passw = set.getString("pass");
				}			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			if(pass.equals(passw)) {
			    Welcome wel = new Welcome();
			    frame.dispose();
			}
			else {
				text.setText("Wrong Username or Passwords");
			}
		}
		if(e.getSource() == register) {
			Register reg  = new Register();
			frame.dispose();
			
		}
				
		
	}
}