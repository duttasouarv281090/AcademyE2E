package Resource;

import org.testng.annotations.DataProvider;

public class dataProvider {

	@DataProvider(name="multipleLogin-data")
	public static Object[][] getLoginmultipleData()
	{
		return new Object[][]
				{
			
			{"duttasourav207@gmail.com","qwerty"},
			{"duttasourqav2809@gmail.com","utyyu"}
			
				};
	}
}
