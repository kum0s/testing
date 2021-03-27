My environment
--------------
- I have tested this on Windows 10 using git-bash shell
- gradle 6.8.3
- java 15.0.2


1. How to Build
---------------
From project root dir, run the below command:
./gradlew clean build


2. How to Run
-------------
After building, run this command from the project root dir. The CSV file is already 
checked in src/main/resources

java -jar build/libs/the-clearing-house.jar

OR you can provide the CVS on command line as show below

java -jar build/libs/the-clearing-house.jar /c/Users/shyam/Downloads//the-clearing-house.csv
 
 

Source Code
-----------
1. Bank - POJO, the bank entity

2. BankRepository - interface to store all the banks and retrieve by search criteria

3. BankRepositoryUsingLinearSearch - implements BankRepository and stores all the banks
   in a ArrayList. For searching, it does a linear search through the ArrayList;
   
4. BankRepositoryUsingIndexForSearch - implements BankRepository and stores all the banks
   in a ArrayList. It also create six HashMaps, one for each search criteria. The key in
   the HashMap is the search criteria. The value is a ArrayList of bank's index in "banks"
   ArrayList. This should provide much faster results in real life.
   
5. BankServices - This class is intended to be used by clients to access bank services eg.
   to load bank and search for banks.
   
   In the constructor of this class, we can choose which BankRepository implementation
   to use - BankRepositoryUsingLinearSearch or BankRepositoryUsingIndexForSearch. By default
   it uses BankRepositoryUsingIndexForSearch.
   
6. BankApplication - The main driver class. Its main functionality is to load banks and 
   get user's search input.
   
   
Testing
-------
For testing, I would have used junit and Mockito for mocking.
I would have written junit testcases for each of the source files.
I would have used the same CSV file to create a list of banks.



Screen Shots of sample runs
---------------------------
shyam@2019-Lenovo-Yoga MSYS /c/dev/projects/java/the-clearing-house (master)
$ java -jar build/libs/the-clearing-house.jar
1) Search by Bank Name
2) Search by Bank type
3) Search by Bank City
4) Search by Bank State
5) Search by Bank ZipCode
6) Search by Bank City and State
0) Exit

Selection: 1
Enter Bank name:Amazing Bank
Bank [name=Amazing Bank, type=Branch, city=New York, state=NY, zipCode=10018]
Bank [name=Amazing Bank, type=ATM, city=New York, state=NY, zipCode=10018]
Bank [name=Amazing Bank, type=ATM, city=Winston-Salem, state=NC, zipCode=27106]
Bank [name=Amazing Bank, type=ATM, city=Dallas, state=TX, zipCode=75202]
1) Search by Bank Name
2) Search by Bank type
3) Search by Bank City
4) Search by Bank State
5) Search by Bank ZipCode
6) Search by Bank City and State
0) Exit

Selection: 4
Enter Bank State:TX
Bank [name=Awesome Bank, type=ATM, city=Dallas, state=TX, zipCode=75201]
Bank [name=Friendly Bank, type=Branch, city=Dallas, state=TX, zipCode=75201]
Bank [name=Amazing Bank, type=ATM, city=Dallas, state=TX, zipCode=75202]
1) Search by Bank Name
2) Search by Bank type
3) Search by Bank City
4) Search by Bank State
5) Search by Bank ZipCode
6) Search by Bank City and State
0) Exit

Selection: 0

shyam@2019-Lenovo-Yoga MSYS /c/dev/projects/java/the-clearing-house (master)
$
   