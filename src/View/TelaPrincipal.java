package View;

import Control.ResultadoBuscaControl;
import DAO.MusicaDAO;
import Model.Musica;
import Model.Usuario;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Lucas Galvano
 */


public class TelaPrincipal extends javax.swing.JFrame {
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(Usuario usuario) {
        initComponents();
        c = new ResultadoBuscaControl(this);
        bt_buscar_home.addActionListener(e -> c.buscarMusicas());
        
        preencherSugestoesFixas();
    }

    
    //Getters e Setters
    public JButton getBt_buscar_home() {
        return bt_buscar_home;
    }

    public void setBt_buscar_home(JButton bt_buscar_home) {
        this.bt_buscar_home = bt_buscar_home;
    }

    public JButton getBt_curtir_home() {
        return bt_curtir_home;
    }

    public void setBt_curtir_home(JButton bt_curtir_home) {
        this.bt_curtir_home = bt_curtir_home;
    }

    public JLabel getLbl_FEI_home() {
        return lbl_FEI_home;
    }

    public void setLbl_FEI_home(JLabel lbl_FEI_home) {
        this.lbl_FEI_home = lbl_FEI_home;
    }

    public JLabel getLbl_SpotiFEI_home() {
        return lbl_SpotiFEI_home;
    }

    public void setLbl_SpotiFEI_home(JLabel lbl_SpotiFEI_home) {
        this.lbl_SpotiFEI_home = lbl_SpotiFEI_home;
    }

    public JLabel getLbl_descubra_novas_musicas() {
        return lbl_descubra_novas_musicas;
    }

    public void setLbl_descubra_novas_musicas(JLabel lbl_descubra_novas_musicas) {
        this.lbl_descubra_novas_musicas = lbl_descubra_novas_musicas;
    }

    public JLabel getLbl_tocando_agora() {
        return lbl_tocando_agora;
    }

    public void setLbl_tocando_agora(JLabel lbl_tocando_agora) {
        this.lbl_tocando_agora = lbl_tocando_agora;
    }

    public JTextField getTxt_busca_home() {
        return txt_busca_home;
    }

    public void setTxt_busca_home(JTextField txt_busca_home) {
        this.txt_busca_home = txt_busca_home;
    }

    public JButton getBt_historico_home() {
        return bt_historico_home;
    }

    public void setBt_historico_home(JButton bt_historico_home) {
        this.bt_historico_home = bt_historico_home;
    }

    public JButton getBt_musicas_curtidas_home() {
        return bt_musicas_curtidas_home;
    }

    public void setBt_musicas_curtidas_home(JButton bt_musicas_curtidas_home) {
        this.bt_musicas_curtidas_home = bt_musicas_curtidas_home;
    }

    public JButton getBt_playlist_home() {
        return bt_playlist_home;
    }

    public void setBt_playlist_home(JButton bt_playlist_home) {
        this.bt_playlist_home = bt_playlist_home;
    }
    
    
    @SuppressWarnings(value = "unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_SpotiFEI_home = new javax.swing.JLabel();
        lbl_FEI_home = new javax.swing.JLabel();
        bt_buscar_home = new javax.swing.JButton();
        txt_busca_home = new javax.swing.JTextField();
        lbl_tocando_agora = new javax.swing.JLabel();
        bt_curtir_home = new javax.swing.JButton();
        lbl_descubra_novas_musicas = new javax.swing.JLabel();
        bt_playlist_home = new javax.swing.JButton();
        bt_musicas_curtidas_home = new javax.swing.JButton();
        bt_historico_home = new javax.swing.JButton();
        sugestoesPanel = new javax.swing.JPanel();
        musicaItemPanel = new javax.swing.JPanel();
        lbl_nome_musica = new javax.swing.JLabel();
        lbl_nome_artista = new javax.swing.JLabel();
        bt_play_home = new javax.swing.JButton();
        musicaItemPanel2 = new javax.swing.JPanel();
        lbl_nome_musica2 = new javax.swing.JLabel();
        lbl_nome_artista2 = new javax.swing.JLabel();
        bt_play_home2 = new javax.swing.JButton();
        musicaItemPanel3 = new javax.swing.JPanel();
        lbl_nome_musica3 = new javax.swing.JLabel();
        lbl_nome_artista3 = new javax.swing.JLabel();
        bt_play_home3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_SpotiFEI_home.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_SpotiFEI_home.setForeground(new java.awt.Color(0, 102, 0));
        lbl_SpotiFEI_home.setText("Spoti");

        lbl_FEI_home.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lbl_FEI_home.setForeground(new java.awt.Color(0, 51, 255));
        lbl_FEI_home.setText("FEI");

        bt_buscar_home.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_buscar_home.setText("Buscar");

        txt_busca_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busca_homeActionPerformed(evt);
            }
        });

        lbl_tocando_agora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tocando_agora.setText("Tocando agora:");

        bt_curtir_home.setText("Curtir");

        lbl_descubra_novas_musicas.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lbl_descubra_novas_musicas.setText("Descubra novas músicas!");

        bt_playlist_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_playlist_home.setText("Playlist");

        bt_musicas_curtidas_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_musicas_curtidas_home.setText("Músicas Curtidas");

        bt_historico_home.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_historico_home.setText("Histórico");
        bt_historico_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_historico_homeActionPerformed(evt);
            }
        });

        sugestoesPanel.setBorder(new javax.swing.border.MatteBorder(null));

        musicaItemPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.darkGray, null, null));

        lbl_nome_musica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_musica.setText("jLabel1");

        lbl_nome_artista.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_artista.setText("jLabel1");

        bt_play_home.setText("Play");

        javax.swing.GroupLayout musicaItemPanelLayout = new javax.swing.GroupLayout(musicaItemPanel);
        musicaItemPanel.setLayout(musicaItemPanelLayout);
        musicaItemPanelLayout.setHorizontalGroup(
            musicaItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicaItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nome_musica)
                .addGap(180, 180, 180)
                .addComponent(lbl_nome_artista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_play_home)
                .addContainerGap())
        );
        musicaItemPanelLayout.setVerticalGroup(
            musicaItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musicaItemPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(musicaItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_musica)
                    .addComponent(lbl_nome_artista)
                    .addComponent(bt_play_home))
                .addGap(15, 15, 15))
        );

        musicaItemPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.darkGray, null, null));

        lbl_nome_musica2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_musica2.setText("jLabel1");

        lbl_nome_artista2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_artista2.setText("jLabel1");

        bt_play_home2.setText("Play");

        javax.swing.GroupLayout musicaItemPanel2Layout = new javax.swing.GroupLayout(musicaItemPanel2);
        musicaItemPanel2.setLayout(musicaItemPanel2Layout);
        musicaItemPanel2Layout.setHorizontalGroup(
            musicaItemPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicaItemPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nome_musica2)
                .addGap(179, 179, 179)
                .addComponent(lbl_nome_artista2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_play_home2)
                .addContainerGap())
        );
        musicaItemPanel2Layout.setVerticalGroup(
            musicaItemPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musicaItemPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(musicaItemPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_musica2)
                    .addComponent(lbl_nome_artista2)
                    .addComponent(bt_play_home2))
                .addGap(15, 15, 15))
        );

        musicaItemPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.darkGray, null, null));

        lbl_nome_musica3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_musica3.setText("jLabel1");

        lbl_nome_artista3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_nome_artista3.setText("jLabel1");

        bt_play_home3.setText("Play");

        javax.swing.GroupLayout musicaItemPanel3Layout = new javax.swing.GroupLayout(musicaItemPanel3);
        musicaItemPanel3.setLayout(musicaItemPanel3Layout);
        musicaItemPanel3Layout.setHorizontalGroup(
            musicaItemPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicaItemPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_nome_musica3)
                .addGap(181, 181, 181)
                .addComponent(lbl_nome_artista3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_play_home3)
                .addContainerGap())
        );
        musicaItemPanel3Layout.setVerticalGroup(
            musicaItemPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musicaItemPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(musicaItemPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_musica3)
                    .addComponent(lbl_nome_artista3)
                    .addComponent(bt_play_home3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sugestoesPanelLayout = new javax.swing.GroupLayout(sugestoesPanel);
        sugestoesPanel.setLayout(sugestoesPanelLayout);
        sugestoesPanelLayout.setHorizontalGroup(
            sugestoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sugestoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sugestoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(musicaItemPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicaItemPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musicaItemPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sugestoesPanelLayout.setVerticalGroup(
            sugestoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sugestoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(musicaItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(musicaItemPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(musicaItemPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_tocando_agora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_curtir_home))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_descubra_novas_musicas)
                                .addGap(132, 132, 132))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_SpotiFEI_home)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_FEI_home, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                                        .addComponent(txt_busca_home, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sugestoesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_buscar_home))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_playlist_home, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_musicas_curtidas_home, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(bt_historico_home, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_SpotiFEI_home)
                    .addComponent(lbl_FEI_home)
                    .addComponent(bt_buscar_home)
                    .addComponent(txt_busca_home, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lbl_descubra_novas_musicas)
                .addGap(18, 18, 18)
                .addComponent(sugestoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_historico_home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_musicas_curtidas_home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_playlist_home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tocando_agora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_curtir_home, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busca_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busca_homeActionPerformed
        c.buscarMusicas();
    }//GEN-LAST:event_txt_busca_homeActionPerformed

    private void bt_historico_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_historico_homeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_historico_homeActionPerformed
    
    private ResultadoBuscaControl c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar_home;
    private javax.swing.JButton bt_curtir_home;
    private javax.swing.JButton bt_historico_home;
    private javax.swing.JButton bt_musicas_curtidas_home;
    private javax.swing.JButton bt_play_home;
    private javax.swing.JButton bt_play_home2;
    private javax.swing.JButton bt_play_home3;
    private javax.swing.JButton bt_playlist_home;
    private javax.swing.JLabel lbl_FEI_home;
    private javax.swing.JLabel lbl_SpotiFEI_home;
    private javax.swing.JLabel lbl_descubra_novas_musicas;
    private javax.swing.JLabel lbl_nome_artista;
    private javax.swing.JLabel lbl_nome_artista2;
    private javax.swing.JLabel lbl_nome_artista3;
    private javax.swing.JLabel lbl_nome_musica;
    private javax.swing.JLabel lbl_nome_musica2;
    private javax.swing.JLabel lbl_nome_musica3;
    private javax.swing.JLabel lbl_tocando_agora;
    private javax.swing.JPanel musicaItemPanel;
    private javax.swing.JPanel musicaItemPanel2;
    private javax.swing.JPanel musicaItemPanel3;
    private javax.swing.JPanel sugestoesPanel;
    private javax.swing.JTextField txt_busca_home;
    // End of variables declaration//GEN-END:variables
}
