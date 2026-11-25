# Java Basic

A Java practice project covering core Java concepts, collections, streams, lambda expressions, method references, Optional, exception handling, and basic DSA problems.

## Project Structure

```text
Java_Basic
├── src/
│   ├── Employee.java
│   ├── EmployeeService.java
│   ├── EmployeeAnalytics.java
│   ├── EmployeeRepository.java
│   ├── InvalidSalaryException.java
│   ├── EmployeeNotFoundException.java
│   ├── LambdaExercises.java
│   ├── MethodReferenceExercises.java
│   ├── StreamExercises.java
│   ├── OptionalExercises.java
│   └── ExceptionExercises.java
├── dsa/
│   ├── MoveZeroes.java
│   └── BestTimeToBuySellStock.java
└── README.md
```

## Modules

### Core Classes
- `Employee.java` - Employee model with validation and display support.
- `EmployeeRepository.java` - In-memory employee data source.
- `EmployeeService.java` - Employee lookup and update operations.
- `EmployeeAnalytics.java` - Salary and department analytics.

### Exception Handling
- `InvalidSalaryException.java` - Custom runtime exception for invalid salary values.
- `EmployeeNotFoundException.java` - Custom runtime exception for missing employees.
- `ExceptionExercises.java` - Demonstrates handling custom and runtime exceptions.

### Java 8+ Exercises
- `LambdaExercises.java` - Lambda expressions with predicates, functions, comparators, and consumers.
- `MethodReferenceExercises.java` - Static, instance, and constructor method references.
- `StreamExercises.java` - Filtering, mapping, sorting, distinct, reduce, aggregation, and reporting.
- `OptionalExercises.java` - Optional search, `orElse`, `orElseThrow`, `filter`, and Optional pipelines.

### DSA
- `MoveZeroes.java` - Moves zeroes to the end while preserving non-zero order.
- `BestTimeToBuySellStock.java` - Finds maximum profit from a single buy/sell transaction.

## Compile

```bash
javac -d out src/*.java dsa/*.java
```

## Run Examples

```bash
java -cp out LambdaExercises
java -cp out MethodReferenceExercises
java -cp out StreamExercises
java -cp out OptionalExercises
java -cp out ExceptionExercises
java -cp out MoveZeroes
java -cp out BestTimeToBuySellStock
```
