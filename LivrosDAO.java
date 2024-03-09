package br.com.livros.dao;

import br.com.livros.factory.ConnectionFactory;
import br.com.livros.model.Livros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;


public class LivrosDAO {
	
	
	
	

	public void save(Livros livros) {
		
		String sql = "INSERT INTO livros(nomeLivro,codigoLivro,nomeAutor) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1,Livros.getNomeLivro());
			pstm.setInt(2,Livros.getCodigoLivro());
			pstm.setString(3, Livros.getNomeAutor());
			
			pstm.execute();
			
			System.out.println("Livro salvo com secess");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public void updte(Livros livros) {
		
		String sql = "UPDATE livros SET nomeLivro= ?, codigoLivro =  ?, nomeAutor = ? "+
				"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm =null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, livros.getNomeLivro());
			pstm.setInt(2, livros.getId());
			pstm.setString(3, livros.getNomeAutor());
			
			pstm.setInt(4, livros.getId());
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id) {
		String sql = "DELETE FROM livros WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstm =null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static List<Livros> getLivros() {

        String sql = "SELECT * FROM livros";

        List<Livros> livrosP = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Livros livros = new Livros();

                livros.setId(rset.getInt("id"));
                livros.setNomeLivro(rset.getString("nomeLivro")); 
                livros.setCodigoLivro(rset.getInt("codigoLivro")); 

                livrosP.add(livros);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close(); 
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return livrosP;
    }
}
