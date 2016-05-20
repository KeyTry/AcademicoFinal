/*
 * Tarea 02
 * Sistema Acad�mico con conexi�n a Base de Datos
 * 
 * Curso: Daniel Somarribas Quir�s
 * Carnet: b57072
 * Mayo, 2016
 */
package Vista.Frame.Ver;

import Modelo.Database.ConexionBD;
import Modelo.Metodos.MTDS_Cursos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielSQ
 */
public class FRM_VerCursos extends javax.swing.JFrame {
    ConexionBD baseDatos;
    DefaultTableModel model;
    String tipo;
    MTDS_Cursos metodos;
    
    /**
     * Creates new form FRM_viewCursos
     */
    public FRM_VerCursos(ConexionBD baseDatos) 
    {
        model = new DefaultTableModel();
        this.baseDatos = baseDatos;
        initComponents();
        resetTabla();
    }
    
    /**
     * Define el modelo de la tabla
     */
    public void defineModel()
    {
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Créditos");
    }
    
    /**
     * Reinicia la tabla
     * Define que las tablas no sean editables
     */
    public void resetTabla()
    {
        model = null;
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        defineModel();
        jtbl_Cursos.setModel(model);
    }
    
    /**
     * Llena la tabla con la información de la Base de Datos
     */
    public void updateTabla()
    {
        int numeroFilas = 0;
        String[][] info = null;
        
        if(tipo.equals("Base"))
        {
            numeroFilas = baseDatos.numeroFilasCursos();
            info = baseDatos.InfoTotalCursos(numeroFilas);
        }
        
        if(tipo.equals("Texto") || tipo.equals("XML"))
        {
            numeroFilas = metodos.getTamanoArray();
            info = metodos.getTodos();
        }
        
        for(int i=0;i<numeroFilas;i++)
        {
            String infoFila[] = new String[3];
            
            System.out.println("Agregando Fila: "+i);
            
            infoFila[0] = info[i][0];
            infoFila[1] = info[i][1];
            infoFila[2] = info[i][2];
            
            model.addRow(infoFila);
            
            System.out.println("Fila Añadida:\n"+
                    "Código: "+infoFila[0]+" "+
                    "Nombre: "+infoFila[1]+" "+
                    "Créditos: "+infoFila[2]+" ");
            
            infoFila = new String[3];
        }
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    
    public void setMetodos(MTDS_Cursos metodos)
    {
        this.metodos = metodos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtn_Salir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_Cursos = new javax.swing.JTable();

        setTitle("Ver Cursos");

        jbtn_Salir.setText("Salir");
        jbtn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SalirActionPerformed(evt);
            }
        });

        jtbl_Cursos.setModel(model);
        jScrollPane2.setViewportView(jtbl_Cursos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jbtn_Salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_SalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbtn_SalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtn_Salir;
    private javax.swing.JTable jtbl_Cursos;
    // End of variables declaration//GEN-END:variables
}
