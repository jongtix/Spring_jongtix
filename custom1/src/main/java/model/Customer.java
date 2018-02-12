package model;
import javax.validation.constraints.AssertFalse;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
public class Customer {
	private int id;
	@NotBlank
	@Length(max=20,message="이름이 너~무 길어")
	private String name;
	@NotBlank(message="주소를 입력하세요")
	@Length(max=80,message="주소는 80자 이내")
	private String address;
	@NotBlank(message="이메일을 입력하시오")
	@Email
	private String emailAddress;
	public Customer() {}
	public Customer(String name,String address,String emailAddress) {
		this.name = name; this.address = address;
		this.emailAddress = emailAddress;
	}
	@AssertFalse(message = "{errors.ngemail}") 
	public boolean isNgEmail() { 
		// 이메일주소가 사용할 수 있는 주소인지 확인 
		// 도메인 이름이 ng.foo.baz이면 사용불가 주소로 본다 
		return emailAddress.matches(".*@ng.foo.baz$");
	}
	public int getId() {	return id;	}
	public void setId(int id) {	this.id = id;	}
	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {	return emailAddress;	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	} 	
	public String toString() {
		return "고객[아이디 : "+id+", 이름 : "+name+", 주소 "+address
			+ ", 이메일 : " + emailAddress+"]";
	}
}