package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
	private LocalDate choiceStart;
	private LocalDate choiceEnd;
	private String day;
	private LocalTime startHour;
	private LocalTime endHour;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User user;
	
	public Availability() {
		super();
	}

	public Availability(Integer id, LocalDate choiceStart, LocalDate choiceEnd, String day, LocalTime startHour,
			LocalTime endHour, User user) {
		super();
		this.id = id;
		this.choiceStart = choiceStart;
		this.choiceEnd = choiceEnd;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startHour == null) ? 0 : startHour.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startHour == null) {
			if (other.startHour != null)
				return false;
		} else if (!startHour.equals(other.startHour))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Availability [id=" + id + ", choiceStart=" + choiceStart + ", choiceEnd=" + choiceEnd + ", day=" + day
				+ ", startHour=" + startHour + ", endHour=" + endHour + "]";
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getChoiceStart() {
		return choiceStart;
	}

	public LocalDate getChoiceEnd() {
		return choiceEnd;
	}

	public String getDay() {
		return day;
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setChoiceStart(LocalDate choiceStart) {
		this.choiceStart = choiceStart;
	}

	public void setChoiceEnd(LocalDate choiceEnd) {
		this.choiceEnd = choiceEnd;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
