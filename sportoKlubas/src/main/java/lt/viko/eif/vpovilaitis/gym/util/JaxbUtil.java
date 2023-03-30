package lt.viko.eif.vpovilaitis.gym.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.vpovilaitis.gym.model.User;

public class JaxbUtil {
    public static void convertToXML(User user1) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);

            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);

            marshaller.marshal(user1, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}

