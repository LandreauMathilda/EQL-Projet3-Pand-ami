package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String label;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private ActivityCategory activityCategory;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private EquipmentType equipmentType;
	@OneToMany (mappedBy = "activity", cascade = CascadeType.ALL)
	private Set<ActivityPreference> activitiesPreferences;
	
	public Activity() {
		super();
	}

	
	public Activity(Integer id, String label, ActivityCategory activityCategory, EquipmentType equipmentType) {
		super();
		this.id = id;
		this.label = label;
		this.activityCategory = activityCategory;
		this.equipmentType = equipmentType;
	}
	
	public Activity(Integer id, String label,  EquipmentType equipmentType) {
		super();
		this.id = id;
		this.label = label;
		this.equipmentType = equipmentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Activity other = (Activity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return   label ;
	}

	public Integer getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public Set<ActivityPreference> getActivitiesPreferences() {
		return activitiesPreferences;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setActivityCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public void setActivitiesPreferences(Set<ActivityPreference> activitiesPreferences) {
		this.activitiesPreferences = activitiesPreferences;
	}
}
