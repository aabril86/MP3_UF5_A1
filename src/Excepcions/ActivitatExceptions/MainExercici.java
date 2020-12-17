package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.Scanner;

public class MainExercici {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int op;
        CompteEstalvi c;

        do{
            System.out.println("\nEscull una opció\n");
            System.out.println("1- Afegir usuari");
            System.out.println("2-Esborrar usuari");
            System.out.println("3-Fer transferència");
            System.out.println("\n0- Sortir");

            op = scanner.nextInt();

            switch(op){

                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while(op != 0);
    }
}
