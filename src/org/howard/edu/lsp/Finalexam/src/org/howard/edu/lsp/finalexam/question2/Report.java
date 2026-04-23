package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract class defining the Template Method for report generation.
 */
public abstract class Report {
    
    /**
     * The Template Method: Final to prevent subclasses from changing the workflow.
     */
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    abstract void loadData();
    abstract void formatHeader();
    abstract void formatBody();
    abstract void formatFooter();
}