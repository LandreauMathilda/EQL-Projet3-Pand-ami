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
@Table(name="activity_preference")
public class ActivityPreference implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime preferenceStart;
	private LocalDateTime preferenceEnd;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Activity activity;
	
	public ActivityPreference() {
		super();
	}

	public ActivityPreference(LocalDateTime preferenceStart, LocalDateTime preferenceEnd, User user,
			Activity activity) {
		super();
		this.preferenceStart = preferenceStart;
		this.preferenceEnd = preferenceEnd;
		this.user = user;
		this.activity = activity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preferenceEnd == null) ? 0 : preferenceEnd.hashCode());
		result = prime * result + ((preferenceStart == null) ? 0 : preferenceStart.hashCode());
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
		ActivityPreference other = (ActivityPreference) obj;
		if (preferenceEnd == null) {
			if (other.preferenceEnd != null)
				return false;
		} else if (!preferenceEnd.equals(other.preferenceEnd))
			return false;
		if (preferenceStart == null) {
			if (other.preferenceStart != null)
				return false;
		} else if (!preferenceStart.equals(other.preferenceStart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActivityPreference [preferenceStart=" + preferenceStart + ", preferenceEnd=" + preferenceEnd + "]";
	}

	public LocalDateTime getPreferenceStart() {
		return preferenceStart;
	}

	public LocalDateTime getPreferenceEnd() {
		return preferenceEnd;
	}

	public User getUser() {
		return user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setPreferenceStart(LocalDateTime preferenceStart) {
		this.preferenceStart = preferenceStart;
	}

	public void setPreferenceEnd(LocalDateTime preferenceEnd) {
		this.preferenceEnd = preferenceEnd;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
