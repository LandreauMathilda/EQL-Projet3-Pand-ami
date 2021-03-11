package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="availability")
public class Availability implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime choiceStart;
	private LocalDateTime choiceEnd;
	private String day;
	private LocalDateTime startHour;
	private LocalDateTime endHour;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User user;
	
	public Availability() {
		super();
	}

	public Availability(Integer id, LocalDateTime choiceStart, LocalDateTime choiceEnd, String day,
			LocalDateTime hourStart, LocalDateTime hourEnd, User user) {
		super();
		this.id = id;
		this.choiceStart = choiceStart;
		this.choiceEnd = choiceEnd;
		this.day = day;
		this.startHour = hourStart;
		this.endHour = hourEnd;
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choiceEnd == null) ? 0 : choiceEnd.hashCode());
		result = prime * result + ((choiceStart == null) ? 0 : choiceStart.hashCode());
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((endHour == null) ? 0 : endHour.hashCode());
		result = prime * result + ((startHour == null) ? 0 : startHour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Availability other = (Availability) obj;
		if (choiceEnd == null) {
			if (other.choiceEnd != null)
				return false;
		} else if (!choiceEnd.equals(other.choiceEnd))
			return false;
		if (choiceStart == null) {
			if (other.choiceStart != null)
				return false;
		} else if (!choiceStart.equals(other.choiceStart))
			return false;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (endHour == null) {
			if (other.endHour != null)
				return false;
		} else if (!endHour.equals(other.endHour))
			return false;
		if (startHour == null) {
			if (other.startHour != null)
				return false;
		} else if (!startHour.equals(other.startHour))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Availability [id=" + id + ", choiceStart=" + choiceStart + ", choiceEnd=" + choiceEnd + ", day=" + day
				+ ", hourStart=" + startHour + ", hourEnd=" + endHour + "]";
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getChoiceStart() {
		return choiceStart;
	}

	public LocalDateTime getChoiceEnd() {
		return choiceEnd;
	}

	public String getDay() {
		return day;
	}

	public LocalDateTime getHourStart() {
		return startHour;
	}

	public LocalDateTime getHourEnd() {
		return endHour;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setChoiceStart(LocalDateTime choiceStart) {
		this.choiceStart = choiceStart;
	}

	public void setChoiceEnd(LocalDateTime choiceEnd) {
		this.choiceEnd = choiceEnd;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setHourStart(LocalDateTime hourStart) {
		this.startHour = hourStart;
	}

	public void setHourEnd(LocalDateTime hourEnd) {
		this.endHour = hourEnd;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
