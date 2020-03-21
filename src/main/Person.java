package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person implements CheckPerson{

        @Override
        public boolean test(Person p) {
                return false;
        }

        public enum Sex {
            MALE, FEMALE
        }

        String name;
        LocalDate birthday;
        Sex gender;
        String emailAddress;

        public int getAge() {
                return Period.between(birthday,LocalDate.now()).getYears();
        }

        interface CheckPerson {
                boolean test(Person p);
        }

        public int printPerson(){
                System.out.println(this.getAge());
                return this.getAge();
        };

        public CheckPerson isSenior = p -> p.getAge() > 90;


        public int printPersons(List<Person> roster) {
                for (Person p : roster) {
                        CheckPerson tester = isSenior;
                        if (tester.test(p)) {
                                return p.printPerson();
                        }
                }
                return -1;
        }
}
