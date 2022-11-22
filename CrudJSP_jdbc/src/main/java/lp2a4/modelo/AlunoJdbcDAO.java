package lp2a4.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoJdbcDAO implements AlunoDAO {
	private static final String SERVER = "jdbc:mysql://localhost";
	private static final String DATABASE = "/escola";
	private static final String USER = "?user=root";
	private static final String PASSWORD = "&password=1234567";

	private static final String USE_SSL = "&useSSL=false";

	private static final String USE_TIMEZONE = "&useTimezone=true";
	private static final String SERVER_TIMEZONE = "&serverTimezone=UTC";

	private static final String STRING_CONNECTION = SERVER + DATABASE + USER + PASSWORD + USE_SSL + USE_TIMEZONE + SERVER_TIMEZONE;

	public static Connection conectaBD() {		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn =  DriverManager.getConnection(STRING_CONNECTION);
			return conn;
		} catch (SQLException err) {
			System.out.println("Tipo de Exceção: " + err.getClass().getSimpleName() + "\nMensagem: " + err.getMessage());
			return null;
		}
	}

	@Override
	public boolean create(AlunoPOJO aluno) {
		String SQL = "INSERT INTO aluno (matricula, nome, endereco, dataIngresso, dataConclusao) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement pst = AlunoJdbcDAO.conectaBD().prepareStatement(SQL);
			pst.setString(1, aluno.getMatricula());
			pst.setString(2, aluno.getNome());
			pst.setString(3, aluno.getEndereco());
			pst.setString(4, aluno.getDataIngresso().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
			pst.setString(5, aluno.getDataConclusao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
			pst.execute();
			pst.close();
			AlunoJdbcDAO.conectaBD().close();
			return true;
		} catch (SQLException err) {
			System.out.println("Tipo de Exceção: " + err.getClass().getSimpleName() + "\nMensagem: " + err.getMessage());
			return false;
		}
	}

	@Override
	public AlunoPOJO retrieve(String matricula) {
		try {
			AlunoPOJO aluno = new AlunoPOJO();

			PreparedStatement pst = conectaBD().prepareStatement("SELECT matricula, nome, endereco, dataIngresso, dataConclusao FROM aluno WHERE matricula = ?;");
			pst.setString(1, matricula);

			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				String nome = rst.getString("nome");
				String endereco = rst.getString("endereco");
				String dataIngresso = rst.getString("dataIngresso");
				String dataConclusao = rst.getString("dataConclusao");

				aluno.setMatricula(matricula);
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setDataIngresso(LocalDate.parse(dataIngresso, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				aluno.setDataConclusao(LocalDate.parse(dataConclusao, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}
			pst.close();
			AlunoJdbcDAO.conectaBD().close();
			return aluno;
		} catch(Exception err) {
			System.out.println("Tipo de Exceção: " + err.getClass().getSimpleName() + "\nMensagem: " + err.getMessage());
			return null;
		}

	}

	@Override
	public boolean update(AlunoPOJO aluno) {
		//Idêntico ao método create, com mudança apenas na instrução.
		String SQL = "UPDATE aluno SET matricula = ?, nome = ?, endereco = ?, dataIngresso = ?, dataConclusao = ? WHERE matricula = ?;";

		try {
			PreparedStatement pst = AlunoJdbcDAO.conectaBD().prepareStatement(SQL);
			pst.setString(1, aluno.getMatricula());
			pst.setString(2, aluno.getNome());
			pst.setString(3, aluno.getEndereco());
			pst.setString(4, aluno.getDataIngresso().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
			pst.setString(5, aluno.getDataConclusao().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
			pst.setString(6, aluno.getMatricula());
			pst.execute();
			pst.close();
			AlunoJdbcDAO.conectaBD().close();
			return true;
		} catch (SQLException err) {
			System.out.println("Tipo de Exceção: " + err.getClass().getSimpleName() + "\nMensagem: " + err.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(String matricula) {
		try {
			PreparedStatement pst = AlunoJdbcDAO.conectaBD().prepareStatement("DELETE FROM aluno WHERE matricula = ?;");
			pst.setString(1, matricula);
			pst.execute();
			pst.close();
			AlunoJdbcDAO.conectaBD().close();
			return true;
		} catch (SQLException err) {
			System.out.println("Tipo de Exceção: " + err.getClass().getSimpleName() + "\nMensagem: " + err.getMessage());
			return false;
		}

	}

}