package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private UserType userType;
	private String name;
	private String surname;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private Gender gender;
	private String street;
	@ManyToOne
	@JoinColumn (referencedColumnName = "id")
	private City city;
	private LocalDate birthDate;
	private String phoneNumber;
	@Column (unique = true)
	private String email;
	private String emergencyContactName;
	private String emergencyContactSurname;
	private String emergencyContactPhoneNumber;
	@Column (unique = true)
	private String login;
	private String password;
	private LocalDateTime inscriptionDate;
	@OneToMany (mappedBy = "volunteer", cascade = CascadeType.ALL)
	private Set<Reply> replies;
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
	private Set<ActivityPreference> activitiesPreferences;
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Availability> availabities;
	@OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Demand> demands;

	public User() {
		super();
	}

	public User(Integer id, UserType userType, String name, String surname, Gender gender, String street, City city,
			LocalDate birthDate, String phoneNumber, String email, String emergencyContactName,
			String emergencyContactSurname, String emergencyContactPhoneNumber, String login, String password,
			LocalDateTime inscriptionDate, Set<Reply> replies, Set<ActivityPreference> activitiesPreferences,
			Set<Availability> availabities) {
		super();
		this.id = id;
		this.userType = userType;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.street = street;
		this.city = city;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactSurname = emergencyContactSurname;
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
		this.login = login;
		this.password = password;
		this.inscriptionDate = inscriptionDate;
		this.replies = replies;
		this.activitiesPreferences = activitiesPreferences;
		this.availabities = availabities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emergencyContactName == null) ? 0 : emergencyContactName.hashCode());
		result = prime * result + ((emergencyContactPhoneNumber == null) ? 0 : emergencyContactPhoneNumber.hashCode());
		result = prime * result + ((emergencyContactSurname == null) ? 0 : emergencyContactSurname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscriptionDate == null) ? 0 : inscriptionDate.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emergencyContactName == null) {
			if (other.emergencyContactName != null)
				return false;
		} else if (!emergencyContactName.equals(other.emergencyContactName))
			return false;
		if (emergencyContactPhoneNumber == null) {
			if (other.emergencyContactPhoneNumber != null)
				return false;
		} else if (!emergencyContactPhoneNumber.equals(other.emergencyContactPhoneNumber))
			return false;
		if (emergencyContactSurname == null) {
			if (other.emergencyContactSurname != null)
				return false;
		} else if (!emergencyContactSurname.equals(other.emergencyContactSurname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscriptionDate == null) {
			if (other.inscriptionDate != null)
				return false;
		} else if (!inscriptionDate.equals(other.inscriptionDate))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", street=" + street + ", birthDate="
				+ birthDate + ", phoneNumber=" + phoneNumber + ", email=" + email + ", emergencyContactName="
				+ emergencyContactName + ", emergencyContactSurname=" + emergencyContactSurname
				+ ", emergencyContactPhoneNumber=" + emergencyContactPhoneNumber + ", login=" + login + ", password="
				+ password + ", inscriptionDate=" + inscriptionDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public UserType getUserType() {
		return userType;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Gender getGender() {
		return gender;
	}

	public String getStreet() {
		return street;
	}

	public City getCity() {
		return city;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public String getEmergencyContactSurname() {
		return emergencyContactSurname;
	}

	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getInscriptionDate() {
		return inscriptionDate;
	}

	public Set<Reply> getReplies() {
		return replies;
	}

	public Set<ActivityPreference> getActivitiesPreferences() {
		return activitiesPreferences;
	}

	public Set<Availability> getAvailabities() {
		return availabities;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public void setEmergencyContactSurname(String emergencyContactSurname) {
		this.emergencyContactSurname = emergencyContactSurname;
	}

	public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setInscriptionDate(LocalDateTime inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	public void setActivitiesPreferences(Set<ActivityPreference> activitiesPreferences) {
		this.activitiesPreferences = activitiesPreferences;
	}

	public void setAvailabities(Set<Availability> availabities) {
		this.availabities = availabities;
	}

}
