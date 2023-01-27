package tests;

/*
 * Import Section
 * ===================
 */
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import config.Config;
import utilities.JSONReader;

/**
 * Test Class
 * ================================================
 * @author Ashutosh Mishra (nityagautam)
 * @desc
 * 		Test 1- Team has only 4 foreign players
 * 		Test 2- Team has at least 1 wicket keeper
 */

@SuppressWarnings("unchecked")
public class TeamsBasicPropertiesTest extends BaseTest{
	
	/*
	 * Class properties/Members
	 * ----------------------------------
	 */
	int countForiegner = 0;
	int expectedForiegnPlayers = 4;
	int countWicketKeepers = 0;
	int expectedWicketKeepers = 1;
	final String homeCountry = "india";
	final String countryKeyword = "country";
	final String playerKeyword = "player";
	final String roleKeyword = "role";
	final String expectedRole = "wicket-keeper";
	
	String fileName = Config.JSONFileLocation + Config.JSONFileName;
	JSONReader jsonReaderObj = new JSONReader(fileName, false);
	
	/*
	 * Test Methods goes here ...
	 * ----------------------------------
	 */
	
	@Test
	public void verifyTeamHasAtLeastOneVicketKeeper() {
		
		// Extra logging
		System.out.println("\n[DEBUG] Test- Team has At least one WicketKeeper ...");
		System.out.println("[DEBUG] Team Name: " + this.jsonReaderObj.get("name") );
		
		// Count for the wicker-keeper role
		this.jsonReaderObj.getList(this.playerKeyword).forEach( obj -> { 
			//System.out.println("[DEBUG] -> " + obj.toString());
			if(this.jsonReaderObj.get(this.roleKeyword, (JSONObject)obj).toLowerCase().contains(this.expectedRole)) {
				this.countWicketKeepers += 1;
			}
		});
		
		// and then assert
		System.out.println("[DEBUG] Total Wicket keepers: " + this.countWicketKeepers + "\n");
		assertEquals(this.countWicketKeepers >= this.expectedWicketKeepers, true);
	}
	
	@Test
	public void verifyTeamHasOnlyFourForeignPlayers() {
		// Extra logging
		System.out.println("\n[DEBUG] Test- Team has 4 foriegn players ...");
		System.out.println("[DEBUG] Team Name: " + this.jsonReaderObj.get("name") );
		
		// Count for the non-home country players,
		this.jsonReaderObj.getList("player").forEach( obj -> { 
			//System.out.println("[DEBUG] -> " + obj.toString());
			if(!this.jsonReaderObj.get(this.countryKeyword, (JSONObject)obj).toLowerCase().contains(this.homeCountry)) {
				this.countForiegner += 1;
			}
		});
		
		// and then assert
		System.out.println("[DEBUG] Total Foriegn Players: " + this.countForiegner + "\n");
		assertEquals(this.countForiegner == this.expectedForiegnPlayers, true);
	}
	

}
