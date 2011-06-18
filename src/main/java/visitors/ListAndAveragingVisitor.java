package visitors;

import java.math.BigDecimal;

import list.ListVisitor;

public class ListAndAveragingVisitor<E extends BigDecimal> implements ListVisitor<E> {

	String catted = "";
	int numberVisits = 0;
	
	BigDecimal sum = new BigDecimal(0);
	
	@Override
	public void visit(final BigDecimal e) {
		
		catString(e.toString());
		sum = sum.add(e);
		
		numberVisits++;
	}

	private void catString(final String str){
		if(numberVisits != 0){
			catted += " ";
		}
		catted += str;
	}
	
	public String getListString(){
		return this.catted;
	}
	
	public BigDecimal getAverage(){
		return sum.divide(new BigDecimal(numberVisits));
	}
	
	@Override
	public String toString()
	{	
		return "The list of numbers is " + getListString() + " The average is " + getAverage();
	}
	
}
