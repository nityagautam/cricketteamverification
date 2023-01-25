package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;


/**
 * 
 * @author Ashutosh Mishra (nityagautam)
 * @created 25 Jan 2023
 * @lastModified 25 Jan 2023
 * @Desc 
 * 		Has the setup and tear-down methods for the each test class
 *
 */
public class BaseTest {
	
	/*
	 * Test Setup/TearDown Methods
	 * ----------------------------------
	 */
	
	@BeforeClass
	public static void setup() {
		//System.out.println("[DEBUG] Setup ...");
	}
	
	@AfterClass
	public static void tearDown() {
		//System.out.println("[DEBUG] Tear-down ...");		
	}
	

}
