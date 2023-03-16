package com.example.demo1.BTECH;

public class ALLCodes {

    /* POST :- Add a student with given name , roll no , branchName ,marks .
*/
    public string <CollegeStudent> addStudent(
            /*@RequestParam */String name,
            /*@RequestParam */ String rollNo,
            /*@RequestParam */BranchName branchName,
            /*@RequestParam */int marks) {

        Branch branch = branchRepository.findByBranchName(branchName)


        CollegeStudent student = new CollegeStudent(name, rollNo, branchName, marks, LocalDate.now().getYear());
        student.setBranch(branch);

        studentRepository.save(student);

        return "added";
    }



    /* GET API - Find list of contact number of HOD(s) who has maximum no. of passing students in                 their branch.
*/

    @RestController
    @RequestMapping("/hod")
    public HodController {

        @Autowired
        private BranchRepository branchRepository;

        @GetMapping("/contact")
        public ResponseEntity<List<String>> getHodContacts() {

            List<Branch> branches = branchRepository.findAll();
            List<Integer> passedCounts = new ArrayList<>();
            List<String> hodContacts = new ArrayList<>();

            int maxCount = 0;

            for (Branch branch : branches) {
                int count = 0;
                for (CollegeStudent student : branch.getStudents()) {
                    if (student.getMarks() >= 40) {
                        count++;
                    }
                }
                passedCounts.add(count);

                if (count > maxCount) {
                    hodContacts.clear();
                    hodContacts.add(branch.getContactNo());
                    maxCount = count;
                } else if (count == maxCount) {
                    hodContacts.add(branch.getContactNo());
                }
            }
            /*The implementation iterates over the branches and updates the maxCount and hodContacts variables as necessary.
             If a new maximum count is found, it clears the hodContacts list and adds the HOD contact number for the current branch to it.
              If the count is equal to the current maximum count, it simply adds the HOD contact number to the hodContacts list.
             */

            return list;
        }

/*GET API - find the list of roll no of students which belongs to the most recent batch of college in terms of year only .
*/

        @RestController
        @RequestMapping("/students")
        public class CollegeStudentController {

            @Autowired
            private CollegeStudentRepository studentRepository;

            @GetMapping("/recent")
            public ResponseEntity<List<String>> getRecentStudents() {

                List<CollegeStudent> students = studentRepository.findAll();
                List<String> recentRollNos = new ArrayList<>();
                int maxYear = 0;

                for (CollegeStudent student : students) {
                    if (student.getAdmissionYear() > maxYear) {
                        recentRollNos.clear();
                        recentRollNos.add(student.getRollNo());
                        maxYear = student.getAdmissionYear();
                    } else if (student.getAdmissionYear() == maxYear) {
                        recentRollNos.add(student.getRollNo());
                    }
                }

                return ResponseEntity.ok(recentRollNos);
            }
        }



        /*GET API = find the grant given to the department containing the maximum absolute number of students who have passed
*/
        @RestController
        @RequestMapping("/departments")
        public class DepartmentController {

            @Autowired
            private CollegeStudentRepository studentRepository;

            @Autowired
            private DepartmentRepository departmentRepository;

            @GetMapping("/grant")
            public ResponseEntity<Integer> getMaxGrantDepartment() {

                List<CollegeStudent> students = studentRepository.findAll();
                List<Department> departments = departmentRepository.findAll();

                int maxPassedCount = 0;
                String maxPassedDepartment = "";

                for (Department department : departments) {
                    int passedCount = 0;

                    for (CollegeStudent student : students) {
                        if (student.getBranchName().equals(department.getBranchName()) && student.getMarks() >= 40) {
                            passedCount++;
                        }
                    }

                    if (Math.abs(passedCount) > maxPassedCount) {
                        maxPassedDepartment = department.getBranchName();
                        maxPassedCount = Math.abs(passedCount);
                    }
                }

                for (Department department : departments) {
                    if (department.getBranchName().equals(maxPassedDepartment)) {
                        return ResponseEntity.ok(department.getGrant());
                    }
                }

                return ResponseEntity.notFound().build();
            }
        }


    }





}
