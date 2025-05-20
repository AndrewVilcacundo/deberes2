import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JSpinner spId;
    private JComboBox cboFaccion;
    private JComboBox cboNombre;
    private JTextField txtPoder;
    private JButton btnAgregar;
    private JTextArea txtListar;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private JButton btnAutobot;
    private JButton btnDecepticon;
    private Lista coleccion=new Lista();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(spId.getValue().toString());
                String f=cboFaccion.getSelectedItem().toString();
                String n=cboNombre.getSelectedItem().toString();
                float p=Float.parseFloat(txtPoder.getText());
                Transformer t=new Transformer(id,f,n,p);
                coleccion.agregar(t);
                txtListar.setText(coleccion.listar());

            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float sumatoria=coleccion.sumarPoder();
                lblResultado.setText("La sumatori total es: "+sumatoria);
            }
        });
        btnAutobot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float aPoder=coleccion.sumarPoderFaccion("Autobot");
                lblResultado.setText("El poder de los autobot es: "+aPoder);
            }
        });

        btnDecepticon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float dPoder= coleccion.sumarPoderFaccion("Decepticon");
                lblResultado.setText("El poder de los decepticon es: "+dPoder);
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

//Suma de decepticon y autobot por separado