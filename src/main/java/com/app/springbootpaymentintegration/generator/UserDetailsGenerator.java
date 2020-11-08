package com.app.springbootpaymentintegration.generator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserDetailsGenerator implements IdentifierGenerator{
	
	public int generateId() {
		Random random = new Random();
		return random.nextInt(100);
	}

	public String generateAnotherId() {

		return RandomStringUtils.randomNumeric(9);
	}

	@Override
	public Serializable generate(SessionImplementor si, Object o)
			throws HibernateException {


		Calendar calendar = Calendar.getInstance();
		return "USDT" + this.generateId() + this.generateAnotherId()
				+ calendar.get(Calendar.DATE) + calendar.get(Calendar.YEAR);

	}

}
