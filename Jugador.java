import javax.swing.JOptionPane;

public class Jugador{
	//Atributos
	private int noJugador;
	private int puntosJugador;
	private Ficha[] manoJugador;
	//private boolean noFichas = false;
	private int fichasComidas = 7;
	private int suma;
	private Master master;

	int cantidadHuerfanas;
	Ficha[] huerfanas;
	Tablero tablero = new Tablero();
	Ficha fichaEscogida = new Ficha(0, 0, 0);
	//Master master = new Master();

	public Jugador(int noJugador){
		this.noJugador = noJugador;
	//	this.puntosJugador = puntosJugador;
	//	this.manoJugador = manoJugador;
	}

	//Métodos



	public void crearMaster(){
		this.master = new Master();
	}
	public Master getMaster(){
		return this.master;
	}

	public void setNoJugador(int noJugador){
		this.noJugador = noJugador;
	}
	public void setPuntosJugador(int puntosJugador){
		this.puntosJugador = puntosJugador;
	}
	public void setManoJugador(Ficha[] manoJugador){
		this.manoJugador = manoJugador;
	}
	public Ficha[] getManoJugador(){
		return manoJugador;
	}
	public void pasarTurno(){

	}
	public void ponerFicha(int fichaId){

	}
	public void comerFicha(int fichaID){
		
	}
	
	public void jugarRondaHotseat(){
		String jugada = JOptionPane.showInputDialog("Escoja su jugada");

		if(jugada.charAt(0) == 'p'){																																																							
			int puesta = Integer.parseInt(JOptionPane.showInputDialog("Escoja una ficha"));
			for(Ficha ficha : this.manoJugador){
				if(puesta == ficha.getId()){
					fichaEscogida = ficha;																																																																									
				}
			}
			if(fichaEscogida.getArriba() == tablero.getIzq() || fichaEscogida.getAbajo() == tablero.getIzq() || fichaEscogida.getArriba() == tablero.getDer() || fichaEscogida.getAbajo() == tablero.getDer()){		

				//this.cantidadFichas = this.cantidadFichas - 1;
				this.suma = this.suma - (fichaEscogida.getArriba() + fichaEscogida.getAbajo());	

				if(tablero.getIzq() != tablero.getDer() && ((fichaEscogida.getArriba() == tablero.getIzq() && fichaEscogida.getAbajo() == tablero.getDer()) || (fichaEscogida.getArriba() == tablero.getDer() && fichaEscogida.getAbajo() == tablero.getIzq()))){
					int ladoEscogido = Integer.parseInt(JOptionPane.showInputDialog("Hay mas de un lado en que puede poner su ficha, escojalo. Use 0 para izquierda y 1 para derecha"));
					if(ladoEscogido == 0){
						if(fichaEscogida.getArriba() == tablero.getIzq()){
							tablero.setIzq(fichaEscogida.getArriba());
						}
						else{
							tablero.setIzq(fichaEscogida.getAbajo());
						}
					}
					else{
						if(fichaEscogida.getArriba() == tablero.getDer()){
							tablero.setDer(fichaEscogida.getArriba());
						}
						else{
							tablero.setDer(fichaEscogida.getAbajo());
						}
					}
					
				}

				if(fichaEscogida.getArriba() == tablero.getIzq()){
					tablero.setIzq(fichaEscogida.getArriba());
				}
				else if(fichaEscogida.getArriba() == tablero.getDer()){
					tablero.setDer(fichaEscogida.getArriba());
				}
				else if(fichaEscogida.getAbajo() == tablero.getIzq()){
					tablero.setIzq(fichaEscogida.getAbajo());
				}
				else{
					tablero.setDer(fichaEscogida.getAbajo());
				}
			}
			else{
				System.out.println("No se puede poner esa ficha");
			}
		}
		
		else if(jugada.charAt(0) == 'c'){
			int comida;
			do{
				comida = (int)(Math.random()*cantidadHuerfanas);
			} while(this.master.getHuerfanas()[comida].getDisponible() == false);

			this.master.getHuerfanas()[comida].setDisponible(false);
			this.master.getMano()[this.fichasComidas] = this.master.getHuerfanas()[comida];
			this.fichasComidas = this.fichasComidas + 1;
			this.suma = this.suma + this.master.getHuerfanas()[comida].getArriba() + this.master.getHuerfanas()[comida].getAbajo();

		}

		else{
			//pasar
		}

	}

}

	
