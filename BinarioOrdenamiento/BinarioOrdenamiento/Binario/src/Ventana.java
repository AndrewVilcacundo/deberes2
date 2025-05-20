import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtNombre;
    private JTextField txtRendimiento;
    private JComboBox cboPosicion;
    private JButton btnRegistrar;
    private JTextArea txtListado;
    private JSpinner spCodigo;
    private JButton btnBuscar;
    private JButton btnMostrar;
    private JSpinner spId;
    private JButton btnEditar;
    private JButton btnEliminar;
    private Equipo eq1=new Equipo();
    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int id=Integer.parseInt(spId.getValue().toString());
                String nombre=txtNombre.getText();
                float ren=Float.parseFloat(txtRendimiento.getText());
                String pos=cboPosicion.getSelectedItem().toString();
               Jugador n=new Jugador(id,nombre, ren, pos);
              try {
                  eq1.agregarJugador(n);
              }catch(Exception ex){
                  JOptionPane.showMessageDialog(null,ex.getMessage());
              }
               txtListado.setText(eq1.listarTodos());
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spCodigo.getValue().toString());
                try{
                    Jugador j=eq1.buscarJugador(codigo);
                    txtListado.setText(j.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListado.setText(eq1.listarTodos());
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo=Integer.parseInt(spCodigo.getValue().toString());
                String nuevoNombre=txtNombre.getText();
                float ren=Float.parseFloat(txtRendimiento.getText());
                String pos=cboPosicion.getSelectedItem().toString();
                try{
                    eq1.editarJugador(codigo,nuevoNombre,ren,pos);
                    txtListado.setText(eq1.listarTodos());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,
                            ex.getMessage());
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(spCodigo.getValue().toString());
                try {
                    eq1.eliminarJugador(codigo);
                    txtListado.setText(eq1.listarTodos());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
