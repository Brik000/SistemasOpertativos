package hilos;

import mundo.OficinaMonitor;


public class Estudiante extends Thread{
	
	/*
	 * Estado que representa estar en sala de computo
	 */
	public final static String AT_COMPUTO="AT_COMPUTO";
	/*
	 * Estado que representa estar en la sala de espera
	 */
	public final static  String AT_FILA="AT_FILA";
	
	/*
	 * Estado que representa estar en la oficina del monitor
	 */
	public final static  String AT_OFFICE="AT_OFFICE";
	
	/*
	 * Probabilidad de que se presente una duda estando en sala de computo
	 */
	public final static double DUDA=0.26;
	
	/*
	 * ID referente al estufiante
	 */
	private int id;
	
	/*
	 * define donde se encuentra el estudiante actualmente
	 */
	
	private String at;
	
	/*
	 * representa la oficina a la que esta asignado el monitor
	 */
	
	private OficinaMonitor uni;
	
	
	/*
	 * Constructor del estudiante
	 */
	public Estudiante(int id,OficinaMonitor uni) {
		
		this.id= id;
		
		this.at= Estudiante.AT_COMPUTO;
		
		this.uni= uni;
	}
	/*
	 * este hilo representa el dia a dia del studiante en el aula de computo 
	 * resolviendo ejercicos hasta encontrarse con una duda
	 */
	@Override
	public void run() {

		
		while (true) {
			try {
			Thread.sleep(4000);
			
			if(this.getAt().equals(this.AT_COMPUTO)){
				
			double duda = Math.random();
			//SI duda es menor a la constante este estuiante se va a hacer una pregunta 
			if(duda < DUDA && at.equals(AT_COMPUTO)) {
				System.out.println("el estudiante " + this.id + " tiene dudas para el Monitor");
				uni.newStudent(this);
				
				
			}
			}
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public long getId() {
		
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public OficinaMonitor getUni() {
		return uni;
	}

	public void setUni(OficinaMonitor uni) {
		this.uni = uni;
	}
	
	
	

}
