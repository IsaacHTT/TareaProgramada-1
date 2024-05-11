public class PruebaNull{
	public static void main(String [] args){
	Ficha[] lista;
	lista = new Ficha[3];
	lista[0] = new Ficha(1, 2, 5);
	lista[1] = new Ficha(3, 4, 6);
	lista[2] = new Ficha(5, 6, 7);
	System.out.println(lista[0].getId());
	System.out.println(lista[1].getId());
	System.out.println(lista[2].getId());

	
		lista = null;
	
	lista[0] = new Ficha(9, 8, 1);
	lista[1] = new Ficha(7, 6, 2);
	lista[2] = new Ficha(5, 4, 3);
	System.out.println(lista[0].getId());
	System.out.println(lista[1].getId());
	System.out.println(lista[2].getId());
	}
}