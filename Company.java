package com.company;
import java.util.*;

class Company{
    Scanner input = new Scanner(System.in);
    private String company_name;
    private String role_offered;
    private int CTC_offered;
    private float minimum_CGPA_required;
    private String company_registration_detail;
    private Student[] applied_students_list = new Student[100];
    private int applied_students_list_ptr = 0 ;
    private int[] company_registration_date_time = new int[5];


    private void register_to_institute_drive(){
        System.out.println("Enter name\nRole offered\nCTC offered\nMinimum CGPA required");
        String company_name = input.nextLine();
        String role_offered = input.nextLine();
        int CTC_offered = input.nextInt();
        float minimum_CGPA_required = input.nextFloat();
        this.company_name = company_name;
        this.role_offered = role_offered;
        this.CTC_offered = CTC_offered;
        this.minimum_CGPA_required = minimum_CGPA_required;
    }
//    protected void get_selected_students(){}
    private void update_role_package_cgpa_criteria(){
        while(true) {
            System.out.println("Welcome " + this.company_name + "\n" +
                    "1.Update Role\n" +
                    "2.Update Package\n" +
                    "3.Update CGPA criteria\n" +
                    "4.Register To Institute Drive\n" +
                    "5.Back");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 5) {
                return;
            } else if (choice == 1) {
                System.out.println("Enter new role");
                String new_role = input.nextLine();
                this.role_offered = new_role;
            } else if (choice == 2) {
                int updated_package = input.nextInt();
                this.CTC_offered = updated_package;
            } else if (choice == 3) {
                float new_cgpa = input.nextFloat();
                this.minimum_CGPA_required = new_cgpa;
            } else if (choice == 4) {
                System.out.println("Enter registration date and time");
                System.out.print("Hour(24h): ");
                company_registration_date_time[3] = input.nextInt();
                input.nextLine();
                System.out.print("Minute: ");
                company_registration_date_time[4] = input.nextInt();
                input.nextLine();
                System.out.print("Day: ");
                company_registration_date_time[2] = input.nextInt();
                input.nextLine();
                System.out.print("Month:(1:Jan , 2:Feb,....)");
                company_registration_date_time[1] = input.nextInt();
                input.nextLine();
                System.out.print("Year: ");
                company_registration_date_time[0] = input.nextInt();
                input.nextLine();



                if (company_registration_date_time[0] > Cell.get_opening_date_time_for_company_registration_using_index(0)) {
                } else if (company_registration_date_time[0] < Cell.get_opening_date_time_for_company_registration_using_index(0)) {
                    System.out.println("Registration not started!");
                    Cell.minus_minus_company_array_ptr();
                    return;
                } else if (company_registration_date_time[0] == Cell.get_opening_date_time_for_company_registration_using_index(0)) {
                    if (company_registration_date_time[1] > Cell.get_opening_date_time_for_company_registration_using_index(1)) {

                    } else if (company_registration_date_time[1] < Cell.get_opening_date_time_for_company_registration_using_index(1)) {
                        System.out.println("Registration not started!");
                        Cell.minus_minus_company_array_ptr();
                        return;
                    } else if (company_registration_date_time[1] == Cell.get_opening_date_time_for_company_registration_using_index(1)) {
                        if (company_registration_date_time[2] > Cell.get_opening_date_time_for_company_registration_using_index(2)) {

                        } else if (company_registration_date_time[2] < Cell.get_opening_date_time_for_company_registration_using_index(2)) {
                            System.out.println("Registration not started!");
                            Cell.minus_minus_company_array_ptr();
                            return;
                        } else if (company_registration_date_time[2] == Cell.get_opening_date_time_for_company_registration_using_index(2)) {
                            if (company_registration_date_time[3] > Cell.get_opening_date_time_for_company_registration_using_index(3)) {

                            } else if (company_registration_date_time[3] < Cell.get_opening_date_time_for_company_registration_using_index(3)) {
                                System.out.println("Registration not started!");
                                Cell.minus_minus_company_array_ptr();
                                return;
                            } else if (company_registration_date_time[3] == Cell.get_opening_date_time_for_company_registration_using_index(3)) {
                                if (company_registration_date_time[4] > Cell.get_opening_date_time_for_company_registration_using_index(4)) {

                                } else if (company_registration_date_time[4] < Cell.get_opening_date_time_for_company_registration_using_index(4)) {
                                    System.out.println("Registration not started!");
                                    Cell.minus_minus_company_array_ptr();
                                    return;
                                } else if (company_registration_date_time[4] == Cell.get_company_registration_deadline_using_index(4)) {
                                }
                            }
                        }
                    }
                }



                if (company_registration_date_time[0] < Cell.get_company_registration_deadline_using_index(0)) {
                } else if (company_registration_date_time[0] > Cell.get_company_registration_deadline_using_index(0)) {
                    System.out.println("Deadline expired!");
                    Cell.minus_minus_company_array_ptr();
                    return;
                } else if (company_registration_date_time[0] == Cell.get_company_registration_deadline_using_index(0)) {
                    if (company_registration_date_time[1] < Cell.get_company_registration_deadline_using_index(1)) {

                    } else if (company_registration_date_time[1] > Cell.get_company_registration_deadline_using_index(1)) {
                        System.out.println("Deadline expired!");
                        Cell.minus_minus_company_array_ptr();
                        return;
                    } else if (company_registration_date_time[1] == Cell.get_company_registration_deadline_using_index(1)) {
                        if (company_registration_date_time[2] < Cell.get_company_registration_deadline_using_index(2)) {

                        } else if (company_registration_date_time[2] > Cell.get_company_registration_deadline_using_index(2)) {
                            System.out.println("Deadline expired!");
                            Cell.minus_minus_company_array_ptr();
                            return;
                        } else if (company_registration_date_time[2] == Cell.get_company_registration_deadline_using_index(2)) {
                            if (company_registration_date_time[3] < Cell.get_company_registration_deadline_using_index(3)) {

                            } else if (company_registration_date_time[3] > Cell.get_company_registration_deadline_using_index(3)) {
                                System.out.println("Deadline expired!");
                                Cell.minus_minus_company_array_ptr();
                                return;
                            } else if (company_registration_date_time[3] == Cell.get_company_registration_deadline_using_index(3)) {
                                if (company_registration_date_time[4] < Cell.get_company_registration_deadline_using_index(4)) {

                                } else if (company_registration_date_time[4] > Cell.get_company_registration_deadline_using_index(4)) {
                                    System.out.println("Deadline expired!");
                                    Cell.minus_minus_company_array_ptr();
                                    return;
                                } else if (company_registration_date_time[4] == Cell.get_company_registration_deadline_using_index(4)) {
                                }
                            }
                        }
                    }
                }
                System.out.println("Registered successfully!");
                this.company_registration_detail = company_registration_detail;
            }
        }
    }

    //Extra functions
    //These functions are only accessed by private functions and
    //are for inter class variable exchange, these functions haven't been accessed from any
    //public context anywhere and hence are practically private only
    protected String get_company_name_company(){
        return this.company_name;
    }
    protected float get_minimum_cgpa_required(){
        return this.minimum_CGPA_required;
    }
    protected String get_role_offered(){
        return this.role_offered;
    }
    protected int get_CTC_offered(){
        return this.CTC_offered;
    }
    protected void apply_to_this_company(Student x){
        applied_students_list[applied_students_list_ptr++] = x;
    }
    protected void print_selected_student_list(){
        for(int i = 0 ; i<this.applied_students_list_ptr ; i++){
            System.out.println("NAME: "+ applied_students_list[i].get_student_name());
            System.out.println("ROLL NO: "+ applied_students_list[i].get_student_rollno());
            System.out.println("BRANCH: "+applied_students_list[i].get_student_rollno());
            System.out.println("CGPA: "+applied_students_list[i].getStudent_cgpa());
        }
    }

//    protected int get_applied_student_list_ptr(){
//        return this.applied_students_list_ptr;
//    }
    
    protected void set_company_name(String name){
        this.company_name = name; 
    }
    protected void set_company_ctc(int ctc){
        this.CTC_offered = ctc ;
    }
    protected void set_company_mincg(float cg){
        this.minimum_CGPA_required = cg ;
    }
    protected void set_company_role(String  role){
        this.role_offered = role ;
    }
    static protected void company_class_menu(){
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Choose the Company Query to perform-\n1.Add Company and Details\n2.Choose Company\n3.Get Available Companies\n4.Back");
            int choice = input.nextInt();
            input.nextLine();
            if(choice ==4){
                break;
            }
            else if(choice==1){
                Company latest = new Company();
                latest.register_to_institute_drive();
                Cell.add_company_to_list(latest);
            }
            else if(choice==2){
                for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++) {
                    System.out.println(i + "." + Cell.get_company_name(i));
                }
                int choice3 = input.nextInt();
                Cell.get_company_object(choice3).update_role_package_cgpa_criteria();
            }
            else if(choice ==3){
                Cell.get_registered_companies_list();
            }


        }
    }



}

