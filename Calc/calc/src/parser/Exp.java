package parser;

import eval.State;
import lexer.SLexer;
import lexer.tokens.*;
import lexer.tokens.Integer;

import java.io.IOException;

public abstract class Exp extends AST {

	public abstract int eval(State<java.lang.Integer> state/*, State<java.lang.Integer> state*/) throws IOException;

	/**
	 * Parses an expression starting at the first {@link Token}
	 * Either:
	 *   - An {@link Integer}
	 *   - A full expression (starting with {@link LPar} and ending with tail)
	 * @param token
	 * @return
	 * @throws IOException
	 */
	static Exp parseSimpleExp(final Token token) throws IOException {
		if (token instanceof Integer) {
			return new IntLit(((Integer) token).getValue());
		} else if (token instanceof LPar) {
			final Token next = SLexer.getToken();
			return parseCompositeExpTail(next);
		} else if (token instanceof Identifier) {
			return new VarId((Identifier) token);
		}

		throw new SyntaxError(token.toString());
	}

	/**
	 * Parses an expression starting after the LPAR.
	 * Either:
	 *   - An {@link UnExp} (starting with '-' and one {@link Exp})
	 *   - A {@link BinExp} (starting with an {@link Op} and two {@link Exp}s)
	 *   - A {@link CondExp} (starting with 'if' and three {@link Exp}s)
	 * @param token The starting {@link Token}
	 * @return The parsed {@link Exp}
	 * @throws IOException
	 */
	static Exp parseCompositeExpTail(Token token) throws IOException {
		if (token instanceof Op) {
			final Op op = (Op)token;
			final Exp exp1 = parseSimpleExp(SLexer.getToken());
			final Token afterExp1 = SLexer.getToken();

			if (op.getValue() == Op.Value.MINUS && afterExp1 instanceof RPar) {
				return new UnExp(exp1);
			} else {
				final Exp exp2 = parseSimpleExp(afterExp1);
				final Token afterExp2 = SLexer.getToken();

				if (afterExp2 instanceof RPar) {
					return new BinExp(op, exp1, exp2);
				}

				throw new SyntaxError(afterExp2.toString());
			}
		} else if (token instanceof If) {
			final Exp exp1 = parseSimpleExp(SLexer.getToken());
			final Exp exp2 = parseSimpleExp(SLexer.getToken());
			final Exp exp3 = parseSimpleExp(SLexer.getToken());
			final Token afterExp3 = SLexer.getToken();

			if (afterExp3 instanceof RPar) {
				return new CondExp(exp1, exp2, exp3);
			}

			throw new SyntaxError(afterExp3.toString());
		}

		throw new SyntaxError(token.toString());
	}

}
