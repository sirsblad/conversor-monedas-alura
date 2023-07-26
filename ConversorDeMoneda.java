import java.awt.event.*;
import javax.swing.*;

public class ConversorDeMoneda extends JFrame implements ActionListener {
    private JPanel panel;
    private JComboBox<String> monedaOrigen, monedaDestino;
    private JTextField cantidad;
    private JButton convertir;
    private JScrollPane scrollPane;
    
    public ConversorDeMoneda() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Conversor de Moneda");
        
        panel = new JPanel();
        monedaOrigen = new JComboBox<String>(new String[] {"Lempiras", "Dólares estadounidenses", "Euros", "Libras esterlinas", "Yen japonés", "Won surcoreano"});
        monedaDestino = new JComboBox<String>(new String[] {"Dólares estadounidenses", "Euros", "Libras esterlinas", "Yen japonés", "Won surcoreano", "Lempiras"});
        cantidad = new JTextField(10);
        convertir = new JButton("Convertir");
        convertir.addActionListener(this);
        scrollPane = new JScrollPane();
        
        panel.add(monedaOrigen);
        panel.add(cantidad);
        panel.add(monedaDestino);
        panel.add(convertir);
        panel.add(scrollPane);
        add(panel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertir) {
            String monedaO = (String) monedaOrigen.getSelectedItem();
            String monedaD = (String) monedaDestino.getSelectedItem();
            double cantidadM = Double.parseDouble(cantidad.getText());
            double resultado = convertirMoneda(monedaO, monedaD, cantidadM);
            scrollPane.setViewportView(new JLabel(String.format("%.2f %s = %.2f %s", cantidadM, monedaO, resultado, monedaD)));
        }
    }
    
    private double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasa = 0.0;
        switch(monedaOrigen) {
            case "Lempiras":
                switch(monedaDestino) {
                    case "Dólares estadounidenses":
                        tasa = 0.041;
                        break;
                    case "Euros":
                        tasa = 0.035;
                        break;
                    case "Libras esterlinas":
                        tasa = 0.030;
                        break;
                    case "Yen japonés":
                        tasa = 4.47;
                        break;
                    case "Won surcoreano":
                        tasa = 48.85;
                        break;
                }
                break;
            case "Dólares estadounidenses":
                switch(monedaDestino) {
                    case "Lempiras":
                        tasa = 24.56;
                        break;
                    case "Euros":
                        tasa = 0.85;
                        break;
                    case "Libras esterlinas":
                        tasa = 0.73;
                        break;
                    case "Yen japonés":
                        tasa = 109.61;
                        break;
                    case "Won surcoreano":
                        tasa = 1182.45;
                        break;
                }
                break;
            case "Euros":
                switch(monedaDestino) {
                    case "Lempiras":
                        tasa = 28.72;
                        break;
                    case "Dólares estadounidenses":
                        tasa = 1.18;
                        break;
                    case "Libras esterlinas":
                        tasa = 0.86;
                        break;
                    case "Yen japonés":
                        tasa = 128.37;
                        break;
                    case "Won surcoreano":
                        tasa = 1387.97;
                        break;
                }
                break;
            case "Libras esterlinas":
                switch(monedaDestino) {
                    case "Lempiras":
                        tasa = 33.09;
                        break;
                    case "Dólares estadounidenses":
                        tasa = 1.38;
                        break;
                    case "Euros":
                        tasa = 1.17;
                        break;
                    case "Yen japonés":
                        tasa = 147.38;
                        break;
                    case "Won surcoreano":
                        tasa = 1593.29;
                        break;
                }
                break;
            case "Yen japonés":
                switch(monedaDestino) {
                    case "Lempiras":
                        tasa = 0.22;
                        break;
                    case "Dólares estadounidenses":
                        tasa = 0.0091;
                        break;
                    case "Euros":
                        tasa = 0.0078;
                        break;
                    case "Libras esterlinas":
                        tasa = 0.0068;
                        break;
                    case "Won surcoreano":
                        tasa = 10.84;
                        break;
                }
                break;
            case "Won surcoreano":
                switch(monedaDestino) {
                    case "Lempiras":
                        tasa = 0.020;
                        break;
                    case "Dólares estadounidenses":
                        tasa = 0.00085;
                        break;
                    case "Euros":
                        tasa = 0.00072;
                        break;
                    case "Libras esterlinas":
                        tasa = 0.00063;
                        break;
                    case "Yen japonés":
                        tasa = 0.092;
                        break;
                }
                break;
        }
        double resultado = cantidad * tasa;
        return resultado;
    }
    
    public static void main(String[] args) {
        new ConversorDeMoneda();
    }
}

