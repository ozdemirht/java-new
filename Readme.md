Introduction
------------

This example demonstrates the use of the Java Streaming API.
<br>Input data is read from a file.
<br>Each line contains one of the following:
<br>Filter Description Line
```
<Filter_Description_Line> ::= 'QF:' <Filter_Line> <br>
<Filter_Line> ::= <String> | <String> <Filter_Line>

```
<br>Line of Log file 
```
<Line_Of_Log> ::= 'LOL:' <Line_Of_Words> <br>
<Line_Of_Words> ::= <String> | <String> " " <Line_Of_Words>

```


