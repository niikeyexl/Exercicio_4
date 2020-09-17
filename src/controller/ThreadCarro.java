package controller;

import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThreadCarro extends Thread{
	private int id;
	private JPanel carro;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;
	private int distancia;
	private int pista;
	
	public ThreadCarro(int id, JPanel carro, 
			JTextField txtVencedor, JTextField txtPerdedor) {
		this.id = id;
		this.carro = carro;
		this.txtVencedor = txtVencedor;
		this.txtPerdedor = txtPerdedor;
		this.distancia = 23;
		this.pista = 450;
	}
	
	@Override
	public void run() {
		while(this.distancia<this.pista) {
			correr();
		}
		if(txtVencedor.getText().isEmpty()) {
			txtVencedor.setText("Carro " + this.id);
		}else {
			txtPerdedor.setText("Carro " + this.id);
		}
	}
	
	private void correr() {
		Random random = new Random();
		this.distancia += random.nextInt(20);
		carro.setBounds(this.distancia, 21, 32, 27);
		try {
			sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
