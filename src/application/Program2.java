package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== test 1: findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== test 2: findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== test 3: insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("inserted! new id: " + newDepartment.getId());

		System.out.println("\n=== test 4: update ===");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("food");
		departmentDao.update(dep2);
		System.out.println("update completed");

		System.out.println("\n=== test 5: delete ===");
		System.out.print("enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("delete completed");

		sc.close();
	}
}
