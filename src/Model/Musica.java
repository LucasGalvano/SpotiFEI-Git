package Model;

/**
 *
 * @author Lucas Galvano
 */
public class Musica {
    private int id, duracaoSegundos;
    private String nome, artista, genero;
    
    //Construtores
    public Musica() {
    }

    public Musica(int id, int duracaoSegundos, String nome, String artista, String genero) {
        this.id = id;
        this.duracaoSegundos = duracaoSegundos;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
}
