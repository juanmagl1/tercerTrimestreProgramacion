package com.jacaranda.utilities;

public class Prueba {

	public static void main(String[] args) throws PuebloException {
		try {
			//Provincia p2=new Provincia ("Sevilla","4A");
			Provincia p1=new Provincia ("Sevilla","41");
			System.out.println(p1);
			//Provincia p12=new Provincia (null,"41");
			//Provincia p12=new Provincia ("Sevilla",null);
			//Provincia p12=new Provincia ("Madrid","4");
			//Provincia p12=new Provincia ("Madrid","477");
			p1.addPueblo("Brenes", "310",20000,0,3570);
			//p1.addPueblo("Brenes", "310",20000,0,3570);
			p1.addPueblo("San José", "300",50000,0,3570);
			//p1.addPueblo("San José", "310",50000,0,3570);
			p1.addPueblo("Villaverde", "320",20000,0,3570);
			p1.addPueblo("Canti", "330",2,0,3570);
			System.out.println(p1);
			//p1.setNumeroHabitantes("BRENES", -40000);
			p1.setNumeroHabitantes("BRENES", 40000);
			System.out.println(p1);
			Pueblo pu=new Pueblo ("Lora","33333");
			Pueblo pu1=new Pueblo ("Lora","33333",-500,0,0);
			Pueblo pu2=new Pueblo ("Lora","33333",500,-10,0);
			Pueblo pu3=new Pueblo ("Lora","33333",500,0,-40);
			System.out.println(pu);
		} catch (ProvinciaException e) {
			e.printStackTrace();
		}

	}

}
