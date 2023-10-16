
package application;

import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class DemoDaojdbc2 {
    
    
    public static void main(String[] args) {
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Chothes");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());
        
        System.out.println("\n=== TEST 2: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);
          
        System.out.println("\n=== TEST 3: department update ===");
        department = departmentDao.findById(6);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Update completed");
          
        System.out.println("\n=== TEST 4: department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");
           
        System.out.println("\n=== TEST 5: department findAll ===");
        List<Department> list = departmentDao.findAll();
            for(Department d : list){
                System.out.println(d);
            }
            
            sc.close();
    }
}
