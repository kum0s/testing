//BankService - clients use this class to interact with Bank either to add, search ..
package com.theclearinghouse.bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class BankServices {
	private static final String COMMA_DELIMITER = ",";
	BankRepository bankRepo;
	
	BankServices(){
		//Change it to BankRepositoryUsingLinearSearch to do linear search
		bankRepo = new BankRepositoryUsingIndexForSearch();
	}
	
	//CSV file to load the bank data from
	public void loadBanks(final String file) {
		BufferedReader reader = null;
		
		try {			
			reader = new BufferedReader(new FileReader(file));
			
			//skip the first line which is the header
			String line = reader.readLine();
			while ((line = reader.readLine()) != null){
				bankRepo.addBank(createBank(line));
			}
		} catch(IOException e) {
			System.out.println("Exception loading from cvs file:"+e.getMessage());
		} finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
        			System.out.println("Exception closing cvs file:"+e.getMessage());
                }
            }
		}
	}
	
	public Bank createBank(final String line) {
		String[] values = line.split(COMMA_DELIMITER);		
		return new Bank(values[1],values[2],values[3],values[4],values[5]);
	}
	
	List<Bank> getBankByName(final String name){
		return bankRepo.getBankByName(name);
	}
	
	List<Bank> getBankByType(final String type){
		return bankRepo.getBankByType(type);
	}
	
	List<Bank> getBankByCity(final String city){
		return bankRepo.getBankByCity(city);
	}
	
	List<Bank> getBankByState(final String state){
		return bankRepo.getBankByState(state);
	}
	
	List<Bank> getBankByZipCode(final String zipCode){
		return bankRepo.getBankByZipCode(zipCode);
	}
	
	List<Bank> getBankByCityAndState(final String city, final String state){
		return bankRepo.getBankByCityAndState(city, state);
	}
}
