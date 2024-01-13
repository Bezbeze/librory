package telran.library.entities;

import java.util.Objects;

public class ReaderDelay {
	private Reader reader;
	private int delay;
	
	public ReaderDelay() {
	}
	
	public ReaderDelay(Reader reader, int delay) {
		super();
		this.reader = reader;
		this.delay = delay;
	}

	public Reader getReader() {
		return reader;
	}

	public int getDelay() {
		return delay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(delay, reader);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReaderDelay other = (ReaderDelay) obj;
		return delay == other.delay && Objects.equals(reader, other.reader);
	}

	@Override
	public String toString() {
		return "ReaderDelay [reader=" + reader + ", delay=" + delay + "]";
	}

	
	
	
}
