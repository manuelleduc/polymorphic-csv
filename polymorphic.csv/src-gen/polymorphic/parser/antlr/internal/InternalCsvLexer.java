package polymorphic.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCsvLexer extends Lexer {
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=6;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__42=42;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalCsvLexer() {;} 
    public InternalCsvLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalCsvLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalCsv.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:11:7: ( 'package' )
            // InternalCsv.g:11:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:12:7: ( ';' )
            // InternalCsv.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:13:7: ( 'constraints' )
            // InternalCsv.g:13:9: 'constraints'
            {
            match("constraints"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:14:7: ( '{' )
            // InternalCsv.g:14:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:15:7: ( '}' )
            // InternalCsv.g:15:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:16:7: ( 'languages' )
            // InternalCsv.g:16:9: 'languages'
            {
            match("languages"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:17:7: ( '=' )
            // InternalCsv.g:17:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:18:7: ( 'true' )
            // InternalCsv.g:18:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:19:7: ( 'false' )
            // InternalCsv.g:19:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:20:7: ( '(' )
            // InternalCsv.g:20:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:21:7: ( ')' )
            // InternalCsv.g:21:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:22:7: ( 'read' )
            // InternalCsv.g:22:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:23:7: ( 'latin1' )
            // InternalCsv.g:23:9: 'latin1'
            {
            match("latin1"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:24:7: ( 'utf8' )
            // InternalCsv.g:24:9: 'utf8'
            {
            match("utf8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:25:7: ( 'print' )
            // InternalCsv.g:25:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:26:7: ( 'nbrow' )
            // InternalCsv.g:26:9: 'nbrow'
            {
            match("nbrow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:27:7: ( 'nbcol' )
            // InternalCsv.g:27:9: 'nbcol'
            {
            match("nbcol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:28:7: ( 'save' )
            // InternalCsv.g:28:9: 'save'
            {
            match("save"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:29:7: ( '[' )
            // InternalCsv.g:29:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:30:7: ( ']' )
            // InternalCsv.g:30:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:31:7: ( ',' )
            // InternalCsv.g:31:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:32:7: ( '=>' )
            // InternalCsv.g:32:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:33:7: ( '<' )
            // InternalCsv.g:33:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:34:7: ( '>' )
            // InternalCsv.g:34:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:35:7: ( '.' )
            // InternalCsv.g:35:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:36:7: ( '?' )
            // InternalCsv.g:36:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:37:7: ( 'extends' )
            // InternalCsv.g:37:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:38:7: ( '&' )
            // InternalCsv.g:38:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:39:7: ( 'super' )
            // InternalCsv.g:39:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:40:7: ( '*' )
            // InternalCsv.g:40:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:41:7: ( 'import' )
            // InternalCsv.g:41:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:42:7: ( 'static' )
            // InternalCsv.g:42:9: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:43:7: ( 'extension' )
            // InternalCsv.g:43:9: 'extension'
            {
            match("extension"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1682:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // InternalCsv.g:1682:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // InternalCsv.g:1682:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalCsv.g:1682:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalCsv.g:1682:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='$'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCsv.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1684:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? ) )
            // InternalCsv.g:1684:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            {
            // InternalCsv.g:1684:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )? | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )? )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalCsv.g:1684:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* ( '\"' )?
                    {
                    match('\"'); 
                    // InternalCsv.g:1684:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalCsv.g:1684:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCsv.g:1684:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // InternalCsv.g:1684:44: ( '\"' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\"') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalCsv.g:1684:44: '\"'
                            {
                            match('\"'); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalCsv.g:1684:49: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* ( '\\'' )?
                    {
                    match('\''); 
                    // InternalCsv.g:1684:54: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalCsv.g:1684:55: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalCsv.g:1684:62: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalCsv.g:1684:79: ( '\\'' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\'') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalCsv.g:1684:79: '\\''
                            {
                            match('\''); 

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1686:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalCsv.g:1686:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalCsv.g:1686:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCsv.g:1686:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1688:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalCsv.g:1688:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalCsv.g:1688:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalCsv.g:1688:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalCsv.g:1688:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalCsv.g:1688:41: ( '\\r' )? '\\n'
                    {
                    // InternalCsv.g:1688:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalCsv.g:1688:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1690:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalCsv.g:1690:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalCsv.g:1690:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalCsv.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalCsv.g:1692:16: ( . )
            // InternalCsv.g:1692:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalCsv.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=39;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalCsv.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // InternalCsv.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // InternalCsv.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // InternalCsv.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // InternalCsv.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // InternalCsv.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // InternalCsv.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // InternalCsv.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // InternalCsv.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // InternalCsv.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // InternalCsv.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // InternalCsv.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // InternalCsv.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // InternalCsv.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // InternalCsv.g:1:94: T__24
                {
                mT__24(); 

                }
                break;
            case 16 :
                // InternalCsv.g:1:100: T__25
                {
                mT__25(); 

                }
                break;
            case 17 :
                // InternalCsv.g:1:106: T__26
                {
                mT__26(); 

                }
                break;
            case 18 :
                // InternalCsv.g:1:112: T__27
                {
                mT__27(); 

                }
                break;
            case 19 :
                // InternalCsv.g:1:118: T__28
                {
                mT__28(); 

                }
                break;
            case 20 :
                // InternalCsv.g:1:124: T__29
                {
                mT__29(); 

                }
                break;
            case 21 :
                // InternalCsv.g:1:130: T__30
                {
                mT__30(); 

                }
                break;
            case 22 :
                // InternalCsv.g:1:136: T__31
                {
                mT__31(); 

                }
                break;
            case 23 :
                // InternalCsv.g:1:142: T__32
                {
                mT__32(); 

                }
                break;
            case 24 :
                // InternalCsv.g:1:148: T__33
                {
                mT__33(); 

                }
                break;
            case 25 :
                // InternalCsv.g:1:154: T__34
                {
                mT__34(); 

                }
                break;
            case 26 :
                // InternalCsv.g:1:160: T__35
                {
                mT__35(); 

                }
                break;
            case 27 :
                // InternalCsv.g:1:166: T__36
                {
                mT__36(); 

                }
                break;
            case 28 :
                // InternalCsv.g:1:172: T__37
                {
                mT__37(); 

                }
                break;
            case 29 :
                // InternalCsv.g:1:178: T__38
                {
                mT__38(); 

                }
                break;
            case 30 :
                // InternalCsv.g:1:184: T__39
                {
                mT__39(); 

                }
                break;
            case 31 :
                // InternalCsv.g:1:190: T__40
                {
                mT__40(); 

                }
                break;
            case 32 :
                // InternalCsv.g:1:196: T__41
                {
                mT__41(); 

                }
                break;
            case 33 :
                // InternalCsv.g:1:202: T__42
                {
                mT__42(); 

                }
                break;
            case 34 :
                // InternalCsv.g:1:208: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 35 :
                // InternalCsv.g:1:216: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 36 :
                // InternalCsv.g:1:228: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 37 :
                // InternalCsv.g:1:244: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 38 :
                // InternalCsv.g:1:260: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 39 :
                // InternalCsv.g:1:268: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\1\44\1\uffff\1\44\2\uffff\1\44\1\53\2\44\2\uffff\4\44\7\uffff\1\44\2\uffff\1\44\1\41\3\uffff\1\41\2\uffff\2\44\2\uffff\1\44\2\uffff\1\44\2\uffff\2\44\2\uffff\6\44\7\uffff\1\44\2\uffff\1\44\4\uffff\25\44\1\152\1\44\1\154\1\155\2\44\1\160\5\44\1\166\3\44\1\uffff\1\172\2\uffff\1\173\1\174\1\uffff\1\175\4\44\1\uffff\2\44\1\u0085\4\uffff\1\u0086\2\44\1\u0089\1\u008a\2\44\2\uffff\1\u008d\1\44\2\uffff\2\44\1\uffff\2\44\1\u0093\1\u0094\1\44\2\uffff\1\u0096\1\uffff";
    static final String DFA13_eofS =
        "\u0097\uffff";
    static final String DFA13_minS =
        "\1\0\1\141\1\uffff\1\157\2\uffff\1\141\1\76\1\162\1\141\2\uffff\1\145\1\164\1\142\1\141\7\uffff\1\170\2\uffff\1\155\1\44\3\uffff\1\52\2\uffff\1\143\1\151\2\uffff\1\156\2\uffff\1\156\2\uffff\1\165\1\154\2\uffff\1\141\1\146\1\143\1\166\1\160\1\141\7\uffff\1\164\2\uffff\1\160\4\uffff\1\153\1\156\1\163\1\147\1\151\1\145\1\163\1\144\1\70\2\157\2\145\1\164\1\145\1\157\1\141\2\164\1\165\1\156\1\44\1\145\2\44\1\167\1\154\1\44\1\162\1\151\1\156\1\162\1\147\1\44\1\162\1\141\1\61\1\uffff\1\44\2\uffff\2\44\1\uffff\1\44\1\143\1\144\1\164\1\145\1\uffff\1\141\1\147\1\44\4\uffff\1\44\1\163\1\151\2\44\1\151\1\145\2\uffff\1\44\1\157\2\uffff\1\156\1\163\1\uffff\1\156\1\164\2\44\1\163\2\uffff\1\44\1\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\162\1\uffff\1\157\2\uffff\1\141\1\76\1\162\1\141\2\uffff\1\145\1\164\1\142\1\165\7\uffff\1\170\2\uffff\1\155\1\172\3\uffff\1\57\2\uffff\1\143\1\151\2\uffff\1\156\2\uffff\1\164\2\uffff\1\165\1\154\2\uffff\1\141\1\146\1\162\1\166\1\160\1\141\7\uffff\1\164\2\uffff\1\160\4\uffff\1\153\1\156\1\163\1\147\1\151\1\145\1\163\1\144\1\70\2\157\2\145\1\164\1\145\1\157\1\141\2\164\1\165\1\156\1\172\1\145\2\172\1\167\1\154\1\172\1\162\1\151\1\156\1\162\1\147\1\172\1\162\1\141\1\61\1\uffff\1\172\2\uffff\2\172\1\uffff\1\172\1\143\1\163\1\164\1\145\1\uffff\1\141\1\147\1\172\4\uffff\1\172\1\163\1\151\2\172\1\151\1\145\2\uffff\1\172\1\157\2\uffff\1\156\1\163\1\uffff\1\156\1\164\2\172\1\163\2\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\4\uffff\1\12\1\13\4\uffff\1\23\1\24\1\25\1\27\1\30\1\31\1\32\1\uffff\1\34\1\36\2\uffff\1\42\2\43\1\uffff\1\46\1\47\2\uffff\1\42\1\2\1\uffff\1\4\1\5\1\uffff\1\26\1\7\2\uffff\1\12\1\13\6\uffff\1\23\1\24\1\25\1\27\1\30\1\31\1\32\1\uffff\1\34\1\36\1\uffff\1\43\1\44\1\45\1\46\45\uffff\1\10\1\uffff\1\14\1\16\2\uffff\1\22\5\uffff\1\17\3\uffff\1\11\1\20\1\21\1\35\7\uffff\1\15\1\40\2\uffff\1\37\1\1\2\uffff\1\33\5\uffff\1\6\1\41\1\uffff\1\3";
    static final String DFA13_specialS =
        "\1\0\u0096\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\41\2\40\2\41\1\40\22\41\1\40\1\41\1\35\1\41\1\34\1\41\1\30\1\36\1\12\1\13\1\31\1\41\1\22\1\41\1\25\1\37\13\41\1\2\1\23\1\7\1\24\1\26\1\41\32\34\1\20\1\41\1\21\1\33\1\34\1\41\2\34\1\3\1\34\1\27\1\11\2\34\1\32\2\34\1\6\1\34\1\16\1\34\1\1\1\34\1\14\1\17\1\10\1\15\5\34\1\4\1\41\1\5\uff82\41",
            "\1\42\20\uffff\1\43",
            "",
            "\1\46",
            "",
            "",
            "\1\51",
            "\1\52",
            "\1\54",
            "\1\55",
            "",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63\22\uffff\1\65\1\64",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "",
            "",
            "\1\100",
            "\1\44\34\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "\1\102\4\uffff\1\103",
            "",
            "",
            "\1\105",
            "\1\106",
            "",
            "",
            "\1\107",
            "",
            "",
            "\1\110\5\uffff\1\111",
            "",
            "",
            "\1\112",
            "\1\113",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\117\16\uffff\1\116",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "",
            "",
            "\1\124",
            "",
            "",
            "",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\153",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\156",
            "\1\157",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\176",
            "\1\177\16\uffff\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0087",
            "\1\u0088",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u008b",
            "\1\u008c",
            "",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u008e",
            "",
            "",
            "\1\u008f",
            "\1\u0090",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0095",
            "",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='p') ) {s = 1;}

                        else if ( (LA13_0==';') ) {s = 2;}

                        else if ( (LA13_0=='c') ) {s = 3;}

                        else if ( (LA13_0=='{') ) {s = 4;}

                        else if ( (LA13_0=='}') ) {s = 5;}

                        else if ( (LA13_0=='l') ) {s = 6;}

                        else if ( (LA13_0=='=') ) {s = 7;}

                        else if ( (LA13_0=='t') ) {s = 8;}

                        else if ( (LA13_0=='f') ) {s = 9;}

                        else if ( (LA13_0=='(') ) {s = 10;}

                        else if ( (LA13_0==')') ) {s = 11;}

                        else if ( (LA13_0=='r') ) {s = 12;}

                        else if ( (LA13_0=='u') ) {s = 13;}

                        else if ( (LA13_0=='n') ) {s = 14;}

                        else if ( (LA13_0=='s') ) {s = 15;}

                        else if ( (LA13_0=='[') ) {s = 16;}

                        else if ( (LA13_0==']') ) {s = 17;}

                        else if ( (LA13_0==',') ) {s = 18;}

                        else if ( (LA13_0=='<') ) {s = 19;}

                        else if ( (LA13_0=='>') ) {s = 20;}

                        else if ( (LA13_0=='.') ) {s = 21;}

                        else if ( (LA13_0=='?') ) {s = 22;}

                        else if ( (LA13_0=='e') ) {s = 23;}

                        else if ( (LA13_0=='&') ) {s = 24;}

                        else if ( (LA13_0=='*') ) {s = 25;}

                        else if ( (LA13_0=='i') ) {s = 26;}

                        else if ( (LA13_0=='^') ) {s = 27;}

                        else if ( (LA13_0=='$'||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='b')||LA13_0=='d'||(LA13_0>='g' && LA13_0<='h')||(LA13_0>='j' && LA13_0<='k')||LA13_0=='m'||LA13_0=='o'||LA13_0=='q'||(LA13_0>='v' && LA13_0<='z')) ) {s = 28;}

                        else if ( (LA13_0=='\"') ) {s = 29;}

                        else if ( (LA13_0=='\'') ) {s = 30;}

                        else if ( (LA13_0=='/') ) {s = 31;}

                        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {s = 32;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||LA13_0=='#'||LA13_0=='%'||LA13_0=='+'||LA13_0=='-'||(LA13_0>='0' && LA13_0<=':')||LA13_0=='@'||LA13_0=='\\'||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFF')) ) {s = 33;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}