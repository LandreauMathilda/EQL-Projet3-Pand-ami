package fr.eql.ai108.pandami.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private CategoryActivity categoryActivity;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private EquipmentType equipmentType;
	
	public Activity() {
		super();

	}

	public Activity(Integer id, String label, CategoryActivity categoryActivity, EquipmentType equipmentType) {
		super();
		this.id = id;
		this.label = label;
		this.categoryActivity = categoryActivity;
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
		return "Activity [id=" + id + ", label=" + label + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	public CategoryActivity getCategoryActivity() {
		return categoryActivity;
	}
	public EquipmentType getEquipmentType() {
		return equipmentType;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setCategoryActivity(CategoryActivity categoryActivity) {
		this.categoryActivity = categoryActivity;
	}
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
}
