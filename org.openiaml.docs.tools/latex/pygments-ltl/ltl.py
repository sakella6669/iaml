# -*- coding: utf-8 -*-
"""
    pygments.lexers.ltl
    ~~~~~~~~~~~~~~~~~~~~~~~~

    Lexer for LTL.
    Based on pygments.lexers.agile

    :license: BSD, see LICENSE for details.
"""

import re

from pygments.scanner import Scanner
from pygments.lexer import Lexer, RegexLexer, include, bygroups, using, \
                           this, combined
from pygments.token import \
     Text, Comment, Operator, Keyword, Name, String, Number, Punctuation, \
     Error

__all__ = ['LtlLexer']

# based on PythonLexer
class LtlLexer(RegexLexer):
    """
    For LTL source code [jevon mod].
    """

    name = 'LTL'
    aliases = ['ltl']
    filenames = ['*.ltl']
    mimetypes = ['text/x-ltl', 'application/x-ltl']

    tokens = {
        'root': [
            (r'\n', Text),
            (r'^(\s*)("""(?:.|\n)*?""")', bygroups(Text, String.Doc)),
            (r"^(\s*)('''(?:.|\n)*?''')", bygroups(Text, String.Doc)),
            (r'[^\S\n]+', Text),
            (r'--.*?\n', Comment.Single),
            (r'[]{}(),;[]', Punctuation),
            (r'\\\n', Text),
            (r'\\', Text),
            (r'(in|is|and|or|not)\b', Operator.Word),
            (r':=|!=|[-~+/*%=<>&^|.!:]', Operator),
            include('keywords'),
            include('builtins'),
            include('name'),
            (r'"(\\\\|\\"|[^"])*"', String),
            include('numbers'),
            (r'(oclIsTypeOf|allInstances|includes|isUnique|isEmpty|exists|forAll|size|'
             r'implies|asSet|includes)\b', Name.Function),
        ],
        'keywords': [
          # TODO not yet populated
            (r'(LTLSPEC|MODULE|VAR|ASSIGN|X|G|F|U|R|W|GF)\b', Keyword),
            (r'(next|case|esac|init)\b', Keyword),
            (r'(boolean)\b', Keyword.Type),
#            (r'(null)\b', Keyword.Constant), -- NuSMV does not have 'null'; in the code sample, 'null' is a normal constant
        ],
        'builtins': [
          # TODO not yet populated
#            (r'(self|none)\b', Name.Builtin),
        ],
        'numbers': [
            (r'[0-9][0-9]*\.[0-9]+([eE][0-9]+)?[fd]?', Number.Float),
            (r'0x[0-9a-f]+', Number.Hex),
            (r'[0-9]+L?', Number.Integer),
        ],
        'name': [
            (r'@[a-zA-Z0-9_.]+', Name.Decorator),
            ('[a-zA-Z_][a-zA-Z0-9_]*', Name),
        ],
    }
