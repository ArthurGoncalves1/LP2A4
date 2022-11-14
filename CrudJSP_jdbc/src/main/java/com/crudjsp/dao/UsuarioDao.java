package com.crudjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjsp.bean.Usuario;

public class UsuarioDao {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjsp", "root", "1234567");
			
		}catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
		return con;
	}
	
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				list.add(usuario);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}