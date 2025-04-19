package com.example.jenkinsdemo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.jenkinsdemo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JenkinsDemoApplicationTests {

  @Autowired
  HelloController helloController;

  @Test
  void contextLoads() {}

  @Test
  void should_contain_hello() {
    String hello = helloController.hello();
    assertThat(hello).containsIgnoringCase("hello");
  }

}
