package com.example.demo.sftp.upload;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.sftp.session.SftpSession;

public class UpAndDownloadSafe {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public UpAndDownloadSafe() {
		super();
	}

	public void uploadSafe(){
        SftpSession session = new SftpSessionFactoryHandler().gimmeFactory().getSession();
        InputStream resourceAsStream =
                UpAndDownloadSafe.class.getClassLoader().getResourceAsStream("mytextfile.txt");
        try {
            String filename = String.format("mynewfile%s.txt", LocalDateTime.now());
            String destination = String.format("/hosts/fhir/tmp/upload/%s", filename);
            logger.info("Write file to: " + destination);

            session.write(resourceAsStream, destination);

//            String donedestination = String.format("/hosts/fhir/tmp/done/%s", filename);
//            logger.info("Rename file to: " + donedestination);
//            session.rename(destination, donedestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        session.close();
    }

    public String downloadSafe(){
        SftpSession session = new SftpSessionFactoryHandler().gimmeFactory().getSession();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            session.read("/hosts/fhir/tmp/z.txt", outputStream);
            return new String(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
