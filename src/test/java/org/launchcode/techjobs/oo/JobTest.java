package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(), 0.01);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
        assertTrue(Objects.equals(job.getName(), "Product tester"));
        assertTrue(Objects.equals(job.getEmployer().getValue(), "ACME"));
        assertTrue(Objects.equals(job.getLocation().getValue(), "Desert"));
        assertTrue(Objects.equals(job.getPositionType().getValue(), "Quality control"));
        assertTrue(Objects.equals(job.getCoreCompetency().getValue(), "Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        String newToString = newLine + "ID: " + job.getId() + newLine  +
                "Name: Product tester" + newLine  +
                "Employer: ACME" + newLine  +
                "Location: Desert" + newLine  +
                "Position Type: Quality control" + newLine  +
                "Core Competency: Persistence" + newLine ;
        assertEquals("\n", String.valueOf(job.toString().charAt(0)));
        assertEquals("\n", String.valueOf(job.toString().charAt(job.toString().length()-1)));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newLine = System.lineSeparator();
        String newToString = "\nID: " + job.getId() + "\n"  +
                "Name: Product tester" + "\n"  +
                "Employer: ACME" + "\n"  +
                "Location: Desert" + "\n"  +
                "Position Type: Quality control" + "\n"  +
                "Core Competency: Persistence" + "\n" ;
        assertEquals(newToString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        String newLine = System.lineSeparator();
        String newToString = "\nID: " + job.getId() + "\n"  +
                "Name: Web Developer" + "\n"  +
                "Employer: Data not available" + "\n"  +
                "Location: StL" + "\n"  +
                "Position Type: Data not available" + "\n"  +
                "Core Competency: Java" + "\n" ;
        assertEquals(newToString, job.toString());
    }
}
