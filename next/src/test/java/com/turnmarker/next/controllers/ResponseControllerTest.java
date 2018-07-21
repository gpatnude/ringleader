/**
 * 
 */
package com.turnmarker.next.controllers;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnmarker.next.models.ResponseModel;
import com.turnmarker.next.models.RingGraphModel;

/**
 * @author Greg Patnude
 *
 */
public class ResponseControllerTest extends AbstractTestBase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRootConnection() {

		RestTemplate rt = this.getRestTemplate();

		//
		String url = "http://localhost:8080/?TURN=34ACE34ADF34AXX";

		// EXECUTE:
		ResponseEntity<String> response = rt.getForEntity(url, String.class);

		// TEST:
		assertEquals(response.getStatusCode(), HttpStatus.OK);

		// EXTRACT THE TOP-LEVEL OBJECT:
		ObjectMapper om = new ObjectMapper();

		try {

			// INSPECT THIS: 
			JsonNode root = om.readTree(response.getBody());
			JsonNode name = root.path("name");
			
			try { 
			
				// IS THIS A STRUCTURED MODEL ?
				RingGraphModel mdl = rt.getForObject(url, RingGraphModel.class);
				
				// 
				
				// WHAT ???
				assertTrue(mdl instanceof RingGraphModel);

			} catch (RestClientException re) {
				
				// TODO Auto-generated catch block
				re.printStackTrace();

				// HIDE THIS WHEN DONE:
				// fail("RestClientException");				
				
			}

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

			// HIDE THIS WHEN DONE:
			fail("IOException");

		}

	}

	/**
	 * Test method for
	 * {@link com.turnmarker.next.controllers.ResponseController#responseModel(java.lang.String, org.springframework.http.HttpHeaders)}.
	 */
	@Test
	public void testResponseModel() {

		fail("Not yet implemented"); // TODO

	}

	/**
	 * Test method for
	 * {@link com.turnmarker.next.controllers.AbstractBaseController#inspectHeader(org.springframework.http.HttpHeaders)}.
	 */
	@Test
	public void testInspectHeader() {

		fail("Not yet implemented"); // TODO

	}

}
