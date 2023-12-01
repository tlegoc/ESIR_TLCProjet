// $ANTLR 3.5.1 C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g 2023-12-01 08:17:23

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class whileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMANDS", "COMMENT", "CONS", 
		"Dec", "EGALITE", "EXPR", "FOR", "FOREACH", "FUNC", "HD", "IF", "LIST", 
		"Maj", "Min", "OUTPUT", "PARAM", "SYMBOL", "Symbol", "TL", "Variable", 
		"WHILE", "WS", "'%'", "'('", "')'", "','", "':'", "':='", "';'", "'=?'", 
		"'cons'", "'do'", "'else'", "'fi'", "'for'", "'foreach'", "'function'", 
		"'hd'", "'if'", "'in'", "'list'", "'nil'", "'nop'", "'od'", "'read'", 
		"'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
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
	public static final int COMMANDS=4;
	public static final int COMMENT=5;
	public static final int CONS=6;
	public static final int Dec=7;
	public static final int EGALITE=8;
	public static final int EXPR=9;
	public static final int FOR=10;
	public static final int FOREACH=11;
	public static final int FUNC=12;
	public static final int HD=13;
	public static final int IF=14;
	public static final int LIST=15;
	public static final int Maj=16;
	public static final int Min=17;
	public static final int OUTPUT=18;
	public static final int PARAM=19;
	public static final int SYMBOL=20;
	public static final int Symbol=21;
	public static final int TL=22;
	public static final int Variable=23;
	public static final int WHILE=24;
	public static final int WS=25;

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


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:46:1: program : ( function )+ ;
	public final whileParser.program_return program() throws RecognitionException {
		whileParser.program_return retval = new whileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function1 =null;


		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:46:9: ( ( function )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:46:11: ( function )+
			{
			root_0 = (Object)adaptor.nil();


			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:46:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==40) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:46:11: function
					{
					pushFollow(FOLLOW_function_in_program295);
					function1=function();
					state._fsp--;

					adaptor.addChild(root_0, function1.getTree());

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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:47:1: function : 'function' i= Symbol ':' definition -> ^( $i definition ) ;
	public final whileParser.function_return function() throws RecognitionException {
		whileParser.function_return retval = new whileParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token string_literal2=null;
		Token char_literal3=null;
		ParserRuleReturnScope definition4 =null;

		Object i_tree=null;
		Object string_literal2_tree=null;
		Object char_literal3_tree=null;
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:47:9: ( 'function' i= Symbol ':' definition -> ^( $i definition ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:47:11: 'function' i= Symbol ':' definition
			{
			string_literal2=(Token)match(input,40,FOLLOW_40_in_function302);  
			stream_40.add(string_literal2);

			i=(Token)match(input,Symbol,FOLLOW_Symbol_in_function308);  
			stream_Symbol.add(i);

			char_literal3=(Token)match(input,30,FOLLOW_30_in_function310);  
			stream_30.add(char_literal3);

			pushFollow(FOLLOW_definition_in_function311);
			definition4=definition();
			state._fsp--;

			stream_definition.add(definition4.getTree());
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
			// 47:46: -> ^( $i definition )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:47:48: ^( $i definition )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot(stream_i.nextNode(), root_1);
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:48:1: definition : 'read' input '%' commands '%' 'write' output -> ^( FUNC input ^( COMMANDS commands ) output ) ;
	public final whileParser.definition_return definition() throws RecognitionException {
		whileParser.definition_return retval = new whileParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal5=null;
		Token char_literal7=null;
		Token char_literal9=null;
		Token string_literal10=null;
		ParserRuleReturnScope input6 =null;
		ParserRuleReturnScope commands8 =null;
		ParserRuleReturnScope output11 =null;

		Object string_literal5_tree=null;
		Object char_literal7_tree=null;
		Object char_literal9_tree=null;
		Object string_literal10_tree=null;
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:48:13: ( 'read' input '%' commands '%' 'write' output -> ^( FUNC input ^( COMMANDS commands ) output ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:48:16: 'read' input '%' commands '%' 'write' output
			{
			string_literal5=(Token)match(input,48,FOLLOW_48_in_definition327);  
			stream_48.add(string_literal5);

			pushFollow(FOLLOW_input_in_definition329);
			input6=input();
			state._fsp--;

			stream_input.add(input6.getTree());
			char_literal7=(Token)match(input,26,FOLLOW_26_in_definition331);  
			stream_26.add(char_literal7);

			pushFollow(FOLLOW_commands_in_definition333);
			commands8=commands();
			state._fsp--;

			stream_commands.add(commands8.getTree());
			char_literal9=(Token)match(input,26,FOLLOW_26_in_definition335);  
			stream_26.add(char_literal9);

			string_literal10=(Token)match(input,52,FOLLOW_52_in_definition336);  
			stream_52.add(string_literal10);

			pushFollow(FOLLOW_output_in_definition337);
			output11=output();
			state._fsp--;

			stream_output.add(output11.getTree());
			// AST REWRITE
			// elements: output, input, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 48:59: -> ^( FUNC input ^( COMMANDS commands ) output )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:48:62: ^( FUNC input ^( COMMANDS commands ) output )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNC, "FUNC"), root_1);
				adaptor.addChild(root_1, stream_input.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:48:75: ^( COMMANDS commands )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:1: input : ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) );
	public final whileParser.input_return input() throws RecognitionException {
		whileParser.input_return retval = new whileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub12 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:8: ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			else if ( (LA2_0==26) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:10: inputSub
					{
					pushFollow(FOLLOW_inputSub_in_input361);
					inputSub12=inputSub();
					state._fsp--;

					stream_inputSub.add(inputSub12.getTree());
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
					// 49:19: -> ^( PARAM inputSub )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:22: ^( PARAM inputSub )
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
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:41: 
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
					// 49:41: -> ^( PARAM )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:49:44: ^( PARAM )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:51:1: inputSub : Variable ( ',' Variable )* -> ( Variable )+ ;
	public final whileParser.inputSub_return inputSub() throws RecognitionException {
		whileParser.inputSub_return retval = new whileParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable13=null;
		Token char_literal14=null;
		Token Variable15=null;

		Object Variable13_tree=null;
		Object char_literal14_tree=null;
		Object Variable15_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:51:10: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:51:12: Variable ( ',' Variable )*
			{
			Variable13=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub384);  
			stream_Variable.add(Variable13);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:51:20: ( ',' Variable )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==29) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:51:21: ',' Variable
					{
					char_literal14=(Token)match(input,29,FOLLOW_29_in_inputSub386);  
					stream_29.add(char_literal14);

					Variable15=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub387);  
					stream_Variable.add(Variable15);

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
			// 51:34: -> ( Variable )+
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) ;
	public final whileParser.output_return output() throws RecognitionException {
		whileParser.output_return retval = new whileParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable16=null;
		Token char_literal17=null;
		Token Variable18=null;

		Object Variable16_tree=null;
		Object char_literal17_tree=null;
		Object Variable18_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:9: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:11: Variable ( ',' Variable )*
			{
			Variable16=(Token)match(input,Variable,FOLLOW_Variable_in_output401);  
			stream_Variable.add(Variable16);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:19: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==29) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:20: ',' Variable
					{
					char_literal17=(Token)match(input,29,FOLLOW_29_in_output403);  
					stream_29.add(char_literal17);

					Variable18=(Token)match(input,Variable,FOLLOW_Variable_in_output404);  
					stream_Variable.add(Variable18);

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
			// 52:34: -> ^( OUTPUT ( Variable )+ )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:52:37: ^( OUTPUT ( Variable )+ )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:1: commands : command ( ';' command )* -> ( command )+ ;
	public final whileParser.commands_return commands() throws RecognitionException {
		whileParser.commands_return retval = new whileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal20=null;
		ParserRuleReturnScope command19 =null;
		ParserRuleReturnScope command21 =null;

		Object char_literal20_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:10: ( command ( ';' command )* -> ( command )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:13: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands423);
			command19=command();
			state._fsp--;

			stream_command.add(command19.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:20: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==32) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:53:21: ';' command
					{
					char_literal20=(Token)match(input,32,FOLLOW_32_in_commands425);  
					stream_32.add(char_literal20);

					pushFollow(FOLLOW_command_in_commands426);
					command21=command();
					state._fsp--;

					stream_command.add(command21.getTree());
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
			// 53:34: -> ( command )+
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:1: command : ( 'nop' | ( vars ':=' exprs ) -> ^( EGALITE vars exprs ) | if_ | while_ | for_ | foreach_ );
	public final whileParser.command_return command() throws RecognitionException {
		whileParser.command_return retval = new whileParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal22=null;
		Token string_literal24=null;
		ParserRuleReturnScope vars23 =null;
		ParserRuleReturnScope exprs25 =null;
		ParserRuleReturnScope if_26 =null;
		ParserRuleReturnScope while_27 =null;
		ParserRuleReturnScope for_28 =null;
		ParserRuleReturnScope foreach_29 =null;

		Object string_literal22_tree=null;
		Object string_literal24_tree=null;
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:8: ( 'nop' | ( vars ':=' exprs ) -> ^( EGALITE vars exprs ) | if_ | while_ | for_ | foreach_ )
			int alt6=6;
			switch ( input.LA(1) ) {
			case 46:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 42:
				{
				alt6=3;
				}
				break;
			case 51:
				{
				alt6=4;
				}
				break;
			case 38:
				{
				alt6=5;
				}
				break;
			case 39:
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
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:10: 'nop'
					{
					root_0 = (Object)adaptor.nil();


					string_literal22=(Token)match(input,46,FOLLOW_46_in_command439); 
					string_literal22_tree = (Object)adaptor.create(string_literal22);
					adaptor.addChild(root_0, string_literal22_tree);

					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:16: ( vars ':=' exprs )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:16: ( vars ':=' exprs )
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:17: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command442);
					vars23=vars();
					state._fsp--;

					stream_vars.add(vars23.getTree());
					string_literal24=(Token)match(input,31,FOLLOW_31_in_command443);  
					stream_31.add(string_literal24);

					pushFollow(FOLLOW_exprs_in_command444);
					exprs25=exprs();
					state._fsp--;

					stream_exprs.add(exprs25.getTree());
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
					// 54:32: -> ^( EGALITE vars exprs )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:35: ^( EGALITE vars exprs )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EGALITE, "EGALITE"), root_1);
						adaptor.addChild(root_1, stream_vars.nextTree());
						adaptor.addChild(root_1, stream_exprs.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:57: if_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_if__in_command457);
					if_26=if_();
					state._fsp--;

					adaptor.addChild(root_0, if_26.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:61: while_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_while__in_command459);
					while_27=while_();
					state._fsp--;

					adaptor.addChild(root_0, while_27.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:68: for_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_for__in_command461);
					for_28=for_();
					state._fsp--;

					adaptor.addChild(root_0, for_28.getTree());

					}
					break;
				case 6 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:54:73: foreach_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_foreach__in_command463);
					foreach_29=foreach_();
					state._fsp--;

					adaptor.addChild(root_0, foreach_29.getTree());

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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:1: vars : Variable ( ',' Variable )* -> ( Variable )+ ;
	public final whileParser.vars_return vars() throws RecognitionException {
		whileParser.vars_return retval = new whileParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable30=null;
		Token char_literal31=null;
		Token Variable32=null;

		Object Variable30_tree=null;
		Object char_literal31_tree=null;
		Object Variable32_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:6: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:8: Variable ( ',' Variable )*
			{
			Variable30=(Token)match(input,Variable,FOLLOW_Variable_in_vars470);  
			stream_Variable.add(Variable30);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:16: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==29) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:55:17: ',' Variable
					{
					char_literal31=(Token)match(input,29,FOLLOW_29_in_vars472);  
					stream_29.add(char_literal31);

					Variable32=(Token)match(input,Variable,FOLLOW_Variable_in_vars473);  
					stream_Variable.add(Variable32);

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
			// 55:30: -> ( Variable )+
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:1: exprs : expression ( ',' expression )* -> ( expression )+ ;
	public final whileParser.exprs_return exprs() throws RecognitionException {
		whileParser.exprs_return retval = new whileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal34=null;
		ParserRuleReturnScope expression33 =null;
		ParserRuleReturnScope expression35 =null;

		Object char_literal34_tree=null;
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:7: ( expression ( ',' expression )* -> ( expression )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:9: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs487);
			expression33=expression();
			state._fsp--;

			stream_expression.add(expression33.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:19: ( ',' expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==29) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:57:20: ',' expression
					{
					char_literal34=(Token)match(input,29,FOLLOW_29_in_exprs489);  
					stream_29.add(char_literal34);

					pushFollow(FOLLOW_expression_in_exprs490);
					expression35=expression();
					state._fsp--;

					stream_expression.add(expression35.getTree());
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
			// 57:36: -> ( expression )+
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:1: if_ : 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression ^( COMMANDS ( commands )+ ) ) ;
	public final whileParser.if__return if_() throws RecognitionException {
		whileParser.if__return retval = new whileParser.if__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal36=null;
		Token string_literal38=null;
		Token string_literal40=null;
		Token string_literal42=null;
		ParserRuleReturnScope expression37 =null;
		ParserRuleReturnScope commands39 =null;
		ParserRuleReturnScope commands41 =null;

		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		Object string_literal40_tree=null;
		Object string_literal42_tree=null;
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression ^( COMMANDS ( commands )+ ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
			{
			string_literal36=(Token)match(input,42,FOLLOW_42_in_if_504);  
			stream_42.add(string_literal36);

			pushFollow(FOLLOW_expression_in_if_505);
			expression37=expression();
			state._fsp--;

			stream_expression.add(expression37.getTree());
			string_literal38=(Token)match(input,49,FOLLOW_49_in_if_506);  
			stream_49.add(string_literal38);

			pushFollow(FOLLOW_commands_in_if_507);
			commands39=commands();
			state._fsp--;

			stream_commands.add(commands39.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:36: ( 'else' commands )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==36) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:37: 'else' commands
					{
					string_literal40=(Token)match(input,36,FOLLOW_36_in_if_510);  
					stream_36.add(string_literal40);

					pushFollow(FOLLOW_commands_in_if_511);
					commands41=commands();
					state._fsp--;

					stream_commands.add(commands41.getTree());
					}
					break;

			}

			string_literal42=(Token)match(input,37,FOLLOW_37_in_if_514);  
			stream_37.add(string_literal42);

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
			// 58:57: -> ^( IF expression ^( COMMANDS ( commands )+ ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:60: ^( IF expression ^( COMMANDS ( commands )+ ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:58:76: ^( COMMANDS ( commands )+ )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_2);
				if ( !(stream_commands.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_commands.hasNext() ) {
					adaptor.addChild(root_2, stream_commands.nextTree());
				}
				stream_commands.reset();

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
	// $ANTLR end "if_"


	public static class while__return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "while_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:1: while_ : 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) ;
	public final whileParser.while__return while_() throws RecognitionException {
		whileParser.while__return retval = new whileParser.while__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal43=null;
		Token string_literal45=null;
		Token string_literal47=null;
		ParserRuleReturnScope expression44 =null;
		ParserRuleReturnScope commands46 =null;

		Object string_literal43_tree=null;
		Object string_literal45_tree=null;
		Object string_literal47_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:8: ( 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:10: 'while' expression 'do' commands 'od'
			{
			string_literal43=(Token)match(input,51,FOLLOW_51_in_while_536);  
			stream_51.add(string_literal43);

			pushFollow(FOLLOW_expression_in_while_537);
			expression44=expression();
			state._fsp--;

			stream_expression.add(expression44.getTree());
			string_literal45=(Token)match(input,35,FOLLOW_35_in_while_538);  
			stream_35.add(string_literal45);

			pushFollow(FOLLOW_commands_in_while_539);
			commands46=commands();
			state._fsp--;

			stream_commands.add(commands46.getTree());
			string_literal47=(Token)match(input,47,FOLLOW_47_in_while_540);  
			stream_47.add(string_literal47);

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
			// 59:44: -> ^( WHILE expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:47: ^( WHILE expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:59:66: ^( COMMANDS commands )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:1: for_ : 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) ;
	public final whileParser.for__return for_() throws RecognitionException {
		whileParser.for__return retval = new whileParser.for__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal48=null;
		Token string_literal50=null;
		Token string_literal52=null;
		ParserRuleReturnScope expression49 =null;
		ParserRuleReturnScope commands51 =null;

		Object string_literal48_tree=null;
		Object string_literal50_tree=null;
		Object string_literal52_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:6: ( 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:8: 'for' expression 'do' commands 'od'
			{
			string_literal48=(Token)match(input,38,FOLLOW_38_in_for_561);  
			stream_38.add(string_literal48);

			pushFollow(FOLLOW_expression_in_for_562);
			expression49=expression();
			state._fsp--;

			stream_expression.add(expression49.getTree());
			string_literal50=(Token)match(input,35,FOLLOW_35_in_for_563);  
			stream_35.add(string_literal50);

			pushFollow(FOLLOW_commands_in_for_564);
			commands51=commands();
			state._fsp--;

			stream_commands.add(commands51.getTree());
			string_literal52=(Token)match(input,47,FOLLOW_47_in_for_565);  
			stream_47.add(string_literal52);

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
			// 60:40: -> ^( FOR expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:43: ^( FOR expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:60:60: ^( COMMANDS commands )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:1: foreach_ : 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) ;
	public final whileParser.foreach__return foreach_() throws RecognitionException {
		whileParser.foreach__return retval = new whileParser.foreach__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token string_literal53=null;
		Token string_literal54=null;
		Token string_literal56=null;
		Token string_literal58=null;
		ParserRuleReturnScope expression55 =null;
		ParserRuleReturnScope commands57 =null;

		Object i_tree=null;
		Object string_literal53_tree=null;
		Object string_literal54_tree=null;
		Object string_literal56_tree=null;
		Object string_literal58_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:10: ( 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:12: 'foreach' i= Variable 'in' expression 'do' commands 'od'
			{
			string_literal53=(Token)match(input,39,FOLLOW_39_in_foreach_586);  
			stream_39.add(string_literal53);

			i=(Token)match(input,Variable,FOLLOW_Variable_in_foreach_592);  
			stream_Variable.add(i);

			string_literal54=(Token)match(input,43,FOLLOW_43_in_foreach_593);  
			stream_43.add(string_literal54);

			pushFollow(FOLLOW_expression_in_foreach_594);
			expression55=expression();
			state._fsp--;

			stream_expression.add(expression55.getTree());
			string_literal56=(Token)match(input,35,FOLLOW_35_in_foreach_595);  
			stream_35.add(string_literal56);

			pushFollow(FOLLOW_commands_in_foreach_596);
			commands57=commands();
			state._fsp--;

			stream_commands.add(commands57.getTree());
			string_literal58=(Token)match(input,47,FOLLOW_47_in_foreach_597);  
			stream_47.add(string_literal58);

			// AST REWRITE
			// elements: commands, i, expression
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 61:65: -> ^( FOREACH $i expression ^( COMMANDS commands ) )
			{
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:68: ^( FOREACH $i expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:61:92: ^( COMMANDS commands )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:62:1: exprbase : ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) );
	public final whileParser.exprbase_return exprbase() throws RecognitionException {
		whileParser.exprbase_return retval = new whileParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;
		Token set59=null;
		Token char_literal60=null;
		Token string_literal61=null;
		Token char_literal63=null;
		Token char_literal64=null;
		Token string_literal65=null;
		Token char_literal67=null;
		Token char_literal68=null;
		Token string_literal69=null;
		Token char_literal71=null;
		Token char_literal72=null;
		Token string_literal73=null;
		Token char_literal75=null;
		Token char_literal76=null;
		Token char_literal78=null;
		ParserRuleReturnScope lexpr62 =null;
		ParserRuleReturnScope lexpr66 =null;
		ParserRuleReturnScope exprbase70 =null;
		ParserRuleReturnScope exprbase74 =null;
		ParserRuleReturnScope lexpr77 =null;

		Object s_tree=null;
		Object set59_tree=null;
		Object char_literal60_tree=null;
		Object string_literal61_tree=null;
		Object char_literal63_tree=null;
		Object char_literal64_tree=null;
		Object string_literal65_tree=null;
		Object char_literal67_tree=null;
		Object char_literal68_tree=null;
		Object string_literal69_tree=null;
		Object char_literal71_tree=null;
		Object char_literal72_tree=null;
		Object string_literal73_tree=null;
		Object char_literal75_tree=null;
		Object char_literal76_tree=null;
		Object char_literal78_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
		RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:62:9: ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) )
			int alt12=4;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==45) ) {
				alt12=1;
			}
			else if ( (LA12_0==27) ) {
				switch ( input.LA(2) ) {
				case 34:
				case 44:
					{
					alt12=2;
					}
					break;
				case 41:
				case 50:
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
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:63:2: ( 'nil' | Variable | Symbol )
					{
					root_0 = (Object)adaptor.nil();


					set59=input.LT(1);
					if ( input.LA(1)==Symbol||input.LA(1)==Variable||input.LA(1)==45 ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set59));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==27) ) {
						int LA10_1 = input.LA(2);
						if ( (LA10_1==34) ) {
							alt10=1;
						}
						else if ( (LA10_1==44) ) {
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
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:5: '(' 'cons' lexpr ')'
							{
							char_literal60=(Token)match(input,27,FOLLOW_27_in_exprbase634);  
							stream_27.add(char_literal60);

							string_literal61=(Token)match(input,34,FOLLOW_34_in_exprbase636);  
							stream_34.add(string_literal61);

							pushFollow(FOLLOW_lexpr_in_exprbase638);
							lexpr62=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr62.getTree());
							char_literal63=(Token)match(input,28,FOLLOW_28_in_exprbase640);  
							stream_28.add(char_literal63);

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
							// 64:26: -> ^( CONS lexpr )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:29: ^( CONS lexpr )
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
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:45: '(' 'list' lexpr ')'
							{
							char_literal64=(Token)match(input,27,FOLLOW_27_in_exprbase652);  
							stream_27.add(char_literal64);

							string_literal65=(Token)match(input,44,FOLLOW_44_in_exprbase654);  
							stream_44.add(string_literal65);

							pushFollow(FOLLOW_lexpr_in_exprbase656);
							lexpr66=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr66.getTree());
							char_literal67=(Token)match(input,28,FOLLOW_28_in_exprbase658);  
							stream_28.add(char_literal67);

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
							// 64:66: -> ^( LIST lexpr )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:64:69: ^( LIST lexpr )
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
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==27) ) {
						int LA11_1 = input.LA(2);
						if ( (LA11_1==41) ) {
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
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:5: '(' 'hd' exprbase ')'
							{
							char_literal68=(Token)match(input,27,FOLLOW_27_in_exprbase673);  
							stream_27.add(char_literal68);

							string_literal69=(Token)match(input,41,FOLLOW_41_in_exprbase675);  
							stream_41.add(string_literal69);

							pushFollow(FOLLOW_exprbase_in_exprbase677);
							exprbase70=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase70.getTree());
							char_literal71=(Token)match(input,28,FOLLOW_28_in_exprbase679);  
							stream_28.add(char_literal71);

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
							// 65:26: -> ^( HD exprbase )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:29: ^( HD exprbase )
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
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:46: '(' 'tl' exprbase ')'
							{
							char_literal72=(Token)match(input,27,FOLLOW_27_in_exprbase690);  
							stream_27.add(char_literal72);

							string_literal73=(Token)match(input,50,FOLLOW_50_in_exprbase692);  
							stream_50.add(string_literal73);

							pushFollow(FOLLOW_exprbase_in_exprbase694);
							exprbase74=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase74.getTree());
							char_literal75=(Token)match(input,28,FOLLOW_28_in_exprbase696);  
							stream_28.add(char_literal75);

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
							// 65:68: -> ^( TL exprbase )
							{
								// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:65:71: ^( TL exprbase )
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
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:5: '(' s= Symbol lexpr ')'
					{
					char_literal76=(Token)match(input,27,FOLLOW_27_in_exprbase711);  
					stream_27.add(char_literal76);

					s=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprbase715);  
					stream_Symbol.add(s);

					pushFollow(FOLLOW_lexpr_in_exprbase717);
					lexpr77=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr77.getTree());
					char_literal78=(Token)match(input,28,FOLLOW_28_in_exprbase719);  
					stream_28.add(char_literal78);

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
					// 66:29: -> ^( SYMBOL $s lexpr )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:66:32: ^( SYMBOL $s lexpr )
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:1: expression : exprbase ( '=?' exprbase )* -> ( exprbase )+ ;
	public final whileParser.expression_return expression() throws RecognitionException {
		whileParser.expression_return retval = new whileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal80=null;
		ParserRuleReturnScope exprbase79 =null;
		ParserRuleReturnScope exprbase81 =null;

		Object string_literal80_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:12: ( exprbase ( '=?' exprbase )* -> ( exprbase )+ )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:15: exprbase ( '=?' exprbase )*
			{
			pushFollow(FOLLOW_exprbase_in_expression740);
			exprbase79=exprbase();
			state._fsp--;

			stream_exprbase.add(exprbase79.getTree());
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:23: ( '=?' exprbase )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==33) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:67:24: '=?' exprbase
					{
					string_literal80=(Token)match(input,33,FOLLOW_33_in_expression742);  
					stream_33.add(string_literal80);

					pushFollow(FOLLOW_exprbase_in_expression744);
					exprbase81=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase81.getTree());
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
			// 67:40: -> ( exprbase )+
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
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:1: lexpr : ( ( exprbase )+ -> ^( EXPR ( exprbase )+ ) | -> ^( EXPR ) );
	public final whileParser.lexpr_return lexpr() throws RecognitionException {
		whileParser.lexpr_return retval = new whileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprbase82 =null;

		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:7: ( ( exprbase )+ -> ^( EXPR ( exprbase )+ ) | -> ^( EXPR ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==Symbol||LA15_0==Variable||LA15_0==27||LA15_0==45) ) {
				alt15=1;
			}
			else if ( (LA15_0==28) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:10: ( exprbase )+
					{
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:10: ( exprbase )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==Symbol||LA14_0==Variable||LA14_0==27||LA14_0==45) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:10: exprbase
							{
							pushFollow(FOLLOW_exprbase_in_lexpr759);
							exprbase82=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase82.getTree());
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
					// 68:20: -> ^( EXPR ( exprbase )+ )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:23: ^( EXPR ( exprbase )+ )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_1);
						if ( !(stream_exprbase.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_exprbase.hasNext() ) {
							adaptor.addChild(root_1, stream_exprbase.nextTree());
						}
						stream_exprbase.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:43: 
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
					// 68:43: -> ^( EXPR )
					{
						// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:68:46: ^( EXPR )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_1);
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


	public static class start_rule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "start_rule"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:69:1: start_rule : program ;
	public final whileParser.start_rule_return start_rule() throws RecognitionException {
		whileParser.start_rule_return retval = new whileParser.start_rule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope program83 =null;


		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:69:11: ( program )
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:69:14: program
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_program_in_start_rule784);
			program83=program();
			state._fsp--;

			adaptor.addChild(root_0, program83.getTree());

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

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program295 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_40_in_function302 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Symbol_in_function308 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_function310 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_definition_in_function311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_definition327 = new BitSet(new long[]{0x0000000004800000L});
	public static final BitSet FOLLOW_input_in_definition329 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_definition331 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_definition333 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_definition335 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_definition336 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_output_in_definition337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub384 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_inputSub386 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_inputSub387 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_Variable_in_output401 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_output403 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_output404 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_command_in_commands423 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_commands425 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_command_in_commands426 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_46_in_command439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command442 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_command443 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_exprs_in_command444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if__in_command457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while__in_command459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for__in_command461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach__in_command463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars470 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_vars472 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_vars473 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_expression_in_exprs487 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_exprs489 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_expression_in_exprs490 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_42_in_if_504 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_expression_in_if_505 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_if_506 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_if_507 = new BitSet(new long[]{0x0000003000000000L});
	public static final BitSet FOLLOW_36_in_if_510 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_if_511 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_if_514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_while_536 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_expression_in_while_537 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_while_538 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_while_539 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_while_540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_for_561 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_expression_in_for_562 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_for_563 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_for_564 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_for_565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_foreach_586 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_foreach_592 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_foreach_593 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_expression_in_foreach_594 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_foreach_595 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_foreach_596 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_foreach_597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_exprbase622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprbase634 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase636 = new BitSet(new long[]{0x0000200018A00000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase638 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprbase652 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_exprbase654 = new BitSet(new long[]{0x0000200018A00000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase656 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprbase673 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprbase675 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase677 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprbase690 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_exprbase692 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase694 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprbase711 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Symbol_in_exprbase715 = new BitSet(new long[]{0x0000200018A00000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase717 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression740 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_expression742 = new BitSet(new long[]{0x0000200008A00000L});
	public static final BitSet FOLLOW_exprbase_in_expression744 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr759 = new BitSet(new long[]{0x0000200008A00002L});
	public static final BitSet FOLLOW_program_in_start_rule784 = new BitSet(new long[]{0x0000000000000002L});
}
