package com.wxq.bigworld.serverconfiggit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServerConfigGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfigGitApplication.class, args);
    }

}

