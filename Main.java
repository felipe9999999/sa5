package br.com.livros.aplicacao;

import br.com.livros.dao.LivrosDAO;
import br.com.livros.model.Livros;

public class Main {

    public static void main(String[] args) {
    	 LivrosDAO livrosDao = new LivrosDAO();

        Livros livros = new Livros();
        livros.setNomeLivro("jabutica 123");
        livros.setCodigoLivro(363838763);
        livros.setNomeAutor("japa");
        
       //livrosDao.save(livros);
       
       Livros l1 = new Livros();
       l1.setNomeLivro("jabutica 456");
       l1.setCodigoLivro(2324324);
       l1.setNomeAutor("xxxxxxxxx");
       l1.setId(9);
       l1.setId(1);
       
       
      //LivrosDAO.update(l1);
       
       
       //LivrosDAO.deletByID(1);
       
      
        
       // visualicao TODOS registros BD
       
       for(Livros c : LivrosDAO.getLivros()) {
    	   System.out.println("Livros: "+c.getNomeLivro());
       }
    }
}
