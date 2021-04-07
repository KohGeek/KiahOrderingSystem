package system.menu;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.login.Member;
import system.payment.Order;

@RunWith(JUnitParamsRunner.class)
public class IdentifyCartOrderUnitTesting {
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 7.1.1
	 * Boundary Value Analysis
	 */
	@Test (expected = IllegalArgumentException.class)
	public void IdentifyCartOrderUnitTest () {
		Order order = new Order();
		order.checkIsCartEmpty();
	}
	
	

}
