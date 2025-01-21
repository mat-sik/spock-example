package com.github.matsik


import spock.lang.Specification

class CalculatorSpec extends Specification {

    def "add should correctly sum two numbers"() {
        given: "a calculator instance"
        def calculator = new Calculator()

        expect: "the add result should be their sum"
        calculator.add(2, 3) == 5
    }

}
