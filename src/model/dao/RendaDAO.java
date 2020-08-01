package model.dao;

import java.sql.*;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Receita;

public class RendaDAO {
		public RendaDAO() {}

		public void create(Receita a) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("INSERT INTO Entradas (Valor, Mês, Descricao, Ano) VALUES(?,?,?,?)");
				stmt.setDouble(1, a.getValor());
				stmt.setInt(2, a.getMes());
				stmt.setString(3, a.getDescricao());
				stmt.setInt(4, a.getAno());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro: "+e);
			}finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
		}
		
	/*
	 * public void findAll(){ Connection con = ConnectionFactory.getConnection();
	 * String sql = "SELECT * FROM Anime"; PreparedStatement stmt = null; ResultSet
	 * rs = null;
	 * 
	 * try { stmt = con.prepareStatement(sql); rs = stmt.executeQuery();
	 * 
	 * while(rs.next()) { Anime anime = new Anime();
	 * anime.setName(rs.getString("Nome")); anime.setCensura(rs.getInt("Censura"));
	 * anime.setDiretor(rs.getString("Diretor"));
	 * anime.setGenero(rs.getString("Genero"));
	 * anime.setData(rs.getString("DataDeProducao"));
	 * System.out.println("Nome: "+anime.getName()+" Diretor: "+anime.getDirector())
	 * ; } JOptionPane.showMessageDialog(null, "Listados no Terminal!"); }
	 * catch(SQLException e){ JOptionPane.showMessageDialog(null, "Erro: "+e); }
	 * finally { ConnectionFactory.closeConnection(con, stmt, rs); } }
	 */
}