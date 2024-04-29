import javax.swing.JOptionPane;

public class Master{

	
	


	public void setGamemode(){
		int gamemode = Integer.parseInt(JOptionPane.showInputDialog("Elija el modo de juego")); //0 IA, 1 Hotseat
	}

	int numeroFichas = Integer.parseInt(JOptionPane.showInputDialog("Elija el numero de fichas"));
	

	Ficha[] listaFichas;
	

	public void generarFichas(){
		
		int i;
		int j;
		int contadorId = 0;

		listaFichas = new Ficha[((numeroFichas+1)*(numeroFichas+2))/2];
		for(i=0; i <= numeroFichas; i++){
			for(j=0; j <= i; j++){
				listaFichas[contadorId] = new Ficha(i, j, contadorId);
				System.out.println("#"+listaFichas[contadorId].getId()+": ["+listaFichas[contadorId].getArriba()+"|"+listaFichas[contadorId].getAbajo()+"]");
				contadorId = contadorId + 1;

			}
		}

		}


		public void repartirFichas(){

			Ficha stageFicha = new Ficha(0, 0, 0);
			
			Ficha[] mano1;
				mano1 = new Ficha[6];
			Ficha[] mano2;
				mano2 = new Ficha[6];

			int m;
			for(m=0; m <=6; m++){
				do{
				int rand1 = (int)(Math.random()*27);
				for(Ficha ficha : listaFichas){
					if (ficha.getId() == rand1)
					stageFicha = ficha;
				}
			} while (stageFicha.getDisponible() == false);
				mano1[m] = stageFicha;
				

			
			}
		}

	}
	
	

	
