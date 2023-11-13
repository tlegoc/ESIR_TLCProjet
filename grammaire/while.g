grammar while;

Min 	:	'a'..'z';
Maj 	:	'A'..'Z';
Dec 	:	'0'..'9';


symbol 	:	Min(Maj|Min|Dec)*('?'|'!')?;
variable 	:	Maj(Maj|Min|Dec)*('?'|'!')?;
program :	function program | function;
function:	'function' symbol ':'definition;
definition  
	: 'read' input '%' commands '%''write'output;
	
	
	
exprbase:	 ('nil'|variable|symbol) | ('(' 'cons' lexpr ')' | '(' 'list' lexpr ')') | ('(' 'hd' exprbase ')' | '(' 'tl' exprbase ')') | ('(' symbol lexpr ')')  ;


