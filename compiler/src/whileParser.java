// $ANTLR 3.5.1 C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g 2024-01-11 08:41:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class whileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "ASSIGN_EXPR", "ASSIGN_VARS", 
		"BODY", "CALL", "COMMANDS", "COMMENT", "CONS", "Dec", "FOR", "FOREACH", 
		"FUNC", "HD", "IF", "LIST", "Maj", "Min", "OUTPUT", "PARAM", "SYMBOL", 
		"Symbol", "THEN", "TL", "VARIABLE", "VIDE", "Variable", "WHILE", "WS", 
		"'%'", "'('", "')'", "','", "':'", "':='", "';'", "'=?'", "'cons'", "'do'", 
		"'else'", "'fi'", "'for'", "'foreach'", "'function'", "'hd'", "'if'", 
		"'in'", "'list'", "'nil'", "'nop'", "'od'", "'read'", "'then'", "'tl'", 
		"'while'", "'write'"
	};
	public static final int EOF=-1;
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
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int ASSIGN=4;
	public static final int ASSIGN_EXPR=5;
	public static final int ASSIGN_VARS=6;
	public static final int BODY=7;
	public static final int CALL=8;
	public static final int COMMANDS=9;
	public static final int COMMENT=10;
	public static final int CONS=11;
	public static final int Dec=12;
	public static final int FOR=13;
	public static final int FOREACH=14;
	public static final int FUNC=15;
	public static final int HD=16;
	public static final int IF=17;
	public static final int LIST=18;
	public static final int Maj=19;
	public static final int Min=20;
	public static final int OUTPUT=21;
	public static final int PARAM=22;
	public static final int SYMBOL=23;
	public static final int Symbol=24;
	public static final int THEN=25;
	public static final int TL=26;
	public static final int VARIABLE=27;
	public static final int VIDE=28;
	public static final int Variable=29;
	public static final int WHILE=30;
	public static final int WS=31;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g"; }


	public static class start_rule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "start_rule"
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:30:1: start_rule : program ;
	public final whileParser.start_rule_return start_rule() throws RecognitionException {
		whileParser.start_rule_return retval = new whileParser.start_rule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope program1 =null;


		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:30:11: ( program )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:30:14: program
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_program_in_start_rule89);
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:54:1: program : ( function )+ ;
	public final whileParser.program_return program() throws RecognitionException {
		whileParser.program_return retval = new whileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function2 =null;


		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:54:9: ( ( function )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:54:11: ( function )+
			{
			root_0 = (Object)adaptor.nil();


			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:54:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==46) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:54:11: function
					{
					pushFollow(FOLLOW_function_in_program323);
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:55:1: function : 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) ;
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
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:55:9: ( 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:55:11: 'function' i= Symbol ':' definition
			{
			string_literal3=(Token)match(input,46,FOLLOW_46_in_function330);  
			stream_46.add(string_literal3);

			i=(Token)match(input,Symbol,FOLLOW_Symbol_in_function336);  
			stream_Symbol.add(i);

			char_literal4=(Token)match(input,36,FOLLOW_36_in_function338);  
			stream_36.add(char_literal4);

			pushFollow(FOLLOW_definition_in_function339);
			definition5=definition();
			state._fsp--;

			stream_definition.add(definition5.getTree());
			// AST REWRITE
			// elements: i, definition
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 55:46: -> ^( FUNC $i definition )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:55:48: ^( FUNC $i definition )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:56:1: definition : 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) ;
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
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:56:13: ( 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:56:16: 'read' input '%' commands '%' 'write' output
			{
			string_literal6=(Token)match(input,54,FOLLOW_54_in_definition357);  
			stream_54.add(string_literal6);

			pushFollow(FOLLOW_input_in_definition359);
			input7=input();
			state._fsp--;

			stream_input.add(input7.getTree());
			char_literal8=(Token)match(input,32,FOLLOW_32_in_definition361);  
			stream_32.add(char_literal8);

			pushFollow(FOLLOW_commands_in_definition363);
			commands9=commands();
			state._fsp--;

			stream_commands.add(commands9.getTree());
			char_literal10=(Token)match(input,32,FOLLOW_32_in_definition365);  
			stream_32.add(char_literal10);

			string_literal11=(Token)match(input,58,FOLLOW_58_in_definition366);  
			stream_58.add(string_literal11);

			pushFollow(FOLLOW_output_in_definition367);
			output12=output();
			state._fsp--;

			stream_output.add(output12.getTree());
			// AST REWRITE
			// elements: commands, input, output
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 56:59: -> ^( BODY input ^( COMMANDS commands ) output )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:56:62: ^( BODY input ^( COMMANDS commands ) output )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);
				adaptor.addChild(root_1, stream_input.nextTree());
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:56:75: ^( COMMANDS commands )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:1: input : ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) );
	public final whileParser.input_return input() throws RecognitionException {
		whileParser.input_return retval = new whileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub13 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:8: ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			else if ( (LA2_0==32) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:10: inputSub
					{
					pushFollow(FOLLOW_inputSub_in_input391);
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
					// 57:19: -> ^( PARAM inputSub )
					{
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:22: ^( PARAM inputSub )
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:41: 
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
					// 57:41: -> ^( PARAM )
					{
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:57:44: ^( PARAM )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:59:1: inputSub : Variable ( ',' Variable )* -> ( Variable )+ ;
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
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:59:10: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:59:12: Variable ( ',' Variable )*
			{
			Variable14=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub414);  
			stream_Variable.add(Variable14);

			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:59:20: ( ',' Variable )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==35) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:59:21: ',' Variable
					{
					char_literal15=(Token)match(input,35,FOLLOW_35_in_inputSub416);  
					stream_35.add(char_literal15);

					Variable16=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub417);  
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
			// 59:34: -> ( Variable )+
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) ;
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
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:9: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:11: Variable ( ',' Variable )*
			{
			Variable17=(Token)match(input,Variable,FOLLOW_Variable_in_output431);  
			stream_Variable.add(Variable17);

			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:19: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==35) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:20: ',' Variable
					{
					char_literal18=(Token)match(input,35,FOLLOW_35_in_output433);  
					stream_35.add(char_literal18);

					Variable19=(Token)match(input,Variable,FOLLOW_Variable_in_output434);  
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
			// 60:34: -> ^( OUTPUT ( Variable )+ )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:60:37: ^( OUTPUT ( Variable )+ )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:61:1: commands : command ( ';' command )* -> ( command )+ ;
	public final whileParser.commands_return commands() throws RecognitionException {
		whileParser.commands_return retval = new whileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal21=null;
		ParserRuleReturnScope command20 =null;
		ParserRuleReturnScope command22 =null;

		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:61:10: ( command ( ';' command )* -> ( command )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:61:13: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands453);
			command20=command();
			state._fsp--;

			stream_command.add(command20.getTree());
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:61:20: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==38) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:61:21: ';' command
					{
					char_literal21=(Token)match(input,38,FOLLOW_38_in_commands455);  
					stream_38.add(char_literal21);

					pushFollow(FOLLOW_command_in_commands456);
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
			// 61:34: -> ( command )+
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:1: command : ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) ) | if_ | while_ | for_ | foreach_ );
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
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:8: ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) ) | if_ | while_ | for_ | foreach_ )
			int alt6=6;
			switch ( input.LA(1) ) {
			case 52:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 48:
				{
				alt6=3;
				}
				break;
			case 57:
				{
				alt6=4;
				}
				break;
			case 44:
				{
				alt6=5;
				}
				break;
			case 45:
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:10: 'nop'
					{
					root_0 = (Object)adaptor.nil();


					string_literal23=(Token)match(input,52,FOLLOW_52_in_command469); 
					string_literal23_tree = (Object)adaptor.create(string_literal23);
					adaptor.addChild(root_0, string_literal23_tree);

					}
					break;
				case 2 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:16: ( vars ':=' exprs )
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:16: ( vars ':=' exprs )
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:17: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command472);
					vars24=vars();
					state._fsp--;

					stream_vars.add(vars24.getTree());
					string_literal25=(Token)match(input,37,FOLLOW_37_in_command473);  
					stream_37.add(string_literal25);

					pushFollow(FOLLOW_exprs_in_command474);
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
					// 62:32: -> ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) )
					{
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:35: ^( ASSIGN ^( ASSIGN_VARS vars ) ^( ASSIGN_EXPR exprs ) )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:44: ^( ASSIGN_VARS vars )
						{
						Object root_2 = (Object)adaptor.nil();
						root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN_VARS, "ASSIGN_VARS"), root_2);
						adaptor.addChild(root_2, stream_vars.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:64: ^( ASSIGN_EXPR exprs )
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:86: if_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_if__in_command495);
					if_27=if_();
					state._fsp--;

					adaptor.addChild(root_0, if_27.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:90: while_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_while__in_command497);
					while_28=while_();
					state._fsp--;

					adaptor.addChild(root_0, while_28.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:97: for_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_for__in_command499);
					for_29=for_();
					state._fsp--;

					adaptor.addChild(root_0, for_29.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:62:102: foreach_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_foreach__in_command501);
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:63:1: vars : Variable ( ',' Variable )* -> ( Variable )+ ;
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
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:63:6: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:63:8: Variable ( ',' Variable )*
			{
			Variable31=(Token)match(input,Variable,FOLLOW_Variable_in_vars508);  
			stream_Variable.add(Variable31);

			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:63:16: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==35) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:63:17: ',' Variable
					{
					char_literal32=(Token)match(input,35,FOLLOW_35_in_vars510);  
					stream_35.add(char_literal32);

					Variable33=(Token)match(input,Variable,FOLLOW_Variable_in_vars511);  
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
			// 63:30: -> ( Variable )+
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:65:1: exprs : expression ( ',' expression )* -> ( expression )+ ;
	public final whileParser.exprs_return exprs() throws RecognitionException {
		whileParser.exprs_return retval = new whileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal35=null;
		ParserRuleReturnScope expression34 =null;
		ParserRuleReturnScope expression36 =null;

		Object char_literal35_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:65:7: ( expression ( ',' expression )* -> ( expression )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:65:9: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs525);
			expression34=expression();
			state._fsp--;

			stream_expression.add(expression34.getTree());
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:65:19: ( ',' expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==35) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:65:20: ',' expression
					{
					char_literal35=(Token)match(input,35,FOLLOW_35_in_exprs527);  
					stream_35.add(char_literal35);

					pushFollow(FOLLOW_expression_in_exprs528);
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
			// 65:36: -> ( expression )+
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:1: if_ : 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) ;
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
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_then_=new RewriteRuleSubtreeStream(adaptor,"rule then_");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:8: ( 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:13: 'if' expression 'then' then_ ( 'else' then_ )? 'fi'
			{
			string_literal37=(Token)match(input,48,FOLLOW_48_in_if_548);  
			stream_48.add(string_literal37);

			pushFollow(FOLLOW_expression_in_if_549);
			expression38=expression();
			state._fsp--;

			stream_expression.add(expression38.getTree());
			string_literal39=(Token)match(input,55,FOLLOW_55_in_if_550);  
			stream_55.add(string_literal39);

			pushFollow(FOLLOW_then__in_if_551);
			then_40=then_();
			state._fsp--;

			stream_then_.add(then_40.getTree());
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:39: ( 'else' then_ )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==42) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:40: 'else' then_
					{
					string_literal41=(Token)match(input,42,FOLLOW_42_in_if_554);  
					stream_42.add(string_literal41);

					pushFollow(FOLLOW_then__in_if_555);
					then_42=then_();
					state._fsp--;

					stream_then_.add(then_42.getTree());
					}
					break;

			}

			string_literal43=(Token)match(input,43,FOLLOW_43_in_if_558);  
			stream_43.add(string_literal43);

			// AST REWRITE
			// elements: then_, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 66:57: -> ^( IF expression ( then_ )+ )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:66:60: ^( IF expression ( then_ )+ )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:67:1: then_ : commands -> ^( COMMANDS commands ) ;
	public final whileParser.then__return then_() throws RecognitionException {
		whileParser.then__return retval = new whileParser.then__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope commands44 =null;

		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:67:11: ( commands -> ^( COMMANDS commands ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:67:16: commands
			{
			pushFollow(FOLLOW_commands_in_then_583);
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
			// 67:25: -> ^( COMMANDS commands )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:67:28: ^( COMMANDS commands )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:68:1: while_ : 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) ;
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
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:68:8: ( 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:68:10: 'while' expression 'do' commands 'od'
			{
			string_literal45=(Token)match(input,57,FOLLOW_57_in_while_598);  
			stream_57.add(string_literal45);

			pushFollow(FOLLOW_expression_in_while_599);
			expression46=expression();
			state._fsp--;

			stream_expression.add(expression46.getTree());
			string_literal47=(Token)match(input,41,FOLLOW_41_in_while_600);  
			stream_41.add(string_literal47);

			pushFollow(FOLLOW_commands_in_while_601);
			commands48=commands();
			state._fsp--;

			stream_commands.add(commands48.getTree());
			string_literal49=(Token)match(input,53,FOLLOW_53_in_while_602);  
			stream_53.add(string_literal49);

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
			// 68:44: -> ^( WHILE expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:68:47: ^( WHILE expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:68:66: ^( COMMANDS commands )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:69:1: for_ : 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) ;
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
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:69:6: ( 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:69:8: 'for' expression 'do' commands 'od'
			{
			string_literal50=(Token)match(input,44,FOLLOW_44_in_for_623);  
			stream_44.add(string_literal50);

			pushFollow(FOLLOW_expression_in_for_624);
			expression51=expression();
			state._fsp--;

			stream_expression.add(expression51.getTree());
			string_literal52=(Token)match(input,41,FOLLOW_41_in_for_625);  
			stream_41.add(string_literal52);

			pushFollow(FOLLOW_commands_in_for_626);
			commands53=commands();
			state._fsp--;

			stream_commands.add(commands53.getTree());
			string_literal54=(Token)match(input,53,FOLLOW_53_in_for_627);  
			stream_53.add(string_literal54);

			// AST REWRITE
			// elements: expression, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 69:40: -> ^( FOR expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:69:43: ^( FOR expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:69:60: ^( COMMANDS commands )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:70:1: foreach_ : 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) ;
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
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:70:10: ( 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:70:12: 'foreach' i= Variable 'in' expression 'do' commands 'od'
			{
			string_literal55=(Token)match(input,45,FOLLOW_45_in_foreach_648);  
			stream_45.add(string_literal55);

			i=(Token)match(input,Variable,FOLLOW_Variable_in_foreach_654);  
			stream_Variable.add(i);

			string_literal56=(Token)match(input,49,FOLLOW_49_in_foreach_655);  
			stream_49.add(string_literal56);

			pushFollow(FOLLOW_expression_in_foreach_656);
			expression57=expression();
			state._fsp--;

			stream_expression.add(expression57.getTree());
			string_literal58=(Token)match(input,41,FOLLOW_41_in_foreach_657);  
			stream_41.add(string_literal58);

			pushFollow(FOLLOW_commands_in_foreach_658);
			commands59=commands();
			state._fsp--;

			stream_commands.add(commands59.getTree());
			string_literal60=(Token)match(input,53,FOLLOW_53_in_foreach_659);  
			stream_53.add(string_literal60);

			// AST REWRITE
			// elements: expression, commands, i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 70:65: -> ^( FOREACH $i expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:70:68: ^( FOREACH $i expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:70:92: ^( COMMANDS commands )
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:71:1: exprbase : ( ( 'nil' -> ^( 'nil' ) |v= Variable -> ^( VARIABLE $v) |s= Symbol -> ^( SYMBOL $s) ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( CALL $s lexpr ) ) );
	public final whileParser.exprbase_return exprbase() throws RecognitionException {
		whileParser.exprbase_return retval = new whileParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token v=null;
		Token s=null;
		Token string_literal61=null;
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

		Object v_tree=null;
		Object s_tree=null;
		Object string_literal61_tree=null;
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
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:71:9: ( ( 'nil' -> ^( 'nil' ) |v= Variable -> ^( VARIABLE $v) |s= Symbol -> ^( SYMBOL $s) ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( CALL $s lexpr ) ) )
			int alt13=4;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==Symbol||LA13_0==Variable||LA13_0==51) ) {
				alt13=1;
			}
			else if ( (LA13_0==33) ) {
				switch ( input.LA(2) ) {
				case 40:
				case 50:
					{
					alt13=2;
					}
					break;
				case 47:
				case 56:
					{
					alt13=3;
					}
					break;
				case Symbol:
					{
					alt13=4;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:2: ( 'nil' -> ^( 'nil' ) |v= Variable -> ^( VARIABLE $v) |s= Symbol -> ^( SYMBOL $s) )
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:2: ( 'nil' -> ^( 'nil' ) |v= Variable -> ^( VARIABLE $v) |s= Symbol -> ^( SYMBOL $s) )
					int alt10=3;
					switch ( input.LA(1) ) {
					case 51:
						{
						alt10=1;
						}
						break;
					case Variable:
						{
						alt10=2;
						}
						break;
					case Symbol:
						{
						alt10=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}
					switch (alt10) {
						case 1 :
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:2: 'nil'
							{
							string_literal61=(Token)match(input,51,FOLLOW_51_in_exprbase685);  
							stream_51.add(string_literal61);

							// AST REWRITE
							// elements: 51
							// token labels: 
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 72:8: -> ^( 'nil' )
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:11: ^( 'nil' )
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot(stream_51.nextNode(), root_1);
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 2 :
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:20: v= Variable
							{
							v=(Token)match(input,Variable,FOLLOW_Variable_in_exprbase695);  
							stream_Variable.add(v);

							// AST REWRITE
							// elements: v
							// token labels: v
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleTokenStream stream_v=new RewriteRuleTokenStream(adaptor,"token v",v);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 72:31: -> ^( VARIABLE $v)
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:34: ^( VARIABLE $v)
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARIABLE, "VARIABLE"), root_1);
								adaptor.addChild(root_1, stream_v.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;
						case 3 :
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:49: s= Symbol
							{
							s=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprbase708);  
							stream_Symbol.add(s);

							// AST REWRITE
							// elements: s
							// token labels: s
							// rule labels: retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							retval.tree = root_0;
							RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (Object)adaptor.nil();
							// 72:58: -> ^( SYMBOL $s)
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:72:61: ^( SYMBOL $s)
								{
								Object root_1 = (Object)adaptor.nil();
								root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYMBOL, "SYMBOL"), root_1);
								adaptor.addChild(root_1, stream_s.nextNode());
								adaptor.addChild(root_0, root_1);
								}

							}


							retval.tree = root_0;

							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==33) ) {
						int LA11_1 = input.LA(2);
						if ( (LA11_1==40) ) {
							alt11=1;
						}
						else if ( (LA11_1==50) ) {
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
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:5: '(' 'cons' lexpr ')'
							{
							char_literal62=(Token)match(input,33,FOLLOW_33_in_exprbase724);  
							stream_33.add(char_literal62);

							string_literal63=(Token)match(input,40,FOLLOW_40_in_exprbase726);  
							stream_40.add(string_literal63);

							pushFollow(FOLLOW_lexpr_in_exprbase728);
							lexpr64=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr64.getTree());
							char_literal65=(Token)match(input,34,FOLLOW_34_in_exprbase730);  
							stream_34.add(char_literal65);

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
							// 73:26: -> ^( CONS lexpr )
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:29: ^( CONS lexpr )
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
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:45: '(' 'list' lexpr ')'
							{
							char_literal66=(Token)match(input,33,FOLLOW_33_in_exprbase742);  
							stream_33.add(char_literal66);

							string_literal67=(Token)match(input,50,FOLLOW_50_in_exprbase744);  
							stream_50.add(string_literal67);

							pushFollow(FOLLOW_lexpr_in_exprbase746);
							lexpr68=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr68.getTree());
							char_literal69=(Token)match(input,34,FOLLOW_34_in_exprbase748);  
							stream_34.add(char_literal69);

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
							// 73:66: -> ^( LIST lexpr )
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:73:69: ^( LIST lexpr )
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==33) ) {
						int LA12_1 = input.LA(2);
						if ( (LA12_1==47) ) {
							alt12=1;
						}
						else if ( (LA12_1==56) ) {
							alt12=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 12, 1, input);
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
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:5: '(' 'hd' exprbase ')'
							{
							char_literal70=(Token)match(input,33,FOLLOW_33_in_exprbase763);  
							stream_33.add(char_literal70);

							string_literal71=(Token)match(input,47,FOLLOW_47_in_exprbase765);  
							stream_47.add(string_literal71);

							pushFollow(FOLLOW_exprbase_in_exprbase767);
							exprbase72=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase72.getTree());
							char_literal73=(Token)match(input,34,FOLLOW_34_in_exprbase769);  
							stream_34.add(char_literal73);

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
							// 74:26: -> ^( HD exprbase )
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:29: ^( HD exprbase )
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
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:46: '(' 'tl' exprbase ')'
							{
							char_literal74=(Token)match(input,33,FOLLOW_33_in_exprbase780);  
							stream_33.add(char_literal74);

							string_literal75=(Token)match(input,56,FOLLOW_56_in_exprbase782);  
							stream_56.add(string_literal75);

							pushFollow(FOLLOW_exprbase_in_exprbase784);
							exprbase76=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase76.getTree());
							char_literal77=(Token)match(input,34,FOLLOW_34_in_exprbase786);  
							stream_34.add(char_literal77);

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
							// 74:68: -> ^( TL exprbase )
							{
								// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:74:71: ^( TL exprbase )
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:75:4: ( '(' s= Symbol lexpr ')' -> ^( CALL $s lexpr ) )
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:75:4: ( '(' s= Symbol lexpr ')' -> ^( CALL $s lexpr ) )
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:75:5: '(' s= Symbol lexpr ')'
					{
					char_literal78=(Token)match(input,33,FOLLOW_33_in_exprbase801);  
					stream_33.add(char_literal78);

					s=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprbase805);  
					stream_Symbol.add(s);

					pushFollow(FOLLOW_lexpr_in_exprbase807);
					lexpr79=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr79.getTree());
					char_literal80=(Token)match(input,34,FOLLOW_34_in_exprbase809);  
					stream_34.add(char_literal80);

					// AST REWRITE
					// elements: s, lexpr
					// token labels: s
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 75:29: -> ^( CALL $s lexpr )
					{
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:75:32: ^( CALL $s lexpr )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:76:1: expression : exprbase ( '=?' exprbase )* -> ( exprbase )+ ;
	public final whileParser.expression_return expression() throws RecognitionException {
		whileParser.expression_return retval = new whileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal82=null;
		ParserRuleReturnScope exprbase81 =null;
		ParserRuleReturnScope exprbase83 =null;

		Object string_literal82_tree=null;
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:76:12: ( exprbase ( '=?' exprbase )* -> ( exprbase )+ )
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:76:15: exprbase ( '=?' exprbase )*
			{
			pushFollow(FOLLOW_exprbase_in_expression830);
			exprbase81=exprbase();
			state._fsp--;

			stream_exprbase.add(exprbase81.getTree());
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:76:23: ( '=?' exprbase )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==39) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:76:24: '=?' exprbase
					{
					string_literal82=(Token)match(input,39,FOLLOW_39_in_expression832);  
					stream_39.add(string_literal82);

					pushFollow(FOLLOW_exprbase_in_expression834);
					exprbase83=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase83.getTree());
					}
					break;

				default :
					break loop14;
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
			// 76:40: -> ( exprbase )+
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
	// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:1: lexpr : ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) );
	public final whileParser.lexpr_return lexpr() throws RecognitionException {
		whileParser.lexpr_return retval = new whileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprbase84 =null;

		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:7: ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==Symbol||LA16_0==Variable||LA16_0==33||LA16_0==51) ) {
				alt16=1;
			}
			else if ( (LA16_0==34) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:10: ( exprbase )+
					{
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:10: ( exprbase )+
					int cnt15=0;
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==Symbol||LA15_0==Variable||LA15_0==33||LA15_0==51) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:10: exprbase
							{
							pushFollow(FOLLOW_exprbase_in_lexpr849);
							exprbase84=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase84.getTree());
							}
							break;

						default :
							if ( cnt15 >= 1 ) break loop15;
							EarlyExitException eee = new EarlyExitException(15, input);
							throw eee;
						}
						cnt15++;
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
					// 77:20: -> ( exprbase )+
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
					// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:35: 
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
					// 77:35: -> ^( VIDE )
					{
						// C:\\Users\\Rémi\\Documents\\GitHub\\ESIR_TLCProjet\\grammaire\\while.g:77:38: ^( VIDE )
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



	public static final BitSet FOLLOW_program_in_start_rule89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_program323 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_function330 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_Symbol_in_function336 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_function338 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_definition_in_function339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_definition357 = new BitSet(new long[]{0x0000000120000000L});
	public static final BitSet FOLLOW_input_in_definition359 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_definition361 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_commands_in_definition363 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_definition365 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_58_in_definition366 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_output_in_definition367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub414 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_inputSub416 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Variable_in_inputSub417 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_Variable_in_output431 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_output433 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Variable_in_output434 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_command_in_commands453 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_commands455 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_command_in_commands456 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_52_in_command469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command472 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_command473 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_exprs_in_command474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if__in_command495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while__in_command497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for__in_command499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach__in_command501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars508 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_vars510 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Variable_in_vars511 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_expression_in_exprs525 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_exprs527 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_expression_in_exprs528 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_48_in_if_548 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_expression_in_if_549 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_55_in_if_550 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_then__in_if_551 = new BitSet(new long[]{0x00000C0000000000L});
	public static final BitSet FOLLOW_42_in_if_554 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_then__in_if_555 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_if_558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_commands_in_then_583 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_while_598 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_expression_in_while_599 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_while_600 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_commands_in_while_601 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_while_602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_44_in_for_623 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_expression_in_for_624 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_for_625 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_commands_in_for_626 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_for_627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_foreach_648 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_Variable_in_foreach_654 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_foreach_655 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_expression_in_foreach_656 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_foreach_657 = new BitSet(new long[]{0x0211300020000000L});
	public static final BitSet FOLLOW_commands_in_foreach_658 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_53_in_foreach_659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_exprbase685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprbase695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprbase708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_exprbase724 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_exprbase726 = new BitSet(new long[]{0x0008000621000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase728 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_exprbase742 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_exprbase744 = new BitSet(new long[]{0x0008000621000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase746 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_exprbase763 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_exprbase765 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase767 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_exprbase780 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_exprbase782 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase784 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_exprbase801 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_Symbol_in_exprbase805 = new BitSet(new long[]{0x0008000621000000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase807 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression830 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_39_in_expression832 = new BitSet(new long[]{0x0008000221000000L});
	public static final BitSet FOLLOW_exprbase_in_expression834 = new BitSet(new long[]{0x0000008000000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr849 = new BitSet(new long[]{0x0008000221000002L});
}
