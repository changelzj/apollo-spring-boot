package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Constant {
    @Value("${username}")
    public String username;

    @Value("${password}")
    public String password;
}
