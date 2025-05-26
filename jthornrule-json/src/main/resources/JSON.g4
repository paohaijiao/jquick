grammar JSON;
json
   : value
   ;

value
   : object
   | array
   | STRING
   | NUMBER
   | 'true'
   | 'false'
   | 'null'
   ;

object
   : '{' pair (',' pair)* '}'
   | '{' '}'
   ;
pair
   : STRING ':' value
   ;
array
   : '[' value (',' value)* ']'
   | '[' ']'
   ;
STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;
fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;
fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;
fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;
NUMBER
   : '-'? INT ('.' [0-9] +)? EXP?
   ;

fragment INT
   : '0' | [1-9] [0-9]*
   ;

fragment EXP
   : [Ee] [+\-]? INT
   ;

// 忽略空白字符
WS
   : [ \t\n\r] + -> skip
   ;