package View;

import DAO.MusicaDAO;
import DAO.PlaylistDAO;
import Model.Musica;
import Model.Playlist;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Lucas Galvano
 */


public class ResultadoBusca extends JFrame {
    private List<Musica> resultados;
    private MusicaDAO musicaDAO;
    private PlaylistDAO playlistDAO;
    private int userId;

    public ResultadoBusca(List<Musica> resultados, MusicaDAO musicaDAO, PlaylistDAO playlistDAO, int userId) {
        this.resultados = resultados;
        this.musicaDAO = musicaDAO;
        this.playlistDAO = playlistDAO;
        this.userId = userId;

        setTitle("Resultados da Busca");
        setSize(600, 400);
        setLayout(new GridLayout(resultados.size(), 1));

        for (Musica musica : resultados) {
            JPanel painel = new JPanel(new FlowLayout());
            JLabel label = new JLabel(musica.getNomeMusica() + " - " + musica.getArtista());
            JButton bt_curtir_descurtir = new JButton(musica.isCurtida() ? "Descurtir" : "Curtir");
            JButton bt_add_playlist = new JButton("Adicionar à Playlist");

            bt_curtir_descurtir.addActionListener(e -> {
                try {
                    if (musica.isCurtida()) {
                        musicaDAO.descurtirMusica(musica.getId(), userId);
                        musica.setCurtida(false);
                        bt_curtir_descurtir.setText("Curtir");
                    } else {
                        musicaDAO.curtirMusica(musica.getId(), userId);
                        musica.setCurtida(true);
                        bt_curtir_descurtir.setText("Descurtir");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar curtida: " + ex.getMessage());
                }
            });

            bt_add_playlist.addActionListener(e -> {
                try {
                    List<Playlist> playlists = playlistDAO.playlistUsuario(userId);
                    String[] nomes = playlists.stream().map(Playlist::getNomePlaylist).toArray(String[]::new);
                    String selecionada = (String) JOptionPane.showInputDialog(
                        this,
                        "Escolha a playlist:",
                        "Adicionar à Playlist",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nomes,
                        nomes.length > 0 ? nomes[0] : null
                    );

                    if (selecionada != null) {
                        for (Playlist p : playlists) {
                            if (p.getNomePlaylist().equals(selecionada)) {
                                playlistDAO.adicionarMusicaNaPlaylist(p.getPlaylistId(), musica.getId());
                                JOptionPane.showMessageDialog(this, "Música adicionada!");
                                break;
                            }
                        }
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao adicionar: " + ex.getMessage());
                }
            });

            painel.add(label);
            painel.add(bt_curtir_descurtir);
            painel.add(bt_add_playlist);
            add(painel);
        }

        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
