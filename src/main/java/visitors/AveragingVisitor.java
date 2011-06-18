package visitors;

import java.math.BigDecimal;

import list.ListVisitor;

public class AveragingVisitor<E extends BigDecimal> implements ListVisitor<E> {

	BigDecimal sum = new BigDecimal(0);
	int numOfNumbers = 0;
	
	@Override
	public void visit(final BigDecimal element)
	{
		sum = sum.add(element);
		numOfNumbers += 1;
	}

	public BigDecimal getAverage(){

		return sum.divide(new BigDecimal(numOfNumbers));
	}
}
