// $ANTLR 3.5.1 C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g 2023-12-05 10:09:43

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class whileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "BODY", "COMMANDS", 
		"COMMENT", "CONS", "Dec", "FOR", "FOREACH", "FUNC", "HD", "IF", "LIST", 
		"Maj", "Min", "OUTPUT", "PARAM", "SYMBOL", "Symbol", "THEN", "TL", "VIDE", 
		"Variable", "WHILE", "WS", "'%'", "'('", "')'", "','", "':'", "':='", 
		"';'", "'=?'", "'cons'", "'do'", "'else'", "'fi'", "'for'", "'foreach'", 
		"'function'", "'hd'", "'if'", "'in'", "'list'", "'nil'", "'nop'", "'od'", 
		"'read'", "'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
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
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int ASSIGN=4;
	public static final int BODY=5;
	public static final int COMMANDS=6;
	public static final int COMMENT=7;
	public static final int CONS=8;
	public static final int Dec=9;
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
	public static final int THEN=22;
	public static final int TL=23;
	public static final int VIDE=24;
	public static final int Variable=25;
	public static final int WHILE=26;
	public static final int WS=27;

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
	@Override public String getGrammarFileName() { return "C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:48:1: program : ( function )+ ;
	public final whileParser.program_return program() throws RecognitionException {
		whileParser.program_return retval = new whileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function1 =null;


		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:48:9: ( ( function )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:48:11: ( function )+
			{
			root_0 = (Object)adaptor.nil();


			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:48:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==42) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:48:11: function
					{
					pushFollow(FOLLOW_function_in_program301);
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:49:1: function : 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) ;
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
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:49:9: ( 'function' i= Symbol ':' definition -> ^( FUNC $i definition ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:49:11: 'function' i= Symbol ':' definition
			{
			string_literal2=(Token)match(input,42,FOLLOW_42_in_function308);  
			stream_42.add(string_literal2);

			i=(Token)match(input,Symbol,FOLLOW_Symbol_in_function314);  
			stream_Symbol.add(i);

			char_literal3=(Token)match(input,32,FOLLOW_32_in_function316);  
			stream_32.add(char_literal3);

			pushFollow(FOLLOW_definition_in_function317);
			definition4=definition();
			state._fsp--;

			stream_definition.add(definition4.getTree());
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
			// 49:46: -> ^( FUNC $i definition )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:49:48: ^( FUNC $i definition )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:50:1: definition : 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) ;
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
		RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:50:13: ( 'read' input '%' commands '%' 'write' output -> ^( BODY input ^( COMMANDS commands ) output ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:50:16: 'read' input '%' commands '%' 'write' output
			{
			string_literal5=(Token)match(input,50,FOLLOW_50_in_definition335);  
			stream_50.add(string_literal5);

			pushFollow(FOLLOW_input_in_definition337);
			input6=input();
			state._fsp--;

			stream_input.add(input6.getTree());
			char_literal7=(Token)match(input,28,FOLLOW_28_in_definition339);  
			stream_28.add(char_literal7);

			pushFollow(FOLLOW_commands_in_definition341);
			commands8=commands();
			state._fsp--;

			stream_commands.add(commands8.getTree());
			char_literal9=(Token)match(input,28,FOLLOW_28_in_definition343);  
			stream_28.add(char_literal9);

			string_literal10=(Token)match(input,54,FOLLOW_54_in_definition344);  
			stream_54.add(string_literal10);

			pushFollow(FOLLOW_output_in_definition345);
			output11=output();
			state._fsp--;

			stream_output.add(output11.getTree());
			// AST REWRITE
			// elements: input, output, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 50:59: -> ^( BODY input ^( COMMANDS commands ) output )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:50:62: ^( BODY input ^( COMMANDS commands ) output )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BODY, "BODY"), root_1);
				adaptor.addChild(root_1, stream_input.nextTree());
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:50:75: ^( COMMANDS commands )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:1: input : ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) );
	public final whileParser.input_return input() throws RecognitionException {
		whileParser.input_return retval = new whileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub12 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:8: ( inputSub -> ^( PARAM inputSub ) | -> ^( PARAM ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			else if ( (LA2_0==28) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:10: inputSub
					{
					pushFollow(FOLLOW_inputSub_in_input369);
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
					// 51:19: -> ^( PARAM inputSub )
					{
						// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:22: ^( PARAM inputSub )
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:41: 
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
					// 51:41: -> ^( PARAM )
					{
						// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:51:44: ^( PARAM )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:53:1: inputSub : Variable ( ',' Variable )* -> ( Variable )+ ;
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
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:53:10: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:53:12: Variable ( ',' Variable )*
			{
			Variable13=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub392);  
			stream_Variable.add(Variable13);

			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:53:20: ( ',' Variable )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==31) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:53:21: ',' Variable
					{
					char_literal14=(Token)match(input,31,FOLLOW_31_in_inputSub394);  
					stream_31.add(char_literal14);

					Variable15=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub395);  
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
			// 53:34: -> ( Variable )+
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) ;
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
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:9: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )+ ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:11: Variable ( ',' Variable )*
			{
			Variable16=(Token)match(input,Variable,FOLLOW_Variable_in_output409);  
			stream_Variable.add(Variable16);

			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:19: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==31) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:20: ',' Variable
					{
					char_literal17=(Token)match(input,31,FOLLOW_31_in_output411);  
					stream_31.add(char_literal17);

					Variable18=(Token)match(input,Variable,FOLLOW_Variable_in_output412);  
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
			// 54:34: -> ^( OUTPUT ( Variable )+ )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:54:37: ^( OUTPUT ( Variable )+ )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:55:1: commands : command ( ';' command )* -> ( command )+ ;
	public final whileParser.commands_return commands() throws RecognitionException {
		whileParser.commands_return retval = new whileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal20=null;
		ParserRuleReturnScope command19 =null;
		ParserRuleReturnScope command21 =null;

		Object char_literal20_tree=null;
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:55:10: ( command ( ';' command )* -> ( command )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:55:13: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands431);
			command19=command();
			state._fsp--;

			stream_command.add(command19.getTree());
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:55:20: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==34) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:55:21: ';' command
					{
					char_literal20=(Token)match(input,34,FOLLOW_34_in_commands433);  
					stream_34.add(char_literal20);

					pushFollow(FOLLOW_command_in_commands434);
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
			// 55:34: -> ( command )+
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:1: command : ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN vars exprs ) | if_ | while_ | for_ | foreach_ );
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
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:8: ( 'nop' | ( vars ':=' exprs ) -> ^( ASSIGN vars exprs ) | if_ | while_ | for_ | foreach_ )
			int alt6=6;
			switch ( input.LA(1) ) {
			case 48:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 44:
				{
				alt6=3;
				}
				break;
			case 53:
				{
				alt6=4;
				}
				break;
			case 40:
				{
				alt6=5;
				}
				break;
			case 41:
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:10: 'nop'
					{
					root_0 = (Object)adaptor.nil();


					string_literal22=(Token)match(input,48,FOLLOW_48_in_command447); 
					string_literal22_tree = (Object)adaptor.create(string_literal22);
					adaptor.addChild(root_0, string_literal22_tree);

					}
					break;
				case 2 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:16: ( vars ':=' exprs )
					{
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:16: ( vars ':=' exprs )
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:17: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command450);
					vars23=vars();
					state._fsp--;

					stream_vars.add(vars23.getTree());
					string_literal24=(Token)match(input,33,FOLLOW_33_in_command451);  
					stream_33.add(string_literal24);

					pushFollow(FOLLOW_exprs_in_command452);
					exprs25=exprs();
					state._fsp--;

					stream_exprs.add(exprs25.getTree());
					}

					// AST REWRITE
					// elements: exprs, vars
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 56:32: -> ^( ASSIGN vars exprs )
					{
						// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:35: ^( ASSIGN vars exprs )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						adaptor.addChild(root_1, stream_vars.nextTree());
						adaptor.addChild(root_1, stream_exprs.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:56: if_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_if__in_command465);
					if_26=if_();
					state._fsp--;

					adaptor.addChild(root_0, if_26.getTree());

					}
					break;
				case 4 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:60: while_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_while__in_command467);
					while_27=while_();
					state._fsp--;

					adaptor.addChild(root_0, while_27.getTree());

					}
					break;
				case 5 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:67: for_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_for__in_command469);
					for_28=for_();
					state._fsp--;

					adaptor.addChild(root_0, for_28.getTree());

					}
					break;
				case 6 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:56:72: foreach_
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_foreach__in_command471);
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:57:1: vars : Variable ( ',' Variable )* -> ( Variable )+ ;
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
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:57:6: ( Variable ( ',' Variable )* -> ( Variable )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:57:8: Variable ( ',' Variable )*
			{
			Variable30=(Token)match(input,Variable,FOLLOW_Variable_in_vars478);  
			stream_Variable.add(Variable30);

			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:57:16: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==31) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:57:17: ',' Variable
					{
					char_literal31=(Token)match(input,31,FOLLOW_31_in_vars480);  
					stream_31.add(char_literal31);

					Variable32=(Token)match(input,Variable,FOLLOW_Variable_in_vars481);  
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
			// 57:30: -> ( Variable )+
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:59:1: exprs : expression ( ',' expression )* -> ( expression )+ ;
	public final whileParser.exprs_return exprs() throws RecognitionException {
		whileParser.exprs_return retval = new whileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal34=null;
		ParserRuleReturnScope expression33 =null;
		ParserRuleReturnScope expression35 =null;

		Object char_literal34_tree=null;
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:59:7: ( expression ( ',' expression )* -> ( expression )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:59:9: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs495);
			expression33=expression();
			state._fsp--;

			stream_expression.add(expression33.getTree());
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:59:19: ( ',' expression )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==31) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:59:20: ',' expression
					{
					char_literal34=(Token)match(input,31,FOLLOW_31_in_exprs497);  
					stream_31.add(char_literal34);

					pushFollow(FOLLOW_expression_in_exprs498);
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
			// 59:36: -> ( expression )+
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:1: if_ : 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) ;
	public final whileParser.if__return if_() throws RecognitionException {
		whileParser.if__return retval = new whileParser.if__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal36=null;
		Token string_literal38=null;
		Token string_literal40=null;
		Token string_literal42=null;
		ParserRuleReturnScope expression37 =null;
		ParserRuleReturnScope then_39 =null;
		ParserRuleReturnScope then_41 =null;

		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		Object string_literal40_tree=null;
		Object string_literal42_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleSubtreeStream stream_then_=new RewriteRuleSubtreeStream(adaptor,"rule then_");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:8: ( 'if' expression 'then' then_ ( 'else' then_ )? 'fi' -> ^( IF expression ( then_ )+ ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:13: 'if' expression 'then' then_ ( 'else' then_ )? 'fi'
			{
			string_literal36=(Token)match(input,44,FOLLOW_44_in_if_518);  
			stream_44.add(string_literal36);

			pushFollow(FOLLOW_expression_in_if_519);
			expression37=expression();
			state._fsp--;

			stream_expression.add(expression37.getTree());
			string_literal38=(Token)match(input,51,FOLLOW_51_in_if_520);  
			stream_51.add(string_literal38);

			pushFollow(FOLLOW_then__in_if_521);
			then_39=then_();
			state._fsp--;

			stream_then_.add(then_39.getTree());
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:39: ( 'else' then_ )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==38) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:40: 'else' then_
					{
					string_literal40=(Token)match(input,38,FOLLOW_38_in_if_524);  
					stream_38.add(string_literal40);

					pushFollow(FOLLOW_then__in_if_525);
					then_41=then_();
					state._fsp--;

					stream_then_.add(then_41.getTree());
					}
					break;

			}

			string_literal42=(Token)match(input,39,FOLLOW_39_in_if_528);  
			stream_39.add(string_literal42);

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
			// 60:57: -> ^( IF expression ( then_ )+ )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:60:60: ^( IF expression ( then_ )+ )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:61:1: then_ : commands -> ^( COMMANDS commands ) ;
	public final whileParser.then__return then_() throws RecognitionException {
		whileParser.then__return retval = new whileParser.then__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope commands43 =null;

		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:61:11: ( commands -> ^( COMMANDS commands ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:61:16: commands
			{
			pushFollow(FOLLOW_commands_in_then_553);
			commands43=commands();
			state._fsp--;

			stream_commands.add(commands43.getTree());
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
			// 61:25: -> ^( COMMANDS commands )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:61:28: ^( COMMANDS commands )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:62:1: while_ : 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) ;
	public final whileParser.while__return while_() throws RecognitionException {
		whileParser.while__return retval = new whileParser.while__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal44=null;
		Token string_literal46=null;
		Token string_literal48=null;
		ParserRuleReturnScope expression45 =null;
		ParserRuleReturnScope commands47 =null;

		Object string_literal44_tree=null;
		Object string_literal46_tree=null;
		Object string_literal48_tree=null;
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:62:8: ( 'while' expression 'do' commands 'od' -> ^( WHILE expression ^( COMMANDS commands ) ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:62:10: 'while' expression 'do' commands 'od'
			{
			string_literal44=(Token)match(input,53,FOLLOW_53_in_while_568);  
			stream_53.add(string_literal44);

			pushFollow(FOLLOW_expression_in_while_569);
			expression45=expression();
			state._fsp--;

			stream_expression.add(expression45.getTree());
			string_literal46=(Token)match(input,37,FOLLOW_37_in_while_570);  
			stream_37.add(string_literal46);

			pushFollow(FOLLOW_commands_in_while_571);
			commands47=commands();
			state._fsp--;

			stream_commands.add(commands47.getTree());
			string_literal48=(Token)match(input,49,FOLLOW_49_in_while_572);  
			stream_49.add(string_literal48);

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
			// 62:44: -> ^( WHILE expression ^( COMMANDS commands ) )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:62:47: ^( WHILE expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:62:66: ^( COMMANDS commands )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:63:1: for_ : 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) ;
	public final whileParser.for__return for_() throws RecognitionException {
		whileParser.for__return retval = new whileParser.for__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal49=null;
		Token string_literal51=null;
		Token string_literal53=null;
		ParserRuleReturnScope expression50 =null;
		ParserRuleReturnScope commands52 =null;

		Object string_literal49_tree=null;
		Object string_literal51_tree=null;
		Object string_literal53_tree=null;
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:63:6: ( 'for' expression 'do' commands 'od' -> ^( FOR expression ^( COMMANDS commands ) ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:63:8: 'for' expression 'do' commands 'od'
			{
			string_literal49=(Token)match(input,40,FOLLOW_40_in_for_593);  
			stream_40.add(string_literal49);

			pushFollow(FOLLOW_expression_in_for_594);
			expression50=expression();
			state._fsp--;

			stream_expression.add(expression50.getTree());
			string_literal51=(Token)match(input,37,FOLLOW_37_in_for_595);  
			stream_37.add(string_literal51);

			pushFollow(FOLLOW_commands_in_for_596);
			commands52=commands();
			state._fsp--;

			stream_commands.add(commands52.getTree());
			string_literal53=(Token)match(input,49,FOLLOW_49_in_for_597);  
			stream_49.add(string_literal53);

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
			// 63:40: -> ^( FOR expression ^( COMMANDS commands ) )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:63:43: ^( FOR expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:63:60: ^( COMMANDS commands )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:64:1: foreach_ : 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) ;
	public final whileParser.foreach__return foreach_() throws RecognitionException {
		whileParser.foreach__return retval = new whileParser.foreach__return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token i=null;
		Token string_literal54=null;
		Token string_literal55=null;
		Token string_literal57=null;
		Token string_literal59=null;
		ParserRuleReturnScope expression56 =null;
		ParserRuleReturnScope commands58 =null;

		Object i_tree=null;
		Object string_literal54_tree=null;
		Object string_literal55_tree=null;
		Object string_literal57_tree=null;
		Object string_literal59_tree=null;
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:64:10: ( 'foreach' i= Variable 'in' expression 'do' commands 'od' -> ^( FOREACH $i expression ^( COMMANDS commands ) ) )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:64:12: 'foreach' i= Variable 'in' expression 'do' commands 'od'
			{
			string_literal54=(Token)match(input,41,FOLLOW_41_in_foreach_618);  
			stream_41.add(string_literal54);

			i=(Token)match(input,Variable,FOLLOW_Variable_in_foreach_624);  
			stream_Variable.add(i);

			string_literal55=(Token)match(input,45,FOLLOW_45_in_foreach_625);  
			stream_45.add(string_literal55);

			pushFollow(FOLLOW_expression_in_foreach_626);
			expression56=expression();
			state._fsp--;

			stream_expression.add(expression56.getTree());
			string_literal57=(Token)match(input,37,FOLLOW_37_in_foreach_627);  
			stream_37.add(string_literal57);

			pushFollow(FOLLOW_commands_in_foreach_628);
			commands58=commands();
			state._fsp--;

			stream_commands.add(commands58.getTree());
			string_literal59=(Token)match(input,49,FOLLOW_49_in_foreach_629);  
			stream_49.add(string_literal59);

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
			// 64:65: -> ^( FOREACH $i expression ^( COMMANDS commands ) )
			{
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:64:68: ^( FOREACH $i expression ^( COMMANDS commands ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_expression.nextTree());
				// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:64:92: ^( COMMANDS commands )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:65:1: exprbase : ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) );
	public final whileParser.exprbase_return exprbase() throws RecognitionException {
		whileParser.exprbase_return retval = new whileParser.exprbase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token s=null;
		Token set60=null;
		Token char_literal61=null;
		Token string_literal62=null;
		Token char_literal64=null;
		Token char_literal65=null;
		Token string_literal66=null;
		Token char_literal68=null;
		Token char_literal69=null;
		Token string_literal70=null;
		Token char_literal72=null;
		Token char_literal73=null;
		Token string_literal74=null;
		Token char_literal76=null;
		Token char_literal77=null;
		Token char_literal79=null;
		ParserRuleReturnScope lexpr63 =null;
		ParserRuleReturnScope lexpr67 =null;
		ParserRuleReturnScope exprbase71 =null;
		ParserRuleReturnScope exprbase75 =null;
		ParserRuleReturnScope lexpr78 =null;

		Object s_tree=null;
		Object set60_tree=null;
		Object char_literal61_tree=null;
		Object string_literal62_tree=null;
		Object char_literal64_tree=null;
		Object char_literal65_tree=null;
		Object string_literal66_tree=null;
		Object char_literal68_tree=null;
		Object char_literal69_tree=null;
		Object string_literal70_tree=null;
		Object char_literal72_tree=null;
		Object char_literal73_tree=null;
		Object string_literal74_tree=null;
		Object char_literal76_tree=null;
		Object char_literal77_tree=null;
		Object char_literal79_tree=null;
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:65:9: ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) ) | ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) ) | ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) ) )
			int alt12=4;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==47) ) {
				alt12=1;
			}
			else if ( (LA12_0==29) ) {
				switch ( input.LA(2) ) {
				case 36:
				case 46:
					{
					alt12=2;
					}
					break;
				case 43:
				case 52:
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:66:2: ( 'nil' | Variable | Symbol )
					{
					root_0 = (Object)adaptor.nil();


					set60=input.LT(1);
					if ( input.LA(1)==Symbol||input.LA(1)==Variable||input.LA(1)==47 ) {
						input.consume();
						adaptor.addChild(root_0, (Object)adaptor.create(set60));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 2 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					{
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:4: ( '(' 'cons' lexpr ')' -> ^( CONS lexpr ) | '(' 'list' lexpr ')' -> ^( LIST lexpr ) )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==29) ) {
						int LA10_1 = input.LA(2);
						if ( (LA10_1==36) ) {
							alt10=1;
						}
						else if ( (LA10_1==46) ) {
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
							// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:5: '(' 'cons' lexpr ')'
							{
							char_literal61=(Token)match(input,29,FOLLOW_29_in_exprbase666);  
							stream_29.add(char_literal61);

							string_literal62=(Token)match(input,36,FOLLOW_36_in_exprbase668);  
							stream_36.add(string_literal62);

							pushFollow(FOLLOW_lexpr_in_exprbase670);
							lexpr63=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr63.getTree());
							char_literal64=(Token)match(input,30,FOLLOW_30_in_exprbase672);  
							stream_30.add(char_literal64);

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
							// 67:26: -> ^( CONS lexpr )
							{
								// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:29: ^( CONS lexpr )
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
							// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:45: '(' 'list' lexpr ')'
							{
							char_literal65=(Token)match(input,29,FOLLOW_29_in_exprbase684);  
							stream_29.add(char_literal65);

							string_literal66=(Token)match(input,46,FOLLOW_46_in_exprbase686);  
							stream_46.add(string_literal66);

							pushFollow(FOLLOW_lexpr_in_exprbase688);
							lexpr67=lexpr();
							state._fsp--;

							stream_lexpr.add(lexpr67.getTree());
							char_literal68=(Token)match(input,30,FOLLOW_30_in_exprbase690);  
							stream_30.add(char_literal68);

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
							// 67:66: -> ^( LIST lexpr )
							{
								// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:67:69: ^( LIST lexpr )
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					{
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:4: ( '(' 'hd' exprbase ')' -> ^( HD exprbase ) | '(' 'tl' exprbase ')' -> ^( TL exprbase ) )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==29) ) {
						int LA11_1 = input.LA(2);
						if ( (LA11_1==43) ) {
							alt11=1;
						}
						else if ( (LA11_1==52) ) {
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
							// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:5: '(' 'hd' exprbase ')'
							{
							char_literal69=(Token)match(input,29,FOLLOW_29_in_exprbase705);  
							stream_29.add(char_literal69);

							string_literal70=(Token)match(input,43,FOLLOW_43_in_exprbase707);  
							stream_43.add(string_literal70);

							pushFollow(FOLLOW_exprbase_in_exprbase709);
							exprbase71=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase71.getTree());
							char_literal72=(Token)match(input,30,FOLLOW_30_in_exprbase711);  
							stream_30.add(char_literal72);

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
							// 68:26: -> ^( HD exprbase )
							{
								// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:29: ^( HD exprbase )
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
							// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:46: '(' 'tl' exprbase ')'
							{
							char_literal73=(Token)match(input,29,FOLLOW_29_in_exprbase722);  
							stream_29.add(char_literal73);

							string_literal74=(Token)match(input,52,FOLLOW_52_in_exprbase724);  
							stream_52.add(string_literal74);

							pushFollow(FOLLOW_exprbase_in_exprbase726);
							exprbase75=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase75.getTree());
							char_literal76=(Token)match(input,30,FOLLOW_30_in_exprbase728);  
							stream_30.add(char_literal76);

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
							// 68:68: -> ^( TL exprbase )
							{
								// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:68:71: ^( TL exprbase )
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:69:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					{
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:69:4: ( '(' s= Symbol lexpr ')' -> ^( SYMBOL $s lexpr ) )
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:69:5: '(' s= Symbol lexpr ')'
					{
					char_literal77=(Token)match(input,29,FOLLOW_29_in_exprbase743);  
					stream_29.add(char_literal77);

					s=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprbase747);  
					stream_Symbol.add(s);

					pushFollow(FOLLOW_lexpr_in_exprbase749);
					lexpr78=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr78.getTree());
					char_literal79=(Token)match(input,30,FOLLOW_30_in_exprbase751);  
					stream_30.add(char_literal79);

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
					// 69:29: -> ^( SYMBOL $s lexpr )
					{
						// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:69:32: ^( SYMBOL $s lexpr )
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:70:1: expression : exprbase ( '=?' exprbase )* -> ( exprbase )+ ;
	public final whileParser.expression_return expression() throws RecognitionException {
		whileParser.expression_return retval = new whileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal81=null;
		ParserRuleReturnScope exprbase80 =null;
		ParserRuleReturnScope exprbase82 =null;

		Object string_literal81_tree=null;
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:70:12: ( exprbase ( '=?' exprbase )* -> ( exprbase )+ )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:70:15: exprbase ( '=?' exprbase )*
			{
			pushFollow(FOLLOW_exprbase_in_expression772);
			exprbase80=exprbase();
			state._fsp--;

			stream_exprbase.add(exprbase80.getTree());
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:70:23: ( '=?' exprbase )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==35) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:70:24: '=?' exprbase
					{
					string_literal81=(Token)match(input,35,FOLLOW_35_in_expression774);  
					stream_35.add(string_literal81);

					pushFollow(FOLLOW_exprbase_in_expression776);
					exprbase82=exprbase();
					state._fsp--;

					stream_exprbase.add(exprbase82.getTree());
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
			// 70:40: -> ( exprbase )+
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
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:1: lexpr : ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) );
	public final whileParser.lexpr_return lexpr() throws RecognitionException {
		whileParser.lexpr_return retval = new whileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprbase83 =null;

		RewriteRuleSubtreeStream stream_exprbase=new RewriteRuleSubtreeStream(adaptor,"rule exprbase");

		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:7: ( ( exprbase )+ -> ( exprbase )+ | -> ^( VIDE ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==Symbol||LA15_0==Variable||LA15_0==29||LA15_0==47) ) {
				alt15=1;
			}
			else if ( (LA15_0==30) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:10: ( exprbase )+
					{
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:10: ( exprbase )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==Symbol||LA14_0==Variable||LA14_0==29||LA14_0==47) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:10: exprbase
							{
							pushFollow(FOLLOW_exprbase_in_lexpr791);
							exprbase83=exprbase();
							state._fsp--;

							stream_exprbase.add(exprbase83.getTree());
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
					// 71:20: -> ( exprbase )+
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
					// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:35: 
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
					// 71:35: -> ^( VIDE )
					{
						// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:71:38: ^( VIDE )
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


	public static class start_rule_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "start_rule"
	// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:72:1: start_rule : program ;
	public final whileParser.start_rule_return start_rule() throws RecognitionException {
		whileParser.start_rule_return retval = new whileParser.start_rule_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope program84 =null;


		try {
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:72:11: ( program )
			// C:\\Askoed\\ESIR_TLCProjet\\grammaire\\while.g:72:14: program
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_program_in_start_rule812);
			program84=program();
			state._fsp--;

			adaptor.addChild(root_0, program84.getTree());

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



	public static final BitSet FOLLOW_function_in_program301 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_function308 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Symbol_in_function314 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_function316 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_definition_in_function317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_definition335 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_input_in_definition337 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_definition339 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_commands_in_definition341 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_definition343 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_definition344 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_output_in_definition345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub392 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_inputSub394 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_Variable_in_inputSub395 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_Variable_in_output409 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_output411 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_Variable_in_output412 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_command_in_commands431 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_34_in_commands433 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_command_in_commands434 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_48_in_command447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command450 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_command451 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_exprs_in_command452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if__in_command465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while__in_command467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for__in_command469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach__in_command471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars478 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_vars480 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_Variable_in_vars481 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_expression_in_exprs495 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_exprs497 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_expression_in_exprs498 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_44_in_if_518 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_expression_in_if_519 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_if_520 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_then__in_if_521 = new BitSet(new long[]{0x000000C000000000L});
	public static final BitSet FOLLOW_38_in_if_524 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_then__in_if_525 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_if_528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_commands_in_then_553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_while_568 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_expression_in_while_569 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_while_570 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_commands_in_while_571 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_while_572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_40_in_for_593 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_expression_in_for_594 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_for_595 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_commands_in_for_596 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_for_597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_foreach_618 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_Variable_in_foreach_624 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_45_in_foreach_625 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_expression_in_foreach_626 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_foreach_627 = new BitSet(new long[]{0x0021130002000000L});
	public static final BitSet FOLLOW_commands_in_foreach_628 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_foreach_629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_exprbase654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_exprbase666 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_exprbase668 = new BitSet(new long[]{0x0000800062200000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase670 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_exprbase672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_exprbase684 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_exprbase686 = new BitSet(new long[]{0x0000800062200000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase688 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_exprbase690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_exprbase705 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_exprbase707 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase709 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_exprbase711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_exprbase722 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_exprbase724 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_exprbase_in_exprbase726 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_exprbase728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_exprbase743 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_Symbol_in_exprbase747 = new BitSet(new long[]{0x0000800062200000L});
	public static final BitSet FOLLOW_lexpr_in_exprbase749 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_exprbase751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression772 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_35_in_expression774 = new BitSet(new long[]{0x0000800022200000L});
	public static final BitSet FOLLOW_exprbase_in_expression776 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr791 = new BitSet(new long[]{0x0000800022200002L});
	public static final BitSet FOLLOW_program_in_start_rule812 = new BitSet(new long[]{0x0000000000000002L});
}
