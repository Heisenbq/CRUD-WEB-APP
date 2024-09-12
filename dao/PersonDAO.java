package com.example.demo.dao;

import com.example.demo.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/student";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2012";

    private static Connection connection;

    static {
        try{
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }


    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "Select * from person";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        }catch (SQLException exception) {
            exception.printStackTrace();
        }

        return people;
    }
    public void save(Person person){
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }
    public void update(int id,Person person){

//        Person personToBeUpdated= show(id);
//        personToBeUpdated.setName(person.getName());
//        personToBeUpdated.setAge(person.getAge());
//        personToBeUpdated.setEmail(person.getEmail());
    }
    public Person show(int id){
        //return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
        return null;
    }
    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
