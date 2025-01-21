package com.github.matsik

import spock.lang.Specification

class CalculatorSpec extends Specification {

    def calculator = new Calculator()

    def "add should correctly sum two numbers"() {
        expect: "the add result should be their sum"
        calculator.add(a, b) == c

        where:
        a | b || c
        1 | 2 || 3
        2 | 2 || 4
        3 | 2 || 5
    }

}
