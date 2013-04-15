clockwork
=========

Written by: Jason Nerothin || http://jasonnerothin.com

A project having to do with clocks and such...

Prerequisites
-------------
1. SBT installed and ready to go.

Description
-----------

This project provides a console application that calculates the required travel of an abstract clock's
minute hand from one time to another.

Ancillary details
-----------------

This app was built and tested using SBT version 0.12.0, scala version 2.9.2 and a 1.7.0 version of Oracle's
OpenJDK, bootstrapped for Mac OSX. I expect it would run equally well on a 1.6 JRE when built as a fat jar.

To Run
------

Open a command window in the project directory and type 'sbt'. Then, type 'run-main Main' (no quotes) and hit
enter. A number of other useful SBT tasks are available such as 'clean', 'test', 'compile', 'package', 'reload',
etc...

