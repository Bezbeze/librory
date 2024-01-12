package telran.library.entities;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Reader implements Serializable
{
	private int readerId;
	private String name;
	private String phone;
	private LocalDate birthData;

	public Reader(){}

	public Reader(int readerId, String name, String phone, LocalDate birthData)
	{
		super();
		if(readerId > 0)
			this.readerId = readerId;
		this.name = name;
		this.phone = phone;
		this.birthData = birthData;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public int getReaderId()
	{
		return readerId;
	}

	public String getName()
	{
		return name;
	}

	public LocalDate getBirthData()
	{
		return birthData;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + readerId;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Reader))
		{
			return false;
		}
		Reader other = (Reader) obj;
		if (readerId != other.readerId)
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Reader [readerId=" + readerId + ", name=" + name + ", phone=" + phone + ", birthData=" + birthData + "]";
	}

}
