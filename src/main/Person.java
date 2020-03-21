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

        interface Checkperson {
                boolean test(Person p);
        }

        public int printPerson(){
                System.out.println(this.getAge());
                return this.getAge();
        };

        public int printPersons(List<Person> roster, CheckPerson tester) {
                for (Person p : roster) {
                        Person person = new Person(){
                                public boolean test(Person p){
                                        return p.getAge() > 90;
                                }
                        };
                        tester = person;
                        if (tester.test(p)) {
                                return p.printPerson();
                        }
                }
                return -1;
        }
}
