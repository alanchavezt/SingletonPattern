package singleton;

import java.util.ArrayList;
import java.util.List;

public class Policy
{
	private static Policy uniqueInstance;
	List<PolicyHolder> policyHolders = new ArrayList<PolicyHolder>();

	private Policy() {}
	
	public static synchronized Policy getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new Policy();
		}
		return uniqueInstance;
	}

	public List<PolicyHolder> getPolicyHolders()
	{
		return policyHolders;
	}

	public void setPolicyHolder(PolicyHolder policyHolder)
	{
		this.policyHolders.add(new PolicyHolder(policyHolder.id, policyHolder.name));
	}
	
	public String getDescription()
	{
		return "Policy: I'm a policy safe Singleton!";
	}
}
