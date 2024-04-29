public class Ficha{
	private int abajo;
	private int arriba;
	private int id;
	private boolean disponible;
	//private Jugador dueno;

	public Ficha (int abajo, int arriba, int id){
		this.abajo = abajo;
		this.arriba = arriba;
		this.id = id;
		this.disponible = true;
	}

	public void setDisponible(boolean disponible){
		this.disponible = disponible;
	}

	//public void setDueno(Jugador player){
	//	this.dueno = player;
	//}

	public int getAbajo(){
		return this.abajo;
	}
	public int getArriba(){
		return this.arriba;
	}
	public int getId(){
		return this.id;
	}

	public boolean getDisponible(){
		return this.disponible;
	}

	//public Jugador getDueno(){
	//	return this.dueno;
	//}
}