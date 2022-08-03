package eu.horasion.intermediate.records;

// Java `record` is a special type of a class with some default access
// modifiers and some default overriden methods.

// All fields are PRIVATE and FINAL.
// The fields are accessible via automatically implemented getter methods.
// No setters for fields, so the data in the object becomes immutable.
// It has a built-in "canonical constructor" which takes the fields as params.
// Records can also have custom constructors, even more than one.
// Records can implement interfaces.
// Records can have custom methods, even static methods.
// Records can NOT have custom instance fields, but static fields are allowed.

// Automatically overridden methods are: toString(), equals() and hashCode()

public record Product(String name, String description, float price) {}

// getter methods here are: name(), description(), price()

// Any default implementation can be changed by overriding it.
// If we want to change the behaviour of the toString method,
// we can simply override it exactly the same way like in a class.
