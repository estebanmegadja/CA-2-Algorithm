
package labpro.ca.algorithm;

import java.util.Scanner;

/**
 *
 * @author emega
 */

public class CA2Algorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Last Name: ");
            String lastName = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Department: ");
            String department = sc.nextLine();

            System.out.print("Position: ");
            String position = sc.nextLine();

            System.out.print("Job Title: ");
            String jobTitle = sc.nextLine();

            System.out.print("Company: ");
            String company = sc.nextLine();

            employees[i] = new Employee(firstName, lastName, gender, email,
                    salary, department, position, jobTitle, company);
        }

        // Sort employees by salary
        QuickSorter.quickSort(employees, 0, employees.length - 1);

        System.out.println("\n=== Sorted Employees by Salary (Ascending) ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        sc.close();
    }
}

// Employee Class

class Employee {
    String firstName;
    String lastName;
    String gender;
    String email;
    double salary;
    String department;
    String position;
    String jobTitle;
    String company;

    public Employee(String firstName, String lastName, String gender, String email,
                    double salary, String department, String position,
                    String jobTitle, String company) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + email + " | $" + salary;
    }
}

// Quick Sorter 
class QuickSorter {

    public static void quickSort(Employee[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Employee[] arr, int low, int high) {
        double pivot = arr[high].salary;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].salary <= pivot) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
