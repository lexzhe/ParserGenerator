grammar Megagrammar;

gram : expression* token*;

expression : NONTERMINAL initialattributes? parentattributes? EQUALS rules;

initialattributes: LBR CODE RBR;

parentattributes: SQUARE_LBR CODE SQUARE_RBR;

rules: onerule ( STICK onerule )* (STICK EMPTY)? DOTCOMA;

onerule: syntezattributes? chain;

syntezattributes: FIGURE_LBR CODE FIGURE_RBR;

chain: name+;

token: TERMINAL  EQUALS CHARS DOTCOMA;

name : TERMINAL | NONTERMINAL;

CHARS : '"' (~('"'))+ '"';
CODE : '@' (~('@'))+ '@';
NONTERMINAL : [a-z][a-zA-Z]*;
TERMINAL : [A-Z]+;

WHITESPACE : [ \t\r\n]+ -> skip;

DOTCOMA : ';';
EQUALS : '=';
STICK : '|';
LBR : '(';
RBR : ')';
SQUARE_LBR : '[';
SQUARE_RBR : ']';
FIGURE_LBR: '{';
FIGURE_RBR: '}';
EMPTY: '<>';
