# algorithms-playground

📚 Learning and exploring algorithms (simple ones!) in Java.

## Instructions

Follow these instructions to build and run the program.

1. Use Java 17
2. Build and run the program:
   * `./gradlew run`
3. Build the program and run the tests:
   * `./gradlew test`
   
## WishList

General clean-ups, TODOs and things I wish to implement for this project:

* DONE Organize everything. Delete the unused code. Finish the unfinished code. Use consistent package names between the main
  and source test sets.
  * DONE Fix the classpath scanning stuff. Guava recommends not using their own utility (`com.google.common.reflect.ClassPath`)
    and recommends using <https://github.com/classgraph/classgraph>.
* IN PROGRESS Consider a "zero-weight project". Meaning, consider removing all dependencies, and Gradle and instead only having Java
  source in this project. The project would be built with a direct invocation of `javac`. Why? It's rare to have Java
  projects without a build tool like Gradle or Maven but in an academic context, we just want to focus on the task at
  hand: algorithms. As much as I want the convenience of Gradle and JUnit, the inclusion of those things multiplies the
  complexity of the codebase and ultimately is a risk for losing the reader. They may try to run the project and give up
  because of environmental issues or worse software rot (old versions of libraries and tools that don't work after some
  years). That would be a shame.
   * IN PROGRESS Replace JUnit tests with `public static void main` tests
   * Remove Gradle. In place of it, there will be a build script that looks like this <https://github.com/dgroomes/jshell-playground/blob/d2a0674b78c17493b0e9c79bede05ee6d8c4fca6/basic/build.sh#L11>
