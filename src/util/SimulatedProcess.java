package util;

import java.util.Objects;

public class SimulatedProcess {
	
	private Character id;
	private int runtime;
	private int priority;
	private int arrivaltime;
	private int remainingRuntime;
	private int deadline;

	public SimulatedProcess(Character ID, int Runtime, int Priority, int Arrivaltime, int Deadline) {
		this.id = ID;
		this.runtime = Runtime;
		this.priority = Priority;
		this.arrivaltime = Arrivaltime;
		this.remainingRuntime = Runtime;
		this.deadline = Deadline;
	}
	
	public int getRemainingRuntime() {
		return remainingRuntime;
	}

	public void setRemainingRuntime(int remainingRuntime) {
		this.remainingRuntime = remainingRuntime;
	}

	public Character getId() {
		return id;
	}

	public int getRuntime() {
		return runtime;
	}

	public int getPriority() {
		return priority;
	}

	public int getArrivaltime() {
		return arrivaltime;
	}

	public int getDeadline() {
		return deadline;
	}

	@Override
	public String toString() {
		return this.getId() + "     " + this.getRuntime() + "     " +  this.getPriority() + "     " +  this.getArrivaltime();
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivaltime, id, runtime, priority, remainingRuntime);
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
		return arrivaltime == other.arrivaltime && Objects.equals(id, other.id) && runtime == other.runtime
				&& priority == other.priority && remainingRuntime == other.remainingRuntime;
	}

}
