import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {
    private JTextField nombreField;
    private JTextField cedulaField;
    private JTextField edadField;
    private JTextField buscarCedulaField;
    private JButton guardarButton;
    private JButton buscarButton;
    private JTextArea resultadoArea;

    private Map<String, Estudiante> estudiantes;

    public Main() {
        estudiantes = new HashMap<>();

        setTitle("Gestión de Estudiantes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel insertarPanel = new JPanel(new GridLayout(4, 2));
        nombreField = new JTextField();
        cedulaField = new JTextField();
        edadField = new JTextField();
        guardarButton = new JButton("Guardar");

        insertarPanel.add(new JLabel("Nombre:"));
        insertarPanel.add(nombreField);
        insertarPanel.add(new JLabel("Cédula:"));
        insertarPanel.add(cedulaField);
        insertarPanel.add(new JLabel("Edad:"));
        insertarPanel.add(edadField);
        insertarPanel.add(new JLabel(""));
        insertarPanel.add(guardarButton);

        JPanel buscarPanel = new JPanel(new GridLayout(2, 2));
        buscarCedulaField = new JTextField();
        buscarButton = new JButton("Buscar");
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        buscarPanel.add(new JLabel("Buscar por Cédula:"));
        buscarPanel.add(buscarCedulaField);
        buscarPanel.add(new JLabel(""));
        buscarPanel.add(buscarButton);

        add(insertarPanel, BorderLayout.NORTH);
        add(buscarPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String cedula = cedulaField.getText();
                int edad = Integer.parseInt(edadField.getText());

                Estudiante estudiante = new Estudiante(nombre, cedula, edad);
                estudiantes.put(cedula, estudiante);
                JOptionPane.showMessageDialog(null, "Estudiante guardado exitosamente.");
                limpiarCampos();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = buscarCedulaField.getText();
                Estudiante estudiante = estudiantes.get(cedula);

                if (estudiante != null) {
                    resultadoArea.setText("Nombre: " + estudiante.getNombre() + "\n" +
                            "Cédula: " + estudiante.getCedula() + "\n" +
                            "Edad: " + estudiante.getEdad());
                } else {
                    resultadoArea.setText("Estudiante no encontrado.");
                }
            }
        });
    }

    private void limpiarCampos() {
        nombreField.setText("");
        cedulaField.setText("");
        edadField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
