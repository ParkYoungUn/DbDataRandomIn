import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DbDataRandomIn extends JFrame {

	private JLabel labelColumn = null;

	private JButton btnInselt = null;


	public DbDataRandomIn() {

		super("DbDataRandomIn");

		preDbTreatment(); // 각각의 PreparedStatement 생성, 초기화 메소드
		JPanel panel = new JPanel();
		add(panel);

		labelColumn = new JLabel("컬럼");

		panel.add(labelColumn);
	}




	private String Url = "jdbc:mysql://localhost:3306/test"; // URL 정보 저장 변수
	private String DBName = "test";
	private String user = "root"; // user 정보 저장 변수 -> hr
	private String password = "1234"; // password 정보 저장 변수 -> hr

	private Connection conn = null;
	private Statement stmt = null;

	/** 데이터베이스 연동 및 Connection, Statement 생성 */
	private void preDbTreatment() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+DBName, user, password);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbDataRandomIn frame = new DbDataRandomIn();
		frame.setVisible(true);
	}
}
