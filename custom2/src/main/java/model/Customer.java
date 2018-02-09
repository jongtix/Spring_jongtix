package model;

import javax.validation.constraints.AssertFalse;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Customer {

	private int id;

	@NotBlank(message = "이름을 반드시 입력하세요")
	@Length(max = 20, message = "이름이 너무 길어요")
	private String name;

	@NotBlank(message = "주소를 반드시 입력하세요")
	@Length(max = 80, message = "주소는 80자 이내로 하세요")
	private String address;

	@NotBlank(message = "이메일 주소를 반드시 입력하세요")
	@Email // 이메일 패턴 체크
	private String email;

	@AssertFalse(message = "{errors.ngemail}")
	public boolean isNgEmail() {
		return email.matches(".*@ng.foo.baz$"); // 도메인 이름이 ng.foo.baz이면 사용불가 주소로 체크
	}

	public Customer() {
	}

	public Customer(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "고객[아이디: " + id + ", 이름: " + name + ", 주소: " + address + ", 이메일: " + email + "]";
	}

}
