/**
 * 
 */
package com.ys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shraddha Gusai
 *
 */
@Entity
@Table(name = "ADDRESSDETAIL")
public class AddressDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRESS_DETAIL_ID")
	private int addressDetailId;

	@Column(name = "ADDRESS_TYPE")
	private String addressType;

	@Column(name = "BUILDING")
	private String building;

	@Column(name = "STREET")
	private String street;

	@Column(name = "LANDMARK")
	private String landmark;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "POSTCODE")
	private String postcode;

	/**
	 * @return the addressDetailId
	 */
	public int getAddressDetailId() {
		return addressDetailId;
	}

	/**
	 * @param addressDetailId the addressDetailId to set
	 */
	public void setAddressDetailId(int addressDetailId) {
		this.addressDetailId = addressDetailId;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressDetail [addressDetailId=" + addressDetailId + ", addressType=" + addressType + ", building="
				+ building + ", street=" + street + ", landmark=" + landmark + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", postcode=" + postcode + ", getAddressDetailId()=" + getAddressDetailId()
				+ ", getAddressType()=" + getAddressType() + ", getBuilding()=" + getBuilding() + ", getStreet()="
				+ getStreet() + ", getLandmark()=" + getLandmark() + ", getCity()=" + getCity() + ", getState()="
				+ getState() + ", getCountry()=" + getCountry() + ", getPostcode()=" + getPostcode() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
