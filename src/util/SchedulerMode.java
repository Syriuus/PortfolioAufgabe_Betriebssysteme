package util;

public enum SchedulerMode {
	EarliestDeadlineFirstNonPreemptive,
	EarliestDeadlineFirstPreemptive,
	FirstComeFirstServed,
	HighestResponseRatioNext,
	LastComeFirstServed,
	LongestJobFirst,
	LongestRemainingTimeFirst,
	PrioritySchedulingPreemptive,
	PrioritySchedulingNonPreemptive,
	RoundRobin,
	ShortestJobFirst,
	ShortestRemainingTimeFirst,
}
