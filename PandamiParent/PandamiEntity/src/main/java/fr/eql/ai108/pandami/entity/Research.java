package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Research implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<LocalDate> rangeDate;
	private LocalTime startHour;
	private LocalTime endHour;
	private List<City> cities;
    private List<Activity> activities;
    private EquipmentType equipment;

	public Research() {
		super();
	}

	public Research(List<LocalDate> rangeDate, LocalTime startHour, LocalTime endHour, List<City> cities,
			List<Activity> activities, EquipmentType equipment) {
		super();
		this.rangeDate = rangeDate;
		this.startHour = startHour;
		this.endHour = endHour;
		this.cities = cities;
		this.activities = activities;
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + ((cities == null) ? 0 : cities.hashCode());
		result = prime * result + ((endHour == null) ? 0 : endHour.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((rangeDate == null) ? 0 : rangeDate.hashCode());
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
		Research other = (Research) obj;
		if (activities == null) {
			if (other.activities != null)
				return false;
		} else if (!activities.equals(other.activities))
			return false;
		if (cities == null) {
			if (other.cities != null)
				return false;
		} else if (!cities.equals(other.cities))
			return false;
		if (endHour == null) {
			if (other.endHour != null)
				return false;
		} else if (!endHour.equals(other.endHour))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (rangeDate == null) {
			if (other.rangeDate != null)
				return false;
		} else if (!rangeDate.equals(other.rangeDate))
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
		return "Research [rangeDate=" + rangeDate + ", startHour=" + startHour + ", endHour=" + endHour + ", cities="
				+ cities + ", activities=" + activities + ", equipment=" + equipment + "]";
	}

	public List<LocalDate> getRangeDate() {
		return rangeDate;
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public List<City> getCities() {
		return cities;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public EquipmentType getEquipment() {
		return equipment;
	}

	public void setRangeDate(List<LocalDate> rangeDate) {
		this.rangeDate = rangeDate;
	}

	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public void setEquipment(EquipmentType equipment) {
		this.equipment = equipment;
	}
}
