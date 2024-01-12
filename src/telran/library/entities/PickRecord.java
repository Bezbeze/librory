package telran.library.entities;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class PickRecord implements Serializable
{
	long isbn;
	int readerId;
	LocalDate pickDate;
	LocalDate returnDate;
	int delayDays;

	public LocalDate getReturnDate()
	{
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate)
	{
		this.returnDate = returnDate;
	}

	public int getDelayDays()
	{
		return delayDays;
	}

	public void setDelayDays(int delayDays)
	{
		this.delayDays = delayDays;
	}

	public long getIsbn()
	{
		return isbn;
	}

	public int getReaderId()
	{
		return readerId;
	}

	public LocalDate getPickDate()
	{
		return pickDate;
	}

	@Override
	public String toString()
	{
		return "PickRecord [isbn=" + isbn + ", readerId=" + readerId + ", pickDate=" + pickDate + ", returnDate="
				+ returnDate + ", delayDays=" + delayDays + "]";
	}

	public PickRecord(long isbn, int readerId, LocalDate pickDate)
	{
		super();
		this.isbn = isbn;
		this.readerId = readerId;
		this.pickDate = pickDate;

	}

	public PickRecord()
	{
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + delayDays;
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		result = prime * result + ((pickDate == null) ? 0 : pickDate.hashCode());
		result = prime * result + readerId;
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PickRecord other = (PickRecord) obj;
		if (delayDays != other.delayDays)
			return false;
		if (isbn != other.isbn)
			return false;
		if (pickDate == null)
		{
			if (other.pickDate != null)
				return false;
		} else if (!pickDate.equals(other.pickDate))
			return false;
		if (readerId != other.readerId)
			return false;
		if (returnDate == null)
		{
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

	

}
