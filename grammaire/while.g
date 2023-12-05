grammar while;
options{
output = AST;

}
tokens {
EXPR;
COMMANDS;
PARAM;
OUTPUT;
SYMBOL;
TL;
HD;
CONS;
LIST;
EGALITE;
FUNC;
IF;
WHILE;
FOR;
FOREACH;
}

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;
    
COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;
    
fragment    
Min 	:	'a'..'z';
fragment
Maj 	:	'A'..'Z';
fragment
Dec 	:	'0'..'9';


Symbol 	:	Min(Maj|Min|Dec)*('?'|'!')?;
Variable 	:	Maj(Maj|Min|Dec)*('?'|'!')?;
program :	function+;
function:	'function' i = Symbol ':'definition->^($i definition);
definition  : 	'read' input '%' commands '%''write'output -> ^(FUNC input ^(COMMANDS commands) output);
input 	:	inputSub -> ^(PARAM inputSub)| -> ^(PARAM);

inputSub :	Variable(','Variable)*-> Variable+;
output 	:	Variable(','Variable)* -> ^(OUTPUT Variable+);
commands :	 command(';'command)* -> command+;
command:	'nop'|(vars':='exprs) -> ^(EGALITE vars exprs)|if_|while_|for_|foreach_;
vars	:	Variable(','Variable)*-> Variable+;

exprs	:	expression(','expression)* -> expression+;
if_	:	'if'expression'then'commands ('else'commands)?'fi'-> ^(IF expression ^(COMMANDS commands+)) ;
while_	:	'while'expression'do'commands'od' -> ^(WHILE expression ^(COMMANDS commands));
for_	:	'for'expression'do'commands'od' -> ^(FOR expression ^(COMMANDS commands));
foreach_	:	'foreach' i = Variable'in'expression'do'commands'od' -> ^(FOREACH $i expression ^(COMMANDS commands));
exprbase:	 
('nil'|Variable|Symbol)
 | ('(' 'cons' lexpr ')' -> ^(CONS lexpr) | '(' 'list' lexpr ')' -> ^(LIST lexpr))
 | ('(' 'hd' exprbase ')'-> ^(HD exprbase) | '(' 'tl' exprbase ')' -> ^(TL exprbase))
 | ('(' s=Symbol lexpr ')'  -> ^(SYMBOL $s lexpr));
expression :	 exprbase('=?' exprbase)* -> exprbase+;
lexpr	:	 exprbase+ -> ^(EXPR exprbase+) | -> ^(EXPR);
start_rule: 	program; 
	
