//BankInterface - Bank interface
//Different implementations can save it in database or provide better search algorithm
package com.theclearinghouse.bank;

import java.util.List;

public interface BankRepository {	
	abstract void addBank(final Bank bank) ;
	
	abstract List<Bank> getBankByName(final String name);
	
	abstract List<Bank> getBankByType(final String type);
	
	abstract List<Bank> getBankByCity(final String city);
	
	abstract List<Bank> getBankByState(final String state);
	
	abstract List<Bank> getBankByZipCode(final String zipCode);
	
	abstract List<Bank> getBankByCityAndState(final String city, final String state);
}
