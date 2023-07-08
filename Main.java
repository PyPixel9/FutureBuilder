package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to future builder\n1.Enter Application\n2.Exit Application");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 2) {break;}
            while (true) {
                System.out.println("Choose the mode:\n1.Student mode\n2.Company mode\n3.Placement cell mode\n4.Return");
                int choice2 = input.nextInt();
                input.nextLine();
                if (choice2 == 4) {break;}
                if (choice2 == 3)
                    Cell.cell_class_menu();
                if (choice2 == 2)
                    Company.company_class_menu();
                if (choice2 == 1)
                    Student.student_menu();
            }
        }
    }
}







