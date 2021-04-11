expr (@public double res = 0.0;@) = {@res = term.res + addSub.res;@} term addSub;

addSub (@public double res = 0.0;@) = {@res = term.res + addSub.res;@} PLUS term addSub
                                    | {@res = -term.res + addSub.res;@}  MINUS term addSub
                                    | <>;

term (@public double res = 1.0;@) = {@res = value.res * mulDiv.res;@} value mulDiv;

mulDiv (@public double res = 1.0;@) = {@res = value.res * mulDiv.res;@} MULT value mulDiv
                                    | {@res = 1 / value.res * mulDiv.res;@} DIV value mulDiv
                                    | <>;

value (@public double res = 0.0;@)  = {@res = Integer.parseInt(NUMBER.text);@} NUMBER
                                    | {@res = -value.res;@} MINUS value
                                    | {@res = expr.res;@} LB expr RB;

NUMBER = "[0-9]+(\\.[0-9]+)?";
PLUS = "\\+";
MULT = "\\*";
DIV = "/";
MINUS = "-";
LB = "\\(";
RB = "\\)";