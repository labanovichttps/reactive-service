package com.labanovich.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class UserServiceApplication {

//    static {
//        BlockHound.builder()
//            .allowBlockingCallsInside("java.util.UUID", "randomUUID")
//            .install();
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
