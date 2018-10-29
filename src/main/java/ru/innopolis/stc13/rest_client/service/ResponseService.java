package ru.innopolis.stc13.rest_client.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc13.rest_client.dto.Request;
import ru.innopolis.stc13.rest_client.dto.Response;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ResponseService {

    public Response getResponse(Request request) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(request, stringWriter);
            String stringRequest = stringWriter.toString();

            URL url = new URL("http://localhost:8080/param");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setRequestProperty("charset", "utf-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            OutputStream os = connection.getOutputStream();
            os.write(stringRequest.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            jaxbContext = JAXBContext.newInstance(Response.class);
            StringReader stringReader = new StringReader(response.toString());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Response) unmarshaller.unmarshal(stringReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
