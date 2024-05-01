public class Jugador{
	//Atributos
	private int noJugador;
	private int puntosJugador;
	private Ficha[] manoJugador;

	public Jugador(int noJugador, int puntosJugador, Ficha[] manoJugador){
		this.noJugador = noJugador;
		this.puntosJugador = puntosJugador;
		this.manoJugador = manoJugador;
	}

	//Métodos
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
}