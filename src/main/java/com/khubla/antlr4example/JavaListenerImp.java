

package com.khubla.antlr4example;

import com.khubla.antlr4example.java.JavaParser;
import com.khubla.antlr4example.java.JavaParserBaseListener;

public class JavaListenerImp extends JavaParserBaseListener {

    @Override
    public void enterCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        System.out.print('\"');
    }

    @Override
    public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        System.out.print('\"');
    }
}
