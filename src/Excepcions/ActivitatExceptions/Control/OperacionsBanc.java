package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;

import java.util.ArrayList;
import java.util.List;

import static Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage.*;


public class OperacionsBanc {

    //igual esta feo esto
    static List<CompteEstalvi> llistaComptes = new ArrayList<>();

    public static boolean verifyDNI(String dni) throws ClientAccountException {
        //TODO implementar fòrnula de verificació del DNI

        if(dni.length() != 9){
            throw new ClientAccountException(WRONG_DNI);
        }
        else {return true;}
    }

    public static boolean verifyAccount(CompteEstalvi account) throws BankAccountException {

        if(!llistaComptes.contains(account)){
            throw new BankAccountException(ACCOUNT_NOT_FOUND);
        }else{
            return false;
        }
    }


    public void transferencia(CompteEstalvi account1, CompteEstalvi account2, double diners) throws BankAccountException {

            if(!verifyAccount(account1) || !verifyAccount(account2)){
                throw new BankAccountException(ACCOUNTS_ERRORS);
            }
            else{
                try{
                    account1.treure(diners);
                }catch (Exception e){
                    throw new BankAccountException(TRANSFER_ERROR);
                }

                try{
                    account2.ingressar(diners);
                }catch (Exception e){
                    throw new BankAccountException(TRANSFER_ERROR);
                }

            }
    }


}
