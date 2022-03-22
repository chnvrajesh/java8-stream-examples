package com.nvrviews.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.nvrviews.streams.model.Employee;

public class StreamsExamples {

	public static void main(String args[]) {
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee("Rajesh", "Chinta", "IT", 101, 25000.00, 26));
		empList.add(new Employee("Kiran", "Abbavram", "IT", 102, 45000.00, 30));
		empList.add(new Employee("Dj", "Tilli", "BPO", 103, 22000.00, 28));
		empList.add(new Employee("Dimple", "Hayathi", "Admin", 104, 55000.00, 29));
		empList.add(new Employee("Manoj", "Manchu", "Admin", 106, 25000.00, 32));
		empList.add(new Employee("Rana", "Daggubati", "Infra", 107, 35000.00, 32));
		
		StreamsExamples s = new StreamsExamples();
		s.exampleForeach(empList);
		s.exampleFilter(empList);
		s.exampleCollector(empList);
		s.exampleMap(empList);
		s.exampleDistinctDept(empList);
		s.exampleMax(empList);
		s.exampleMin(empList);
		s.exampleSum(empList);
		s.exampleAverage(empList);
		
	}
	
	/*
	 * use forEach to display employee names
	 */
	
	public void exampleForeach(List<Employee> empList) {
		empList.stream().forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
		System.out.println("--------------------------------------");
	}
	
	/*
	 * use filter to filter IT employees
	 */
	
	public void exampleFilter(List<Employee> empList) {
		long noOfItEmployees = empList.stream()
			.filter(a -> (a.getDepartment() != null && a.getDepartment().equalsIgnoreCase("IT")))
			.count();
		
		System.out.println("IT Employees Count: "+noOfItEmployees);
		System.out.println("--------------------------------------");
	}
	
	
	/*
	 * use filter to filter IT employees and collect it to sublist
	 */
	
	public void exampleCollector(List<Employee> empList) {
		List<Employee> itEmployees = empList.stream()
			.filter(a -> (a.getDepartment() != null && a.getDepartment().equalsIgnoreCase("IT")))
			.collect(Collectors.toList());
		
		System.out.println("IT Employees List: ");
		
		exampleForeach(itEmployees);
	}
	
	/*
	 * use map to get  employee names to Upper case
	 */
	
	public void exampleMap(List<Employee> empList) {
		String employees = empList.stream()
			.map(a -> a.getFirstName().toUpperCase() + " " + a.getLastName().toUpperCase())
			.collect(Collectors.joining(" | "));
		
		System.out.println("All employees:" + employees);

		System.out.println("--------------------------------------");
	}
	
	/*
	 * use distinct to get distinct departments
	 */
	
	public void exampleDistinctDept(List<Employee> empList) {
		List<String> departments = empList.stream()
			.map(Employee::getDepartment)
			.distinct()
			.collect(Collectors.toList());
		
		System.out.println("All Distinct Departments:" + departments);

		System.out.println("--------------------------------------");
	}
	
	/*
	 * use max to get max salary in the list
	 */
	
	public void exampleMax(List<Employee> empList) {
		Optional<Employee> empl = empList.stream()
			.max(Comparator.comparing(Employee::getSalary));
		
		System.out.println("Max Salary among all employees:" + empl.get().getSalary());

		System.out.println("--------------------------------------");
	}
	
	/*
	 * use min to get min salary in the list
	 */
	
	public void exampleMin(List<Employee> empList) {
		
		System.out.println("***** method 1 to use min(Comparator) *****");
		Optional<Employee> empl = empList.stream()
			.min(Comparator.comparing(Employee::getSalary));
		
		System.out.println("Min Salary among all employees:" + empl.get().getSalary());

		System.out.println("***** method 2 to use mapToDouble / mapToInt *****");
		OptionalDouble minSalary = empList.stream()
				.mapToDouble(Employee::getSalary)
				.min();
			
			System.out.println("Min Salary among all employees:" + minSalary.getAsDouble());
		
		System.out.println("--------------------------------------");
	}
	
	/*
	 * use sum to get total salary's paid in the list
	 */
	
	public void exampleSum(List<Employee> empList) {
		
		System.out.println("***** method 2 to use mapToDouble / mapToInt *****");
		double total = empList.stream()
				.mapToDouble(Employee::getSalary)
				.sum();
			
			System.out.println("Total Salary of all employees:" + total);
		
		System.out.println("--------------------------------------");
	}
	
	/*
	 * use sum to get total salary's paid in the list
	 */
	
	public void exampleAverage(List<Employee> empList) {
		
		System.out.println("***** method 2 to use mapToDouble / mapToInt *****");
		OptionalDouble avarage = empList.stream()
				.mapToDouble(Employee::getSalary)
				.average();
			
			System.out.println("Average Salary of all employees:" + avarage.getAsDouble());
		
		System.out.println("--------------------------------------");
	}
}
