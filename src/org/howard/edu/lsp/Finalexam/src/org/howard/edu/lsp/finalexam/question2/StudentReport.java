package org.howard.edu.lsp.finalexam.question2;

public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    @Override
    void loadData() {
        this.studentName = "John Doe";
        this.gpa = 3.8;
    }

    @Override
    void formatHeader() {
        System.out.println("=== HEADER ===\nStudent Report");
    }

    @Override
    void formatBody() {
        System.out.println("\n=== BODY ===\nStudent Name: " + studentName + "\nGPA: " + gpa);
    }

    @Override
    void formatFooter() {
        System.out.println("\n=== FOOTER ===\nEnd of Student Report\n");
    }
}
