package com.khubla.antlr4example;

import java.io.IOException;
import java.io.InputStream;

import com.khubla.antlr4example.java.JavaLexer;
import com.khubla.antlr4example.java.JavaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


/**
 * @author Tom Everett
 */
class Main {
   public static void main(String[] args) {
      System.out.println("Antlr4 Example");
      try {
         /*
          * get the input file as an InputStream
          */
         InputStream inputStream = Main.class.getResourceAsStream("example1.txt");
         /*
          * make Lexer
          */
         JavaLexer lexer = new JavaLexer(CharStreams.fromStream(inputStream));
         /*
          * get a TokenStream on the Lexer
          */
         TokenStream tokenStream = new CommonTokenStream(lexer);
         /*
          * make a Parser on the token stream
          */
         JavaParser parser = new JavaParser(tokenStream);

         ParseTree tree=parser.compilationUnit();

         ParseTreeWalker walker = new ParseTreeWalker();

         JavaListenerImp javaListenerImp = new JavaListenerImp();

         walker.walk(javaListenerImp, tree);

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}