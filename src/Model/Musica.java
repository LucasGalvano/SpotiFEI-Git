package Model;


/**
 *
 * @author Lucas Galvano
 */


public class Musica {
    private int id, duracaoSegundos;
    private String nomeMusica, artista, genero;
    
    //Construtores
    public Musica() {
    }

    public Musica(int id, int duracaoSegundos, String nomeMusica, String artista, String genero) {
        this.id = id;
        this.duracaoSegundos = duracaoSegundos;
        this.nomeMusica = nomeMusica;
        this.artista = artista;
        this.genero = genero;
    }
    
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nome) {
        this.nomeMusica = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    // Método p/ formatar tamanho da musica p min e seg
    public String duracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%d:%02d", minutos, segundos);
    }
}
