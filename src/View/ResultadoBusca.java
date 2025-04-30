package View;

import Model.Musica;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 *
 * @author Lucas Galvano
 */
public class ResultadoBusca extends javax.swing.JFrame {
    private JTable tabela;
    private JScrollPane scrollPane;

    public ResultadoBusca(List<Musica> resultados) {
        setTitle("Resultado da Busca");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colunas = {"ID", "Nome", "Artista", "Gênero", "Duração (s)"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Musica m : resultados) {
            Object[] row = {
                m.getId(),
                m.getNomeMusica(),
                m.getArtista(),
                m.getGenero(),
                m.duracaoFormatada()
            };
            modelo.addRow(row);
        }

        tabela = new JTable(modelo);
        scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);
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
