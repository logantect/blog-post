package io.jeongjaeeom.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.jeongjaeeom.junit.example.util.Calculator;
import org.junit.jupiter.api.Test;

class MyFirstJUnitJupiterTests {

  private final Calculator calculator = new Calculator();

  @Test
  void addition() {
    assertEquals(2, calculator.add(1, 1));
  }
}