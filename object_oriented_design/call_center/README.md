*Problem: Imagine you have a call center with three levels of employees: respondent, manager, and director. An incoming telephone call must be first allocated to a respondent who is free. If the respondent can't handle the call, he or she must escalate the call to a manager. If the manager is not free or not able to handle it, then the call should be escalated to a director. Implement a method dispatchCall() which assigns a call to the first available employee.*

*-from Cracking the Coding Interview Ch. 7.2*

##Abstract Class

An abstract class is a class which cannot be instantiated, but can be extended by a subclass. This is potentially for useful for closely related classes which may want to share methods and/or fields.

In this case, Employee is an abstract class that is extended by Director, Responder, and Manager. These different positions share the same properties of availability and names.  

Everything is instantiated in Problem.java and the result is printed to the console.
