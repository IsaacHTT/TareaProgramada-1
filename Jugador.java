import javax.swing.JOptionPane;

public class Jugador{
	//Atributos
	private int noJugador;
	public int puntosJugador;   //estos son public para poder operarlos en el main, ejemplo: player1.suma += 1. esto no se puede con get y con un set quedaría raro
	private int fichasComidas;  //fichas comidas es para saber en que celda de la mano pongo la siguiente ficha comida, para no crear nuevas listas
	public int suma;
	private Master master;
	public int cantidadFichas;
	private String nombre;

	
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

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String imprimirMano(){
		String output = "";
		for(Ficha ficha : this.master.getMano(this.noJugador)){
				if(ficha != null && ficha.getEnMano()){
					String workinside = (" [" + ficha.getArriba() + "|" + ficha.getAbajo() + "](" + ficha.getId() + ")");	
					output += workinside;				
				}
		}
		return output;
	}

///////////////////////////////////////////////////////////////////
	public void jugarRondaHotseat(int turno){

	int n = 1;

	while(n != 0){

		Ficha fichaEscogida;
		fichaEscogida = new Ficha(0, 0, 0);
		Tablero tablero = this.master.getTablero();  //esto simplemente evita escribir todo el lado derecho cada vez que uso el tablero, que son muchas.
		String jugada = JOptionPane.showInputDialog
		(this.nombre + ", escoja su jugada. Digite (p) para poner una ficha, (c) para comer o (n) para pasar." + 
			"\nSus fichas: " + imprimirMano() +
			"\nVista del tablero: [" + tablero.getIzq() + "| ... |" +
			tablero.getDer() +  "]	||	Sus puntos: " + getPuntosJugador());

// Un jugador puede poner (p) una ficha, o comer (c) de la pila común.

		if(jugada.charAt(0) == 'p'){																																																							
			int puesta = Integer.parseInt(JOptionPane.showInputDialog("Escoja una ficha:" + 
																		"\n" + "Sus fichas: " + imprimirMano() + "\nVista del tablero: [" + tablero.getIzq() + "| ... |" 
																		+ tablero.getDer() +"]"));
			for(Ficha ficha : this.master.getMano(this.noJugador)){
				if(ficha != null){ //si es null me da error porque no tiene id y la parte de abajo corrompe el programa. asi el if de abajo se ejecuta solo para fichas no nulas
					if(puesta == ficha.getId()){
					fichaEscogida = ficha;																																																																									
					}
				}
			}
			if(fichaEscogida.getArriba() == tablero.getIzq() || fichaEscogida.getAbajo() == tablero.getIzq() || fichaEscogida.getArriba() == tablero.getDer() || fichaEscogida.getAbajo() == tablero.getDer()){		//esto es necesario y suficiente para que la ficha se pueda poner.

				this.cantidadFichas = this.cantidadFichas - 1; //como la ficha se puede poner si o si, se la descuento al jugador desde ya
				System.out.println(this.cantidadFichas);
				this.suma = this.suma - (fichaEscogida.getArriba() + fichaEscogida.getAbajo());	
				fichaEscogida.setEnMano(false);
				n = 0;

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
				JOptionPane.showMessageDialog(null, "No se puede colocar esa ficha");
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
			this.master.pila = this.master.pila - 1;
		

		}

		else if(jugada.charAt(0) == 'n'){
			if(this.master.getPila() == 0){
				JOptionPane.showMessageDialog(null, "Turno cedido");
				n = 0;
			}
			else{
				JOptionPane.showMessageDialog(null, "No tiene permitido ceder el turno");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Jugada inválida. Digite (p) para poner una ficha, (c) para comer o (n) para pasar.");
		}
	}

	}

}

	
