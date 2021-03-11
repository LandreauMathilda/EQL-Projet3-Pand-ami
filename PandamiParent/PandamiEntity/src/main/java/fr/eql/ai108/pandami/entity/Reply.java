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
@Table(name="reply")
public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime replyDate;
	private LocalDateTime selectionDate;
	private LocalDateTime desistDate;
	private LocalDateTime rejectDate;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private User volunteer;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Demand demand;
	
	public Reply() {
		super();
	}

	public Reply(Integer id, LocalDateTime replyDate, LocalDateTime selectionDate, LocalDateTime desistDate,
			LocalDateTime rejectDate, User volunteer, Demand demand) {
		super();
		this.id = id;
		this.replyDate = replyDate;
		this.selectionDate = selectionDate;
		this.desistDate = desistDate;
		this.rejectDate = rejectDate;
		this.volunteer = volunteer;
		this.demand = demand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desistDate == null) ? 0 : desistDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rejectDate == null) ? 0 : rejectDate.hashCode());
		result = prime * result + ((replyDate == null) ? 0 : replyDate.hashCode());
		result = prime * result + ((selectionDate == null) ? 0 : selectionDate.hashCode());
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
		Reply other = (Reply) obj;
		if (desistDate == null) {
			if (other.desistDate != null)
				return false;
		} else if (!desistDate.equals(other.desistDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rejectDate == null) {
			if (other.rejectDate != null)
				return false;
		} else if (!rejectDate.equals(other.rejectDate))
			return false;
		if (replyDate == null) {
			if (other.replyDate != null)
				return false;
		} else if (!replyDate.equals(other.replyDate))
			return false;
		if (selectionDate == null) {
			if (other.selectionDate != null)
				return false;
		} else if (!selectionDate.equals(other.selectionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", replyDate=" + replyDate + ", selectionDate=" + selectionDate + ", desistDate="
				+ desistDate + ", rejectDate=" + rejectDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getReplyDate() {
		return replyDate;
	}

	public LocalDateTime getSelectionDate() {
		return selectionDate;
	}

	public LocalDateTime getDesistDate() {
		return desistDate;
	}

	public LocalDateTime getRejectDate() {
		return rejectDate;
	}

	public User getVolunteer() {
		return volunteer;
	}

	public Demand getDemand() {
		return demand;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setReplyDate(LocalDateTime replyDate) {
		this.replyDate = replyDate;
	}

	public void setSelectionDate(LocalDateTime selectionDate) {
		this.selectionDate = selectionDate;
	}

	public void setDesistDate(LocalDateTime desistDate) {
		this.desistDate = desistDate;
	}

	public void setRejectDate(LocalDateTime rejectDate) {
		this.rejectDate = rejectDate;
	}

	public void setVolunteer(User volunteer) {
		this.volunteer = volunteer;
	}

	public void setDemand(Demand demand) {
		this.demand = demand;
	}
}
