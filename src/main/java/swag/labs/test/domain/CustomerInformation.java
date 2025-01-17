package swag.labs.test.domain;

public class CustomerInformation {

	private String firstName;
	
	private String lastName;
	
	private String postalCode;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "CustomerInformation [firstName=" + firstName + ", lastName=" + lastName + ", postalCode=" + postalCode
				+ "]";
	}
}