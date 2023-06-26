package Billing;

public class User 
{
String name;
String address;
long phone;
public User(String name, String address, long phone) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
}
@Override
public String toString() {
	return "User [name=" + name + ", address=" + address + ", phone=" + phone + "]";
}

	
}
