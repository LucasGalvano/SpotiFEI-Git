package View;

import DAO.MusicaDAO;
import Model.Musica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Lucas Galvano
 */


public class ResultadoBusca extends JFrame {
    private JPanel painelPrincipal;
    private MusicaDAO musicaDAO;
    private int userId;

    public ResultadoBusca(List<Musica> musicas, MusicaDAO dao, int userId) {
        this.userId = userId;
        this.musicaDAO = dao;
        setTitle("Resultado da Busca");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        for (Musica m : musicas) {
            JPanel linha = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel info = new JLabel(m.getNomeMusica() + " - " + m.getArtista() + " [" + m.getGenero() + "]");
            JButton botao = new JButton(m.isCurtida() ? "Descurtir" : "Curtir");

            botao.addActionListener((ActionEvent e) -> {
                try {
                    if (m.isCurtida()) {
                        musicaDAO.descurtirMusica(m.getId(), userId);
                        m.setCurtida(false);
                        botao.setText("Curtir");
                    } else {
                        musicaDAO.curtirMusica(m.getId(), userId);
                        m.setCurtida(true);
                        botao.setText("Descurtir");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar curtida: " + ex.getMessage());
                }
            });

            linha.add(info);
            linha.add(botao);
            painelPrincipal.add(linha);
        }

        JScrollPane scroll = new JScrollPane(painelPrincipal);
        add(scroll);
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
