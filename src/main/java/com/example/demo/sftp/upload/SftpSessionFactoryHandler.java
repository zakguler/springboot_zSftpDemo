package com.example.demo.sftp.upload;

import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

public class SftpSessionFactoryHandler {

    public DefaultSftpSessionFactory gimmeFactory(){
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory();
        
//        factory.setHost("0.0.0.0");
//        factory.setPort(22);
//        factory.setAllowUnknownKeys(true);
//        factory.setUser("mike");
//        factory.setPassword("password123");
        
        factory.setHost("172.23.164.87");
        factory.setPort(22);
        factory.setAllowUnknownKeys(true);
        factory.setUser("fhir");
        factory.setPassword("NjBhNWE4ZTc4NTk4YjQ4MDQ2");

        return factory;
    }
}
