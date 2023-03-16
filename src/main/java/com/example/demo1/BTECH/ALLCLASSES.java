package com.example.demo1.BTECH;

public class ALLCLASSES {
    @Entity
    @Table(name = "branches")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public  Branch {

        @Id
        @Enumerated(EnumType.STRING)
        private BranchName branchName;

        private String hodName;

        private String contactNo;

        @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<CollegeStudent> students = new ArrayList<>();

        public void addStudent(CollegeStudent student) {
            students.add(student);
            student.setBranch(this);
        }

        public void removeStudent(CollegeStudent student) {
            students.remove(student);
            student.setBranch(null);
        }
    }




    @Entity
    @Table(name = "college_students")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public  CollegeStudent {

        @Id
        private String rollNo;

        private String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "branch_name")
        private Branch branch;

        private int marks;

        private int admissionYear;
    }



    @Entity
    @Table(name = "grants")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public Grant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "branch_name")
        private Branch branch;

        private int amount;

        public Grant(Branch branch, int amount) {
            this.branch = branch;
            this.amount = amount;
        }
    }



}
