package com.github.matsik

import spock.lang.Specification

class CalculatorSpec extends Specification {

    def "add should correctly sum two numbers"() {
        given:
        Calculator calculator = Mock {
            1 * add(_, _) >> {first, second -> first + second}
            0 * _
        }

        expect: "the add result should be their sum"
        calculator.add(a, b) == c

        where:
        a | b || c
        1 | 2 || 3
        2 | 2 || 4
        3 | 2 || 5
        2 | 3 || 5
    }

}
