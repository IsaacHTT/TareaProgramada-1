import javax.swing.JOptionPane;

public class Prueba{
	public static void main(String [] args){


	Master master1 = new Master();

	master1.setGamemode();
 	master1.generarFichas();
 	master1.repartirFichas();
	master1.escogerTurno();
	

	}
}