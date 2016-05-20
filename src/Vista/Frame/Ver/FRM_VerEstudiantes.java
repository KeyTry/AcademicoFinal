/*
 * Tarea 02
 * Sistema Acad�mico con conexi�n a Base de Datos
 * 
 * Estudiante: Daniel Somarribas Quir�s
 * Carnet: b57072
 * Mayo, 2016
 */
package Vista.Frame.Ver;

import Modelo.Database.ConexionBD;
import Modelo.Metodos.MTDS_Estudiantes;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DanielSQ
 */
public class FRM_VerEstudiantes extends javax.swing.JFrame {
    ConexionBD baseDatos;
    DefaultTableModel model;
    MTDS_Estudiantes metodos;
    String tipo;
    
    /**
     * Creates new form FRM_viewEstudiantes
     */
    public FRM_VerEstudiantes(ConexionBD baseDatos) 
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
        model.addColumn("Dirección");
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
        jtbl_Estudiantes.setModel(model);
    }
    
    /**
     * Llena la tabla con la información de la Base de Datos
     */
    public void updateTabla()
    {
        if(tipo.equals("Base"))
        {
            int numeroFilas = baseDatos.numeroFilasEstudiantes();
            String[][] info = baseDatos.InfoTotalEstudiantes(numeroFilas);
            
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
                        "Dirección: "+infoFila[2]+" ");
                
                infoFila = new String[3];
            }
        }
        
        if(tipo.equals("Texto") || tipo.equals("XML"))
        {
            int numeroFilas = metodos.getTamano();
            String[][] info = metodos.getTodos();
            
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
                        "Dirección: "+infoFila[2]+" ");
                
                infoFila = new String[3];
            }
        }
    }
    
    public void setMetodos(MTDS_Estudiantes metodos)
    {
        this.metodos = metodos;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Estudiantes = new javax.swing.JTable();
        jbtn_Salir = new javax.swing.JButton();

        setTitle("Ver Estudiantes");
        setResizable(false);

        jtbl_Estudiantes.setModel(model);
        jtbl_Estudiantes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbl_Estudiantes);

        jbtn_Salir.setText("Salir");
        jbtn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jbtn_Salir)
                .addContainerGap(240, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Salir;
    private javax.swing.JTable jtbl_Estudiantes;
    // End of variables declaration//GEN-END:variables
}