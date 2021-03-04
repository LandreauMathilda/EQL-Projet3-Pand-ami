package fr.eql.ai108.pandami.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date birthDate;
	private String phoneNumber;
	@Column (unique = true)
	private String email;
	private String emergencyContactName;
	private String emergencyContactSurname;
	private String emergencyContactPhoneNumber;
	@Column (unique = true)
	private String login;
	private String password;
	private Date inscriptionDate;

	public User() {
		super();
	}

	public User(Integer id, UserType userType, String name, String surname, Gender gender, String street, City city,
			Date birthDate, String phoneNumber, String email, String emergencyContactName,
			String emergencyContactSurname, String emergencyContactPhoneNumber, String login, String password,
			Date inscriptionDate) {
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
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactSurname() {
		return emergencyContactSurname;
	}

	public void setEmergencyContactSurname(String emergencyContactSurname) {
		this.emergencyContactSurname = emergencyContactSurname;
	}

	public String getEmergencyContactPhoneNumber() {
		return emergencyContactPhoneNumber;
	}

	public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
		this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}








}
