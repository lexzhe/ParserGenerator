expr (@public double res = 0.0;@) = {@res = term.res + addSub.res;@} term addSub;

addSub (@public double res = 0.0;@) = {@res = term.res + addSub.res;@} PLUS term addSub
                                    | {@res = -term.res + addSub.res;@}  MINUS term addSub
                                    | <>;

term (@public double res = 1.0;@) = {@res = value.res * mulDiv.res;@} value mulDiv;

mulDiv (@public double res = 1.0;@) = {@res = value.res * mulDiv.res;@} MULT value mulDiv
                                    | {@res = 1 / value.res * mulDiv.res;@} DIV value mulDiv
                                    | <>;

value (@public double res = 0.0;@)  = {@res = Integer.parseInt(NUMBER.text);@} NUMBER
                                    | {@res = func.res;@} func
                                    | {@res = -value.res;@} MINUS value
                                    | {@res = expr.res;@} LB expr RB;

func (@public double res = 0.0;@) = {@switch (NAME.text) {case "sin": res = Math.sin(expr.res); break; case "max": res = Math.max(expr.res, exprs.argss.get(0)); break;}@} NAME LB expr exprs RB;


exprs (@public List<Double> argss = new ArrayList<>();@) = {@argss.add(expr.res); argss.addAll(exprs.argss);@} COMA expr exprs
                                                         |  <>;

NUMBER = "[0-9]+(\\.[0-9]+)?";
NAME = "[a-z][a-zA-Z]*";
COMA = ",";
PLUS = "\\+";
MULT = "\\*";
DIV = "/";
MINUS = "-";
LB = "\\(";
RB = "\\)";