// $ANTLR 3.5.1 C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g 2023-11-27 10:21:19

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class whileParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Dec", "Maj", "Min", "Symbol", 
		"Variable", "WS", "'%'", "'('", "')'", "','", "':'", "':='", "';'", "'=?'", 
		"'cons'", "'do'", "'else'", "'fi'", "'for'", "'foreach'", "'function'", 
		"'hd'", "'if'", "'in'", "'list'", "'nil'", "'nop'", "'od'", "'read'", 
		"'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
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
	public static final int Dec=4;
	public static final int Maj=5;
	public static final int Min=6;
	public static final int Symbol=7;
	public static final int Variable=8;
	public static final int WS=9;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "output", "function", "input", "inputSub", "foreach_", 
		"expression", "definition", "commands", "for_", "exprs", "lexpr", "exprbase", 
		"start_rule", "while_", "vars", "command", "if_", "program"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public whileParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public whileParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public whileParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return whileParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g"; }



	// $ANTLR start "program"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:19:1: program : function ( program )? ;
	public final void program() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(19, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:19:9: ( function ( program )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:19:11: function ( program )?
			{
			dbg.location(19,11);
			pushFollow(FOLLOW_function_in_program161);
			function();
			state._fsp--;
			dbg.location(19,21);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:19:21: ( program )?
			int alt1=2;
			try { dbg.enterSubRule(1);
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==24) ) {
				alt1=1;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:19:21: program
					{
					dbg.location(19,21);
					pushFollow(FOLLOW_program_in_program164);
					program();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(1);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(19, 28);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "program"



	// $ANTLR start "function"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:20:1: function : 'function' Symbol ':' definition ;
	public final void function() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:20:9: ( 'function' Symbol ':' definition )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:20:11: 'function' Symbol ':' definition
			{
			dbg.location(20,11);
			match(input,24,FOLLOW_24_in_function171); dbg.location(20,22);
			match(input,Symbol,FOLLOW_Symbol_in_function173); dbg.location(20,29);
			match(input,14,FOLLOW_14_in_function175); dbg.location(20,32);
			pushFollow(FOLLOW_definition_in_function176);
			definition();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(20, 41);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "function"



	// $ANTLR start "definition"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:21:1: definition : 'read' input '%' commands '%' 'write' output ;
	public final void definition() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "definition");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(21, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:21:13: ( 'read' input '%' commands '%' 'write' output )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:21:15: 'read' input '%' commands '%' 'write' output
			{
			dbg.location(21,15);
			match(input,32,FOLLOW_32_in_definition184); dbg.location(21,22);
			pushFollow(FOLLOW_input_in_definition186);
			input();
			state._fsp--;
			dbg.location(21,28);
			match(input,10,FOLLOW_10_in_definition188); dbg.location(21,32);
			pushFollow(FOLLOW_commands_in_definition190);
			commands();
			state._fsp--;
			dbg.location(21,41);
			match(input,10,FOLLOW_10_in_definition192); dbg.location(21,44);
			match(input,36,FOLLOW_36_in_definition193); dbg.location(21,51);
			pushFollow(FOLLOW_output_in_definition194);
			output();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(21, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "definition");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "definition"



	// $ANTLR start "input"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:22:1: input : ( inputSub )? ;
	public final void input() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "input");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(22, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:22:8: ( ( inputSub )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:22:10: ( inputSub )?
			{
			dbg.location(22,10);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:22:10: ( inputSub )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:22:10: inputSub
					{
					dbg.location(22,10);
					pushFollow(FOLLOW_inputSub_in_input202);
					inputSub();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(22, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "input");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "input"



	// $ANTLR start "inputSub"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:23:1: inputSub : ( Variable | Variable ',' inputSub );
	public final void inputSub() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "inputSub");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(23, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:23:10: ( Variable | Variable ',' inputSub )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==Variable) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==13) ) {
					alt3=2;
				}
				else if ( (LA3_1==10) ) {
					alt3=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:23:12: Variable
					{
					dbg.location(23,12);
					match(input,Variable,FOLLOW_Variable_in_inputSub210); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:23:21: Variable ',' inputSub
					{
					dbg.location(23,21);
					match(input,Variable,FOLLOW_Variable_in_inputSub212); dbg.location(23,29);
					match(input,13,FOLLOW_13_in_inputSub213); dbg.location(23,32);
					pushFollow(FOLLOW_inputSub_in_inputSub214);
					inputSub();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(23, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "inputSub");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "inputSub"



	// $ANTLR start "output"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:24:1: output : ( Variable | Variable ',' output );
	public final void output() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "output");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(24, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:24:9: ( Variable | Variable ',' output )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==Variable) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==13) ) {
					alt4=2;
				}
				else if ( (LA4_1==EOF||LA4_1==24) ) {
					alt4=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:24:11: Variable
					{
					dbg.location(24,11);
					match(input,Variable,FOLLOW_Variable_in_output222); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:24:20: Variable ',' output
					{
					dbg.location(24,20);
					match(input,Variable,FOLLOW_Variable_in_output224); dbg.location(24,28);
					match(input,13,FOLLOW_13_in_output225); dbg.location(24,31);
					pushFollow(FOLLOW_output_in_output226);
					output();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(24, 36);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "output");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "output"



	// $ANTLR start "commands"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:25:1: commands : command ( ';' commands )? ;
	public final void commands() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "commands");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(25, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:25:10: ( command ( ';' commands )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:25:13: command ( ';' commands )?
			{
			dbg.location(25,13);
			pushFollow(FOLLOW_command_in_commands234);
			command();
			state._fsp--;
			dbg.location(25,20);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:25:20: ( ';' commands )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==16) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:25:21: ';' commands
					{
					dbg.location(25,21);
					match(input,16,FOLLOW_16_in_commands236); dbg.location(25,24);
					pushFollow(FOLLOW_commands_in_commands237);
					commands();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(25, 33);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "commands");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "commands"



	// $ANTLR start "command"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:1: command : ( 'nop' | ( vars ':=' exprs ) | if_ | while_ | for_ | foreach_ );
	public final void command() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "command");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(26, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:8: ( 'nop' | ( vars ':=' exprs ) | if_ | while_ | for_ | foreach_ )
			int alt6=6;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			switch ( input.LA(1) ) {
			case 30:
				{
				alt6=1;
				}
				break;
			case Variable:
				{
				alt6=2;
				}
				break;
			case 26:
				{
				alt6=3;
				}
				break;
			case 35:
				{
				alt6=4;
				}
				break;
			case 22:
				{
				alt6=5;
				}
				break;
			case 23:
				{
				alt6=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:10: 'nop'
					{
					dbg.location(26,10);
					match(input,30,FOLLOW_30_in_command245); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:16: ( vars ':=' exprs )
					{
					dbg.location(26,16);
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:16: ( vars ':=' exprs )
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:17: vars ':=' exprs
					{
					dbg.location(26,17);
					pushFollow(FOLLOW_vars_in_command248);
					vars();
					state._fsp--;
					dbg.location(26,21);
					match(input,15,FOLLOW_15_in_command249); dbg.location(26,25);
					pushFollow(FOLLOW_exprs_in_command250);
					exprs();
					state._fsp--;

					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:32: if_
					{
					dbg.location(26,32);
					pushFollow(FOLLOW_if__in_command253);
					if_();
					state._fsp--;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:36: while_
					{
					dbg.location(26,36);
					pushFollow(FOLLOW_while__in_command255);
					while_();
					state._fsp--;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:43: for_
					{
					dbg.location(26,43);
					pushFollow(FOLLOW_for__in_command257);
					for_();
					state._fsp--;

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:26:48: foreach_
					{
					dbg.location(26,48);
					pushFollow(FOLLOW_foreach__in_command259);
					foreach_();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(26, 55);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "command");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "command"



	// $ANTLR start "vars"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:1: vars : ( Variable | ( Variable ',' vars ) );
	public final void vars() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "vars");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(27, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:6: ( Variable | ( Variable ',' vars ) )
			int alt7=2;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==Variable) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==13) ) {
					alt7=2;
				}
				else if ( (LA7_1==15) ) {
					alt7=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:8: Variable
					{
					dbg.location(27,8);
					match(input,Variable,FOLLOW_Variable_in_vars266); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:17: ( Variable ',' vars )
					{
					dbg.location(27,17);
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:17: ( Variable ',' vars )
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:27:18: Variable ',' vars
					{
					dbg.location(27,18);
					match(input,Variable,FOLLOW_Variable_in_vars269); dbg.location(27,26);
					match(input,13,FOLLOW_13_in_vars270); dbg.location(27,29);
					pushFollow(FOLLOW_vars_in_vars271);
					vars();
					state._fsp--;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(27, 33);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "vars");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "vars"



	// $ANTLR start "exprs"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:1: exprs : expression ( ',' exprs )? ;
	public final void exprs() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "exprs");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:7: ( expression ( ',' exprs )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:9: expression ( ',' exprs )?
			{
			dbg.location(28,9);
			pushFollow(FOLLOW_expression_in_exprs279);
			expression();
			state._fsp--;
			dbg.location(28,19);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:19: ( ',' exprs )?
			int alt8=2;
			try { dbg.enterSubRule(8);
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==13) ) {
				alt8=1;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:28:20: ',' exprs
					{
					dbg.location(28,20);
					match(input,13,FOLLOW_13_in_exprs281); dbg.location(28,23);
					pushFollow(FOLLOW_exprs_in_exprs282);
					exprs();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(8);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(28, 29);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprs");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "exprs"



	// $ANTLR start "if_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:29:1: if_ : 'if' expression 'then' commands ( 'else' commands )? 'fi' ;
	public final void if_() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "if_");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(29, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:29:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:29:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
			{
			dbg.location(29,7);
			match(input,26,FOLLOW_26_in_if_291); dbg.location(29,11);
			pushFollow(FOLLOW_expression_in_if_292);
			expression();
			state._fsp--;
			dbg.location(29,21);
			match(input,33,FOLLOW_33_in_if_293); dbg.location(29,27);
			pushFollow(FOLLOW_commands_in_if_294);
			commands();
			state._fsp--;
			dbg.location(29,35);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:29:35: ( 'else' commands )?
			int alt9=2;
			try { dbg.enterSubRule(9);
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			int LA9_0 = input.LA(1);
			if ( (LA9_0==20) ) {
				alt9=1;
			}
			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:29:36: 'else' commands
					{
					dbg.location(29,36);
					match(input,20,FOLLOW_20_in_if_296); dbg.location(29,42);
					pushFollow(FOLLOW_commands_in_if_297);
					commands();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(9);}
			dbg.location(29,52);
			match(input,21,FOLLOW_21_in_if_300); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(29, 55);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "if_");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "if_"



	// $ANTLR start "while_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:30:1: while_ : 'while' expression 'do' commands 'od' ;
	public final void while_() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "while_");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(30, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:30:8: ( 'while' expression 'do' commands 'od' )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:30:10: 'while' expression 'do' commands 'od'
			{
			dbg.location(30,10);
			match(input,35,FOLLOW_35_in_while_307); dbg.location(30,17);
			pushFollow(FOLLOW_expression_in_while_308);
			expression();
			state._fsp--;
			dbg.location(30,27);
			match(input,19,FOLLOW_19_in_while_309); dbg.location(30,31);
			pushFollow(FOLLOW_commands_in_while_310);
			commands();
			state._fsp--;
			dbg.location(30,39);
			match(input,31,FOLLOW_31_in_while_311); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(30, 42);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "while_");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "while_"



	// $ANTLR start "for_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:31:1: for_ : 'for' expression 'do' commands 'od' ;
	public final void for_() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "for_");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(31, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:31:6: ( 'for' expression 'do' commands 'od' )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:31:8: 'for' expression 'do' commands 'od'
			{
			dbg.location(31,8);
			match(input,22,FOLLOW_22_in_for_318); dbg.location(31,13);
			pushFollow(FOLLOW_expression_in_for_319);
			expression();
			state._fsp--;
			dbg.location(31,23);
			match(input,19,FOLLOW_19_in_for_320); dbg.location(31,27);
			pushFollow(FOLLOW_commands_in_for_321);
			commands();
			state._fsp--;
			dbg.location(31,35);
			match(input,31,FOLLOW_31_in_for_322); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(31, 38);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "for_");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "for_"



	// $ANTLR start "foreach_"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:32:1: foreach_ : 'foreach' Variable 'in' expression 'do' commands 'od' ;
	public final void foreach_() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "foreach_");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(32, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:32:10: ( 'foreach' Variable 'in' expression 'do' commands 'od' )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:32:12: 'foreach' Variable 'in' expression 'do' commands 'od'
			{
			dbg.location(32,12);
			match(input,23,FOLLOW_23_in_foreach_329); dbg.location(32,21);
			match(input,Variable,FOLLOW_Variable_in_foreach_330); dbg.location(32,29);
			match(input,27,FOLLOW_27_in_foreach_331); dbg.location(32,33);
			pushFollow(FOLLOW_expression_in_foreach_332);
			expression();
			state._fsp--;
			dbg.location(32,43);
			match(input,19,FOLLOW_19_in_foreach_333); dbg.location(32,47);
			pushFollow(FOLLOW_commands_in_foreach_334);
			commands();
			state._fsp--;
			dbg.location(32,55);
			match(input,31,FOLLOW_31_in_foreach_335); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(32, 58);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "foreach_");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "foreach_"



	// $ANTLR start "exprbase"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:1: exprbase : ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' | '(' 'list' lexpr ')' ) | ( '(' 'hd' exprbase ')' | '(' 'tl' exprbase ')' ) | ( '(' Symbol lexpr ')' ) );
	public final void exprbase() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "exprbase");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(33, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:9: ( ( 'nil' | Variable | Symbol ) | ( '(' 'cons' lexpr ')' | '(' 'list' lexpr ')' ) | ( '(' 'hd' exprbase ')' | '(' 'tl' exprbase ')' ) | ( '(' Symbol lexpr ')' ) )
			int alt12=4;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( ((LA12_0 >= Symbol && LA12_0 <= Variable)||LA12_0==29) ) {
				alt12=1;
			}
			else if ( (LA12_0==11) ) {
				switch ( input.LA(2) ) {
				case 18:
				case 28:
					{
					alt12=2;
					}
					break;
				case 25:
				case 34:
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
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:12: ( 'nil' | Variable | Symbol )
					{
					dbg.location(33,12);
					if ( (input.LA(1) >= Symbol && input.LA(1) <= Variable)||input.LA(1)==29 ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:38: ( '(' 'cons' lexpr ')' | '(' 'list' lexpr ')' )
					{
					dbg.location(33,38);
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:38: ( '(' 'cons' lexpr ')' | '(' 'list' lexpr ')' )
					int alt10=2;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					int LA10_0 = input.LA(1);
					if ( (LA10_0==11) ) {
						int LA10_1 = input.LA(2);
						if ( (LA10_1==18) ) {
							alt10=1;
						}
						else if ( (LA10_1==28) ) {
							alt10=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 10, 1, input);
								dbg.recognitionException(nvae);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:39: '(' 'cons' lexpr ')'
							{
							dbg.location(33,39);
							match(input,11,FOLLOW_11_in_exprbase353); dbg.location(33,43);
							match(input,18,FOLLOW_18_in_exprbase355); dbg.location(33,50);
							pushFollow(FOLLOW_lexpr_in_exprbase357);
							lexpr();
							state._fsp--;
							dbg.location(33,56);
							match(input,12,FOLLOW_12_in_exprbase359); 
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:62: '(' 'list' lexpr ')'
							{
							dbg.location(33,62);
							match(input,11,FOLLOW_11_in_exprbase363); dbg.location(33,66);
							match(input,28,FOLLOW_28_in_exprbase365); dbg.location(33,73);
							pushFollow(FOLLOW_lexpr_in_exprbase367);
							lexpr();
							state._fsp--;
							dbg.location(33,79);
							match(input,12,FOLLOW_12_in_exprbase369); 
							}
							break;

					}
					} finally {dbg.exitSubRule(10);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:86: ( '(' 'hd' exprbase ')' | '(' 'tl' exprbase ')' )
					{
					dbg.location(33,86);
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:86: ( '(' 'hd' exprbase ')' | '(' 'tl' exprbase ')' )
					int alt11=2;
					try { dbg.enterSubRule(11);
					try { dbg.enterDecision(11, decisionCanBacktrack[11]);

					int LA11_0 = input.LA(1);
					if ( (LA11_0==11) ) {
						int LA11_1 = input.LA(2);
						if ( (LA11_1==25) ) {
							alt11=1;
						}
						else if ( (LA11_1==34) ) {
							alt11=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 11, 1, input);
								dbg.recognitionException(nvae);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(11);}

					switch (alt11) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:87: '(' 'hd' exprbase ')'
							{
							dbg.location(33,87);
							match(input,11,FOLLOW_11_in_exprbase375); dbg.location(33,91);
							match(input,25,FOLLOW_25_in_exprbase377); dbg.location(33,96);
							pushFollow(FOLLOW_exprbase_in_exprbase379);
							exprbase();
							state._fsp--;
							dbg.location(33,105);
							match(input,12,FOLLOW_12_in_exprbase381); 
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:111: '(' 'tl' exprbase ')'
							{
							dbg.location(33,111);
							match(input,11,FOLLOW_11_in_exprbase385); dbg.location(33,115);
							match(input,34,FOLLOW_34_in_exprbase387); dbg.location(33,120);
							pushFollow(FOLLOW_exprbase_in_exprbase389);
							exprbase();
							state._fsp--;
							dbg.location(33,129);
							match(input,12,FOLLOW_12_in_exprbase391); 
							}
							break;

					}
					} finally {dbg.exitSubRule(11);}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:136: ( '(' Symbol lexpr ')' )
					{
					dbg.location(33,136);
					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:136: ( '(' Symbol lexpr ')' )
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:33:137: '(' Symbol lexpr ')'
					{
					dbg.location(33,137);
					match(input,11,FOLLOW_11_in_exprbase397); dbg.location(33,141);
					match(input,Symbol,FOLLOW_Symbol_in_exprbase399); dbg.location(33,148);
					pushFollow(FOLLOW_lexpr_in_exprbase401);
					lexpr();
					state._fsp--;
					dbg.location(33,154);
					match(input,12,FOLLOW_12_in_exprbase403); 
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(33, 159);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprbase");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "exprbase"



	// $ANTLR start "expression"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:34:1: expression : exprbase ( '=?' exprbase )? ;
	public final void expression() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(34, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:34:12: ( exprbase ( '=?' exprbase )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:34:15: exprbase ( '=?' exprbase )?
			{
			dbg.location(34,15);
			pushFollow(FOLLOW_exprbase_in_expression414);
			exprbase();
			state._fsp--;
			dbg.location(34,23);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:34:23: ( '=?' exprbase )?
			int alt13=2;
			try { dbg.enterSubRule(13);
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			int LA13_0 = input.LA(1);
			if ( (LA13_0==17) ) {
				alt13=1;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:34:24: '=?' exprbase
					{
					dbg.location(34,24);
					match(input,17,FOLLOW_17_in_expression416); dbg.location(34,29);
					pushFollow(FOLLOW_exprbase_in_expression418);
					exprbase();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(13);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(34, 38);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expression"



	// $ANTLR start "lexpr"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:35:1: lexpr : ( exprbase lexpr )? ;
	public final void lexpr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "lexpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(35, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:35:7: ( ( exprbase lexpr )? )
			dbg.enterAlt(1);

			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:35:10: ( exprbase lexpr )?
			{
			dbg.location(35,10);
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:35:10: ( exprbase lexpr )?
			int alt14=2;
			try { dbg.enterSubRule(14);
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			int LA14_0 = input.LA(1);
			if ( ((LA14_0 >= Symbol && LA14_0 <= Variable)||LA14_0==11||LA14_0==29) ) {
				alt14=1;
			}
			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:35:11: exprbase lexpr
					{
					dbg.location(35,11);
					pushFollow(FOLLOW_exprbase_in_lexpr429);
					exprbase();
					state._fsp--;
					dbg.location(35,20);
					pushFollow(FOLLOW_lexpr_in_lexpr431);
					lexpr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(14);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(35, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lexpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "lexpr"



	// $ANTLR start "start_rule"
	// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:36:1: start_rule : ( commands | program );
	public final void start_rule() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "start_rule");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(36, 0);

		try {
			// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:36:11: ( commands | program )
			int alt15=2;
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( (LA15_0==Variable||(LA15_0 >= 22 && LA15_0 <= 23)||LA15_0==26||LA15_0==30||LA15_0==35) ) {
				alt15=1;
			}
			else if ( (LA15_0==24) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(15);}

			switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:36:14: commands
					{
					dbg.location(36,14);
					pushFollow(FOLLOW_commands_in_start_rule440);
					commands();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\theo\\Documents\\Repos\\ESIR_TLCProjet\\grammaire\\while.g:36:25: program
					{
					dbg.location(36,25);
					pushFollow(FOLLOW_program_in_start_rule444);
					program();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(36, 31);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "start_rule");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "start_rule"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program161 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_program_in_program164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_function171 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Symbol_in_function173 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_function175 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_definition_in_function176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_definition184 = new BitSet(new long[]{0x0000000000000500L});
	public static final BitSet FOLLOW_input_in_definition186 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_definition188 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_definition190 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_definition192 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_definition193 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_output_in_definition194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub212 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_inputSub213 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_inputSub_in_inputSub214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_output222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_output224 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_output225 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_output_in_output226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_command_in_commands234 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_commands236 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_commands237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_command245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command248 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_command249 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_exprs_in_command250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if__in_command253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while__in_command255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for__in_command257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_foreach__in_command259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars269 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_vars270 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_vars_in_vars271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_exprs279 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_exprs281 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_exprs_in_exprs282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_if_291 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_expression_in_if_292 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_if_293 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_if_294 = new BitSet(new long[]{0x0000000000300000L});
	public static final BitSet FOLLOW_20_in_if_296 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_if_297 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_if_300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_while_307 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_expression_in_while_308 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_while_309 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_while_310 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_while_311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_for_318 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_expression_in_for_319 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_for_320 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_for_321 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_for_322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_foreach_329 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_Variable_in_foreach_330 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_foreach_331 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_expression_in_foreach_332 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_foreach_333 = new BitSet(new long[]{0x0000000844C00100L});
	public static final BitSet FOLLOW_commands_in_foreach_334 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_foreach_335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_exprbase342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprbase353 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_exprbase355 = new BitSet(new long[]{0x0000000020001980L});
	public static final BitSet FOLLOW_lexpr_in_exprbase357 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_exprbase359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprbase363 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprbase365 = new BitSet(new long[]{0x0000000020001980L});
	public static final BitSet FOLLOW_lexpr_in_exprbase367 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_exprbase369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprbase375 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_exprbase377 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_exprbase_in_exprbase379 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_exprbase381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprbase385 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprbase387 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_exprbase_in_exprbase389 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_exprbase391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprbase397 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_Symbol_in_exprbase399 = new BitSet(new long[]{0x0000000020001980L});
	public static final BitSet FOLLOW_lexpr_in_exprbase401 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_exprbase403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_expression414 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_17_in_expression416 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_exprbase_in_expression418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprbase_in_lexpr429 = new BitSet(new long[]{0x0000000020000980L});
	public static final BitSet FOLLOW_lexpr_in_lexpr431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_commands_in_start_rule440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_program_in_start_rule444 = new BitSet(new long[]{0x0000000000000002L});
}
