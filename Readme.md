Introduction
------------

This example demonstrates the use of the Java Streaming API.
Input data is read from a file.
Each line contains one of the following:
Filter Description Line <br>

\verbatim

QF: <Filter_Description_Line>
<Filter_Description_Line> ::= 'QF:' <Filter_Line> <br>
<Filter_Line> ::= <String> | <String> <Filter_Line>

\endverbatim


