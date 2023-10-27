package account.bank.validate;

import account.bank.bean.UpdateAmountRQ;
import account.bank.model.Product;

public class ValidateAccount {
	
	public static boolean validateAccountPersonal(Product product) {
		if(product.getAccountType().equals("Ahorro")) {
			return true;
		} else if(product.getAccountType().equals("Cuenta corriente")) {
			return true;
		} else if(product.getAccountType().equals("Plazo fijo")) {
			return true;
		}
		return false;
	}
	
	public static boolean validateAccountEmpresarial(Product product) {
		if(!product.getAccountType().equals("Ahorro")) {
			return true;
		} else if(!product.getAccountType().equals("Plazo fijo")) {
			return true;
		}
		return false;
	}
	
	public static boolean validateTransaction(UpdateAmountRQ updateAmountRQ) {
		if(updateAmountRQ.getTransaction().equals("Retiro")) {
			return true;
		} else if(updateAmountRQ.getTransaction().equals("Compras")) {
			return true;
		}
		return false;
	}

}
