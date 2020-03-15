package hilos;

import mundo.OficinaMonitor;

public class Monitor extends Thread{
	/**
	 * This attribute contains a reference to the actual Office the monitor is attending.
	 */
	private OficinaMonitor oficina;
	
	/**
	 * Constructor method for the monitor.
	 * @param of parameter that indicates the actual office the monitor is working on.
	 */
	public Monitor(OficinaMonitor of) {
		oficina = of;
	}
	

	/**
	 * Run method.
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
