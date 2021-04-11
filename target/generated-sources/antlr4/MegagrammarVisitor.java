// Generated from Megagrammar.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MegagrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MegagrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#gram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGram(MegagrammarParser.GramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MegagrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#initialattributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialattributes(MegagrammarParser.InitialattributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#parentattributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentattributes(MegagrammarParser.ParentattributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(MegagrammarParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#onerule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnerule(MegagrammarParser.OneruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#syntezattributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntezattributes(MegagrammarParser.SyntezattributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChain(MegagrammarParser.ChainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(MegagrammarParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegagrammarParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(MegagrammarParser.NameContext ctx);
}