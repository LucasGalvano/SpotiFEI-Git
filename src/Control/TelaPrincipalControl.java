package Control;

import DAO.Conexao;
import DAO.MusicaDAO;
import Model.Musica;
import View.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucas Galvano
 */


public class TelaPrincipalControl {
    private TelaPrincipal view;
    private int userId;

    public TelaPrincipalControl(TelaPrincipal view, int userId) {
        this.view = view;
        this.userId = userId;
    }

    public void carregarMusicasAleatorias() {
        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();
            MusicaDAO musicaDAO = new MusicaDAO(conn);
            List<Musica> musicas = musicaDAO.musicasAleatorias(3);

            if (musicas.size() >= 3) {
                view.getLbl_nome_musica().setText(musicas.get(0).getNomeMusica());
                view.getLbl_nome_artista().setText(musicas.get(0).getArtista());

                view.getLbl_nome_musica2().setText(musicas.get(1).getNomeMusica());
                view.getLbl_nome_artista2().setText(musicas.get(1).getArtista());

                view.getLbl_nome_musica3().setText(musicas.get(2).getNomeMusica());
                view.getLbl_nome_artista3().setText(musicas.get(2).getArtista());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar sugestões: " + ex.getMessage());
        }
    }
}
