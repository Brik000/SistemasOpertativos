package hilos;

import mundo.OficinaMonitor;


public class Estudiante extends Thread{
	
	
	public final static String AT_COMPUTO="AT_COMPUTO";
	
	public final static  String AT_FILA="AT_FILA";
	
	public final static  String AT_OFFICE="AT_OFFICE";
	
	public final static double DUDA=0.26;
	
	private int id;
	
	private String at;
	
	private OficinaMonitor uni;
	
	public Estudiante(int id,OficinaMonitor uni) {
		
		this.id= id;
		
		this.at= Estudiante.AT_COMPUTO;
		
		this.uni= uni;
	}
	
	@Override
	public void run() {

		
		while (true) {
			try {
			Thread.sleep(4000);
			double duda = Math.random();
			
			if(duda < 0.3 && at.equals(AT_COMPUTO)) {
				System.out.println("el estudiante " + this.id + " tiene dudas para el Monitor");
				uni.newStudent(this);;
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
