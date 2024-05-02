import javax.swing.JOptionPane;

public class Prueba{
	public static void main(String [] args){


	Master master = new Master();

	master.setGamemode();
 	master.generarFichas();
 	master.repartirFichas();
	master.escogerTurno();

	Jugador player = new Jugador();
	player.jugarRondaHotseat();
	

	}
}