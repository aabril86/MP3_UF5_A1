package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;


public class OperacionsBanc {

    //igual esta feo esto
    public static List<CompteEstalvi> llistaComptes = new ArrayList<>();


    public static boolean verifyDNI(String dni) throws ClientAccountException {
        //TODO implementar fòrnula de verificació del DNI

        if(dni.length() != 9){
            throw new ClientAccountException(WRONG_DNI);
        }
        else {return true;}
    }

    public static CompteEstalvi verifyAccount(String account) throws BankAccountException {

        CompteEstalvi compte = null;
        for (CompteEstalvi comp: OperacionsBanc.llistaComptes) {
            if(comp.getNumCompte().equals(account)) {
                compte = comp;
                System.out.println("Compte valid");
                return compte;
            }
        }

        throw new BankAccountException(ACCOUNT_NOT_FOUND);

    }


    public void transferencia(String account1, String account2, double diners) throws BankAccountException {


        CompteEstalvi acc1 = verifyAccount(account1);
        CompteEstalvi acc2 = verifyAccount(account2);
        try{
            acc1.treure(diners);
        }catch (Exception e){
            throw new BankAccountException(TRANSFER_ERROR);
        }

        try{
            acc2.ingressar(diners);
        }catch (Exception e){
            throw new BankAccountException(TRANSFER_ERROR);
        }

        System.out.println("Transferencia feta");

    }


}
