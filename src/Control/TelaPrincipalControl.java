package Control;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucas Galvano
 */


public class TelaPrincipalControl {
    private TelaPrincipal view;
    private int userId;
    private List<Musica> musicasExibidas = new ArrayList<>(); // Dessa forma deve manter de forma fixa as 3 msc aleat
    
    public TelaPrincipalControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }

    public void carregarMusicasAleatorias() {
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            MusicaDAO musicaDAO = new MusicaDAO(conn);
            musicasExibidas = musicaDAO.musicasAleatorias(3);

            if (musicasExibidas.size() >= 3) {
                view.getLbl_nome_musica().setText(musicasExibidas.get(0).getNomeMusica());
                view.getLbl_nome_artista().setText(musicasExibidas.get(0).getArtista());

                view.getLbl_nome_musica2().setText(musicasExibidas.get(1).getNomeMusica());
                view.getLbl_nome_artista2().setText(musicasExibidas.get(1).getArtista());

                view.getLbl_nome_musica3().setText(musicasExibidas.get(2).getNomeMusica());
                view.getLbl_nome_artista3().setText(musicasExibidas.get(2).getArtista());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar sugestões: " + ex.getMessage());
        }
    }
    
        public void curtirMusicaAtual() {
        String nomeAtual = view.getLbl_musicaAtual().getText();
        if (nomeAtual == null || nomeAtual.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Nenhuma música selecionada para curtir.");
            return;
        }

        for (Musica m : musicasExibidas) {
            if (m.getNomeMusica().equals(nomeAtual)) {
                try {
                    Conexao conexao = new Conexao();
                    Connection conn = conexao.getConnection();
                    MusicaDAO musicaDAO = new MusicaDAO(conn);
                    boolean estaCurtida = musicaDAO.isMusicaCurtida(m.getMusicaId(), userId);
                    
                    if(estaCurtida){
                        JOptionPane.showMessageDialog(view, "Essa música já está entre suas curtidas!");
                    }
                    else{
                        musicaDAO.curtirMusica(m.getMusicaId(), userId);
                        JOptionPane.showMessageDialog(view, "Você curtiu: " + m.getNomeMusica());
                    }
                    return;
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(view, "Erro ao curtir música: " + e.getMessage());
                }
            }
        }

        JOptionPane.showMessageDialog(view, "Música não encontrada entre as sugestões.");
    }
}
