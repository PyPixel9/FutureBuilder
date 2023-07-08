package com.company;
import java.util.*;

class Cell {
    static Scanner input = new Scanner(System.in);
    private static Company[] company_array = new Company[100];
    private static int company_array_ptr = 0;
    private static Student[] student_array = new Student[100];
    private static int student_array_ptr = 0 ;
    private static int number_of_student_registrations = 0 ;
    private static int[] op_d_t= new int[5];
    private static int[] cl_d_t= new int[5];
    private static int[] student_d_t= new int[5];
    private static int number_of_blocked_students;
    private static int number_of_unplaced_students = 0 ;
    private static int total_package;
    private static int total_placement;

    //Methods
    private static void open_student_registrations() {
        System.out.println("Enter opening date & time for student registration: ");
        System.out.print("Hour(24h): ");
        int x = input.nextInt();
        System.out.print("Minute: ");
        x = input.nextInt();
        System.out.print("Day: ");
        x = input.nextInt();
        System.out.print("Month:(1:Jan , 2:Feb,....)");
        x = input.nextInt();
        System.out.print("Year: ");
        x = input.nextInt();
        input.nextLine();
        System.out.println("Enter closing date & time for student");
        System.out.print("Hour(24h): ");
        student_d_t[3] = input.nextInt();
        System.out.print("Minute: ");
        student_d_t[4] = input.nextInt();
        System.out.print("Day: ");
        student_d_t[2] = input.nextInt();
        System.out.print("Month:(1:Jan , 2:Feb,....)");
        student_d_t[1] = input.nextInt();
        System.out.print("Year: ");
        student_d_t[0] = input.nextInt();
        input.nextLine();
    }
    private static void open_company_registrations() {
        System.out.println("Enter opening date and time: ");
        System.out.print("Hour(24h): ");
        op_d_t[3] = input.nextInt();
        System.out.print("Minute: ");
        op_d_t[4] = input.nextInt();
        System.out.print("Day: ");
        op_d_t[2] = input.nextInt();
        System.out.print("Month:(1:Jan , 2:Feb,....)");
        op_d_t[1] = input.nextInt();
        System.out.print("Year: ");
        op_d_t[0] = input.nextInt();

        System.out.println("Enter closing date and time");
        System.out.print("Hour(24h): ");
        cl_d_t[3] = input.nextInt();
        input.nextLine();
        System.out.print("Minute: ");
        cl_d_t[4] = input.nextInt();
        input.nextLine();
        System.out.print("Day: ");
        cl_d_t[2] = input.nextInt();
        input.nextLine();
        System.out.print("Month:(1:Jan , 2:Feb,....)");
        cl_d_t[1] = input.nextInt();
        input.nextLine();
        System.out.print("Year: ");
        cl_d_t[0] = input.nextInt();
        input.nextLine();
    }
    private static int get_number_of_student_registrations() {
        System.out.println(number_of_student_registrations);
        return number_of_student_registrations;
    }
    private static int return_number_of_student_registrations() {
        return number_of_student_registrations;
    }
    private static int get_number_of_company_registrations() {
        System.out.println(company_array_ptr);
        return company_array_ptr;
    }
//    private void get_number_of_placed_unplaced_blocked_students(){} HAVE MADE THE GET STATISTICS FUNCTION INSTEAD
    private static void get_student_details() {
        System.out.println("Enter name:");
        System.out.println("Enter rollno:");
        String n = input.nextLine();
        int r = input.nextInt();
        input.nextLine();
        for(int i = 0 ; i<student_array_ptr ; i++){
            if(student_array[i].get_student_rollno()==r){

                System.out.println("NAME " +student_array[i].get_student_name());
                System.out.println("CGPA "+ student_array[i].getStudent_cgpa());
                System.out.println("ROLL NO "+student_array[i].get_student_rollno());
                student_array[i].get_current_status();
                student_array[i].get_shortlisted_companies();
                student_array[i].get_shortlisted_and_applied_companies();
            }
        }
    }
    private static void get_company_details() {
        String name = input.nextLine();
        for(int i= 0 ; i<company_array_ptr ; i++){
            if((name.equals(company_array[i].get_company_name_company()))) {
                System.out.println("Name: " + company_array[i].get_company_name_company());
                System.out.println("CTC offered: " + company_array[i].get_CTC_offered());
                System.out.println("Role offered: " + company_array[i].get_role_offered());
                System.out.println("Minimum CGPA: " + company_array[i].get_minimum_cgpa_required());

                System.out.println("Hiring details:");
                company_array[i].print_selected_student_list();
            }
        }
    }
    private static void get_average_package() {
        System.out.println("Average package for IIITD is:");
        System.out.print(total_package/total_placement);
        System.out.println(" LPA");

    }
    private static void get_company_process_results() {
        System.out.println("Which company's selected candidates you wanna look?");
        String x = input.nextLine();
        for(int i = 0 ; i<student_array_ptr ; i++){
                if(student_array[i].get_final_company().equals(x)){
                    System.out.println(student_array[i].get_student_name());
                    System.out.println(student_array[i].getStudent_cgpa());
                    System.out.println(student_array[i].get_student_rollno());
                }
            }
        }


    //Extra functions
    // These functions are only accessed by private functions and
    //are for inter class variable exchange, there functions haven't been accessed from any
    //public context anywhere and hence are practically private only
    protected static void add_company_to_list(Company x) {
        company_array[company_array_ptr++] = x;
    }
    protected static int get_company_array_ptr() {
        return Cell.company_array_ptr;
    }
    protected static String get_company_name(int index) {
        return (Cell.company_array[index]).get_company_name_company();
    }
    protected static Company get_company_object(int index){
        return company_array[index];
    }
    protected static void add_student_to_student_array(){
        System.out.println("Enter \n1.Name\n2.Rollno\n3.CGPA\n4.Branch");
        Student latest = new Student();
        String name= input.nextLine();
        int rollno = input.nextInt();
        input.nextLine();
        float cgpa = input.nextFloat();
        input.nextLine();
        String branch= input.nextLine();
        Cell.student_array[student_array_ptr++] = latest;
        latest.add_student(name , rollno , cgpa , branch);
    }
    protected static int get_student_array_ptr(){
        return Cell.student_array_ptr;
    }
    protected static Student get_student_array_element(int index){
        return student_array[index];
    }
    protected static void update_cgpa_from_cell(float old_cgpa, float new_cgpa , int rollno){
        for(int i =  0 ; i<student_array_ptr ; i++){
            if(student_array[i].get_student_rollno() == rollno){
                student_array[i].update_cg_student(new_cgpa) ;
            }
        }
    }
    protected static void setNumber_of_student_registrations(){
        Cell.number_of_student_registrations++;
    }
    protected static void get_registered_companies_list(){
        for(int i= 0 ; i<company_array_ptr ; i++){
            System.out.println(company_array[i].get_company_name_company() +" "+ company_array[i].get_role_offered() +" "+ company_array[i].get_CTC_offered());

        }
    }
    protected static int get_company_registration_deadline_using_index(int index) {
        return cl_d_t[index];
    }
    protected static void minus_minus_company_array_ptr(){
        company_array_ptr-- ;
    }
    protected static void minus_minus_student_array_ptr(){
        student_array_ptr--;
    }
    protected static void get_stats(){
        int r = Cell.return_number_of_student_registrations();
        System.out.println("Number of placed students: ");
        for(int i = 0 ; i<Cell.student_array_ptr ; i++){
            if(student_array[i].get_if_student_is_placed()==false){
                number_of_unplaced_students++ ;
            }
        }

        System.out.println("Total offers: ");
        System.out.println(r);

        System.out.println("Number of unplaced students: ");
        System.out.println(number_of_unplaced_students);

        System.out.println("Number of blocked students: ");
        System.out.println(number_of_blocked_students);
    }
    protected static void plus_plus_number_of_blocked_students(){
        number_of_blocked_students++ ;
    }
    protected static void increment_total_number_of_offers(){
        total_placement++;
    }
    protected static void increase_total_package(int x){
        total_package+= x;
    }
    protected static int get_student_registration_deadline_using_index(int i) {
        return student_d_t[i];
    }
    protected static void cell_class_menu(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to IIITD Placement Cell\n1.Open Student Registrations\n2.Open Company Registrations\n3.Get Number of Student Registrations\n4.Get Number of Company Registrations\n5.Get Number of Offered/Unoffered/Blocked Students\n6.Get Student Details\n7.Get Company Details\n8.Get Average Package\n9.Get Company Process Results\n10.Back");
            int choice = input.nextInt();
            input.nextLine();
            if(choice ==1){
                Cell.open_student_registrations();
            }
            if (choice == 2)
                Cell.open_company_registrations();
            else if(choice ==10)
                break;
            else if(choice ==9){
                Cell.get_company_process_results();
            }
            else if(choice == 3){
                Cell.get_number_of_student_registrations();
            }
            else if(choice==4){
                Cell.get_number_of_company_registrations();
            }
            else if(choice ==6){
                Cell.get_student_details();
            }
            else if(choice ==7){
                Cell.get_company_details();
            }
            else if(choice ==8){
                Cell.get_average_package();
            }
            else if(choice ==5){
                Cell.get_stats();
            }
        }
    }
    protected static int get_opening_date_time_for_company_registration_using_index(int index){
        return op_d_t[index];
    }
}





