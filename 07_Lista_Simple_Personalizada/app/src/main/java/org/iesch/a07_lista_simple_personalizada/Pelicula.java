package org.iesch.a07_lista_simple_personalizada;

public class Pelicula {

    private int imgFoto;
    private String titulo;
    private String ano;

    public Pelicula(int imgFoto, String titulo, String ano) {
        this.imgFoto = imgFoto;
        this.titulo = titulo;
        this.ano = ano;
    }

    public int getImgFoto() {
        return imgFoto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }
}
