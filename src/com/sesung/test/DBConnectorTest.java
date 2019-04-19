package com.sesung.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sesung.util.DBConnector;

public class DBConnectorTest {

	@Test
	public void dbcTest() throws Exception {
		DBConnector.connection();
	}

}
