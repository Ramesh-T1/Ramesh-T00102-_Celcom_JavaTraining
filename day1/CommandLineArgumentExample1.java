package com.celcom.day1;
public class CommandLineArgumentExample1{
  public static void main(String args[]){
    System.out.println("Total no.of Arguments : "+args.length);
    System.out.println("Argument 1 : "+args[0]);
    System.out.println("Argument 2 : "+args[1]);
    System.out.println("Argument 3 : "+args[2]);
  }
}



/*To compile-->java ClassName.java
To Run-->java ClassName arg1 arg2 arg3....
args only accepts string value later we need to convert it using typecasting */
