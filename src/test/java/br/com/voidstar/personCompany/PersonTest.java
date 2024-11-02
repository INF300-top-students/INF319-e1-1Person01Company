package br.com.voidstar.personCompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

public class PersonTest {
    private static Person pa, pb, pc;

    private static Company cc;

    @Before
    public void setUp() throws Exception {

        pa = new Person();
        pb = new Person("Ana", "Karenina");

        cc = new Company("Iceberg");
        pc = new Person("Janus", "Kamasarov", 1.00, cc);

    }

    @After
    public void tearDown() throws Exception {
        // No action necessary.
    }

    @Test
    public void test() {
        // Test construction.
        assertEquals(pa.getName(), "");
        assertEquals(pa.getSurname(), "");
        assertNull(pa.getCompany());
        assertEquals(pa.getSalary(), 0.0, 0.0);

        assertEquals(pb.getName(), "Ana");
        assertEquals(pb.getSurname(), "Karenina");
        assertEquals(pb.getSalary(), 0.0, 0.0);
        assertNull(pb.getCompany());

        pb.setName("Anna");
        pb.setSurname("Kustikova");
        assertEquals(pb.getName(), "Anna");
        assertEquals(pb.getSurname(), "Kustikova");

        assertEquals(pc.getName(), "Janus");
        assertEquals(pc.getSurname(), "Kamasarov");
        assertEquals(pc.getCompany(), cc);
        assertEquals(pc.getSalary(), 1.0, 0.0);
        // Constructors guarantee the number of employees is
        // kept consistent with the association of a Person
        // with a Company
        assertEquals(cc.getNumberOfEmployees(), 1);

        // Teste de demitese
        pc.selfDismiss();
        assertNull(pc.getCompany());
        assertEquals(pc.getSalary(), 0.0, 0.0);

        pc.selfHire(cc, 10.0);
        assertEquals(cc.getNumberOfEmployees(), 1);
        assertEquals(pc.getSalary(), 10.0, 0.0);

        // It is possible to increment and decrement the number of
        // employees of a company directly, without the hiring or
        // dismissal of any person
        cc.incrementNumberOfEmployees();
        cc.incrementNumberOfEmployees();
        cc.decrementNumberOfEmployees();
        // Number of employees is always greater than or equal
        // to zero
        assertEquals(cc.getNumberOfEmployees(), 2);
        for (int i = 0; i < 10; i++) {
            cc.decrementNumberOfEmployees();
        }
        assertFalse(cc.getNumberOfEmployees() < 0);

    }

}
