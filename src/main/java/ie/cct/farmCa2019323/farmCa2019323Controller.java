package ie.cct.farmCa2019323;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class farmCa2019323Controller {

	public ArrayList<Animal> animals;// creating an arrayList
	public ArrayList<Animal> cow = new ArrayList<>();
	ArrayList<Animal> pigs = new ArrayList<>();
	public ArrayList<Animal> chickens = new ArrayList<>();

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

	// second endpoint
	@GetMapping("calculate-animal-average-weight")

	public float averageAnimalWeight() {
//		if (animals.size() != 0) {

		float pigWeight = 0.0f;
		float cowWeight = 0.0f;
		float chickenWeight = 0.0f;
		float weight = 0.0f;

		for (Animal animal : animals) {

			if (animal.getType().equals("pigs")) {
				pigs.add(animal);
				pigWeight += animal.getWeight();
			}
			pigWeight = pigWeight / animals.size();
			weight = pigWeight / animals.size();

			System.out.println("The average weight of pig  is " + pigWeight);

			if (animal.getType().equals("cows")) {
				cowWeight += animal.getWeight();
				cowWeight = cowWeight / animals.size();
				weight = cowWeight / animals.size();
				// line for check the result in eclipse
				System.out.println("The average weight of cow is " + cowWeight);

			}

			if (animal.getType().equals("chickens")) {
				chickenWeight += animal.getWeight();
				chickenWeight = chickenWeight / animals.size();
				weight = chickenWeight / animals.size();

				System.out.println("The average weight of chickens  is " + chickenWeight);

			}
		}
		return (weight);
	}

	// third endpoint
	@GetMapping("calculate-total")
	public int calculate() {
		// ArrayList<Animal> myAnimal = new ArrayList<Animal>();
		int totalPigs = 0;
		int totalCows = 0;
		int totalChickens = 0;
		int totalAnimal = 0;
		// float pigWeight= 0f;

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
				System.out.println("The total off cows is : " + totalCows);
			}
			if (animal.getType().equals("chickens") && animal.getWeight() >= 0.5) {
				totalChickens++;
				totalAnimal = totalChickens;
				System.out.println("The total of chickens is : " + totalChickens);

			}
		}
		return (totalAnimal );

	}

	public Collection<Animal> ListAnimal() {
		ArrayList<Animal> myAnimal = new ArrayList<Animal>();
		for (int i = 0; i < animals.size(); i++) {
			myAnimal.add(animals.get(i));
		}

		return animals;

	}
}
