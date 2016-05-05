package net.aimeizi.service.person;

import net.aimeizi.person.Person;
import net.aimeizi.person.PersonService;
import net.aimeizi.person.QueryParameter;
import org.apache.avro.AvroRemoteException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Override
    public String ping() throws AvroRemoteException {
        return "pong";
    }

    @Override
    public List<Person> getPersonList(QueryParameter queryParameter) throws AvroRemoteException {
        Person person = new Person();
        person.setAge(queryParameter.getAgeStart());
        person.setName("dubbo");
        List<Person> persons = new ArrayList<Person>();
        persons.add(person);
        return persons;
    }
}
