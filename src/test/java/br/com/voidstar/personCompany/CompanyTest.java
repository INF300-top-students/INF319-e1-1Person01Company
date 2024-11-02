package br.com.voidstar.personCompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class CompanyTest {
    private static Company ca, cb, cc;

    @Before
    public void setUp() throws Exception {

        ca = new Company();
        cb = new Company("CB");
        cc = new Company("CC");

    }

    @After
    public void tearDown() throws Exception {
        // No action necessary here.
    }

    @Test
    public void test() {
        // Test the state of ca after its construction.
        assertEquals(ca.getName(), "");
        assertEquals(ca.getNumberOfEmployees(), 0);

        // Test the state of cb after its construction.
        assertEquals(cb.getName(), "CB");
        assertEquals(cb.getNumberOfEmployees(), 0);

        // Test construction of cc
        assertEquals(cc.getName(), "CC");
        assertEquals(cc.getNumberOfEmployees(), 0);
        cc.setName("BananaSplit");
        assertEquals(cc.getName(), "BananaSplit");

        // It is possible to change the number of employees of
        // a company without irrespective of any person have
        // hired or dismissal by a person.
        // This behaviour, although valid from the perspective of
        // Company's API, should be allowed?
        ca.setNumberOfEmployees(10);
        assertEquals(ca.getNumberOfEmployees(), 10);
        ca.decrementNumberOfEmployees();
        assertEquals(ca.getNumberOfEmployees(), 9);
        ca.incrementNumberOfEmployees();
        assertEquals(ca.getNumberOfEmployees(), 10);
    }
}
