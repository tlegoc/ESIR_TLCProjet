grammar while;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;
    
Min 	:	'a'..'z';
Maj 	:	'A'..'Z';
Dec 	:	'0'..'9';


symbol 	:	Min(Maj|Min|Dec)*('?'|'!')?;
variable 	:	Maj(Maj|Min|Dec)*('?'|'!')?;
program :	function  program?;
function:	'function' symbol ':'definition;
definition  : 'read' input '%' commands '%''write'output;
input 	:	inputSub?;
inputSub :	variable|variable','inputSub;
output 	:	variable|variable','output;
commands :	 command(';'commands)?;
command:'nop'|(vars':='exprs)|if|while|for|foreach;
vars	:	variable|(variable','vars);
exprs	:	expression(','exprs)?;
if	:	'if'expression'then'commands('else'commands)?'fi';
while	:	'while'expression'do'commands'od';
for	:	'for'expression'do'commands'od';
foreach	:	'foreach'variable'in'expression'do'commands'od';
exprbase:	 ('nil'|variable|symbol) | ('(' 'cons' lexpr ')' | '(' 'list' lexpr ')') | ('(' 'hd' exprbase ')' | '(' 'tl' exprbase ')') | ('(' symbol lexpr ')')  ;
expression :	 exprbase('=?' exprbase)?;
lexpr	:	 (exprbase lexpr)?;
start_rule: lexpr; 
	
	
