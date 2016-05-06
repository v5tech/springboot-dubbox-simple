package net.aimeizi;

import net.aimeizi.student.Student;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 测试rest服务
 */
public class RestClient {

    public static void main(String[] args) {

        final String port = "8000";

        registerStudent("http://localhost:" + port + "/services/students/register.json", MediaType.APPLICATION_JSON_TYPE);

        registerStudent("http://localhost:" + port + "/services/students/register.xml", MediaType.TEXT_XML_TYPE);

        getStudent("http://localhost:" + port + "/services/students/1.json");

        getStudent("http://localhost:" + port + "/services/students/2.xml");

        registerStudent("http://localhost:" + port + "/services/s/register.json", MediaType.APPLICATION_JSON_TYPE);

        registerStudent("http://localhost:" + port + "/services/s/register.xml", MediaType.TEXT_XML_TYPE);

        getStudent("http://localhost:" + port + "/services/s/1.json");

        getStudent("http://localhost:" + port + "/services/s/2.xml");

        registerStudent("http://localhost:" + port + "/services/customers/register.json", MediaType.APPLICATION_JSON_TYPE);

        registerStudent("http://localhost:" + port + "/services/customers/register.xml", MediaType.TEXT_XML_TYPE);

        getStudent("http://localhost:" + port + "/services/customers/1.json");

        getStudent("http://localhost:" + port + "/services/customers/2.xml");

    }

    private static void registerStudent(String url, MediaType mediaType) {
        System.out.println("Registering student via " + url);
        Student student = new Student(1L, "dubbo");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(student, mediaType));

        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }

    private static void getStudent(String url) {
        System.out.println("Getting student via " + url);
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed with HTTP error code : " + response.getStatus());
            }
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
    }
}
