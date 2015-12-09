package controllers;

/**
 * class that extends abstract class Routing Policy
 * implements method for round robin algorithm
 * * // ------ vasileios comment
    // you should add descriptive comments both for the class and for the method
 */
public class RoundRobin extends RoutingPolicy {
    @Override
    String getNextURL() {
        return ("http://localhost:9002/pentaho");
    }
}
