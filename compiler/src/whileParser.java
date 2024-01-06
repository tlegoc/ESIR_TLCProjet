// $ANTLR 3.5.1 C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g 2024-01-06 14:32:02

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class whileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "ASSIGN_EXPR", "ASSIGN_VARS", 
		"BODY", "COMMANDS", "COMMENT", "CONS", "Dec", "FOR", "FOREACH", "FUNC", 
		"HD", "IF", "LIST", "Maj", "Min", "OUTPUT", "PARAM", "SYMBOL", "Symbol", 
		"THEN", "TL", "VIDE", "Variable", "WHILE", "WS", "'%'", "'('", "')'", 
		"','", "':'", "':='", "';'", "'=?'", "'cons'", "'do'", "'else'", "'fi'", 
		"'for'", "'foreach'", "'function'", "'hd'", "'if'", "'in'", "'list'", 
		"'nil'", "'nop'", "'od'", "'read'", "'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int ASSIGN=4;
	public static final int ASSIGN_EXPR=5;
	public static final int ASSIGN_VARS=6;
	public static final int BODY=7;
	public static final int COMMANDS=8;
	public static final int COMMENT=9;
	public static final int CONS=10;
	public static final int Dec=11;
	public static final int FOR=12;
	public static final int FOREACH=13;
	public static final int FUNC=14;
	public static final int HD=15;
	public static final int IF=16;
	public static final int LIST=17;
	public static final int Maj=18;
	public static final int Min=19;
	public static final int OUTPUT=20;
	public static final int PARAM=21;
	public static final int SYMBOL=22;
	public static final int Symbol=23;
	public static final int THEN=24;
	public static final int TL=25;
	public static final int VIDE=26;
	public static final int Variable=27;
	public static final int WHILE=28;
	public static final int WS=29;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public whileParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public whileParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return whileParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g"; }


	public static class start_rule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "start_rule"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:1: start_rule : program ;
	public final whileParser.start_rule_return start_rule() throws RecognitionException {
		whileParser.start_rule_return retval = new whileParser.start_rule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope program1 =null;


		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:11: ( program )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:14: program
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_program_in_start_rule83);
			program1=program();
			state._fsp--;

			adaptor.addChild(root_0, program1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start_rule"


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:1: program : ( function )+ ;
	public final whileParser.program_return program() throws RecognitionException {
		whileParser.program_return retval = new whileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function2 =null;


		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:9: ( ( function )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:11: ( function )+
			{
			root_0 = (Object)adaptor.nil();


			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==44) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:11: function
					{
					pushFollow(FOLLOW_function_in_program316);
					function2=function();
					state._fsp--;

					adaptor.addChild(root_0, function2.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:1: function : 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) ;
	public final whileParser.function_return function() throws RecognitionException {
		whileParser.function_return retval = new whileParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token string_literal3=null;
		Token char_literal4=null;
		ParserRuleReturnScope definition5 =null;

		Object i_tree=null;
		Object string_literal3_tree=null;
		Object char_literal4_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:9: ( 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:11: 'function' i= Symbol ':' definition
			{
			string_literal3=(Token)match(input,44,FOLLOW_44_in_function323);  
			stream_44.add(string_literal3);

			i=(Token)match(input,Symbol,FOLLOW_Symbol_in_function329);  
			stream_Symbol.add(i);

			char_literal4=(Token)match(input,34,FOLLOW_34_in_function331);  
			stream_34.add(char_literal4);

			pushFollow(FOLLOW_definition_in_function332);
			definition5=definition();
			state._fsp--;

			stream_definition.add(definition5.getTree());
			// AST REWRITE
			// elements: definition, i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 53:46: -> ^( FUNC $i definition )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:48: ^( FUNC $i definition )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC, "FUNC"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_definition.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definition"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:1: definition : 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) ;
	public final whileParser.definition_return definition() throws RecognitionException {
		whileParser.definition_return retval = new whileParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal6=null;
		Token char_literal8=null;
		Token char_literal10=null;
		Token string_literal11=null;
		ParserRuleReturnScope input7 =null;
		ParserRuleReturnScope commands9 =null;
		ParserRuleReturnScope output12 =null;

		Object string_literal6_tree=null;
		Object char_literal8_tree=null;
		Object char_literal10_tree=null;
		Object string_literal11_tree=null;
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:13: ( 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:16: 'read' input '%' commands '%' 'write' output
			{
			string_literal6=(Token)match(input,52,FOLLOW_52_in_definition350);  
			stream_52.add(string_literal6);

			pushFollow(FOLLOW_input_in_definition352);
			input7=input();
			state._fsp--;

			stream_input.add(input7.getTree());
			char_literal8=(Token)match(input,30,FOLLOW_30_in_definition354);  
			stream_30.add(char_literal8);

			pushFollow(FOLLOW_commands_in_definition356);
			commands9=commands();
			state._fsp--;

			stream_commands.add(commands9.getTree());
			char_literal10=(Token)match(input,30,FOLLOW_30_in_definition358);  
			stream_30.add(char_literal10);

			string_literal11=(Token)match(input,56,FOLLOW_56_in_definition359);  
			stream_56.add(string_literal11);

			pushFollow(FOLLOW_output_in_definition360);
			output12=output();
			state._fsp--;

			stream_output.add(output12.getTree());
			// AST REWRITE
			// elements: output, commands, input
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 54:59: -> ^( BODY input ^( COMMANDS commands ) output )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:62: ^( BODY input ^( COMMANDS commands ) output )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);
				adaptor.addChild(root_1, stream_input.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:75: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, stream_output.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "definition"


	public static class input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:1: input : ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) );
	public final whileParser.input_return input() throws RecognitionException {
		whileParser.input_return retval = new whileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub13 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:8: ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			else if ( (LA2_0==30) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:10: inputSub
					{
					pushFollow(FOLLOW_inputSub_in_input384);
					inputSub13=inputSub();
					state._fsp--;

					stream_inputSub.add(inputSub13.getTree());
					// AST REWRITE
					// elements: inputSub
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:19: -> ^( PARAM inputSub )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:22: ^( PARAM inputSub )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM, "PARAM"), root_1);
						adaptor.addChild(root_1, stream_inputSub.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:41: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:41: -> ^( PARAM )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:44: ^( PARAM )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PARAM, "PARAM"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "input"


	public static class inputSub_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputSub"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:1: inputSub : Variable ( ',' Variable )* -> ( Variable )+ ;
	public final whileParser.inputSub_return inputSub() throws RecognitionException {
		whileParser.inputSub_return retval = new whileParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable14=null;
		Token char_literal15=null;
		Token Variable16=null;

		Object Variable14_tree=null;
		Object char_literal15_tree=null;
		Object Variable16_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:10: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:12: Variable ( ',' Variable )*
			{
			Variable14=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub407);  
			stream_Variable.add(Variable14);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:20: ( ',' Variable )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==33) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:21: ',' Variable
					{
					char_literal15=(Token)match(input,33,FOLLOW_33_in_inputSub409);  
					stream_33.add(char_literal15);

					Variable16=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub410);  
					stream_Variable.add(Variable16);

					}
					break;

				default :
					break loop3;
				}
			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 57:34: -> ( Variable )+
			{
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_0, stream_Variable.nextNode());
				}
				stream_Variable.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inputSub"


	public static class output_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) ;
	public final whileParser.output_return output() throws RecognitionException {
		whileParser.output_return retval = new whileParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable17=null;
		Token char_literal18=null;
		Token Variable19=null;

		Object Variable17_tree=null;
		Object char_literal18_tree=null;
		Object Variable19_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:9: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:11: Variable ( ',' Variable )*
			{
			Variable17=(Token)match(input,Variable,FOLLOW_Variable_in_output424);  
			stream_Variable.add(Variable17);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:19: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==33) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:20: ',' Variable
					{
					char_literal18=(Token)match(input,33,FOLLOW_33_in_output426);  
					stream_33.add(char_literal18);

					Variable19=(Token)match(input,Variable,FOLLOW_Variable_in_output427);  
					stream_Variable.add(Variable19);

					}
					break;

				default :
					break loop4;
				}
			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 58:34: -> ^( OUTPUT ( Variable )+ )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:37: ^( OUTPUT ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUT, "OUTPUT"), root_1);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "output"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:1: commands : command ( ';' command )* -> ( command )+ ;
	public final whileParser.commands_return commands() throws RecognitionException {
		whileParser.commands_return retval = new whileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal21=null;
		ParserRuleReturnScope command20 =null;
		ParserRuleReturnScope command22 =null;

		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:10: ( command ( ';' command )* -> ( command )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:13: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands446);
			command20=command();
			state._fsp--;

			stream_command.add(command20.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:20: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==36) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:21: ';' command
					{
					char_literal21=(Token)match(input,36,FOLLOW_36_in_commands448);  
					stream_36.add(char_literal21);

					pushFollow(FOLLOW_command_in_commands449);
					command22=command();
					state._fsp--;

					stream_command.add(command22.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// AST REWRITE
			// elements: command
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 59:34: -> ( command )+
			{
				if ( !(stream_command.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_command.hasNext() ) {
					adaptor.addChild(root_0, stream_command.nextTree());
				}
				stream_command.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "commands"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:1: command : ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) ) | if_ | while_ | for_ | foreach_ );
	public final whileParser.command_return command() throws RecognitionException {
		whileParser.command_return retval = new whileParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal23=null;
		Token string_literal25=null;
		ParserRuleReturnScope vars24 =null;
		ParserRuleReturnScope exprs26 =null;
		ParserRuleReturnScope if_27 =null;
		ParserRuleReturnScope while_28 =null;
		ParserRuleReturnScope for_29 =null;
		ParserRuleReturnScope foreach_30 =null;

		Object string_literal23_tree=null;
		Object string_literal25_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:8: ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) ) | if_ | while_ | for_ | foreach_ )
			int alt6=6;
			switch ( input.LA(1) ) {
			case 50:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 46:
				{
				alt6=3;
				}
				break;
			case 55:
				{
				alt6=4;
				}
				break;
			case 42:
				{
				alt6=5;
				}
				break;
			case 43:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:10: 'nop'
					{
					root_0 = (Object)adaptor.nil();


					string_literal23=(Token)match(input,50,FOLLOW_50_in_command462); 
					string_literal23_tree = (Object)adaptor.create(string_literal23);
					adaptor.addChild(root_0, string_literal23_tree);

					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:16: ( vars ':=' exprs )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:16: ( vars ':=' exprs )
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:17: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command465);
					vars24=vars();
					state._fsp--;

					stream_vars.add(vars24.getTree());
					string_literal25=(Token)match(input,35,FOLLOW_35_in_command466);  
					stream_35.add(string_literal25);

					pushFollow(FOLLOW_exprs_in_command467);
					exprs26=exprs();
					state._fsp--;

					stream_exprs.add(exprs26.getTree());
					}

					// AST REWRITE
					// elements: vars, exprs
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:32: -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:35: ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:44: ^( ASSIGN_VARS vars )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_VARS, "ASSIGN_VARS"), root_2);
						adaptor.addChild(root_2, stream_vars.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:64: ^( ASSIGN_EXPR exprs )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_EXPR, "ASSIGN_EXPR"), root_2);
						adaptor.addChild(root_2, stream_exprs.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:86: if_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_if__in_command488);
					if_27=if_();
					state._fsp--;

					adaptor.addChild(root_0, if_27.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:90: while_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_while__in_command490);
					while_28=while_();
					state._fsp--;

					adaptor.addChild(root_0, while_28.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:97: for_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_for__in_command492);
					for_29=for_();
					state._fsp--;

					adaptor.addChild(root_0, for_29.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:102: foreach_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_foreach__in_command494);
					foreach_30=foreach_();
					state._fsp--;

					adaptor.addChild(root_0, foreach_30.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:1: vars : Variable ( ',' Variable )* -> ( Variable )+ ;
	public final whileParser.vars_return vars() throws RecognitionException {
		whileParser.vars_return retval = new whileParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable31=null;
		Token char_literal32=null;
		Token Variable33=null;

		Object Variable31_tree=null;
		Object char_literal32_tree=null;
		Object Variable33_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:6: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:8: Variable ( ',' Variable )*
			{
			Variable31=(Token)match(input,Variable,FOLLOW_Variable_in_vars501);  
			stream_Variable.add(Variable31);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:16: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==33) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:17: ',' Variable
					{
					char_literal32=(Token)match(input,33,FOLLOW_33_in_vars503);  
					stream_33.add(char_literal32);

					Variable33=(Token)match(input,Variable,FOLLOW_Variable_in_vars504);  
					stream_Variable.add(Variable33);

					}
					break;

				default :
					break loop7;
				}
			}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 61:30: -> ( Variable )+
			{
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					adaptor.addChild(root_0, stream_Variable.nextNode());
				}
				stream_Variable.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vars"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:1: exprs : expression ( ',' expression )* -> ( expression )+ ;
	public final whileParser.exprs_return exprs() throws RecognitionException {
		whileParser.exprs_return retval = new whileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal35=null;
		ParserRuleReturnScope expression34 =null;
		ParserRuleReturnScope expression36 =null;

		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:7: ( expression ( ',' expression )* -> ( expression )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:9: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs518);
			expression34=expression();
			state._fsp--;

			stream_expression.add(expression34.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:19: ( ',' expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==33) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:20: ',' expression
					{
					char_literal35=(Token)match(input,33,FOLLOW_33_in_exprs520);  
					stream_33.add(char_literal35);

					pushFollow(FOLLOW_expression_in_exprs521);
					expression36=expression();
					state._fsp--;

					stream_expression.add(expression36.getTree());
					}
					break;

				default :
					break loop8;
				}
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 63:36: -> ( expression )+
			{
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_0, stream_expression.nextTree());
				}
				stream_expression.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprs"


	public static class if__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "if_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:1: if_ : 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) ;
	public final whileParser.if__return if_() throws RecognitionException {
		whileParser.if__return retval = new whileParser.if__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal37=null;
		Token string_literal39=null;
		Token string_literal41=null;
		Token string_literal43=null;
		ParserRuleReturnScope expression38 =null;
		ParserRuleReturnScope then_40 =null;
		ParserRuleReturnScope then_42 =null;

		Object string_literal37_tree=null;
		Object string_literal39_tree=null;
		Object string_literal41_tree=null;
		Object string_literal43_tree=null;
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_then_=new RewriteRuleSubtreeStream(adaptor,"rule then_");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:8: ( 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:13: 'if' expression 'then' then_ ( 'else' then_ )? 'fi'
			{
			string_literal37=(Token)match(input,46,FOLLOW_46_in_if_541);  
			stream_46.add(string_literal37);

			pushFollow(FOLLOW_expression_in_if_542);
			expression38=expression();
			state._fsp--;

			stream_expression.add(expression38.getTree());
			string_literal39=(Token)match(input,53,FOLLOW_53_in_if_543);  
			stream_53.add(string_literal39);

			pushFollow(FOLLOW_then__in_if_544);
			then_40=then_();
			state._fsp--;

			stream_then_.add(then_40.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:39: ( 'else' then_ )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==40) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:40: 'else' then_
					{
					string_literal41=(Token)match(input,40,FOLLOW_40_in_if_547);  
					stream_40.add(string_literal41);

					pushFollow(FOLLOW_then__in_if_548);
					then_42=then_();
					state._fsp--;

					stream_then_.add(then_42.getTree());
					}
					break;

			}

			string_literal43=(Token)match(input,41,FOLLOW_41_in_if_551);  
			stream_41.add(string_literal43);

			// AST REWRITE
			// elements: expression, then_
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 64:57: -> ^( IF expression ( then_ )+ )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:60: ^( IF expression ( then_ )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				if ( !(stream_then_.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_then_.hasNext() ) {
					adaptor.addChild(root_1, stream_then_.nextTree());
				}
				stream_then_.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_"


	public static class then__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "then_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:1: then_ : commands -> ^( COMMANDS commands ) ;
	public final whileParser.then__return then_() throws RecognitionException {
		whileParser.then__return retval = new whileParser.then__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope commands44 =null;

		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:11: ( commands -> ^( COMMANDS commands ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:16: commands
			{
			pushFollow(FOLLOW_commands_in_then_576);
			commands44=commands();
			state._fsp--;

			stream_commands.add(commands44.getTree());
			// AST REWRITE
			// elements: commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 65:25: -> ^( COMMANDS commands )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:28: ^( COMMANDS commands )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_1);
				adaptor.addChild(root_1, stream_commands.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "then_"


	public static class while__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "while_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:1: while_ : 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) ;
	public final whileParser.while__return while_() throws RecognitionException {
		whileParser.while__return retval = new whileParser.while__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal45=null;
		Token string_literal47=null;
		Token string_literal49=null;
		ParserRuleReturnScope expression46 =null;
		ParserRuleReturnScope commands48 =null;

		Object string_literal45_tree=null;
		Object string_literal47_tree=null;
		Object string_literal49_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:8: ( 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:10: 'while' expression 'do' commands 'od'
			{
			string_literal45=(Token)match(input,55,FOLLOW_55_in_while_591);  
			stream_55.add(string_literal45);

			pushFollow(FOLLOW_expression_in_while_592);
			expression46=expression();
			state._fsp--;

			stream_expression.add(expression46.getTree());
			string_literal47=(Token)match(input,39,FOLLOW_39_in_while_593);  
			stream_39.add(string_literal47);

			pushFollow(FOLLOW_commands_in_while_594);
			commands48=commands();
			state._fsp--;

			stream_commands.add(commands48.getTree());
			string_literal49=(Token)match(input,51,FOLLOW_51_in_while_595);  
			stream_51.add(string_literal49);

			// AST REWRITE
			// elements: commands, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 66:44: -> ^( WHILE expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:47: ^( WHILE expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:66: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "while_"


	public static class for__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "for_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:1: for_ : 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) ;
	public final whileParser.for__return for_() throws RecognitionException {
		whileParser.for__return retval = new whileParser.for__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal50=null;
		Token string_literal52=null;
		Token string_literal54=null;
		ParserRuleReturnScope expression51 =null;
		ParserRuleReturnScope commands53 =null;

		Object string_literal50_tree=null;
		Object string_literal52_tree=null;
		Object string_literal54_tree=null;
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:6: ( 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:8: 'for' expression 'do' commands 'od'
			{
			string_literal50=(Token)match(input,42,FOLLOW_42_in_for_616);  
			stream_42.add(string_literal50);

			pushFollow(FOLLOW_expression_in_for_617);
			expression51=expression();
			state._fsp--;

			stream_expression.add(expression51.getTree());
			string_literal52=(Token)match(input,39,FOLLOW_39_in_for_618);  
			stream_39.add(string_literal52);

			pushFollow(FOLLOW_commands_in_for_619);
			commands53=commands();
			state._fsp--;

			stream_commands.add(commands53.getTree());
			string_literal54=(Token)match(input,51,FOLLOW_51_in_for_620);  
			stream_51.add(string_literal54);

			// AST REWRITE
			// elements: commands, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 67:40: -> ^( FOR expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:43: ^( FOR expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:60: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "for_"


	public static class foreach__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "foreach_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:1: foreach_ : 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) ;
	public final whileParser.foreach__return foreach_() throws RecognitionException {
		whileParser.foreach__return retval = new whileParser.foreach__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token string_literal55=null;
		Token string_literal56=null;
		Token string_literal58=null;
		Token string_literal60=null;
		ParserRuleReturnScope expression57 =null;
		ParserRuleReturnScope commands59 =null;

		Object i_tree=null;
		Object string_literal55_tree=null;
		Object string_literal56_tree=null;
		Object string_literal58_tree=null;
		Object string_literal60_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:10: ( 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:12: 'foreach' i= Variable 'in' expression 'do' commands 'od'
			{
			string_literal55=(Token)match(input,43,FOLLOW_43_in_foreach_641);  
			stream_43.add(string_literal55);

			i=(Token)match(input,Variable,FOLLOW_Variable_in_foreach_647);  
			stream_Variable.add(i);

			string_literal56=(Token)match(input,47,FOLLOW_47_in_foreach_648);  
			stream_47.add(string_literal56);

			pushFollow(FOLLOW_expression_in_foreach_649);
			expression57=expression();
			state._fsp--;

			stream_expression.add(expression57.getTree());
			string_literal58=(Token)match(input,39,FOLLOW_39_in_foreach_650);  
			stream_39.add(string_literal58);

			pushFollow(FOLLOW_commands_in_foreach_651);
			commands59=commands();
			state._fsp--;

			stream_commands.add(commands59.getTree());
			string_literal60=(Token)match(input,51,FOLLOW_51_in_foreach_652);  
			stream_51.add(string_literal60);

			// AST REWRITE
			// elements: expression, i, commands
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 68:65: -> ^( FOREACH $i expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:68: ^( FOREACH $i expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:92: ^( COMMANDS commands )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				adaptor.addChild(root_2, stream_commands.nextTree());
				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "foreach_"


	public static class exprbase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprbase"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:69:1: exprbase : ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) );
	public final whileParser.exprbase_return exprbase() throws RecognitionException {
		whileParser.exprbase_return retval = new whileParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;
		Token set61=null;
		Token char_literal62=null;
		Token string_literal63=null;
		Token char_literal65=null;
		Token char_literal66=null;
		Token string_literal67=null;
		Token char_literal69=null;
		Token char_literal70=null;
		Token string_literal71=null;
		Token char_literal73=null;
		Token char_literal74=null;
		Token string_literal75=null;
		Token char_literal77=null;
		Token char_literal78=null;
		Token char_literal80=null;
		ParserRuleReturnScope lexpr64 =null;
		ParserRuleReturnScope lexpr68 =null;
		ParserRuleReturnScope exprbase72 =null;
		ParserRuleReturnScope exprbase76 =null;
		ParserRuleReturnScope lexpr79 =null;

		Object s_tree=null;
		Object set61_tree=null;
		Object char_literal62_tree=null;
		Object string_literal63_tree=null;
		Object char_literal65_tree=null;
		Object char_literal66_tree=null;
		Object string_literal67_tree=null;
		Object char_literal69_tree=null;
		Object char_literal70_tree=null;
		Object string_literal71_tree=null;
		Object char_literal73_tree=null;
		Object char_literal74_tree=null;
		Object string_literal75_tree=null;
		Object char_literal77_tree=null;
		Object char_literal78_tree=null;
		Object char_literal80_tree=null;
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:69:9: ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) )
			int alt12=4;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==49) ) {
				alt12=1;
			}
			else if ( (LA12_0==31) ) {
				switch ( input.LA(2) ) {
				case 38:
				case 48:
					{
					alt12=2;
					}
					break;
				case 45:
				case 54:
					{
					alt12=3;
					}
					break;
				case Symbol:
					{
					alt12=4;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:70:2: ( 'nil' | Variable | Symbol )
					{
					root_0 = (Object)adaptor.nil();


					set61=input.LT(1);
					if ( input.LA(1)==Symbol||input.LA(1)==Variable||input.LA(1)==49 ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set61));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==31) ) {
						int LA10_1 = input.LA(2);
						if ( (LA10_1==38) ) {
							alt10=1;
						}
						else if ( (LA10_1==48) ) {
							alt10=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 10, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}

					switch (alt10) {
						case 1 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:5: '(' 'cons' lexpr ')'
							{
							char_literal62=(Token)match(input,31,FOLLOW_31_in_exprbase689);  
							stream_31.add(char_literal62);

							string_literal63=(Token)match(input,38,FOLLOW_38_in_exprbase691);  
							stream_38.add(string_literal63);

							pushFollow(FOLLOW_lexpr_in_exprbase693);
							lexpr64=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr64.getTree());
							char_literal65=(Token)match(input,32,FOLLOW_32_in_exprbase695);  
							stream_32.add(char_literal65);

							// AST REWRITE
							// elements: lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 71:26: -> ^( CONS lexpr )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:29: ^( CONS lexpr )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
								adaptor.addChild(root_1, stream_lexpr.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:45: '(' 'list' lexpr ')'
							{
							char_literal66=(Token)match(input,31,FOLLOW_31_in_exprbase707);  
							stream_31.add(char_literal66);

							string_literal67=(Token)match(input,48,FOLLOW_48_in_exprbase709);  
							stream_48.add(string_literal67);

							pushFollow(FOLLOW_lexpr_in_exprbase711);
							lexpr68=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr68.getTree());
							char_literal69=(Token)match(input,32,FOLLOW_32_in_exprbase713);  
							stream_32.add(char_literal69);

							// AST REWRITE
							// elements: lexpr
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 71:66: -> ^( LIST lexpr )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:71:69: ^( LIST lexpr )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
								adaptor.addChild(root_1, stream_lexpr.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 3 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==31) ) {
						int LA11_1 = input.LA(2);
						if ( (LA11_1==45) ) {
							alt11=1;
						}
						else if ( (LA11_1==54) ) {
							alt11=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 11, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:5: '(' 'hd' exprbase ')'
							{
							char_literal70=(Token)match(input,31,FOLLOW_31_in_exprbase728);  
							stream_31.add(char_literal70);

							string_literal71=(Token)match(input,45,FOLLOW_45_in_exprbase730);  
							stream_45.add(string_literal71);

							pushFollow(FOLLOW_exprbase_in_exprbase732);
							exprbase72=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase72.getTree());
							char_literal73=(Token)match(input,32,FOLLOW_32_in_exprbase734);  
							stream_32.add(char_literal73);

							// AST REWRITE
							// elements: exprbase
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 72:26: -> ^( HD exprbase )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:29: ^( HD exprbase )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HD, "HD"), root_1);
								adaptor.addChild(root_1, stream_exprbase.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:46: '(' 'tl' exprbase ')'
							{
							char_literal74=(Token)match(input,31,FOLLOW_31_in_exprbase745);  
							stream_31.add(char_literal74);

							string_literal75=(Token)match(input,54,FOLLOW_54_in_exprbase747);  
							stream_54.add(string_literal75);

							pushFollow(FOLLOW_exprbase_in_exprbase749);
							exprbase76=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase76.getTree());
							char_literal77=(Token)match(input,32,FOLLOW_32_in_exprbase751);  
							stream_32.add(char_literal77);

							// AST REWRITE
							// elements: exprbase
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 72:68: -> ^( TL exprbase )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:72:71: ^( TL exprbase )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TL, "TL"), root_1);
								adaptor.addChild(root_1, stream_exprbase.nextTree());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 4 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:73:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:73:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:73:5: '(' s= Symbol lexpr ')'
					{
					char_literal78=(Token)match(input,31,FOLLOW_31_in_exprbase766);  
					stream_31.add(char_literal78);

					s=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprbase770);  
					stream_Symbol.add(s);

					pushFollow(FOLLOW_lexpr_in_exprbase772);
					lexpr79=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr79.getTree());
					char_literal80=(Token)match(input,32,FOLLOW_32_in_exprbase774);  
					stream_32.add(char_literal80);

					// AST REWRITE
					// elements: lexpr, s
					// token labels: s
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 73:29: -> ^( SYMBOL $s lexpr )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:73:32: ^( SYMBOL $s lexpr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYMBOL, "SYMBOL"), root_1);
						adaptor.addChild(root_1, stream_s.nextNode());
						adaptor.addChild(root_1, stream_lexpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprbase"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:74:1: expression : exprbase ( '=?' exprbase )* -> ( exprbase )+ ;
	public final whileParser.expression_return expression() throws RecognitionException {
		whileParser.expression_return retval = new whileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal82=null;
		ParserRuleReturnScope exprbase81 =null;
		ParserRuleReturnScope exprbase83 =null;

		Object string_literal82_tree=null;
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:74:12: ( exprbase ( '=?' exprbase )* -> ( exprbase )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:74:15: exprbase ( '=?' exprbase )*
			{
			pushFollow(FOLLOW_exprbase_in_expression795);
			exprbase81=exprbase();
			state._fsp--;

			stream_exprbase.add(exprbase81.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:74:23: ( '=?' exprbase )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==37) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:74:24: '=?' exprbase
					{
					string_literal82=(Token)match(input,37,FOLLOW_37_in_expression797);  
					stream_37.add(string_literal82);

					pushFollow(FOLLOW_exprbase_in_expression799);
					exprbase83=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase83.getTree());
					}
					break;

				default :
					break loop13;
				}
			}

			// AST REWRITE
			// elements: exprbase
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 74:40: -> ( exprbase )+
			{
				if ( !(stream_exprbase.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_exprbase.hasNext() ) {
					adaptor.addChild(root_0, stream_exprbase.nextTree());
				}
				stream_exprbase.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class lexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lexpr"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:1: lexpr : ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) );
	public final whileParser.lexpr_return lexpr() throws RecognitionException {
		whileParser.lexpr_return retval = new whileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprbase84 =null;

		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:7: ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==Symbol||LA15_0==Variable||LA15_0==31||LA15_0==49) ) {
				alt15=1;
			}
			else if ( (LA15_0==32) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:10: ( exprbase )+
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:10: ( exprbase )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==Symbol||LA14_0==Variable||LA14_0==31||LA14_0==49) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:10: exprbase
							{
							pushFollow(FOLLOW_exprbase_in_lexpr814);
							exprbase84=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase84.getTree());
							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
					}

					// AST REWRITE
					// elements: exprbase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 75:20: -> ( exprbase )+
					{
						if ( !(stream_exprbase.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_exprbase.hasNext() ) {
							adaptor.addChild(root_0, stream_exprbase.nextTree());
						}
						stream_exprbase.reset();

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:35: 
					{
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 75:35: -> ^( VIDE )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:75:38: ^( VIDE )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VIDE, "VIDE"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lexpr"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_start_rule83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_program316 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_44_in_function323 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Symbol_in_function329 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_function331 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_definition_in_function332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_definition350 = new BitSet(new long[]{0x0000000048000000L});
	public static final BitSet FOLLOW_input_in_definition352 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_definition354 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_commands_in_definition356 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_definition358 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_definition359 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_output_in_definition360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub407 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_inputSub409 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Variable_in_inputSub410 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_Variable_in_output424 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_output426 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Variable_in_output427 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_command_in_commands446 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_36_in_commands448 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_command_in_commands449 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_50_in_command462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command465 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_command466 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_exprs_in_command467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if__in_command488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while__in_command490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for__in_command492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach__in_command494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars501 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_vars503 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Variable_in_vars504 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_expression_in_exprs518 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_exprs520 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_expression_in_exprs521 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_46_in_if_541 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_expression_in_if_542 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_if_543 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_then__in_if_544 = new BitSet(new long[]{0x0000030000000000L});
	public static final BitSet FOLLOW_40_in_if_547 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_then__in_if_548 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_if_551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_commands_in_then_576 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_while_591 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_expression_in_while_592 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_while_593 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_commands_in_while_594 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_while_595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_for_616 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_expression_in_for_617 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_for_618 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_commands_in_for_619 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_for_620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_foreach_641 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Variable_in_foreach_647 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_foreach_648 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_expression_in_foreach_649 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_foreach_650 = new BitSet(new long[]{0x00844C0008000000L});
	public static final BitSet FOLLOW_commands_in_foreach_651 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_foreach_652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_exprbase677 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_exprbase689 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_38_in_exprbase691 = new BitSet(new long[]{0x0002000188800000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase693 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_exprbase695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_exprbase707 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_exprbase709 = new BitSet(new long[]{0x0002000188800000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase711 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_exprbase713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_exprbase728 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_exprbase730 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase732 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_exprbase734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_exprbase745 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_exprbase747 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase749 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_exprbase751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_exprbase766 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Symbol_in_exprbase770 = new BitSet(new long[]{0x0002000188800000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase772 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_exprbase774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression795 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_expression797 = new BitSet(new long[]{0x0002000088800000L});
	public static final BitSet FOLLOW_exprbase_in_expression799 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr814 = new BitSet(new long[]{0x0002000088800002L});
}
