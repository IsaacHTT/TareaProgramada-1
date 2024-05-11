import javax.swing.JOptionPane;

public class Jugador{
	//Atributos
	private int noJugador;
	public int puntosJugador;   //estos son public para poder operarlos en el main, ejemplo: player1.suma += 1. esto no se puede con get y con un set quedaría raro
	private int fichasComidas;  //fichas comidas es para saber en que celda de la mano pongo la siguiente ficha comida, para no crear nuevas listas
	public int suma;
	private Master master;
	public int cantidadFichas;

	
	Ficha[] huerfanas;
	

	public Jugador(int noJugador){
		this.noJugador = noJugador;
		this.puntosJugador = 0;      
		this.fichasComidas = 7;
		this.cantidadFichas = 7;
		this.suma = 0;
	}

	//Métodos

	public void setMaster(Master master){  //esto es para asignarle al player2 el mismo master que al player1
		this.master = master;
	}

	public void crearMaster(){
		this.master = new Master(); //esto solo se usara para el player1, cuyo master sera el de todo el juego
	}
	public Master getMaster(){
		return this.master;
	}

	public int getCantidadFichas(){
		return this.cantidadFichas;
	}

	public int getSuma(){
		return this.suma;
	}
	
	public int getPuntosJugador(){
		return this.puntosJugador;
	}

	public void jugarRondaHotseat(int turno){
		Ficha fichaEscogida;
		fichaEscogida = new Ficha(0, 0, 0);
		String jugada = JOptionPane.showInputDialog("Escoja su jugada " + turno);
		Tablero tablero = this.master.getTablero();  //esto simplemente evita escribir todo el lado derecho cada vez que uso el tablero, que son muchas.

		if(jugada.charAt(0) == 'p'){																																																							
			int puesta = Integer.parseInt(JOptionPane.showInputDialog("Escoja una ficha"));
			for(Ficha ficha : this.master.getMano(this.noJugador)){
				if(ficha != null){ //si es null me da error porque no tiene id y la parte de abajo corromple el programa. asi el if de abajo se ejecuta solo para fichas no nulas
					if(puesta == ficha.getId()){
					fichaEscogida = ficha;																																																																									
					}
				}
			}
			if(fichaEscogida.getArriba() == tablero.getIzq() || fichaEscogida.getAbajo() == tablero.getIzq() || fichaEscogida.getArriba() == tablero.getDer() || fichaEscogida.getAbajo() == tablero.getDer()){		//esto es necesario y suficiente para que la ficha se pueda poner.

				this.cantidadFichas = this.cantidadFichas - 1; //como la ficha se puede poner si o si, se la descuento al jugador desde ya
				this.suma = this.suma - (fichaEscogida.getArriba() + fichaEscogida.getAbajo());	

				if(tablero.getIzq() != tablero.getDer() && ((fichaEscogida.getArriba() == tablero.getIzq() && fichaEscogida.getAbajo() == tablero.getDer()) || (fichaEscogida.getArriba() == tablero.getDer() && fichaEscogida.getAbajo() == tablero.getIzq()))){ //este caso es especial porque si el jugador tiene una ficha que puede poner en
					int ladoEscogido = Integer.parseInt(JOptionPane.showInputDialog("Hay mas de un lado en que puede poner su ficha, escojalo. Use 0 para izquierda y 1 para derecha"));																			//ambos lados del tablero, debe escoger en cual hacerlo
					if(ladoEscogido == 0){
						if(fichaEscogida.getArriba() == tablero.getIzq()){  //esta secuencia busca que lado coincide con cual y "coloca" la pieza donde corresponde. por ejemplo si tengo un 5|6 y quiero ponerlo en la derecha
							tablero.setIzq(fichaEscogida.getAbajo());		//... esto busca cual lado de mi ficha tiene el numero de la derecha, por ejemplo 6, y cambia la derecha del tablero por 5.
						}
						else{
							tablero.setIzq(fichaEscogida.getArriba());
						}
					}
					else{
						if(fichaEscogida.getArriba() == tablero.getDer()){
							tablero.setDer(fichaEscogida.getAbajo());
						}
						else{
							tablero.setDer(fichaEscogida.getArriba());
						}
					}
					
				}

				if(fichaEscogida.getArriba() == tablero.getIzq()){ //en este caso la ficha solo se puede poner en un lado, por lo que el programa lo hace automaticamente
					tablero.setIzq(fichaEscogida.getAbajo());
				}
				else if(fichaEscogida.getArriba() == tablero.getDer()){
					tablero.setDer(fichaEscogida.getAbajo());
				}
				else if(fichaEscogida.getAbajo() == tablero.getIzq()){
					tablero.setIzq(fichaEscogida.getArriba());
				}
				else{
					tablero.setDer(fichaEscogida.getArriba());
				}
			}
			else{
				System.out.println("No se puede poner esa ficha"); //provisional
			}
		}
		
		else if(jugada.charAt(0) == 'c'){
			int comida;
			do{
				comida = (int)(Math.random()*this.master.getCantidadHuerfanas()); //automaticamente se escoge un random y se busca esa ficha entre las huerfanas disponibles
			} while(this.master.getHuerfanas()[comida].getDisponible() == false);

			this.master.getHuerfanas()[comida].setDisponible(false);
			this.master.getMano(this.noJugador)[this.fichasComidas] = this.master.getHuerfanas()[comida];  //este es el enredo; busca la mano del jugador, va a la primera celda vacia, determinada por fcihasComidas, y mete la ficha nueva ahi
			this.cantidadFichas = this.cantidadFichas + 1;
			this.fichasComidas = this.fichasComidas + 1;
			this.suma = this.suma + this.master.getHuerfanas()[comida].getArriba() + this.master.getHuerfanas()[comida].getAbajo(); //le agrega la nueva ficha a la suma

		}

		else{
			//pasar
		}

	}

}

	
