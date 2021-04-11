// Generated from Megagrammar.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MegagrammarParser}.
 */
public interface MegagrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void enterGram(MegagrammarParser.GramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#gram}.
	 * @param ctx the parse tree
	 */
	void exitGram(MegagrammarParser.GramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MegagrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MegagrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#initialattributes}.
	 * @param ctx the parse tree
	 */
	void enterInitialattributes(MegagrammarParser.InitialattributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#initialattributes}.
	 * @param ctx the parse tree
	 */
	void exitInitialattributes(MegagrammarParser.InitialattributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#parentattributes}.
	 * @param ctx the parse tree
	 */
	void enterParentattributes(MegagrammarParser.ParentattributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#parentattributes}.
	 * @param ctx the parse tree
	 */
	void exitParentattributes(MegagrammarParser.ParentattributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(MegagrammarParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(MegagrammarParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#onerule}.
	 * @param ctx the parse tree
	 */
	void enterOnerule(MegagrammarParser.OneruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#onerule}.
	 * @param ctx the parse tree
	 */
	void exitOnerule(MegagrammarParser.OneruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#syntezattributes}.
	 * @param ctx the parse tree
	 */
	void enterSyntezattributes(MegagrammarParser.SyntezattributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#syntezattributes}.
	 * @param ctx the parse tree
	 */
	void exitSyntezattributes(MegagrammarParser.SyntezattributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(MegagrammarParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(MegagrammarParser.ChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(MegagrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(MegagrammarParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MegagrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(MegagrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MegagrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(MegagrammarParser.NameContext ctx);
}