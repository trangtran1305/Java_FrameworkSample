package com.nopcommerce.register;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerDataHelper {
	private Locale locale = new Locale("en");
	private Faker faker = new Faker(locale);

	public static FakerDataHelper getData() {
		return new FakerDataHelper();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password();
	}
}
