grammar Calc;

// syntactic rules
/*
Noter, dans la fenêtre Calc.g4 ainsi que dans la fenêtre Structure,
la différence entre règles syntaxiques et règles lexicales : les règles
lexicales sont aussi des règles de grammaires (en fait des descriptions
 régulières) mais donnent lieu à la génération d'unités lexicales qui sont
  des feuilles de l'arbre syntaxique, avec des symboles non-terminaux qui
   commencent par une majuscule.
*/
program  : funcDef* body
         ;

funcDef  : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef   : '(' '=' variableId expression ')'
         ;
expression : intLit
           | variableId
           | '(' '-' expression tail
           | binExp
           | '(' 'if' expression expression expression ')'
           | '(' functionId expression* ')'
           ;

intLit : LITERAL;

tail: ')'
| expression ')'
;

binExp : '(' OP expression expression ')';

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;



// lexical rules

OP       : '+' | '-' | '*' | '/' | '==' | '<' 
         ;
IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;

