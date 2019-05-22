package singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsuranceDriver
{
	Policy policy;
	public Scanner fileIn = null;
	List<String> fileLines;
	String customersFile = "src/singleton/customers.txt";

	public InsuranceDriver()
	{
		policy = Policy.getInstance();
		openCustomersFile();
		readCustomersFile();
		addCustomers();
	}
	
	public void openCustomersFile()
    {
    	try
    	{
    		System.out.println("Customer's File: " + customersFile);
    		fileIn = new Scanner(new File(customersFile));
		}
    	catch (FileNotFoundException x)
    	{
			System.out.println("File open failed.");
			x.printStackTrace();
			System.exit(0);
		}
    }
	
	public void readCustomersFile()
	{
		String line;
        fileLines = new ArrayList<String>();

    	while(fileIn.hasNextLine())
        {
        	line = fileIn.nextLine();
            fileLines.add(line);
        }
    	
    	fileIn.close();
	}
	
	public void printFileLines()
	{
		for(String line: fileLines)
		{
			System.out.println(line);
		}
	}
	
	public void addCustomers()
	{
		System.out.println("\nRetrieving Customers...\n");
		for(String line: fileLines)
		{
			String[] arrOfStr = line.split(" +");
			int id = Integer.parseInt(arrOfStr[0]);
			String name = arrOfStr[1] + ", " + arrOfStr[2];
			policy.setPolicyHolder(new PolicyHolder(id, name));
		}
	}
	
	public void printPolicies()
	{
		List<PolicyHolder> policyHolders = policy.getPolicyHolders();
		
		System.out.println("********************Policies********************");
		for(PolicyHolder policyHolder: policyHolders )
		{
			System.out.println(policyHolder.toString());
		}
		
		printDescription();
	}
	
	public void printDescription()
	{
		System.out.println("\n***************Policy Description***************");
		System.out.println(policy.getDescription());
	}
	

}
