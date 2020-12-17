//
//You are given a string expression representing a Lisp-like expression to retur
//n the integer value of.
// 
//The syntax for these expressions is given as follows.
// 
// An expression is either an integer, a let-expression, an add-expression, a mu
//lt-expression, or an assigned variable. Expressions always evaluate to a single 
//integer. 
// 
// (An integer could be positive or negative.) 
// 
// A let-expression takes the form (let v1 e1 v2 e2 ... vn en expr), where let i
//s always the string "let", then there are 1 or more pairs of alternating variabl
//es and expressions, meaning that the first variable v1 is assigned the value of 
//the expression e1, the second variable v2 is assigned the value of the expressio
//n e2, and so on sequentially; and then the value of this let-expression is the v
//alue of the expression expr. 
// 
// An add-expression takes the form (add e1 e2) where add is always the string "
//add", there are always two expressions e1, e2, and this expression evaluates to 
//the addition of the evaluation of e1 and the evaluation of e2. 
// 
// A mult-expression takes the form (mult e1 e2) where mult is always the string
// "mult", there are always two expressions e1, e2, and this expression evaluates 
//to the multiplication of the evaluation of e1 and the evaluation of e2. 
// 
// For the purposes of this question, we will use a smaller subset of variable n
//ames. A variable starts with a lowercase letter, then zero or more lowercase let
//ters or digits. Additionally for your convenience, the names "add", "let", or "m
//ult" are protected and will never be used as variable names. 
// 
// Finally, there is the concept of scope. When an expression of a variable name
// is evaluated, within the context of that evaluation, the innermost scope (in te
//rms of parentheses) is checked first for the value of that variable, and then ou
//ter scopes are checked sequentially. It is guaranteed that every expression is l
//egal. Please see the examples for more details on scope. 
// 
//
// Evaluation Examples: 
// 
//Input: (add 1 2)
//Output: 3
//
//Input: (mult 3 (add 2 3))
//Output: 15
//
//Input: (let x 2 (mult x 5))
//Output: 10
//
//Input: (let x 2 (mult x (let x 3 y 4 (add x y))))
//Output: 14
//Explanation: In the expression (add x y), when checking for the value of the v
//ariable x,
//we check from the innermost scope to the outermost in the context of the varia
//ble we are trying to evaluate.
//Since x = 3 is found first, the value of x is 3.
//
//Input: (let x 3 x 2 x)
//Output: 2
//Explanation: Assignment in let statements is processed sequentially.
//
//Input: (let x 1 y 2 x (add x y) (add x y))
//Output: 5
//Explanation: The first (add x y) evaluates as 3, and is assigned to x.
//The second (add x y) evaluates as 3+2 = 5.
//
//Input: (let x 2 (add (let x 3 (let x 4 x)) x))
//Output: 6
//Explanation: Even though (let x 4 x) has a deeper scope, it is outside the con
//text
//of the final x in the add-expression.  That final x will equal 2.
//
//Input: (let a1 3 b2 (add a1 1) b2) 
//Output 4
//Explanation: Variable names can contain digits after the first character.
//
// 
//
// Note:
// The given string expression is well formatted: There are no leading or traili
//ng spaces, there is only a single space separating different components of the s
//tring, and no space between adjacent parentheses. The expression is guaranteed t
//o be legal and evaluate to an integer. 
// The length of expression is at most 2000. (It is also non-empty, as that woul
//d not be a legal expression.) 
// The answer and all intermediate calculations of that answer are guaranteed to
// fit in a 32-bit integer. 
// Related Topics String




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evaluate(String expression) {
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
