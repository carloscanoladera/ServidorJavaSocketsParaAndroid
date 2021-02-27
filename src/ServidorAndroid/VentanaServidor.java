package ServidorAndroid;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaServidor {

	private JFrame frame;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaServidor window = new VentanaServidor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaServidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 46, 475, 190);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Arrancar Servidor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ServidorCentros().start();
				textArea.append("El servidor para datos de Android ha sido iniciado...\n");
			}
		});
		btnNewButton.setBounds(111, 137, 135, 21);
		panel.add(btnNewButton);
		
		JButton btnPararServidor = new JButton("Parar Servidor");
		btnPararServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServidorCentros.pararServidor();
				textArea.append("El servidor para datos de Android ha sido parado...\n");
			}
		});
		btnPararServidor.setBounds(284, 137, 142, 21);
		panel.add(btnPararServidor);
		
		JLabel lblNewLabel = new JLabel("Servidor Java Android");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(75, 10, 345, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 305, 481, 184);
		frame.getContentPane().add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
