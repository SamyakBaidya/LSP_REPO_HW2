package org.howard.edu.lsp.finalexam.question2;

public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    @Override
    void loadData() {
        this.courseName = "CSCI 363";
        this.enrollment = 45;
    }

    @Override
    void formatHeader() {
        System.out.println("=== HEADER ===\nCourse Report");
    }

    @Override
    void formatBody() {
        System.out.println("\n=== BODY ===\nCourse: " + courseName + "\nEnrollment: " + enrollment);
    }

    @Override
    void formatFooter() {
        System.out.println("\n=== FOOTER ===\nEnd of Course Report\n");
    }
}