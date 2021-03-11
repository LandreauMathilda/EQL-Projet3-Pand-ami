package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	private LocalDateTime startActionDate;
	private LocalDateTime endActionDate;
	private String street;
	private LocalDateTime publishDate;
	private LocalDateTime cancelDate;
	private LocalDateTime closeDate;
	private LocalDateTime reportDate;
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

	public Demand(Integer id, LocalDateTime startActionDate, LocalDateTime endActionDate, String street,
			LocalDateTime publishDate, LocalDateTime cancelDate, LocalDateTime closeDate, LocalDateTime reportDate,
			City city, Activity activity, EndedType endedType, Set<Reply> replies, ReportIssue reportIssue) {
		super();
		this.id = id;
		this.startActionDate = startActionDate;
		this.endActionDate = endActionDate;
		this.street = street;
		this.publishDate = publishDate;
		this.cancelDate = cancelDate;
		this.closeDate = closeDate;
		this.reportDate = reportDate;
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
		result = prime * result + ((cancelDate == null) ? 0 : cancelDate.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result + ((endActionDate == null) ? 0 : endActionDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((reportDate == null) ? 0 : reportDate.hashCode());
		result = prime * result + ((startActionDate == null) ? 0 : startActionDate.hashCode());
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
		if (cancelDate == null) {
			if (other.cancelDate != null)
				return false;
		} else if (!cancelDate.equals(other.cancelDate))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (endActionDate == null) {
			if (other.endActionDate != null)
				return false;
		} else if (!endActionDate.equals(other.endActionDate))
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
		if (startActionDate == null) {
			if (other.startActionDate != null)
				return false;
		} else if (!startActionDate.equals(other.startActionDate))
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
		return "Demand [id=" + id + ", startActionDate=" + startActionDate + ", endActionDate=" + endActionDate
				+ ", street=" + street + ", publishDate=" + publishDate + ", cancelDate=" + cancelDate + ", closeDate="
				+ closeDate + ", reportDate=" + reportDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getStartActionDate() {
		return startActionDate;
	}

	public LocalDateTime getEndActionDate() {
		return endActionDate;
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

	public void setStartActionDate(LocalDateTime startActionDate) {
		this.startActionDate = startActionDate;
	}

	public void setEndActionDate(LocalDateTime endActionDate) {
		this.endActionDate = endActionDate;
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
