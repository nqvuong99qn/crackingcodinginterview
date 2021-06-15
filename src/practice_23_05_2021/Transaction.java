package practice_23_05_2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Transaction implements Comparable<Transaction>{
	
	private final String who;
	private final Date when;
	private final double amount;
	
	
	/**
	 * Initializes a new transaction  from given arguments
	 * @param who the person involved in this transaction
	 * @param when the date of this transaction
	 * @param amount the amout of this transaction
	 * @throws IllegalArgumentException if {@code amount}
	 * 			is {@code Double.NaN}, {@code Double.infinite}
	 */
	
	public Transaction(String who, Date when, double amount) {
		if(Double.isNaN(amount) || Double.isInfinite(amount))
			throw new IllegalArgumentException("Amount can be not a NaN or infinite");
		
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	
	/**
	 * Initializes a new transaction by parsing from a string of form NAME DATE AMOUNT
	 * @param transaction string to parse
	 * 
	 */
	public Transaction(String transaction) {
		
		String[] a = transaction.split("\\s+");
		who = a[0];
		when = new Date(a[1]);
		amount = Double.parseDouble(a[2]);
		
		if(Double.isNaN(amount) || Double.isInfinite(amount))
			throw new IllegalArgumentException("Amount can be not a NaN or infinite");
		
	}
	
	/**
	 * Return the name of customer involved in this transaction
	 * @return the name of the customer involved in this transaction
	 */
	public String who() {
		return who;
	}
	
	/**
	 * Return the date of this transaction
	 * @return Return the date of this transaction
	 */
	public Date when() {
		return when;
	}
	
	/**
	 * Return amount of this transaction
	 * @return Return amount of this transaction
	 */
	public double amount() {
		return amount;
	}

	
	/**
	 * Compares transaction by amount
	 * @param that the other transaction
	 * @return { a negative integer, zero, a positive integer}, depending on
	 *  whether the amount of this transaction  is {less than, equal to, greater than} the
	 *  amount of that transaction
	 * }
	 */
	@Override
	public int compareTo(Transaction that) {
		// TODO Auto-generated method stub
		return Double.compare(this.amount, that.amount);
	}
	
	
	/**
	 * Returns a string representation of this transaction
	 * @return a string representation of this transaction
	 */
	@Override
	public String toString() {
		return String.format("%-10s %10s %8.2f", who, when, amount);
	}
	
	
	public boolean equals(Object other) {
		if(other == this) return true;
		if(other == null) return false;
		
		if(other.getClass() != this.getClass()) return false;
		Transaction that = (Transaction)other;
		return (this.amount == that.amount) && (this.who.equals(that.who))
											&& (this.when.equals(that.when));
		
	}
	
	
	public static void main(String args[]) {
	
	}
	
	
	
	

}
