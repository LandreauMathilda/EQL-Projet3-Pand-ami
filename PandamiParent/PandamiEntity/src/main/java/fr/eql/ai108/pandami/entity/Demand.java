package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Table(name="demand")
public class Demand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User user;
	private LocalDate actionDate;
	private LocalTime startHour;
	private LocalTime endHour;
	private String street;
	private LocalDateTime publishDate;
	private LocalDateTime cancelDate;
	private LocalDateTime closeDate;
	private LocalDateTime reportDate;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private CancelReason cancelReason;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private City city;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Activity activity;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private EndedType endedType;
	@OneToMany (mappedBy = "demand", cascade = CascadeType.ALL)
	private Set<Reply> replies;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private ReportIssue reportIssue;

	public Demand() {
		super();
	}

	public Demand(Integer id, User user, LocalDate actionDate, LocalTime startHour, LocalTime endHour, String street,
			LocalDateTime publishDate, LocalDateTime cancelDate, LocalDateTime closeDate, LocalDateTime reportDate,
			CancelReason cancelReason, City city, Activity activity, EndedType endedType, Set<Reply> replies,
			ReportIssue reportIssue) {
		super();
		this.id = id;
		this.user = user;
		this.actionDate = actionDate;
		this.startHour = startHour;
		this.endHour = endHour;
		this.street = street;
		this.publishDate = publishDate;
		this.cancelDate = cancelDate;
		this.closeDate = closeDate;
		this.reportDate = reportDate;
		this.cancelReason = cancelReason;
		this.city = city;
		this.activity = activity;
		this.endedType = endedType;
		this.replies = replies;
		this.reportIssue = reportIssue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actionDate == null) ? 0 : actionDate.hashCode());
		result = prime * result + ((cancelDate == null) ? 0 : cancelDate.hashCode());
		result = prime * result + ((cancelReason == null) ? 0 : cancelReason.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result + ((endHour == null) ? 0 : endHour.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		result = prime * result + ((startHour == null) ? 0 : startHour.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Demand other = (Demand) obj;
		if (actionDate == null) {
			if (other.actionDate != null)
				return false;
		} else if (!actionDate.equals(other.actionDate))
			return false;
		if (cancelDate == null) {
			if (other.cancelDate != null)
				return false;
		} else if (!cancelDate.equals(other.cancelDate))
			return false;
		if (cancelReason == null) {
			if (other.cancelReason != null)
				return false;
		} else if (!cancelReason.equals(other.cancelReason))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
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
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		if (startHour == null) {
			if (other.startHour != null)
				return false;
		} else if (!startHour.equals(other.startHour))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Demand [id=" + id + ", actionDate=" + actionDate + ", startHour=" + startHour + ", endHour=" + endHour
				+ ", street=" + street + ", publishDate=" + publishDate + ", cancelDate=" + cancelDate + ", closeDate="
				+ closeDate + ", reportDate=" + reportDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public LocalDate getActionDate() {
		return actionDate;
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public String getStreet() {
		return street;
	}

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public LocalDateTime getCancelDate() {
		return cancelDate;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public LocalDateTime getReportDate() {
		return reportDate;
	}

	public CancelReason getCancelReason() {
		return cancelReason;
	}

	public City getCity() {
		return city;
	}

	public Activity getActivity() {
		return activity;
	}

	public EndedType getEndedType() {
		return endedType;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public ReportIssue getReportIssue() {
		return reportIssue;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setActionDate(LocalDate actionDate) {
		this.actionDate = actionDate;
	}

	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}

	public void setCancelDate(LocalDateTime cancelDate) {
		this.cancelDate = cancelDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
	}

	public void setCancelReason(CancelReason cancelReason) {
		this.cancelReason = cancelReason;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void setEndedType(EndedType endedType) {
		this.endedType = endedType;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	public void setReportIssue(ReportIssue reportIssue) {
		this.reportIssue = reportIssue;
	}
}
