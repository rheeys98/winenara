package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

	// �ν��Ͻ��� �ּҸ� �����ϱ� ���� ���� ����
	private static Connection conn;

	// Connection ���� ���� ���
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final static String USER = "java";
	private final static String PASS = "1234";

	// �ݵ�� �����ڸ� private ���� �����Ͽ� ����ȭ ��Ų��.
	// => �ܺο��� �ν��Ͻ��� �������� ���ϵ��� ����
	// ������ ? �����ؼ� ����ؾ� �ϴµ� ��ü �����ؼ� ����ϸ�
	// �ǹ̾���(����� �Ǽ� ���� �뵵)
	private DBManager() { // default ������ ����
	}

	// �ν��Ͻ��� ���� �Ǵ� ���� �ν��Ͻ��� ��ȯ�ϴ�
	public static Connection getConnection() {
		conn = null;

		if (conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	// SELECT�� ������ �� �ڿ������� ���� �޼���.
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt ) {
		try {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public static void close(Connection conn, ResultSet rs ) {
		try {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

