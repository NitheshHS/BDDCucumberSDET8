Feature: Dataprovider feature

Scenario Outline: Exceute the same scenario with multiple set of data
When I want to fetch the deatils Employees "<empId>" and "<empName>" and <empsal>
Examples:
		|empId|empName|empsal|
		|Ty_01|Nithesh|5000|
		|Ty_02|Alex|3000|
		|Ty_03|Manoj|5000|


@SmokeTest		
Scenario: I want to read the data from data table using java collection
When I want to read data in row and column wise
|id|name|number|
|TY_02|Alex|456|
|TY_03|Supreeth|789|