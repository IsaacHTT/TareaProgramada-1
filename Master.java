import javax.swing.JOptionPane;

public class Master{

	int numeroFichas = Integer.parseInt(JOptionPane.showInputDialog("Elija el numero de fichas"));

	private int cantidadHuerfanas = (((numeroFichas+1)*(numeroFichas+2))/2)-14;
	private Ficha[] bolsa; //esto es la misma listaFichas, pero necesito accederla en el main. 
	private Ficha[] huerfanas; 
	private Ficha[] mano1;
	private Ficha[] mano2;
	private int turno1; //es el jugador 1 o 2
	private Tablero tablero = new Tablero();
	


	public void setGamemode(){
		int gamemode = Integer.parseInt(JOptionPane.showInputDialog("Elija el modo de juego")); //0 IA, 1 Hotseat
	}

	public Tablero getTablero(){
		return this.tablero;
	}
	
	public int getCantidadHuerfanas(){
		return this.cantidadHuerfanas;
	}

	Ficha[] listaFichas;

	public void setBolsa(){
		this.bolsa = listaFichas;
	}

	public Ficha[] getBolsa(){
		return this.bolsa;
	}


	public void generarFichas(){
		
		int i;
		int j;
		int contadorId = 0;

		listaFichas = new Ficha[((numeroFichas+1)*(numeroFichas+2))/2];
		for(i=0; i <= numeroFichas; i++){
			for(j=0; j <= i; j++){
				listaFichas[contadorId] = new Ficha(i, j, contadorId);
				//System.out.println("#"+listaFichas[contadorId].getId()+": ["+listaFichas[contadorId].getArriba()+"|"+listaFichas[contadorId].getAbajo()+"]");
				contadorId = contadorId + 1;

			}
		}

		}

		public Ficha[] getHuerfanas(){
			return this.huerfanas;
		}


		public void repartirFichas(){

			Ficha stageFicha = new Ficha(0, 0, 0);
			this.mano1 = new Ficha[28];
			this.mano2 = new Ficha[28];
			

			int m;
			for(m=0; m <= 6; m++){
				do{												//selecciona una ficha, aun no la asigna
				int rand1 = (int)(Math.random()*28);
				for(Ficha ficha : listaFichas){
					if (ficha.getId() == rand1){
					stageFicha = ficha;
					}

				}
			} while (stageFicha.getDisponible() == false);  //si la ficha seleccionada no esta en la pila, vuelve a seleccionar una al azar
				this.mano1[m] = stageFicha;                      //cuando escogió una ficha que sí está disponible, se la asigna al jugador
				stageFicha.setDisponible(false);			//esta ficha ya no estara disponible

				System.out.println("Ficha"+m+"de jugador 1"+mano1[m].getId()+": ["+mano1[m].getArriba()+"|"+mano1[m].getAbajo()+"]");
				stageFicha.setDueno(1);




				do{
				int rand2 = (int)(Math.random()*27);
				for(Ficha ficha : listaFichas){
					if (ficha.getId() == rand2){
					stageFicha = ficha;
					}
				}
			} while (stageFicha.getDisponible() == false);
				this.mano2[m] = stageFicha;
				stageFicha.setDisponible(false);
				System.out.println("Ficha"+m+"de jugador 2"+mano2[m].getId()+": ["+mano2[m].getArriba()+"|"+mano2[m].getAbajo()+"]");
				stageFicha.setDueno(2);
			
			
			
			}

			int huerfana = 0;
			huerfanas = new Ficha[(((numeroFichas+1)*(numeroFichas+2))/2)-14];
			for(Ficha ficha : listaFichas){
				if(ficha.getDisponible()==true){
					this.huerfanas[huerfana] = ficha;
					//System.out.println(huerfanas[huerfana].getId()+": ["+huerfanas[huerfana].getArriba()+"|"+huerfanas[huerfana].getAbajo()+"]");
					huerfana += 1;

				}
			}
		}

		public void escogerTurno(){
			int primera = 0;
			for(Ficha ficha : listaFichas){
				if(ficha.getDisponible() == false && ficha.getArriba() == ficha.getAbajo()){  			//busca todas las fichas dobles con dueno. si no tiene dueno la ignora, si no es doble tambien.
					this.turno1 = ficha.getDueno();   //aqui iria un getDueño()									//la ultima asignación a turno1 se da con la ficha doble mas grande. si un jugador tiene doble 3, 
					primera = ficha.getArriba();
				}																						//pero el otro tiene doble 4, el for volvera a ejecutarse hasta llegar a este y asignarle turno1.
			}
			System.out.println(turno1);
			
			this.tablero.setIzq(primera);															//esto equivale a poner la ficha doble mas grande en el tablero
			this.tablero.setDer(primera);
		}

		public int getTurno1(){
			return this.turno1;
		}



		public Ficha[] getMano(int noMano){                 //tiene un parametro que sera el noJugador, asi se sabe la mano de quien se esta pidiendo
			Ficha[] stageMano;
			stageMano = new Ficha[28];
			if(noMano == 1){
				stageMano = this.mano1;
			}
			else if(noMano == 2){
				stageMano = this.mano2;
			}
			//System.out.println(stageMano[1].getId());
			return stageMano;
		}



	}
	
	

	
