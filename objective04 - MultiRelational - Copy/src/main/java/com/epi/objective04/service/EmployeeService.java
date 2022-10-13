package com.epi.objective04.service;
        import com.epi.objective04.entity.*;
        import com.epi.objective04.repo.EmployeeRepo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;
    @Transactional
    public String saveEmployee(tempData tempdata,boolean update){
        try {
            if ((employeeRepository.doesEmployeeExist(tempdata.getId_number())==0)|| (update==true)){

                int primary_key;

                if (update==false){


                if (employeeRepository.findMaxId()==null){
                    primary_key=1;
                }else {
                    primary_key=employeeRepository.findMaxId()+1;
                }
                }else{
                    primary_key=employeeRepository.findupdateId(tempdata.getId_number());
                }

                Employee employee = new Employee();
                employee.setId(primary_key);
                employee.setName(tempdata.getName());
                employee.setSurname(tempdata.getSurname());
                employee.setDob(tempdata.getDob());
                employee.setEmail(tempdata.getEmail());
                employee.setNationality(tempdata.getNationality());
                employee.setId_number(tempdata.getId_number());


                Job_Info job_info = new Job_Info();
                job_info.setId(primary_key);
                job_info.setPosition(tempdata.getPosition());
                job_info.setCurrency(tempdata.getCurrency());
                job_info.setSalary(tempdata.getSalary());
                employee.setJob_info(job_info);
                job_info.setEmployee(employee);


                Home_Address home_address = new Home_Address();
                home_address.setId(primary_key);
                home_address.setCountry(tempdata.getCountry());
                home_address.setProvince(tempdata.getProvince());
                home_address.setCity(tempdata.getCity());
                home_address.setAddress(tempdata.getAddress());
                home_address.setDwellingType(tempdata.getDwellingType());
                home_address.setPoBox(tempdata.getPoBox());
                home_address.setEmployee(employee);
                employee.setHomeAddress_id(home_address);

                Work_Address work_address = new Work_Address();
                work_address.setId(primary_key);
                work_address.setCountry(tempdata.getWork_country());
                work_address.setProvince(tempdata.getWork_province());
                work_address.setCity(tempdata.getWork_city());
                work_address.setAddress(tempdata.getWork_address());
                work_address.setPoBox(tempdata.getPoBox());

                work_address.setLocationType(tempdata.getLocationType());

                work_address.setEmployee(employee);
                employee.setWork_Address(work_address);

                System.out.println(employeeRepository.doesEmployeeExist(employee.getId_number()));


                employeeRepository.save(employee);
                return "Employee record saved successfully.";
                 }else {
                   return "Employee already exists in the database.";
                  }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Employee> readEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> readEmployeeById(long id){return employeeRepository.findById(id);}

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