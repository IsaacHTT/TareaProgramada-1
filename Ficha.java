public class Ficha{
	private int abajo;
	private int arriba;
	private int id;
	private boolean disponible;
	private int dueno;

	public Ficha (int abajo, int arriba, int id){
		this.abajo = abajo;
		this.arriba = arriba;
		this.id = id;
		this.disponible = true;
	}

	public void setDisponible(boolean disponible){
		this.disponible = disponible;
	}

	public void setDueno(int dueno){
		this.dueno = dueno;
	}

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

	public int getDueno(){ //int porque es jugador 1 o 2
		return this.dueno;
	}
}