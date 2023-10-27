package account.bank.validate;

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

}
