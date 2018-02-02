# Polymorphic Domain Specific Languages


## Introduction

This repository contains many DSL implementations and compiler to various GPL targets.

### CSV

The CSV dsl operates on CSV and allow the following operations:
 - open
 - write
 - print
 - line count

The CSV dsl compiles to:
 - java
 - java + [commons-csv](https://commons.apache.org/proper/commons-csv/)
 - python (using the csv library)

## FSM

The FSM dsl allow the definition of simple FSM composed of named states and transitions.
It also provide well-formedness rules such as final node reachability.

The FSM dsl compiles to:
- java
- java + [squirrel](https://github.com/hekailiang/squirrel)
- python



## Project architecture

- [examples](examples): Program examples
- [polymorphic.csv](polymorphic.csv): CSV Language specifications
- [polymorphic.csv.ide](polymorphic.csv.ide): CSV Eclipse specific specifications
- [polymorphic.csv.tests](polymorphic.csv.tests): CSV Language tests
- [polymorphic.csv.ui](polymorphic.csv.ui): CSV Language UI specific specifications
- [polymorphic.csv.ui.tests](polymorphic.csv.ui.tests): CSV UI specific tests
- [polymorphic.fsm](polymorphic.fsm): FSM Language specifications
- [polymorphic.fsm.ide](polymorphic.fsm.ide): FSM Eclipse specific specifications
- [polymorphic.fsm.tests](polymorphic.fsm.tests): FSM Language tests
- [polymorphic.fsm.ui](polymorphic.fsm.ui): FSM Language UI specific specifications
- [polymorphic.fsm.ui.tests](polymorphic.fsm.ui.tests): FSM UI specific tests


## CSV Implementations proposal

- https://github.com/uniVocity/csv-parsers-comparison
  - Bean IO Parser
  - Apache Commons CSV
  - Esperio CSV parser... Parser Esperio
  - Gen-Java CSV
  - Java CSV Parser
  - JCSV Parser
  - OpenCSV
  - Simple CSV parser
  - SuperCSV
  - uniVocity CSV parser
  - Way IO Parser
  - Oster Miller CSV parser
  - Jackson CSV parser
  - SimpleFlatMapper CSV parser
  - Product Collections parser
  - Diergo Easy CSV Streamable
- https://rosettacode.org/wiki/CSV_data_manipulation
- https://github.com/apache/commons-csv/blob/master/src/test/java/org/apache/commons/csv/CSVBenchmark.java
