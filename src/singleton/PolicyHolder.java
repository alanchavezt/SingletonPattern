package singleton;

public class PolicyHolder
{
	public String name;
	public int id;
	
	public PolicyHolder(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString()
	{
		return "PolicyHolder [id=" + id + ", name=" + name + "]";
	}
	
}
