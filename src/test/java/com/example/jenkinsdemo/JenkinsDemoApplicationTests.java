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

  @Test
  void should_contain_echo() {
    String hello = helloController.echo("echo");
    assertThat(hello).isEqualTo("echo");
  }

  @Test
  void should_contain_hello_name() {
    String name = "John";
    String hello = helloController.greet(name);
    assertThat(hello).containsIgnoringCase("hello");
    assertThat(hello).containsIgnoringCase(name);
  }

  @Test
  void should_contain_hello_name_in_spanish() {
    String name = "John";
    String hello = helloController.greetSpanish(name);
    assertThat(hello).containsIgnoringCase("hola");
    assertThat(hello).containsIgnoringCase(name);
  }

  @Test
  void should_contain_hello_name_in_french() {
    String name = "John";
    String hello = helloController.greetFrench(name);
    assertThat(hello).containsIgnoringCase("bonjour");
    assertThat(hello).containsIgnoringCase(name);
  }

  @Test
  void should_contain_hello_name_in_italian() {
    String name = "John";
    String hello = helloController.greetItalian(name);
    assertThat(hello).containsIgnoringCase("ciao");
    assertThat(hello).containsIgnoringCase(name);
  }

}
