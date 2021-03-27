//BankRepository - simple implementation of BankInterface
//Save banks in array list
//Simple linear search of list to get the desired banks
package com.theclearinghouse.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankRepositoryUsingLinearSearch implements BankRepository {
	private List<Bank> banks = new ArrayList<>();
	
	public void addBank(final Bank bank) {
		banks.add(bank);
	}
	
	public List<Bank> getBankByName(final String name){
		return banks.stream().filter(bank -> bank.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByType(final String type){
		return banks.stream().filter(bank -> bank.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByCity(final String city){
		return banks.stream().filter(bank -> bank.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByState(final String state){
		return banks.stream().filter(bank -> bank.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByZipCode(final String zipCode){
		return banks.stream().filter(bank -> bank.getZipCode().equalsIgnoreCase(zipCode)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByCityAndState(final String city, final String state){
		return banks.stream().filter(bank -> bank.getCity().equalsIgnoreCase(city) && bank.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}
}
