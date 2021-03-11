package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category_activity")
public class CategoryActivity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String label;
	@OneToMany (mappedBy = "categoryActivity", cascade = CascadeType.ALL)
	private Set<Activity> activities;
	
	public CategoryActivity() {
		super();
	}

	public CategoryActivity(Integer id, String label, Set<Activity> activities) {
		super();
		this.id = id;
		this.label = label;
		this.activities = activities;
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
		CategoryActivity other = (CategoryActivity) obj;
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
		return "CategoryActivity [id=" + id + ", label=" + label + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
}
