package com.github.matsik


import spock.lang.Specification

class CalculatorSpec extends Specification {

    def "add should correctly sum two numbers"() {
        given: "a calculator instance"
        def calculator = new Calculator()

        when: "adding two numbers"
        def result = calculator.add(2, 3)

        then: "the result should be their sum"
        result == 5
    }

}
