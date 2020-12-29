package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExercici {
    public static void main(String[] args) throws ClientAccountException, BankAccountException {
        Scanner scanner = new Scanner(System.in);

        int op;
        CompteEstalvi c = new CompteEstalvi();
        Client client;
        OperacionsBanc operacionsBanc = new OperacionsBanc();

        //Preparo l'entorn per probar les transferencies

        CompteEstalvi compteEstalviNaomi = new CompteEstalvi("N1234");
        CompteEstalvi compteEstalviAitor = new CompteEstalvi("A1234");

        compteEstalviNaomi.setSaldo(500);
        compteEstalviAitor.setSaldo(700);

        OperacionsBanc.llistaComptes.add(compteEstalviNaomi);
        OperacionsBanc.llistaComptes.add(compteEstalviAitor);

        //menu
        do{
            System.out.println("\nEscull una opció\n");
            System.out.println("1- Afegir usuari");
            System.out.println("2-Esborrar usuari");
            System.out.println("3-Fer transferència");
            System.out.println("\n0- Sortir");

            op = scanner.nextInt();
            String dni;

            switch(op){

                case 1:
                    scanner.nextLine();

                    client = new Client();

                    System.out.print("Nom: ");
                    client.setNom(scanner.nextLine());

                    System.out.print("Cognoms: ");
                    client.setCognoms(scanner.nextLine());

                    System.out.print("DNI: ");
                    do{
                        dni = scanner.nextLine();
                        OperacionsBanc.verifyDNI(dni);

                    }while(!OperacionsBanc.verifyDNI(dni));

                    client.setDNI(dni);

                    System.out.println("Nombre d'usuaris al compte: " +  c.addUser(client) );

                    break;

                case 2:
                    scanner.nextLine();

                    System.out.println("DNI del usuari: ");

                    do{
                        dni = scanner.nextLine();
                        OperacionsBanc.verifyDNI(dni);

                    }while(!OperacionsBanc.verifyDNI(dni));

                    System.out.println("Nombre d'usuaris al compte: " + c.removeUser(dni));
                    break;

                case 3:

                    scanner.nextLine();
                    System.out.println("Numero de compte 1: ");
                    String numCompte1 = scanner.nextLine();

                    System.out.println("Numero de compte 2: ");
                    String numCompte2 = scanner.nextLine();

                    operacionsBanc.transferencia(numCompte1, numCompte2, 50);
                    break;
            }
        }while(op != 0);
    }
}
