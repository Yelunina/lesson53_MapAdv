package ait.person;

import ait.person.model.Person;
import ait.person.model.PersonNotFoundException;

import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        Person[] persons = {new Person("John", 28), new Person("Mary", 19), new Person("Peter", 25)};
        Optional<Person> optional = findPersonByAge(persons, 28);
//        if (optional.isPresent()) {
//            Person person = optional.get();
//            System.out.println(person.getName());
//        }

//        optional.ifPresent(p -> System.out.println(p.getName()));

//        Person person = optional.orElse(new Person("Anonymous", -1));

//        Person person = optional.orElseGet(() -> {
//            System.out.println("Sorry... ;)");
//            return new Person("Anonymous", -1);
//        });

        Person person = optional.orElseThrow(() -> new PersonNotFoundException());

        System.out.println(person.getName());

    }

    private static Optional<Person> findPersonByAge(Person[] persons, int age) {
        Person person = null;
        for (Person p : persons) {
            if (p.getAge() == age) {
                person = p;
                break;
            }
        }
        return Optional.ofNullable(person);
    }
}