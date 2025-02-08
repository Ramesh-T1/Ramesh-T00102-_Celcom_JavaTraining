package com.Assignment2;

public class Dog {
	String name,breed;
	Dog(String name,String breed){
		this.name=name;
		this.breed=breed;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d1=new Dog("Moti","GermanShephard");
		/*System.out.println("Object before modifying using setter method:");
		System.out.println(d1.getName());
		System.out.println(d1.getBreed());*/
		System.out.println("Object after modifying using setter method:");
		d1.setName("Tuffy");
		d1.setBreed("Dalmatian");
		System.out.println(d1.getName());
		System.out.println(d1.getBreed());
		Dog d2=new Dog("Juno","GermanShephard");
		/*System.out.println("Object before modifying using setter method:");
		System.out.println(d2.getName());
		System.out.println(d2.getBreed());*/
		System.out.println("Object after modifying using setter method:");
		d2.setName("Luvi");
		d2.setBreed("Indian Spitz");
		System.out.println(d2.getName());
		System.out.println(d2.getBreed());
	}

}
