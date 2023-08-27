package view;

import javax.swing.*;
import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController redes=new RedesController();
		String os=redes.os();
		System.out.println(os);
		String escolha=null;
		
		while(escolha!="Finalizado") {
			escolha=JOptionPane.showInputDialog("1- Chamar funcao ip\n2-Chamar funcao ping\n9- Finalizar");
			if(escolha.equals("1")) {
				redes.ip(os);
			}else if(escolha.equals("2")) {
				redes.ping(os);
			}
			if(escolha.equals("9")){
				JOptionPane.showMessageDialog(null, "Finalizado");
				escolha="Finalizado";
			}
		}
	}
}
