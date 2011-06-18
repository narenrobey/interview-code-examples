/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package list;

import java.math.BigDecimal;

import visitors.ListAndAveragingVisitor;

import list.listImpl.ListImpl;

/**
 *
 * @author robeyna
 */
public class ListImplDriver {

    public static void main(String [] args){
        

    	List<BigDecimal> list = new ListImpl<BigDecimal>();
    	
    	list.add(new BigDecimal("5"));
    	list.add(new BigDecimal("25"));
    	list.add(new BigDecimal("13"));
    	list.add(new BigDecimal("4928"));

    	ListVisitor<BigDecimal> visitor = new ListAndAveragingVisitor<BigDecimal>();
    	
    	list.forEach(visitor);
    	
    	System.out.println(visitor.toString());
    }
}
