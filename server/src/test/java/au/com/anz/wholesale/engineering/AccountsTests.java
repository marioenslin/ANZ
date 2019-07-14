package au.com.anz.wholesale.engineering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AccountsTests extends AbstractTest{
	
	@Override
    @Before
    public void setUp() {
       super.setUp();
    }

	@Test
	public void getAllAccountsList() throws Exception {
	   String uri = "/all-accounts";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Accounts[] accountslist = super.mapFromJson(content, Accounts[].class);
	   assertTrue(accountslist.length > 0);
	}
}
