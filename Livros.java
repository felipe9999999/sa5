package br.com.livros.model;

public class Livros {
    private int id;
	public Object setNomeLivros;
    private static String nomeLivro;
    private static int codigoLivro;
    private static String nomeAutor;

    public Livros() {
    }

    public Livros(String nomeLivro, int codigoLivro, String nomeAutor) {
        this.nomeLivro = nomeLivro;
        this.codigoLivro = codigoLivro;
        this.nomeAutor = nomeAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public static int getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public static String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}

