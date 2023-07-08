package com.company;
import java.util.*;

class Student{
    static Scanner input = new Scanner(System.in);
    private String student_name;
    private int student_roll_number;
    private float student_cgpa;
    private String student_branch;
    private int current_CTC=0;
    private boolean isplaced = false;
//    private boolean isregistered = false;
//    private String particular_student_registration_time_date;
    private String status = "not applied";
    private Company shortlisted_and_also_applied_companies[] =new Company[100];
//    private int[] rejected_company_array = new int[100];
    private int shortlisted_and_also_applied_companies_ptr= 0;
    private String final_company_name;
    private int number_of_eligible_companies;
    private int[] student_registration_date_time =new int[5];
    private int[] rejected_company_list = new int[100];
    private boolean blocked_status = false ;
    private void register_for_placement_drive(){
        System.out.println("Enter registration date and time: ");

        System.out.print("Hour(24h): ");
        student_registration_date_time[3] = input.nextInt();
        input.nextLine();
        System.out.print("Minute: ");
        student_registration_date_time[4] = input.nextInt();
        input.nextLine();
        System.out.print("Day: ");
        student_registration_date_time[2] = input.nextInt();
        input.nextLine();
        System.out.print("Month (1:Jan , 2:Feb,....)");
        student_registration_date_time[1] = input.nextInt();
        input.nextLine();
        System.out.print("Year: ");
        student_registration_date_time[0] = input.nextInt();
        input.nextLine();
        if(student_registration_date_time[0]<Cell.get_student_registration_deadline_using_index(0)){

        }
        else if(student_registration_date_time[0]>Cell.get_student_registration_deadline_using_index(0)){
            System.out.println("Deadline expired!");
            Cell.minus_minus_student_array_ptr();
            return ;
        }
        else if(student_registration_date_time[0]==Cell.get_student_registration_deadline_using_index(0)){
            if(student_registration_date_time[1]<Cell.get_student_registration_deadline_using_index(1)){

            }
            else if(student_registration_date_time[1]>Cell.get_student_registration_deadline_using_index(1)){
                System.out.println("Deadline expired!");
                Cell.minus_minus_student_array_ptr();
                return ;
            }
            else if(student_registration_date_time[1]==Cell.get_student_registration_deadline_using_index(1)){
                if(student_registration_date_time[2]<Cell.get_student_registration_deadline_using_index(2)){

                }
                else if(student_registration_date_time[2]>Cell.get_student_registration_deadline_using_index(2)){
                    System.out.println("Deadline expired!");
                    Cell.minus_minus_student_array_ptr();
                    return ;
                }
                else if(student_registration_date_time[2]==Cell.get_student_registration_deadline_using_index(2)){
                    if(student_registration_date_time[3]<Cell.get_student_registration_deadline_using_index(3)){

                    }
                    else if(student_registration_date_time[3]>Cell.get_student_registration_deadline_using_index(3)){
                        System.out.println("Deadline expired!");
                        Cell.minus_minus_student_array_ptr();
                        return ;
                    }
                    else if(student_registration_date_time[3]==Cell.get_student_registration_deadline_using_index(3)) {
                        if(student_registration_date_time[4]<Cell.get_student_registration_deadline_using_index(4)){

                        }
                        else if(student_registration_date_time[4]>Cell.get_student_registration_deadline_using_index(4)){
                            System.out.println("Deadline expired!");
                            Cell.minus_minus_student_array_ptr();
                            return ;
                        }
                        else if(student_registration_date_time[4]==Cell.get_student_registration_deadline_using_index(4)){}
                    }
                }
            }
        }
        Cell.setNumber_of_student_registrations();
        System.out.println(this.student_name + " You have registered for placement drive at IIITD!");
        System.out.println("Your details are:");
        System.out.println("NAME: " + this.get_student_name());
        System.out.println("ROLL NO: " + this.get_student_rollno());
        System.out.println("CGPA: "+ this.student_cgpa);
        System.out.println("BRANCH: "+this.student_branch);
    }
    private void register_for_company(){
        //we are assuming that we can apply to any company available
        if(blocked_status==true){
            System.out.println("YOU ARE BLOCKED, YOU CANNOT REGISTER!");
            return ;
        }
        String name_of_company = input.nextLine();

            if(this.isplaced==false) {
                for (int i = 0; i < Cell.get_company_array_ptr(); i++) {
                    if ((Cell.get_company_object(i).get_company_name_company().equals(name_of_company)) && Cell.get_company_object(i).get_minimum_cgpa_required() <= this.student_cgpa) {
                        Cell.get_company_object(i).apply_to_this_company(this);
                        System.out.println("Successfully registered for " + Cell.get_company_object(i).get_role_offered() + " at " + Cell.get_company_object(i).get_company_name_company());
                        this.status = "applied";
                        shortlisted_and_also_applied_companies[shortlisted_and_also_applied_companies_ptr++] = Cell.get_company_object(i);
                        return;
                    }
                    else if((Cell.get_company_object(i).get_company_name_company().equals(name_of_company)) && Cell.get_company_object(i).get_minimum_cgpa_required() > this.student_cgpa) {
                        System.out.println("CGPA criteria not fulfilled ");
                        return;
                    }
                }
            }
            else if(this.isplaced==true){
                    for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++) {
                        if (((Cell.get_company_object(i).get_company_name_company().equals(name_of_company)) && Cell.get_company_object(i).get_CTC_offered() >= 3 * this.current_CTC)) {
                            Cell.get_company_object(i).apply_to_this_company(this);
                            System.out.println("Successfully registered for " + Cell.get_company_object(i).get_role_offered() + " at " + Cell.get_company_object(i).get_company_name_company());
                            this.status = "applied";
                            shortlisted_and_also_applied_companies[shortlisted_and_also_applied_companies_ptr++] = Cell.get_company_object(i);
                            break;
                        }
                    }
            }

        }
    private int get_all_available_companies() {
        int num = 0 ;
        if(this.isplaced == false){
            for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++){
                if(Cell.get_company_object(i).get_minimum_cgpa_required() <= this.student_cgpa && rejected_company_list[i]==0){
                    System.out.println("NAME: "+Cell.get_company_object(i).get_company_name_company()+"\nCTC: "+Cell.get_company_object(i).get_CTC_offered());
                    System.out.println("ROLE: "+ Cell.get_company_object(i).get_role_offered());
                    System.out.println("CGPA: "+Cell.get_company_object(i).get_minimum_cgpa_required());
                    num++;
                    this.number_of_eligible_companies++;
                }
            }
        }
        else if(this.isplaced==true){
            for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++){
                if(Cell.get_company_object(i).get_minimum_cgpa_required() <= this.student_cgpa && Cell.get_company_object(i).get_CTC_offered()>=3*current_CTC && rejected_company_list[i]==0){
                    System.out.println("NAME: "+Cell.get_company_object(i).get_company_name_company()+"\nCTC: "+Cell.get_company_object(i).get_CTC_offered());
                    num++;
                    this.number_of_eligible_companies++;
                }
            }
        }
        if(num==0){
            System.out.println("No new companies available");
        }
        return num;
    }
    private int get_number_of_all_available_companies(){
        int num = 0 ;
        if(this.isplaced == false){
            for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++){
                if(Cell.get_company_object(i).get_minimum_cgpa_required() <= this.student_cgpa && rejected_company_list[i]==0){
                    num++;

                }
            }
        }
        else if(this.isplaced==true){
            for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++){
                if(Cell.get_company_object(i).get_minimum_cgpa_required() <= this.student_cgpa && Cell.get_company_object(i).get_CTC_offered()>=3*current_CTC && rejected_company_list[i]==0){
                    num++;
                }
            }
        }
        if(num==0){
        }
        return num;
    }
    private void update_cgpa(){
        System.out.print("ENTER OLD CGPA: ");
        float old_cgpa = input.nextFloat();
        input.nextLine();
        System.out.print("ENTER NEW CGPA: ");
        float new_cgpa = input.nextFloat();
        Cell.update_cgpa_from_cell(old_cgpa , new_cgpa , this.student_roll_number);
    }
    private void reject_offer(){
        int number_of_offers = this.get_number_of_all_available_companies();
        System.out.println("Companies that have offered you: ");
        for(int i = 0 ; i<this.shortlisted_and_also_applied_companies_ptr ; i++){
            System.out.println(shortlisted_and_also_applied_companies[i].get_company_name_company());
        }
        System.out.println("How many companies you wish to reject?");
        int num = input.nextInt();
        input.nextLine();
        if(number_of_offers == num){
            this.status = "blocked";
            this.blocked_status = true;
            Cell.plus_plus_number_of_blocked_students();
        }
        for(int j =0 ; j<num ; j++) {
            System.out.println("Enter name of company you want to reject: ");
            String company_name = input.nextLine();
            for (int i = 0; i < Cell.get_company_array_ptr(); i++) {
                if (Cell.get_company_object(i).get_company_name_company().equals(company_name)) {
                    rejected_company_list[i] = 1;
                }

            }
            for(int i = 0 ; i<shortlisted_and_also_applied_companies_ptr ; i++){
                if(shortlisted_and_also_applied_companies[i].get_company_name_company().equals(company_name)){
                    Company latest = new Company() ;
                    latest.set_company_ctc(-1);
                    latest.set_company_role(" ");
                    latest.set_company_mincg(100000);
                    latest.set_company_name(" ");
                    shortlisted_and_also_applied_companies[i] = latest;
                    if(shortlisted_and_also_applied_companies_ptr==1){
                        shortlisted_and_also_applied_companies_ptr--;
                    }
                }
            }
        }


    }
    protected void get_current_status(){
        System.out.print("CURRENT STATUS IS:");
        if(this.blocked_status==true){
            System.out.println("BLOCKED");
            return ;
        }
        if(this.number_of_eligible_companies == 0){
            System.out.println("Unoffered");
            return ;
        }
        System.out.println(this.status);
        if(shortlisted_and_also_applied_companies_ptr ==0){
            System.out.println(this.status);
        }
        else{
            Company final_company = null;
            int final_ctc_amount=0;
            for(int i = 0 ; i<shortlisted_and_also_applied_companies_ptr ; i++){
                if(shortlisted_and_also_applied_companies[i].get_CTC_offered()>final_ctc_amount){
                    final_ctc_amount = shortlisted_and_also_applied_companies[i].get_CTC_offered();
                    final_company = shortlisted_and_also_applied_companies[i];
                    this.final_company_name = final_company.get_company_name_company();
                    this.current_CTC = final_ctc_amount;
                }
            }
            System.out.println(this.student_name+ " has been shortlisted by "+final_company.get_company_name_company());
            System.out.println("CTC OFFERED: "+final_company.get_CTC_offered());
            System.out.println("ROLE OFFERED: "+final_company.get_role_offered());
        }
    }

    //Extra
    protected void add_student(String name , int rollno, float cgpa , String branch){
        this.student_name = name ;
        this.student_roll_number= rollno;
        this.student_cgpa = cgpa ;
        this.student_branch = branch ;
    }
    protected String get_student_name(){
        return this.student_name;
    }
    protected int get_student_rollno(){
        return this.student_roll_number;
    }
    private void student_login_menu() {
        while(true) {
            System.out.println("Welcome " + this.get_student_name());
            System.out.println("1.Register For Placement Drive\n2.Register For Company\n" +
                    "3.Get All available companies\n4.Get Current Status\n" +
                    "5.Update CGPA\n6.Accept offer\n7.Reject offer Back\n8.Back");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1)
                this.register_for_placement_drive();
            if (choice == 3)
                this.get_all_available_companies();
            if (choice == 2)
                this.register_for_company();
            if (choice == 6) {
                this.isplaced = true;
                System.out.println("Placed in: " + this.final_company_name);
                System.out.println("Congratulations "+this.student_name + " you have successfully accepted the offer of " + this.final_company_name );
                this.status = "placed";
                Cell.increase_total_package(this.current_CTC);
                Cell.increment_total_number_of_offers();
            }
            if (choice == 4) {
                this.get_current_status();
            }
            if(choice == 8){
                return ;
            }
            if(choice ==5){
                this.update_cgpa();
            }
            if(choice ==7){
                this.reject_offer();
            }
        }
    }
    protected boolean get_if_student_is_placed(){
        return this.isplaced;
    }
    protected float getStudent_cgpa(){
        return this.student_cgpa;
    }
    protected void update_cg_student(float new_cgpa) {
        this.student_cgpa = new_cgpa;
    }
    protected void get_shortlisted_and_applied_companies(){
        System.out.println("APPLIED COMPANIES");
        for(int i = 0 ; i<shortlisted_and_also_applied_companies_ptr  ;i++){
            System.out.println(shortlisted_and_also_applied_companies[i].get_company_name_company());
        }
    }
    protected void get_shortlisted_companies(){
        System.out.println("SHORTLISTED COMPANIES");
        for(int i = 0 ; i<Cell.get_company_array_ptr() ; i++){
            if(Cell.get_company_object(i).get_minimum_cgpa_required()<=this.student_cgpa){
                System.out.println(Cell.get_company_object(i).get_company_name_company());
            }
        }
    }
    private int get_package_offered(){
        return this.current_CTC;
    }
    protected static void student_menu(){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Choose the Student Query to perform-\n" +
                    "1) Enter as a Student(Give Student Name, and Roll No.)\n" +
                    "2) Add students\n" +
                    "3) Back");
            int choice5 = input.nextInt();
            input.nextLine();
            if (choice5 == 3){break;}
            else if(choice5==2){
                System.out.println("Enter number of students to add: ");
                int choice6 = input.nextInt();
                input.nextLine();
                for(int i = 0 ; i<choice6 ; i++){
                    Cell.add_student_to_student_array();
                }
            }
            else if(choice5==1){
                System.out.println("LOGIN\nEnter name:");
                String login_name = input.nextLine();
                System.out.println("Enter Roll No:");
                int login_rollno = input.nextInt();
                input.nextLine();
                System.out.println("openining database for "+login_name+".....");
                for(int i = 0 ; i<Cell.get_student_array_ptr() ; i++) {
                    if ((Cell.get_student_array_element(i).get_student_rollno() ==login_rollno)) {
                        Cell.get_student_array_element(i).student_login_menu();
                    }
                }

            }

        }
    }
    protected String get_final_company(){
        return this.final_company_name;
    }

}
