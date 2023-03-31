package util;

import java.util.Objects;

public class SimulatedProcess {
	
	private Character id;
	private int laufzeit;
	private int priorität;
	private int ankunftszeit;
	private int verbleibendeLaufzeit;

	public SimulatedProcess(Character ID, int Laufzeit, int Priorität, int Ankunftszeit, int VerbleibendeLaufzeit) {
		this.id = ID;
		this.laufzeit = Laufzeit;
		this.priorität = Priorität;
		this.ankunftszeit = Ankunftszeit;
		this.verbleibendeLaufzeit = VerbleibendeLaufzeit;
	}

	public int getVerbleibendeLaufzeit() {
		return verbleibendeLaufzeit;
	}

	public void setVerbleibendeLaufzeit(int verbleibendeLaufzeit) {
		this.verbleibendeLaufzeit = verbleibendeLaufzeit;
	}

	public Character getId() {
		return id;
	}

	public int getLaufzeit() {
		return laufzeit;
	}

	public int getPriorität() {
		return priorität;
	}

	public int getAnkunftszeit() {
		return ankunftszeit;
	}
	
	public String toString() {
		return this.getId() + "     " + this.getLaufzeit() + "     " +  this.getPriorität() + "     " +  this.getVerbleibendeLaufzeit();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ankunftszeit, id, laufzeit, priorität, verbleibendeLaufzeit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulatedProcess other = (SimulatedProcess) obj;
		return ankunftszeit == other.ankunftszeit && Objects.equals(id, other.id) && laufzeit == other.laufzeit
				&& priorität == other.priorität && verbleibendeLaufzeit == other.verbleibendeLaufzeit;
	}

}
