package system.domain.order_module;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import system.domain.login_module.Member;
import system.domain.order_module.Order;

@RunWith(JUnitParamsRunner.class)
public class IdentifyCartOrderUnitTesting {
	
	/*
	 * Order Module Unit Testing
	 * Test Cases 7.1.1
	 *
	 */
	@Test (expected = IllegalArgumentException.class)
	public void IdentifyCartOrderUnitTest () {
		Order order = new Order();
		order.checkIsCartEmpty();
	}
	
	//missing one branch
	
	

}
