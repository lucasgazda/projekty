
public class Event {
	
	private String eventName;
	private int duration;
	private int participantNumber;
	
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getParticipantName() {
		return participantNumber;
	}
	
	public void setParticipantNumber(int partcipantNumber) {
		this.participantNumber = partcipantNumber;
	}

	public Event() {
		
	}

	public Event(String eventName, int duration, int participantNumber) {
		this.eventName = eventName;
		this.duration = duration;
		this.participantNumber = participantNumber;
	}

	@Override
		public String toString() {
			String text = "";
			text += "EVENT NAME = " + getEventName() + "\n";
			text += "DURATION = " + getDuration() + "\n";
			text += "PARTICIPANT NUMBER = " + getParticipantName() + "\n";
			return text;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + participantNumber;
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (duration != other.duration)
			return false;
		if (participantNumber != other.participantNumber)
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		return true;
		
	}
}
