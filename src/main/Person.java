package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {

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

        static class Criteria implements CheckPerson{
                public boolean test(Person p){
                        return p.getAge() > 90;
                }
        }

        public int printPersons(List<Person> roster, CheckPerson tester) {
                for (Person p : roster) {
                        if (tester.test(p)) {
                                return p.printPerson();
                        }
                }
                return -1;
        }
}
