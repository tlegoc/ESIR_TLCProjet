grammar while;

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
program :	function  program?;
function:	'function' Symbol ':'definition;
definition  : 'read' input '%' commands '%''write'output;
input 	:	inputSub?;
inputSub :	Variable|Variable','inputSub;
output 	:	Variable|Variable','output;
commands :	 command(';'commands)?;
command:	'nop'|(vars':='exprs)|if_|while_|for_|foreach_;
vars	:	Variable|(Variable','vars);
exprs	:	expression(','exprs)?;
if_	:	'if'expression'then'commands('else'commands)?'fi';
while_	:	'while'expression'do'commands'od';
for_	:	'for'expression'do'commands'od';
foreach_	:	'foreach'Variable'in'expression'do'commands'od';
exprbase:	 ('nil'|Variable|Symbol) | ('(' 'cons' lexpr ')' | '(' 'list' lexpr ')') | ('(' 'hd' exprbase ')' | '(' 'tl' exprbase ')') | ('(' Symbol lexpr ')')  ;
expression :	 exprbase('=?' exprbase)?;
lexpr	:	 (exprbase lexpr)?;
start_rule: 	commands | program; 
	
	
