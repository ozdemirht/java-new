Introduction
------------

This example demonstrates the use of the Java Streaming API.
<br>Input data is read from a file.
<br>Each line contains one of the following:
<br>Filter Description Line
```
<Filter_Description_Line> ::= 'QF:' <Filter_Line> <br>
            <Filter_Line> ::= <Term> | <Term> <Filter_Line>
                   <Term> ::= <String>
```
<br>Line of Log file 
```
 <Line_Of_Log>  ::= 'LOL:' <Line_Of_Words> <br>
<Words_Of_Line> ::= <Word> | <Word> " " <Words_Of_Line>
         <Word> ::= <String> 
```
As a result, the BNF of given file is as follows:

```
<Line_of_File> ::= <Filter_Description_Line> |  <Line_Of_Log>
```

Functional Requirements
-----------------------
1) When the solution encounters a Filter Description Line, it should print the Filter Description as.
```
Filter_Description_Response::= "A:" <Filter_Terms> "; FID=" <Filter_ID>
<Filter_Terms> ::= <String> | <String> " " <Filter_Terms>
<Filter_ID> ::= <Integer>
```
Filter_ID: Filter identifier, starts with 1.

2) When the solution encounters a Line of Log, it should print the Line of Log as.
```
Line_Of_Log_Response::= "M:" <Line_Of_Words> "; FID=" <FILTER_IDS>
<FILTER_IDS> ::= <Integer> | <Integer> "," <FILTER_IDS>

```

References
------------
1. [Augmented BNF for Syntax Specifications: ABNF](https://datatracker.ietf.org/doc/html/rfc5234)
