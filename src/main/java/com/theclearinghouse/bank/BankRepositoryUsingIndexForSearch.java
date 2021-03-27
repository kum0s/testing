//BankRepository - simple implementation of BankInterface
//Save banks in array list
//For faster search it creates six HashMap, one for each search criteria
//In each of this HashMap, the key is search criteria
//And the value is list of indexes in the banks arrayList
package com.theclearinghouse.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BankRepositoryUsingIndexForSearch implements BankRepository {
	private List<Bank> banks = new ArrayList<>();
	
	//key - bank name, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByName = new HashMap<String,ArrayList<Integer>>();

	//key - bank type, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByType = new HashMap<String,ArrayList<Integer>>();

	//key - city, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByCity = new HashMap<String,ArrayList<Integer>>();

	//key - state, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByState = new HashMap<String,ArrayList<Integer>>();

	//key - zipcode, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByZipCode = new HashMap<String,ArrayList<Integer>>();

	//key - city-state, array - index into banks
	private HashMap<String,ArrayList<Integer>> banksByCityState = new HashMap<String,ArrayList<Integer>>();
	
	public void addBank(final Bank bank) {
		banks.add(bank);
		updateBankByNameIndexes(bank);
		updateBankByTypeIndexes(bank);
		updateBankByCityIndexes(bank);
		updateBankByStateIndexes(bank);
		updateBankByZipCodeIndexes(bank);
		updateBankByCityStateIndexes(bank);
	}
	
	public void updateBankByNameIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByName index
		String bankName = bank.getName();
		ArrayList<Integer> list= banksByName.getOrDefault(bankName, new ArrayList<Integer>());
		list.add(index);
		banksByName.put(bankName, list);
	}
	
	public void updateBankByTypeIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByType index
		String bankType = bank.getType();
		ArrayList<Integer> list= banksByType.getOrDefault(bankType, new ArrayList<Integer>());
		list.add(index);
		banksByType.put(bankType, list);
	}
	
	public void updateBankByCityIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByCity index
		String bankCity = bank.getCity();
		ArrayList<Integer> list= banksByCity.getOrDefault(bankCity, new ArrayList<Integer>());
		list.add(index);
		banksByCity.put(bankCity, list);
	}
	
	public void updateBankByStateIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByState index
		String bankState = bank.getState();
		ArrayList<Integer> list= banksByState.getOrDefault(bankState, new ArrayList<Integer>());
		list.add(index);
		banksByState.put(bankState, list);
	}
	
	public void updateBankByZipCodeIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByZipCode index
		String bankZipCode = bank.getZipCode();
		ArrayList<Integer> list= banksByZipCode.getOrDefault(bankZipCode, new ArrayList<Integer>());
		list.add(index);
		banksByZipCode.put(bankZipCode, list);
	}
	
	public void updateBankByCityStateIndexes(Bank bank) {
		int index = banks.size() - 1;
		
		//update banksByCityState index
		String bankCityState = bank.getCity()+"-"+bank.getState();
		ArrayList<Integer> list= banksByCityState.getOrDefault(bankCityState, new ArrayList<Integer>());
		list.add(index);
		banksByCityState.put(bankCityState, list);
	}
	
	public List<Bank> getBankByName(final String name){
		ArrayList<Integer> bankIndexes = banksByName.getOrDefault(name, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByType(final String type){
		ArrayList<Integer> bankIndexes = banksByType.getOrDefault(type, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());
	}
	
	public List<Bank> getBankByCity(final String city){
		ArrayList<Integer> bankIndexes = banksByCity.getOrDefault(city, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());	
		}
	
	public List<Bank> getBankByState(final String state){
		ArrayList<Integer> bankIndexes = banksByState.getOrDefault(state, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());	
		}
	
	public List<Bank> getBankByZipCode(final String zipCode){
		ArrayList<Integer> bankIndexes = banksByZipCode.getOrDefault(zipCode, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());	
		}
	
	public List<Bank> getBankByCityAndState(final String city, final String state){
		String bankCityState = city+"-"+state;
		ArrayList<Integer> bankIndexes = banksByCityState.getOrDefault(bankCityState, new ArrayList<Integer>());
		return bankIndexes.stream().map(idx -> banks.get(idx)).collect(Collectors.toList());		}
}
