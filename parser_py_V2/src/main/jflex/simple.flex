//user_code
package org.example;
import java.io.*;
import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;
%%
//options and declarations

%public
%class Lexer
%type Token
%line
%column

L = [a-zA-Z_]
LetterOrDigitOrScript = [A-Za-z0-9_]
D=[0-9]
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = [ \t\r]

/* comments */
comentario = "#" {InputCharacter}* {LineTerminator}?
/*comilla doble*/
doble = "\"" {InputCharacter}* "\""
/*comilla simple*/
simple = "\'" {InputCharacter}* "\'"

%eofval{
    return new Token();
%eofval}

%%
//lexical rules
var |
as |
assert |
break |
class |
continue |
def |
del |
elif |
else |
except |
False |
finally |
for |
from |
global |
if |
import |
in |
is |
lambda |
None |
nonlocal |
pass |
raise |
return |
True |
try |
while |
with |
yield {return new Token(TokenEnum.KW, yytext(), "KW", yyline + 1, yycolumn + 1);}

"(" |
")" |
"[" |
"]" |
"{" |
"}" |
"," |
"." |
";" |
":" {return new Token(TokenEnum.OTHER, yytext(), yytext(), yyline + 1, yycolumn + 1);}

"+" |
"-" |
"**" |
"/" |
"//" |
"%" |
"*" {return new Token(TokenEnum.ARITHMETIC, yytext(), yytext(), yyline + 1 , yycolumn + 1);}

"==" |
"!=" |
">" |
"<" |
">=" |
"<=" {return new Token(TokenEnum.COMPARISON, yytext(), yytext(), yyline + 1 , yycolumn + 1);}

and |
or |
not {return new Token(TokenEnum.LOGIC, yytext(),yytext(), yyline + 1 , yycolumn + 1);}

"=" |
"*=" |
"-=" |
"+=" |
"/=" {return new Token(TokenEnum.ASSIGNMENT, yytext(),yytext(), yyline + 1 , yycolumn + 1);}

{comentario} {return new Token(TokenEnum.COMMENT,yytext(), "\\w",yyline + 1, yycolumn + 1);}
{doble} {return new Token(TokenEnum.CONST, yytext(), "\\w", yyline + 1, yycolumn + 1);}
{simple} {return new Token(TokenEnum.CONST, yytext(), "\\w", yyline + 1, yycolumn + 1);}
{L}({LetterOrDigitOrScript})* {return new Token(TokenEnum.ID, yytext(), "\\w", yyline + 1, yycolumn + 1);}
{D}+ |
{D}+ (("."){D}+)   {return new Token(TokenEnum.CONST, yytext(), "\\d", yyline + 1, yycolumn + 1);}
{WhiteSpace}+ {/* ignore */}
{LineTerminator}+ {/* ignore */}
[^] {return new Token(TokenEnum.ERROR, yyline + 1, yycolumn + 1);}