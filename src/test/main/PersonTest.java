package main;


import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static main.Person.Sex.MALE;

public class PersonTest {

    @Test
    public void printPersons() {
     Person dave = new Person();
     ArrayList<Person> testRoster = new ArrayList<Person>(Arrays.asList(dave));
        dave.name = "Dave";
     dave.birthday = LocalDate.of(1111,01,01);
    dave.gender = MALE;
    dave.emailAddress = "dave@dave.dave";
    int expected = 909;
    int actual = dave.printPersons(testRoster, new Person.Criteria());
    Assert.assertEquals(expected,actual);

    }
}