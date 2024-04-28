public class Ficha{
	private int abajo;
	private int arriba;
	private int id;

	public Ficha (int abajo, int arriba, int id){
		this.abajo = abajo;
		this.arriba = arriba;
		this.id = id;
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
}