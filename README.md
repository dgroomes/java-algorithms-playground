# java-algorithms-playground

📚 Learning and exploring algorithms (simple ones!) in Java.


## Overview

This codebase is for me to explore basic algorithms using Java. I started the beginnings of this codebase years ago
(2015) without version control. Later, I formalized it as a Git repository, added "run instructions" and did other
clean ups. Today (2023), I want to get even more leverage out of it as I continue to implement algorithms in Java as a
way to learn language features like [Java's Pattern Matching for switch](https://openjdk.org/jeps/433) and in general to
enrich my intuition about computational power in the same spirit as [*Computers are Fast*](https://computers-are-fast.github.io/).

A tenet of a codebase like this is to reduce the noise. That's why I have a "Wish List" item to remove Gradle and other
dependencies. A project like this is for "early programmers" who are learning principles of computation and just enough
programming language knowledge (e.g. Java, `javac`, and `java`; or honestly a non-compiled language would be best) to
exercise their knowledge. But, this is only an idea. In practice, I really need JUnit and also it is super convenient to
have Gradle. Java does not have its own build tool or testing facilities (compare to Go, for example). 

**NOTE**: This project was developed on macOS. It is for my own personal use.


## Instructions

Follow these instructions to build and run the program.

1. Use Java 17
2. Build and run the program:
   * ```shell
     ./gradlew run
     ```
   * Altogether, it should look something like this:
     ```text
     ❯ ./gradlew run
     
     > Task :run
     Question 1.1
     testing: charsAreAllUnique_v_1
     input string|expected result|actual result
     a|true|true
     ab|true|true
     ba|true|true
     aa|false|false
     |true|true
     testing: charsAreAllUnique_v_1
     input string|expected result|actual result
     a|true|true
     ab|true|true
     ba|true|true
     aa|false|false
     |true|true
     
     
     Question 1.3
     testing: isAPermutationOfB
     input string|expected result|actual result
     baa|true|true
     aba|true|true
     a|false|false
     testing: isAPermutationOfB
     input string|expected result|actual result
     baa|true|true
     aba|true|true
     a|false|false
     
     ... snip ...
     ```
3. Build the program and run the tests:
   * ```shell
     ./gradlew test
     ```
   

## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Organize everything. Delete the unused code. Finish the unfinished code. Use consistent package names between the main
  and source test sets.
  * DONE Fix the classpath scanning stuff. Guava recommends not using their own utility (`com.google.common.reflect.ClassPath`)
    and recommends using <https://github.com/classgraph/classgraph>.
* [ ] IN PROGRESS Consider a "zero-weight project". Meaning, consider removing all dependencies, and Gradle and instead only having Java
  source in this project. The project would be built with a direct invocation of `javac`. Why? It's rare to have Java
  projects without a build tool like Gradle or Maven but in an academic context, we just want to focus on the task at
  hand: algorithms. As much as I want the convenience of Gradle and JUnit, the inclusion of those things multiplies the
  complexity of the codebase and ultimately is a risk for losing the reader. They may try to run the project and give up
  because of environmental issues or worse software rot (old versions of libraries and tools that don't work after some
  years). That would be a shame.
   * Replace JUnit tests with `public static void main` tests
   * Remove Gradle. In place of it, there will be a build script that looks like this <https://github.com/dgroomes/jshell-playground/blob/d2a0674b78c17493b0e9c79bede05ee6d8c4fca6/basic/build.sh#L11>
* [ ] Consistent test log output. Right now it's a mismash of "printing test cases" or printing nothing at all. I don't
  mean for this to be a "test framework" but instead just conventions for describe what is being tested, and the test
  result (success or failure). 
