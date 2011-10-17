Bigtop / Lift example
=====================

This example demonstrates the use of Bigtop Routes within a Lift application.

Running the code
================

You should be able to get this up and running with the following code:

    git clone git@github.com/bigtop/lift-example.git bigtop-lift-example
    cd bigtop-lift-example
    ./sbt jetty-run ~prepare-webapp

Key files
=========

The important files in this demo are:

 - `code/Site.scala` - defines a URL dispatch table using Bigtop Routes;
 - `code/snippets/CalculationIndex.scala` - demonstrates type-safe URL construction using the Site object;

The files you should try to ignore are:

 - `code/LiftSiteExtras.scala` - hackery to make Routes play with typed Lift snippets - only required if you're using typed snippets, and hopefully soon to be entirely unnecessary.
