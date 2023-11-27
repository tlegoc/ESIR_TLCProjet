grammar while;
options{
output = AST;

}
tokens {
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
definition  : 	'read' input '%' commands '%''write'output -> ^(FUNC input commands output);
input 	:	inputSub?;

inputSub :	Variable(','Variable)*-> Variable+;
output 	:	Variable(','Variable)* -> Variable+;
commands :	 command(';'command)* -> command+;
command:	'nop'|(vars':='exprs) -> ^(EGALITE vars exprs)|if_|while_|for_|foreach_;
vars	:	Variable(','Variable)*-> Variable+;

exprs	:	expression(','expression)* -> expression+;
if_	:	'if'expression'then'commands ('else'commands)?'fi'-> ^(IF expression commands+) ;
while_	:	'while'expression'do'commands'od' -> ^(WHILE expression commands);
for_	:	'for'expression'do'commands'od' -> ^(FOR expression commands);
foreach_	:	'foreach' i = Variable'in'expression'do'commands'od' -> ^(FOREACH $i expression commands);
exprbase:	 
('nil'|Variable|Symbol)
 | ('(' 'cons' lexpr ')' -> ^(CONS lexpr) | '(' 'list' lexpr ')' -> ^(LIST lexpr))
 | ('(' 'hd' exprbase ')'-> ^(HD exprbase) | '(' 'tl' exprbase ')' -> ^(TL exprbase))
 | ('(' Symbol lexpr ')')  -> ^(SYMBOL lexpr) ;
expression :	 exprbase('=?' exprbase)* -> exprbase+;
lexpr	:	 exprbase+;
start_rule: 	program; 
	
