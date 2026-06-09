package test;

import org.testng.annotations.Test;

public class TestNgAttributes {
	@Test()
	public void signUp(){
		System.out.println("Sign Up");
		
	}
	@Test
	public void login() {
		System.out.println("Login");
	}
	@Test
	public void searchProduct() {
		System.out.println("Search Product");
	}
	@Test
	public void addToCart() {
		System.out.println("Cart");
	}
	@Test
	public void signOut() {
		System.out.println("Sign Out");
	}

}
