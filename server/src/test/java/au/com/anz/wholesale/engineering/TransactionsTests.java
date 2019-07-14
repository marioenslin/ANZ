package au.com.anz.wholesale.engineering;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TransactionsTests extends AbstractTest{
	
	@Override
    @Before
    public void setUp() {
       super.setUp();
    }

	@Test
	public void getAllTransactionsList() throws Exception {
	   String uri = "/all-transactions";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Transactions[] transactionslist = super.mapFromJson(content, Transactions[].class);
	   assertTrue(transactionslist.length > 0);
	}
	
	@Test
	public void getTransactionsByAccountNumber() throws Exception {
	   String uri = "/transactions?accountNumber=791066619";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Transactions[] transactionslist = super.mapFromJson(content, Transactions[].class);
	   assertTrue(transactionslist.length > 0);
	}
}
