import javax.swing.JOptionPane;

public class Prueba{
	public static void main(String [] args){

	JOptionPane.showMessageDialog(null, "Bienvenido a este juego de domino. Presiona ok para comenzar y escoger tu configuracion de juego.");

	Jugador player1 = new Jugador(1); //crea los jugadores, un solo master asociado a player1 y le asigna el mismo master a player2
	player1.crearMaster();
	Jugador player2 = new Jugador(2);
	Master master = player1.getMaster(); //evita usar getMaster un monton de veces
	player2.setMaster(master);
	master.setBolsa(); //hace que se pueda acceder a listaFichas con master.bolsa. esto porque listafichas no es un atributo. basicamente me dio pereza cambiar todas las veces que aparecia lisatfichas
	System.out.println(player1.getCantidadFichas() + "1" + player2.getCantidadFichas()); //print de prueba

	master.setGamemode(); //lo primero despues de la bienvenida es el modo de juego


	while(player1.getPuntosJugador() < 70 && player2.getPuntosJugador() < 70){  //se jugara un set siempre que ningun jugador tenga 70pts
 		master.generarFichas(); //todo set empieza generando fichas, repartiendolas, y determinando quien empieza
 		master.repartirFichas();
		master.escogerTurno();

	
		for(int i = 0; i <= 6; i++){																				//esto hace las sumas iniciales con base en las manos de cada jugador
		player1.suma = player1.getSuma() + master.getMano(1)[i].getArriba() + master.getMano(1)[i].getAbajo();
		}
		for(int i = 0; i <= 6; i++){	
		player2.suma = player2.getSuma() + master.getMano(2)[i].getArriba() + master.getMano(2)[i].getAbajo();		//estas sumas iran cambiando durante el set
		}

		if(master.getTurno1() == 1){
		player1.suma = player1.getSuma() - 2*(master.getTablero().getIzq());										//la pieza del turno1 ya esta puesta, pero no se le ha descontado a su dueno. esto se hace aqui
		}
		else{
		player2.suma = player2.getSuma() - 2*(master.getTablero().getIzq());
		}

		if(master.getTurno1() == 1){				//el jugador con el turno1 ya jugo su turno, al poner la primera pieza, entonces se debe "emparejar" para poder inciar el bucle de turnos sin problemas.
			player2.jugarRondaHotseat(2);
		}
		else{
			player1.jugarRondaHotseat(1);			//esto busca el jugador que no tiene el turno1, y le da un turno
		}

		System.out.println(player1.getCantidadFichas() + "2" + player2.getCantidadFichas()); //print de prueba

		while(player1.getCantidadFichas() > 0 && player2.getCantidadFichas() > 0){				//siempre que ambos jugadores tengan fichas se jugara una ronda
			if(master.getTurno1() == 1){														//los if y else grandes buscan el jugador del turno1 y le otorgan la prioridad
				player1.jugarRondaHotseat(1);													//el jugador con prioridad juega su turno
				System.out.println(player1.getCantidadFichas() + "3" + player2.getCantidadFichas());  //print de prueba

				if(player1.getCantidadFichas() > 0 && player2.getCantidadFichas() > 0){				//puede ser que el jugador con prioridad ya se haya quedado sin fichas, en este caso, este if no se satisface y el while tampoco
					player2.jugarRondaHotseat(2);													//entonces se acaba el set
				}
			}
			else{
				player2.jugarRondaHotseat(2);
				System.out.println(player1.getCantidadFichas() + "3" + player2.getCantidadFichas());
				if(player1.getCantidadFichas() > 0 && player2.getCantidadFichas() > 0){
					player1.jugarRondaHotseat(1);
				}
			}
		System.out.println(player1.getCantidadFichas() + "4" + player2.getCantidadFichas()); //print de prueba
		}

		if(player1.getCantidadFichas() == 0){				//busca el jugador que se quedo sin fichas y le otorga los puntos
			player1.puntosJugador = player1.getPuntosJugador() + player2.getSuma();
		}
		else{
			player2.puntosJugador = player2.getPuntosJugador() + player1.getSuma();
		}

		for(Ficha ficha : master.getBolsa()){			//MUY IMPORTANTE: se limpian todas las listas antes de iniciar un nuevo set. todos sus elementos se vuelven null, 
			ficha = null;								//pero al volver a generar y repartir se rellenan
		}

		for(Ficha ficha : master.getHuerfanas()){
			ficha = null;
		}

		for(Ficha ficha : master.getMano(1)){
			ficha = null;
		}

		for(Ficha ficha : master.getMano(2)){
			ficha = null;
		}

		player1.suma = 0; //reinicia las sumas
		player2.suma = 0;
	}

	if(player1.puntosJugador >= 70){ //una vez un jugador alcanzo los 70pts, busca cual es y le da la victoria
		//gana jugador1
	}
	else{
		//gana jugador2
	}

	//System.out.println(player1.cantidadFichas + player2.cantidadFichas);


	
	
	

	}
}
