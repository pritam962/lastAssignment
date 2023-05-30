
	import java.util.Arrays;
	import java.util.List;
	import java.util.stream.Collectors;

	class Employee {
	    private String name;
	    private int age;
	    private double salary;

	    public Employee(String name, int age, double salary) {
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "name='" + name + '\'' +
	                ", age=" + age +
	                ", salary=" + salary +
	                '}';
	    }
	}

	public class La_6{
	    public static void main(String[] args) {
	        // Create a list of employees
	        List<Employee> employees = Arrays.asList(
	                new Employee("John Doe", 30, 5000.0),
	                new Employee("Jane Smith", 25, 4000.0),
	                new Employee("Mark Johnson", 35, 6000.0),
	                new Employee("Emily Brown", 28, 4500.0),
	                new Employee("David Williams", 32, 5500.0)
	        );

	        // Filter employees older than 30
	        List<Employee> filteredEmployees = employees.stream()
	                .filter(employee -> employee.getAge() > 30)
	                .collect(Collectors.toList());

	        System.out.println("Filtered Employees:");
	        filteredEmployees.forEach(System.out::println);

	        // Sort employees by salary in descending order
	        List<Employee> sortedEmployees = employees.stream()
	                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
	                .collect(Collectors.toList());

	        System.out.println("Sorted Employees by Salary:");
	        sortedEmployees.forEach(System.out::println);
	    }
	}
