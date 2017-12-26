package com.group8.grades;
import static org.junit.Assert.*;


import org.junit.Test;


public class NormalisePointsTest {

	@Test
	public void checkNormalisedValue() {  //checks the normalize functionality
		NormalisePoints normalise = new NormalisePoints();
		double[] res = new double[]{0.5,0.5};
		double scores[][] = new double[][] {{4,4,5},{5,4,4}} ;
		double[] resCheck = normalise.normalisePoints(scores);
	    assertArrayEquals(res, resCheck, 0.00);
	}
	
	@Test
	public void checkNullInput() { //when input is null
		NormalisePoints normalise = new NormalisePoints();
		double scores[][] = null;
		double[] res2 = normalise.normalisePoints(scores);
	    assertNull(res2);
	}
	
	@Test
	public void checkFewerColsInput() {   //for number of columns less than 3 in input
		NormalisePoints normalise = new NormalisePoints();
		double scores[][] = new double[][] {{4,5},{5,4,4}} ;
		double res[] = {-1};
		double[] resCheck = normalise.normalisePoints(scores);
	    assertArrayEquals(res,resCheck,0.00);
	}
	
	@Test
	public void checkExtraColsInput() {   //for number of columns more than 3 in input
		NormalisePoints normalise = new NormalisePoints();
		double scores[][] = new double[][] {{4,5,5,6},{5,4,4}} ;
		double res[] = {-1};
		double[] resCheck = normalise.normalisePoints(scores);
	    assertArrayEquals(res,resCheck,0.00);
	}
	
	@Test
	public void checkInputType() {   //for checking the input correctness in terms of input type
		NormalisePoints normalise = new NormalisePoints();
		double scores[][] = new double[][] {{100,45,67},{4,5,6}} ;
		double res[] = {-1};
		double[] resCheck = normalise.normalisePoints(scores);
	    assertArrayEquals(res,resCheck,0.00);
	}
	
    @Test
	public void checkInputValues() { //the inputs should be in range of 1-5
		NormalisePoints normalise = new NormalisePoints();
		double res[] = {-1};
		double scores[][] = new double[][] {{4,7,5},{5,4,8}};
		double[] res2 = normalise.normalisePoints(scores);
	    assertArrayEquals(res, res2, 0.00);
	}
	
    @Test
	public void checkNullOutput() { //when output is null
		NormalisePoints normalise = new NormalisePoints();
		double scores[][] = null;
		double[] res2 = normalise.normalisePoints(scores);
	    assertNull(res2);
	}

}
