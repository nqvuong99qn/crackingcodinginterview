package mastercodinginterview;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaExpressions_13_7 {
	
	public class Country{
		
		String Continent;
		int Population;
		
		public Country(String Continent, int Population) {
			this.Continent = Continent;
			this.Population = Population;
		}
		
		
		String getContinent() {
			return "test";
		}
		
		int getPopulation() {
			return 0;
		}

	}
	// problem
	public int getPopulation(List<Country> countries, String continent) {
//		AtomicInteger result = new AtomicInteger(0);
//		countries.stream().forEach(country ->{
//			if(country.getContinent().equals(continent))
//				result.set(result.get() + country.getPopulation());;
//		});
//		return result.get();
		
		// filter countries
		Stream<Country> subList = countries.stream().filter(item -> item.getContinent().equals(continent));
		
		
		// get Population
		Stream<Integer> populations = subList.map(item -> item.getPopulation());
		
		// using reduce
		
		return populations.reduce(0, (a, b) -> a + b);
		
		
		
		
//		// without lambda expression
//		int sum = 0;
//		for(Country country : countries) {
//			if(country.getContinent().equals(continent))
//				sum += country.getPopulation();
//		}
//		return sum;
	}
	

	
	public static void main(String[] args) {
		
		
		List<Integer> test = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
	
		// test filter
		List<Integer> oddNumber = test.stream().filter(item -> item % 2 ==0)
						.collect(Collectors.toList());
		
		
		
		
		
		


		
		
				
		
		System.out.println("Say hi!!!!");
		
		
		
		
	}

}
