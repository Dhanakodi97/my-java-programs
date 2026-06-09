package test;

import org.testng.annotations.Test;

public class LearnGroups {
	
	@Test(groups = {"start"})
	public void signUp() {
		System.out.println("Sign Up");
	}
	@Test(groups = {"log"})
	public void Login() {
		System.out.println("Login");
	}
	@Test(groups = {"purchase"})
	public void SearchProduct() {
		System.out.println("Search Product");
	}
	@Test(groups = {"purchase"})
	public void AddToCart() {
		System.out.println("Add to Cart");
	}
	@Test(groups = {"log"})
	public void Logout() {
		System.out.println("Logout");
		
	}

}
