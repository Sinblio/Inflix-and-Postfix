package edu.iastate.cs228.hw4;

/**
 *  
 * @author
 *
 */

/**
 * 
 * This class evaluates input infix and postfix expressions. 
 *
 */

import java.util.HashMap;
import java.util.Scanner;

public class InfixPostfix 
{

	/**
	 * Repeatedly evaluates input infix and postfix expressions.  See the project description
	 * for the input description. It constructs a HashMap object for each expression and passes it 
	 * to the created InfixExpression or PostfixExpression object. 
	 *  
	 * @param args
	 **/
	public static void main(String[] args) 
	{
		System.out.println("Evaluation of Infix and Postfix Expressions");
		System.out.println("keys: 1 (standard input) 2 (file input) 3 (exit)");
		System.out.println("(Enter “I” before an infix expression, “P” before a postfix expression”)");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		String res;
		int count = 1;
		
		System.out.print("Trial " + count + ":");
		res = in.next();
		
		count++;
		
		while(!res.equals("3"))
		{
			if (res.equals("1"));
			{
				System.out.print("Expression: ");
				String eq = in.next();
				
				if(eq.charAt(0) == 'I')
				{
					InfixExpression i = new InfixExpression(eq.substring(1));
					
					System.out.println("Infix form: " + i.toString());
					System.out.println("Postfix form; " + i.postfixString());;
					
					char[] ary = eq.toCharArray();
					
					int var = 0;
					
					for (char x : ary)
					{
						if (Expression.isVariable(x))
						{
							var ++;
						}
					}
					
					if (var > 0) 
					{
						HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
								
						for (char x : ary)
						{
							if (Expression.isVariable(x))
							{
								System.out.print(String.valueOf(x) + " = ");
								int val = Integer.parseInt(in.next());
								hashMap.put(x, val);
							}
						}
						
						i = new InfixExpression(eq.substring(1), hashMap);
					}
					
					System.out.println("Expression Value: " + i.evaluate());
				}
				if(eq.charAt(0) == 'P')
				{
					PostfixExpression p = new PostfixExpression(eq.substring(1));
					
					System.out.println("Postfix form: " + p.toString());
					
					char[] ary = eq.toCharArray();
					
					int var = 0;
					
					for (char x : ary)
					{
						if (Expression.isVariable(x))
						{
							var ++;
						}
					}
					
					if (var > 0) 
					{
						HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
								
						for (char x : ary)
						{
							if (Expression.isVariable(x))
							{
								System.out.print(String.valueOf(x) + " = ");
								int val = Integer.parseInt(in.next());
								hashMap.put(x, val);
							}
						}
						
						p = new PostfixExpression(eq.substring(1), hashMap);
					}
					
					try 
					{
						System.out.println("Expression Value: " + p.evaluate());
					} 
					catch (ExpressionFormatException e) 
					{
						
					}
				}
			}
			if (res.equals("2"))
			{
				//TODO
			}
			
			System.out.println();
			System.out.print("Trial " + count + ":");
			res = in.next();
			
			count++;
		}
	}
	
	// helper methods if needed
}
