package hilos;

import mundo.OficinaMonitor;

public class Monitor extends Thread{
	/**
	 * es la referencia a la oficin a ala cual este mintor atiende
	 */
	private OficinaMonitor oficina;
	
	/**
	 * constructor de monitor, le da vida a un nuevo monitos 
	 * @param indica a que oficina se asigna el monitor
	 */
	public Monitor(OficinaMonitor of) {
		oficina = of;
	}
	

	/**
	 * este metodo represetna como el monitor simpre tiene disposicion para ayudar a os estudiantes que tengan dudas
	 * si nadie tiene dudas el monitor se duerme un rato hasta que alguientenga dudas
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			try {
				if(oficina.getActual()==null) {					
					oficina.monitorTrabaja();
					Thread.sleep(3000);
				}
				else if(oficina.estaVacia()){
					
					
					System.out.println("el monitor se duerme");
					Thread.sleep(3000);
				}
				
			}
			catch(Exception e) {
				
			}
		}
		
	}

}
