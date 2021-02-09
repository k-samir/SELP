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



expression :'('expression OP1 expression  ')'                     # binExp
            |  '(' ('-' | '!')  expression  ')'                   # unExp
            | ('-' | '!')  expression                             # unExp
            | '('expression OP2 expression     ')'                # binExp
            | '('expression OP3 expression   ')'                  # binExp
            | '('expression OP4 expression   ')'                  # binExp
            |'(' expression OP5 expression   ')'                  # binExp
            |'(' expression OP6 expression   ')'                  # binExp
            |'(' expression '-' expression   ')'                  # binExp
            | expression '-' expression                           # binExp
            | expression OP1 expression                           # binExp
            | expression OP2 expression                           # binExp
            | expression OP3 expression                           # binExp
            | expression OP4 expression                           # binExp
            | expression OP5 expression                           # binExp
            | expression OP6 expression                           # binExp
            | '(' LITERAL ')'                                     # intLit
            | LITERAL                                             # intLit
            | LITERAL LITERAL                                     # syntaxError
            | '(' LITERAL LITERAL ')'                             # syntaxError
            |'(' ('-' | '!')  expression   ')'                    # unExp
            | variableId                                          # VarCall
            | '(' expression ')'                                  # Exp
            | <assoc = right> expression ':' expression '?'       # syntaxError
            | <assoc = right> expression '?' expression ':' expression  # condExp
            | BOOLEAN                                             # boolean
            ;

tail: ')'
| expression ')'
;

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

BOOLEAN : 'true' |'false' ;
// lexical rules

OP1       : '*' | '/';
OP2       : '-' | '+';
OP3       :  '<' | '>' | '<='  |'>=';
OP4       :  '==' | '!=' ;
OP5       : '&&';
OP6       : '||';


IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*
         ;

WS       : [ \t\n\r]+ -> channel(HIDDEN)
         ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN)
         ;


