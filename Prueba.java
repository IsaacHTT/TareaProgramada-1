import javax.swing.JOptionPane;

public class Prueba{
	public static void main(String [] args){


	//Master master = new Master();

	Jugador player1 = new Jugador(1);
	player1.crearMaster();
	Jugador player2 = new Jugador(2);

	Master master = player1.getMaster();

	master.setGamemode();
 	master.generarFichas();
 	master.repartirFichas();
	master.escogerTurno();

	player1.jugarRondaHotseat();
	

	}
}