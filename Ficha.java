public class Ficha{
	private int abajo;
	private int arriba;
	private int id;
	private boolean disponible;

	public Ficha (int abajo, int arriba, int id){
		this.abajo = abajo;
		this.arriba = arriba;
		this.id = id;
	}

	public void setDisponible(boolean disponible){
		this.disponible = disponible;
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
}