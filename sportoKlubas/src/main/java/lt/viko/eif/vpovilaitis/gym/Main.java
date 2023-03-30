package lt.viko.eif.vpovilaitis.gym;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.vpovilaitis.gym.model.*;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {


        Trainer trainer1 = new Trainer("rob", "robinson");
        Equipment equipment1 = new Equipment("machine", "legs");
        Plan plan1 = new Plan("squat", "12", "3", equipment1);
        Membership membership1 = new Membership(plan1);
        User user1 = new User("john", "johnson", membership1, trainer1);
        System.out.println(user1);

        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.marshal(user1, new File("user.xml"));
        marshaller.marshal(user1, System.out);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Path path = Path.of("user.xml");
        String xmlContent = Files.readString(path);
        System.out.print(xmlContent);
        StringReader reader = new StringReader(xmlContent);
        User user = (User) unmarshaller.unmarshal(reader);
        System.out.println(user);


    }
}