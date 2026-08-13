public class ExceptionHandling {
    public static void main(String[] args){
        // 1. any code generating system's exceptions are caught in the try block
        // 2. our code can catch the exception in the catch block
        // 3. to manually throw an exception use the keyword throw
        // 4. Any exception that is thrown out of a method must be specified as such by a throws clause
        // 5. Any code that absolutely must be executed after a try block completes is put in a finally block.

        /*
         * try {
         * // block of code to monitor for errors
         * }
         * catch (ExceptionType1 exOb) {
         * // exception handler for ExceptionType1
         * }
         * catch (ExceptionType2 exOb) {
         * // exception handler for ExceptionType2
         * }
         * // ...
         * finally {
         * // block of code to be executed after try block ends
         * }
         * 
         * 
         */
        //Exception types:-
        // 6. Throwable :- Super Class, thus all the exception types are its subclasses.
        // 7. Below Throwable, there are 2 subclasses, which partitions exceptions in two different branches.
        // 8. One is 'Exception' , there is one important subclass of Exception, named RuntimeException.
        // 9. The other branch is topped by Error.Exceptions of type Error are used
            // by the Java run-time system to indicate errors having to do with the run-time environment,
            // itself. Stack overflow is an example of such an error. This chapter will not be dealing with
            // exceptions of type Error, because these are typically created in response to catastrophic failures
            // that cannot usually be handled by your program.

        int d,a;
        try { // monitor a block of code.
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) { // catch divide-by-zero error
            System.out.println("Division by zero.");
        }
        System.out.println("After catch statement.");

        // 10. Throwable overrides toString() method...thus,
        try { // monitor a block of code.
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) { // catch divide-by-zero error
            System.out.println("Exception : " + e);
        }
        System.out.println("After catch statement.");


        // in some cases multiple exceptions could be raised thus, in this case mutiple catch statements can be implemented.
        // try statements can be nested

        /*
         * The try statement can be nested. That is, a try statement can be inside the
         * block of another try.
         * Each time a try statement is entered, the context of that exception is pushed
         * on the stack. If an
         * inner try statement does not have a catch handler for a particular exception,
         * the stack is
         * unwound and the next try statement’s catch handlers are inspected for a
         * match. This continues
         * until one of the catch statements succeeds, or until all of the nested try
         * statements are exhausted.
         * If no catch statement matches, then the Java run-time system will handle the
         * exception.
         */

        //Throw ->
        // general form of throw : throw ThrowableInstance;
    }
}
