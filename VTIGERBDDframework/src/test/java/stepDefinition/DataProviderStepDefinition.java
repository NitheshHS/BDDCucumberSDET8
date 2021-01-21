package stepDefinition;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class DataProviderStepDefinition {
	@When("I want to fetch the deatils Employees {string} and {string} and {string}")
	public void i_want_to_fetch_the_deatils_employees_and_and(String string, String string2, String string3) {
	    System.out.println(string+"|"+string2+"|"+string3);
	}
	@When("I want to read data in row and column wise")
	public void i_want_to_read_data_in_row_and_column_wise(DataTable dataTable) {
	List<Map<Object, Object>> data = dataTable.asMaps(String.class, String.class);
	System.out.println(data.get(0).get("name"));
	System.out.println(data.get(1).get("name"));
	}

}
