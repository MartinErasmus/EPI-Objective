package com.epi.objective04.service;
        import com.epi.objective04.entity.*;
        import com.epi.objective04.repo.EmployeeRepo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Transactional
    public String createEmployee(tempData tempdata){
        try {
           // if (!employeeRepository.existsByEmail(tempdata.getEmail())){

               
                Employee employee = new Employee();
                employee.setName(tempdata.getName());
                employee.setSurname(tempdata.getSurname());
                employee.setDob(tempdata.getDob());
                employee.setEmail(tempdata.getEmail());
                employee.setNationality(tempdata.getNationality());
                employee.setId_number(tempdata.getId_number());
        
                Job_Info job_info = new Job_Info();
                job_info.setPosition(tempdata.getPosition());
                job_info.setCurrency(tempdata.getCurrency());
                job_info.setSalary(tempdata.getSalary());
                employee.setJob_info(job_info);
                job_info.setEmployee(employee);
        
        
                Home_Address home_address = new Home_Address();
                home_address.setHomeNumber(tempdata.getHomeNumber());
                home_address.setDwellingType(tempdata.getDwellingType());
                home_address.setStreetName(tempdata.getStreetName());
                home_address.setPoBox(tempdata.getPoBox());
                home_address.setEmployee(employee);
                employee.setHomeAddress_id(home_address);

                Work_Address work_address = new Work_Address();
                work_address.setBuildingNumber(tempdata.getBuildingNumber());
                work_address.setPoBox(tempdata.getPoBox());
                work_address.setStreetName(tempdata.getWork_streetName());
                work_address.setLocationType(tempdata.getLocationType());

                work_address.setEmployee(employee);
                employee.setWork_Address(work_address);

                employeeRepository.save(employee);
                return "Employee record created successfully.";
           // }else {
             //   return "Employee already exists in the database.";
          //  }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Employee> readEmployees(){
        return employeeRepository.findAll();
    }

    @Transactional
    public String updateEmployee(Employee employee){
            try {
                    employeeRepository.save(employee);
                return "Employee record updated.";
            }catch (Exception e){
                throw e;
            }
    }

    @Transactional
    public String deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return "Employee record deleted successfully.";
        //if (employeeRepository.existsByEmail(employee.getEmail())){
//            try {
//                List<Employee> employees = employeeRepository.findByEmail(employee.getEmail());
//                employees.stream().forEach(s -> {
//                    employeeRepository.delete(s);
//                });
//                return "Employee record deleted successfully.";
//            }catch (Exception e){
//                throw e;
//            }
//
//        }else {
//            return "Employee does not exist";

    }
}