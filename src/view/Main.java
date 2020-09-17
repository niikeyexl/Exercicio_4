package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ThreadCarro;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;
	private JPanel [] carro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		carro = new JPanel [2];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 137, 540, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 65, 540, 71);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		carro[0] = new JPanel();
		carro[0].setBounds(23, 21, 32, 27);
		panel_1.add(carro[0]);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 146, 540, 71);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		carro[1] = new JPanel();
		carro[1].setBounds(23, 21, 32, 27);
		panel_1_1.add(carro[1]);
		
		JLabel lblNewLabel = new JLabel("Carro 1");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 38, 65, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCarro = new JLabel("Carro 2");
		lblCarro.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCarro.setBounds(10, 228, 65, 14);
		contentPane.add(lblCarro);
		
		JButton btnIniciar = new JButton("Correr");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carro[0].setBounds(23, 21, 32, 27);
				carro[1].setBounds(23, 21, 32, 27);
				txtVencedor.setText("");
				txtPerdedor.setText("");
				for(int i=0; i<2; i++) {
					Thread t = new ThreadCarro(i + 1, carro[i], txtVencedor, txtPerdedor);
					t.start();
				}
			}
		});
		btnIniciar.setBounds(441, 257, 89, 23);
		contentPane.add(btnIniciar);
		
		txtVencedor = new JTextField();
		txtVencedor.setEditable(false);
		txtVencedor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVencedor.setBounds(148, 257, 86, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setEditable(false);
		txtPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtPerdedor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPerdedor.setColumns(10);
		txtPerdedor.setBounds(270, 258, 86, 20);
		contentPane.add(txtPerdedor);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVencedor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVencedor.setBounds(148, 232, 86, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerdedor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPerdedor.setBounds(270, 233, 86, 14);
		contentPane.add(lblPerdedor);
	}
}
