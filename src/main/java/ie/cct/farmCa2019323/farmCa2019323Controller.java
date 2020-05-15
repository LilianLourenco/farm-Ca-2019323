package ie.cct.farmCa2019323;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class farmCa2019323Controller {

	public ArrayList<Animal> animals;// creating an arrayList
	public ArrayList<Animal> cows = new ArrayList<>();
	ArrayList<Animal> pigs = new ArrayList<>();
	public ArrayList<Animal> chickens = new ArrayList<>();

	/**
	 * FIRST ENDPOINT
	 */
	public farmCa2019323Controller() {// creating a constructor
		animals = new ArrayList<Animal>();// creating an empty array inside the constructor
	}

	// first endpoint
	// Post http://localhost:8080/add-animal
	@PostMapping("add-animal")
	public SuccessResponse addAnimal(@RequestBody Animal animal) {
		animals.add(animal);
		return new SuccessResponse("Animal " + animal.getType() + " added");

	}

	/**
	 * SECOND ENDPOINT
	 */
	// Get http://localhost:8080/average-weight
	@GetMapping("average-weight")
	public HashMap<String, Float> averageAnimalWeight() {
		if (animals.size() == 0) {

			throw new NotFoundException("No animals stored in the farm");
		}
		float pigWeight = 0.0f;
		float cowWeight = 0.0f;
		float chickenWeight = 0.0f;
		float weight = 0.0f;
		// hasshMap will take all type of animals in a list
		HashMap<String, Float> weightAnimal = new HashMap<String, Float>();
		// lopping
		for (Animal animal : animals) {
			// taking the animal by type
			if (animal.getType().equals("pigs")) {
				pigs.add(animal);

				pigWeight += animal.getWeight();
			}

			weight = pigWeight / pigs.size();
			System.out.println("The average weight of pig  is " + pigWeight);
			if (animal.getType().equals("cows")) {
				cowWeight += animal.getWeight();
			}

			weight = cowWeight / cows.size();
			// line for check the result in eclipse
			System.out.println("The average weight of cow is " + cowWeight);

			if (animal.getType().equals("chickens")) {
				chickenWeight += animal.getWeight();
			}
			weight = chickenWeight / chickens.size();
			System.out.println("The average weight of chickens  is " + chickenWeight);

		}
		weightAnimal.put("pigs", pigWeight);
		weightAnimal.put("cows", cowWeight);
		weightAnimal.put("chickens", chickenWeight);
		System.out.println(weightAnimal.keySet());

		return (weightAnimal);
	}

	/**
	 * THIRD ENDPOINT
	 */
	@GetMapping("calculate-total")
	public HashMap<String, Integer> calculate() {

		if (animals.size() == 0) {

			throw new NotFoundException("No animals stored in the farm");
		}
		int totalPigs = 0;
		int totalCows = 0;
		int totalChickens = 0;
		int totalAnimal = 0;

		for (Animal animal : animals) {
			if (animals.size() == 0) {
				{
					throw new RuntimeException("No animals found in the Farm");
				}
			}
			if (animal.getType().equals("pigs") && animal.getWeight() >= 100) {

				totalPigs++;
				totalAnimal = totalPigs;
				System.out.println("The total of pigs is : " + totalPigs);

			}

			if (animal.getType().equals("cows") && animal.getWeight() >= 300) {
				totalCows++;
				totalAnimal = totalCows;
				System.out.println("The total of cows is : " + totalCows);
			}
			if (animal.getType().equals("chickens") && animal.getWeight() >= 0.5) {
				totalChickens++;
				totalAnimal = totalChickens;
				System.out.println("The total of chickens is : " + totalChickens);

				System.out.println(animal);
			}
		}

		HashMap<String, Integer> myAnimal = new HashMap<String, Integer>();
		myAnimal.put("pigs", totalPigs);
		myAnimal.put("cows", totalCows);
		myAnimal.put("chickens", totalChickens);
		System.out.println(myAnimal.keySet());
		return (myAnimal);

	}

	/**
	 * FOURTH ENDPOINT
	 */
	@GetMapping("calculate-Total-Farm")
	public SuccessResponse calculateFarm() {
		if (animals.size() == 0) {

			throw new NotFoundException("No animals stored in the farm");
		}
		int totalPigs = 0;
		int totalCows = 0;
		int totalChickens = 0;
		int totalAnimal = 0;

		for (Animal animal : animals) {

			if (animal.getType().equals("pigs") && animal.getWeight() >= 100) {
				float pigValue = 250;
				totalPigs += pigValue;
				totalPigs += animal.getPrice();

			}

			totalAnimal = totalPigs + pigs.size();

			// Getting the type of the aninal and checking if the weiht is enough for sell
			if (animal.getType().equals("cows") && animal.getWeight() >= 300) {
				// taking the price of the animal and adding it in the variable totalCows
				float cowValue = 500;
				totalCows += cowValue;
				totalCows += animal.getPrice();
			}
			totalAnimal = totalCows + cows.size();
			// comparing if the type of the animal is equal chicken and is yes the weight
			// cannot be below 0.5
			if (animal.getType().equals("chickens") && animal.getWeight() >= 0.5) {
				float chickenValue = 5;
				totalChickens += chickenValue;
				totalChickens += animal.getPrice();
			}
			totalAnimal = totalChickens + chickens.size();
		}
		totalAnimal = totalPigs + totalCows + totalChickens;

		return new SuccessResponse("The total of the Farm is: €" + totalAnimal);

	}

	/**
	 * FIFTH ENDPOINT
	 * 
	 * @return
	 */
	// value of the farm assuming the price of each animal is set by a parameter in
	// the HTTP request

	
	@GetMapping("request-params")
	public String farmValue(@RequestParam(required = true) Float pigPrice,
			@RequestParam(required = true) float cowPrice, @RequestParam(required = true) float chickensPrice) {
		float totalAnimal=0.f;
		totalAnimal = pigPrice + cowPrice + chickensPrice;
		return " pigs  €" + pigPrice + "  cows  €"  + cowPrice + "  chickens  €" + chickensPrice  +" The Farm total is:   €"+totalAnimal;

	}
}
