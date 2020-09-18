import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DbDataRandomIn extends JFrame {

	private JLabel labelColumn1 = null;
	private JLabel labelColumn2 = null;
	private JLabel labelColumn3 = null;
	private JLabel labelColumn4 = null;
	private JLabel labelColumn5 = null;
	private JLabel labelColumn6 = null;

	private JButton btnInsert = null;

	private JTextField tfColumn1 = null;
	private JTextField tfColumn2 = null;
	private JTextField tfColumn3 = null;
	private JTextField tfColumn4 = null;
	private JTextField tfColumn5 = null;
	private JTextField tfColumn6 = null;


	public DbDataRandomIn() {

		super("DbDataRandomIn");

		preDbTreatment(); // 각각의 PreparedStatement 생성, 초기화 메소드

		JPanel panel = new JPanel();	// 화면에 표시될 패널 생성

		// 라벨 레이블 생성
		labelColumn1 = new JLabel("컬럼1");
		labelColumn2 = new JLabel("컬럼2");
		labelColumn3 = new JLabel("컬럼3");
		labelColumn4 = new JLabel("컬럼4");
		labelColumn5 = new JLabel("컬럼5");
		labelColumn6 = new JLabel("컬럼6");

		// 값을 입력받거나 표시할 텍스트필드 생성
		tfColumn1 = new JTextField(8);
		tfColumn2 = new JTextField(8);
		tfColumn3 = new JTextField(8);
		tfColumn4 = new JTextField(8);
		tfColumn5 = new JTextField(8);
		tfColumn6 = new JTextField(8);


		// 버튼 레이블 생성
		btnInsert = new JButton("데이터 입력");

		// 패널에 각각의 레이블과 텍스트필드 추가
		panel.add(labelColumn1);
		panel.add(tfColumn1);
		panel.add(labelColumn2);
		panel.add(tfColumn2);
		panel.add(labelColumn3);
		panel.add(tfColumn3);
		panel.add(labelColumn4);
		panel.add(tfColumn4);
		panel.add(labelColumn5);
		panel.add(tfColumn5);
		panel.add(labelColumn6);
		panel.add(tfColumn6);

		// 패널에 버튼 추가
		panel.add(btnInsert);


		Container c = getContentPane();
		c.add(panel, BorderLayout.SOUTH);

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
