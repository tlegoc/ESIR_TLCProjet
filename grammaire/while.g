grammar while;

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
function:	'function' Symbol ':'definition;
definition  : 	'read' input '%' commands '%''write'output;
input 	:	inputSub?;
inputSub :	Variable(','Variable)*;
output 	:	Variable(','Variable)*;
commands :	 command(';'command)*;
command:	'nop'|(vars':='exprs)|if_|while_|for_|foreach_;
vars	:	Variable(','Variable)*;
exprs	:	expression(','expression)*;
if_	:	'if'expression'then'commands('else'commands)?'fi';
while_	:	'while'expression'do'commands'od';
for_	:	'for'expression'do'commands'od';
foreach_	:	'foreach'Variable'in'expression'do'commands'od';
exprbase:	 ('nil'|Variable|Symbol) | ('(' 'cons' lexpr ')' | '(' 'list' lexpr ')') | ('(' 'hd' exprbase ')' | '(' 'tl' exprbase ')') | ('(' Symbol lexpr ')')  ;
expression :	 exprbase('=?' exprbase)*;
lexpr	:	 (exprbase lexpr)?;
start_rule: 	program; 
	
	
