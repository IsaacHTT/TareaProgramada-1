import javax.swing.JOptionPane;

public class Master{

	
	


	public void setGamemode(){
		int gamemode = Integer.parseInt(JOptionPane.showInputDialog("Elija el modo de juego")); //0 IA, 1 Hotseat
	}

	int numeroFichas = Integer.parseInt(JOptionPane.showInputDialog("Elija el numero de fichas"));
	

	Ficha[] listaFichas;
	//Ficha[] huerfanas;

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


		public void repartirFichas(){

			Ficha stageFicha = new Ficha(0, 0, 0);
			
			Ficha[] mano1;
				mano1 = new Ficha[7];
			Ficha[] mano2;
				mano2 = new Ficha[7];

			int m;
			for(m=0; m <=6; m++){
				do{
				int rand1 = (int)(Math.random()*27);
				for(Ficha ficha : listaFichas){
					if (ficha.getId() == rand1){
					stageFicha = ficha;
					}

				}
			} while (stageFicha.getDisponible() == false);
				mano1[m] = stageFicha;
				stageFicha.setDisponible(false);
				System.out.println("Ficha"+m+"de jugador 1"+mano1[m].getId()+": ["+mano1[m].getArriba()+"|"+mano1[m].getAbajo()+"]");

				do{
				int rand2 = (int)(Math.random()*27);
				for(Ficha ficha : listaFichas){
					if (ficha.getId() == rand2){
					stageFicha = ficha;
					}
				}
			} while (stageFicha.getDisponible() == false);
				mano2[m] = stageFicha;
				stageFicha.setDisponible(false);
				System.out.println("Ficha"+m+"de jugador 2"+mano2[m].getId()+": ["+mano2[m].getArriba()+"|"+mano2[m].getAbajo()+"]");
				
			
			
			
			}

			//int huerfana = 0;
			//huerfanas = new Ficha[(((numeroFichas+1)*(numeroFichas+2))/2)-14];
			//for(Ficha ficha : listaFichas){
			//	if(ficha.getDisponible()==true){
			//		huerfanas[huerfana] = ficha;
			//		System.out.println(huerfanas[huerfana].getId()+": ["+huerfanas[huerfana].getArriba()+"|"+huerfanas[huerfana].getAbajo()+"]");
			//		huerfana += huerfana;

			//	}
			//}
		}

		public void escogerTurno(){
			int turno1 = 0;
			for(Ficha ficha : listaFichas){
				if(ficha.getDisponible()==false && ficha.getArriba() == ficha.getAbajo()){
					turno1 = ficha.getId();   //aqui iria un getDueño()
				}
			}
			System.out.println(turno1);
		}

	}
	
	

	
