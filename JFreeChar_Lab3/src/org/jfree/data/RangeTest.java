package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

/**
 * authors: Alexander Varga, Dominic Vanderkerkhove, Cedric John Acierto, Ivan Tompong
 * course: SENG438 - Assignment 2
 */

public class RangeTest {
    private Range exampleRangeAlex;
    private Range exampleRangeCedric;
    private Range exampleRangeIvan;
    private Range exampleRangeIvan2;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	exampleRangeAlex = new Range(-1, 1);
    	exampleRangeCedric = new Range(10.0, 20.0);
    }


    @Test
    public void testCentralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRangeCedric.getCentralValue(), .000000001d);
    }
    
    @Test
    public void testIntersectsLessThanRange() {
        //This test should return false because it does not intersect with
        //exampleRange.
        assertFalse("8.0-9.0 does not intersect", 
        		exampleRangeCedric.intersects(8.0, 9.0));
    }
    
    @Test
    public void testIntersectsTouchesLowerBound() {
        //This test should return true because intersects with exampleRange.
        assertTrue("9.0-10.0 intersects range", 
        		exampleRangeCedric.intersects(9.0, 10.0));
    }
    
    @Test
    public void testIntersectsWithinRange() {
        //This test should return true because intersects with exampleRange.
        assertTrue("15.0-16.0 intersects range", 
        		exampleRangeCedric.intersects(15.0, 16.0));
    }
    
    @Test
    public void testIntersectsTouchesUpperBound() {
        //This test should return true because intersects with exampleRange.
        assertTrue("20.0-21.0 intersects range",
        		exampleRangeCedric.intersects(20.0, 21.0));
    }
    
    @Test
    public void testIntersectsMoreThanRange() {
        //This test should return false because it does not intersect with
        //exampleRange.
        assertFalse("21.0-22.0 does not intersect range",
        		exampleRangeCedric.intersects(21.0, 22.0));
    }
    
    @Test
    public void testConstrainLessThanLowerBound() {
        //Tests for nearest value to 8.0 in the range.
        assertEquals("Nearest value should be lower bound.",
                10.0, exampleRangeCedric.constrain(8.0), 0.000000001d);
    }
    
    @Test
    public void testConstrainAtLowerBound() {
        //Tests for nearest value to 10.0 in the range.
        assertEquals("Nearest value should be lower bound.",
                10.0, exampleRangeCedric.constrain(10.0), 0.000000001d);
    }
    
    @Test
    public void testConstrainWithinRange() {
        //Tests for nearest value to 15.0 in the range.
        assertEquals("Nearest value should be the value itself",
                15.0, exampleRangeCedric.constrain(15.0), 0.000000001d);
    }
    
    @Test
    public void testConstrainAtUpperBound() {
        //Tests for nearest value to 20.0 in the range.
        assertEquals("Nearest value should be upper bound.",
                20.0, exampleRangeCedric.constrain(20.0), 0.000000001d);
    }
    
    @Test
    public void testConstrainMoreThanUpperBound() {
        //Tests for nearest value to 22.0 in the range.
        assertEquals("Nearest value should be upper bound.", 
                20.0, exampleRangeCedric.constrain(22.0), 0.000000001d);
    }
    
    @Test
    public void testRangeContainsTrue()
    {
    	//check for valid input in Range, expect true
    	assertTrue(exampleRangeAlex.contains(1.0));
    }
    
    @Test
    public void testRangeContainsFalse()
    {
    	//check for invalid input in Range, expect false
    	assertFalse(exampleRangeAlex.contains(2.0));
    }
    
    @Test
    // test getting a negative lower bound
    public void testNegativeGetLowerBound() {    
        
        // establish range with negative lower bound
        Range negLower = new Range(-10, 0);
        
        // use getLowerBound() to retrieve lower bound
        double lowerBound = negLower.getLowerBound();
        
        // assert the lower bound matches the expected value
        assertEquals("Expecting -10, got " +lowerBound, -10, lowerBound, .000000001d);
    }
    
    @Test
    // test getting a positive lower bound
    public void testPositiveGetLowerBound() {

        // establish range with positive lower bound
        Range posLower = new Range(10, 20);
        
        // use getLowerBound() to retrieve lower bound
        double lowerBound = posLower.getLowerBound();
        
        // assert the lower bound matches the expected value
        assertEquals("Expecting 10, got " +lowerBound, 10, lowerBound, .000000001d);
    }
    
    @Test
    // test getting a lower bound of 0
    public void testZeroGetLowerBound() {
        
        // establish range with a lower bound of 0
        Range zeroLower = new Range(0, 10);
        
        // use getLowerBound() to retrieve lower bound        
        double lowerBound = zeroLower.getLowerBound();
        
        // assert lower bound is 0
        assertEquals("Expecting 0, got " +lowerBound, 0, lowerBound, .000000001d);
    }
    
    @Test
    // test getting a negative upper bound
    public void testNegativeGetUpperBound() {
        
        //establish range with a negative upper bound
        Range negUpper = new Range(-20, -10);
        
        // use getUpperBound() to retrieve upper bound
        double upperBound = negUpper.getUpperBound();
        
        // assert the upper bound matches the expected value
        assertEquals("Expecting -10, got " +upperBound, -10, upperBound, .000000001d);
    }
    
    @Test
    // test getting a positive upper bound
    public void testPositiveGetUpperBound() {    
        
        //establish range with a positive upper bound
        Range posUpper = new Range(0, 10);
        
        // use getUpperBound() to retrieve upper bound
        double upperBound = posUpper.getUpperBound();
        
        // assert the upper bound matches the expected value
        assertEquals("Expecting 10, got " +upperBound, 10, upperBound, .000000001d);
    }
    
    @Test
    // test getting an upper bound of 0
    public void testZeroGetUpperBound() {    
        
        //establish range with an upper bound of 0
        Range zeroUpper = new Range(-10, 0);
        
        // use getUpperBound() to retrieve upper bound
        double upperBound = zeroUpper.getUpperBound();
        
        // assert upper bound is 0
        assertEquals("Expecting 0, got " +upperBound, 0, upperBound, .000000001d);
    }
    
    
    @Test
    // test getting range length
    public void testGetRangeLength() {    
        //establish range with an length of 10
        Range length = new Range(0, 10);
        
        // use getLength()
        double rangeLength = length.getLength();
        
        // assert range is 10
        assertEquals("Expecting 10, got " + rangeLength, 10, rangeLength, .000000001d);
    }
    
    @Test
    // test getting range to String output:
    // "Range[lower,upper]"
    public void testRangeToString() {    
        //establish range with an length of 10
        Range length = new Range(0, 10);
        
        // use toString
        String rangeString = length.toString();
        
        // assert range is formated properly
        assertTrue("Expecting String of output Range[0,10] got " + rangeString, rangeString.equals("Range[0,10]"));
    }
    
    
    
    @Test
    public void testIntersectsContainsWholeRange() {
    	//test should return true since the input range (-15, 15) contains the range (-10, 10)
    	
    	assertTrue("(-15, 15) intersects with (-10, 10), but intersects(double b0, double b1) returns false",
    			   exampleRangeIvan.intersects(-15, 15));
    }
    
    @Test
    public void testIntersectsInputUpperBoundArgLessThanInputLowerBoundArg() {
    	//test should return false since the input upper bound should to the function be equal to or greater than lower bound
    	
    	assertFalse("(-5, -15) is an invalid range since input upper bound to the function should be greather than or equal to lower bound, "
    				+ "	but intersects(double b0, double b1) returns true",
    			   exampleRangeIvan.intersects(-5, -15));
    }
    
    @Test
    public void testIntersectsUpperBoundLessThanInputLowerBound() {
    	//test should return false since upper bound should be equal to or greater than lower bound
    	
    	assertFalse("(20, 15) is an invalid range since upper bound should be greather than or equal to lower bound, "
    				+ "	but intersects(double b0, double b1) returns true",
    			   exampleRangeIvan.intersects(20, 15));
    }
    
    @Test
     public void testIntersectsRangeObjArgReturnTrue() {
    	//Test should return true, since (-5, 5) intersects with (-10, 10)
    	
    	Range testRange = new Range(-5, 5);
    	assertTrue("(-5, 5) intersects with (-10, 10) but function intersects(Range range) returns false\n", exampleRangeIvan.intersects(testRange));
    }
    
    @Test
    public void testIntersectsRangeObjArgReturnFalse() {
   	//Test should return false, since (20, 30) intersects with (20, 30)
   	
   	Range testRange = new Range(20, 30);
   	assertFalse("(20, 30) does not intersect with (-10, 10) but function intersects(Range range) returns true\n", exampleRangeIvan.intersects(testRange));
   }
    
    @Test
    public void testRangeIntersect() 
    {
    	 //establish range with a negative upper bound
        Range negUpper = new Range(-10, 10);
        Range valiRange = new Range(0, 10);
        
        // use getUpperBound() to retrieve upper bound
        boolean upperBound = negUpper.intersects(valiRange);
        
        // assert the upper bound matches the expected value
        assertTrue("Expecting true, got false", upperBound);
    }  

    @Test
    public void testHashCode() {
        Range testRange1 = new Range(0, 10);
        Range testRange2 = new Range(0, 10);
        
        int hash1 = testRange1.hashCode();
        int hash2 = testRange2.hashCode();
        
        assertEquals("Hash codes should be equal.", hash1, hash2);
    }

  @Test
    public void testIsNaNRangeFalse() {
    	//Tests to see if the Range of (-10, 10) is a NaN (Not a Number)
    	boolean testOutput = exampleRangeIvan.isNaNRange();
    	
    	//Asserts that isNaNRange() returns false
    	assertFalse("Range is not NaN, but isNaNRange() returns true",testOutput);
    }
    
    @Test
    public void testIsNaNRangeTrue() {
    	//Tests to see if the Range of (NaN, NaN) is a NaN (Not a Number)
    	
    	Double lower = Double.NaN; //Makes the lower bound a NaN
    	Double upper = Double.NaN; //Makes the upper bound a NaN
    	exampleRangeIvan = new Range(lower.doubleValue(), upper.doubleValue());
    	boolean testOutput = exampleRangeIvan.isNaNRange();
    	
    	//Asserts that isNaNRange() returns true
    	assertTrue("Range is a NaN, but isNaNRange() returns false", testOutput);
    }
    
    @Test
    public void testIsNaNRangeOneNumberOneNaN() {
    	//Tests to see if the Range of (NaN, 10) is a NaN (Not a Number)
    	
    	Double lower = Double.NaN; //Makes the lower bound a NaN
    	exampleRangeIvan = new Range(lower.doubleValue(), 10);
    	boolean testOutput = exampleRangeIvan.isNaNRange();
    	
    	//Asserts that isNaNRange() returns true
    	assertTrue( "Range is a NaN, but isNaNRange() returns false", testOutput);
    }
    
    @Test 
    public void testCombineRange1IsNull() {
    	//Tests the combine(Range range1, Range range2) function
    	exampleRangeIvan = null;
    	exampleRangeIvan2 = new Range(0 ,10);
    	
    	Range test = Range.combine(exampleRangeIvan, exampleRangeIvan2); 
    	
    	//Asserts that 'test' is equal to the range2 argument
    	assertEquals("The combined range should be equal to the 'range2' argument since 'range1' argument is null",
    					exampleRangeIvan, test);
    }
    
    @Test 
    public void testCombineRange2IsNull() {
    	//Tests the combine(Range range1, Range range2) function
    	exampleRangeIvan = new Range(0 ,10);
    	exampleRangeIvan2 = null;
    	Range test = Range.combine(exampleRangeIvan, exampleRangeIvan2); 
    	
    	//Asserts that 'test' is equal to the range1 argument
    	assertEquals("The combined range should be equal to the 'range1' argument since 'range2' argument is null",
    					exampleRangeIvan, test);
    }
    
    @Test 
    public void testCombineNoNullInputs() {
    	//Tests the combine(Range range1, Range range2) function
    	exampleRangeIvan = new Range(0, 10);
    	exampleRangeIvan2 = new Range(0, 10);
    	Range test = Range.combine(exampleRangeIvan, exampleRangeIvan2); 
    	Range expected = new Range(0, 20);
    	
    	//Asserts that the resulting combined range of (-10, 10) and (15, 30) is equal to the expected range of (-10, 30)
    	assertEquals("The combined range should be equal to (0, 20) since the input ranges are (0, 10) and (0, 10)",
    					expected, test);
    }
    
    
    
    @Test
    public void testCombineIgnoringNaNRange1IsNaN() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input1 = new Range(Double.NaN, Double.NaN);
    	Range test = Range.combineIgnoringNaN(input1, exampleRangeIvan);
    	Range expected = new Range(Double.NaN, 10);
    	
    	
    	assertEquals("The combined range should be (NaN, 10) since the input ranges are (NaN, NaN) and (-10, 10)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNRange2IsNaN1() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input1 = new Range(Double.NaN, Double.NaN);
    	Range test = Range.combineIgnoringNaN(exampleRangeIvan2, input1);
    	Range expected = new Range(Double.NaN, 30);
    	
    	
    	assertEquals("The combined range should be (NaN, 30) since the input ranges are (NaN, NaN) and(15, 130)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNAllNaNInputs() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input1 = new Range(Double.NaN, Double.NaN);
    	Range input2 = new Range(Double.NaN, Double.NaN);
    	Range test = Range.combineIgnoringNaN(input1, input2);
    	Range expected = null;
    	
    	
    	assertEquals("The combined range should be (NaN, NaN) since the input ranges are (NaN, NaN) and (NaN, NaN)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNZeroNaNInputs() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range test = Range.combineIgnoringNaN(exampleRangeIvan, exampleRangeIvan2);
    	Range expected = new Range(-10, 30);
    	
    	
    	assertEquals("The combined range should be (-10, 30) since the input ranges are (-10, 10) and (15, 30)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNRange1IsNull() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range test = Range.combineIgnoringNaN(null, exampleRangeIvan2);
    	Range expected = new Range(15, 30);
    	
    	
    	assertEquals("The combined range should be (15, 30) since the input ranges are null and (15, 30)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNRange2IsNull() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range test = Range.combineIgnoringNaN(exampleRangeIvan2, null);
    	Range expected = new Range(15, 30);
    	
    	
    	assertEquals("The combined range should be (15, 30) since the input ranges are null and (15, 30)",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNRange1IsNullRange2IsNaN() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input = new Range(Double.NaN, Double.NaN);
    	Range test = Range.combineIgnoringNaN(null, input);
    	Range expected = null;
    	
    	
    	assertEquals("The combined range should be null since the input ranges are null and NaN",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNRange2IsNullRange1IsNaN() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input = new Range(Double.NaN, Double.NaN);
    	Range test = Range.combineIgnoringNaN(input, null);
    	Range expected = null;
    	
    	
    	assertEquals("The combined range should be null since the input ranges are null and NaN",expected, test);
    }
    
    @Test
    public void testCombineIgnoringNaNAllNullInput() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	
    	Range test = Range.combineIgnoringNaN(null, null);
    	Range expected = null;
    	
    	
    	assertEquals("The combined range should be null since the input ranges are null and null",expected, test);
    }
    
    
    @Test
    public void testCombineIgnoringNaNUpperBoundIsNaNButLowerBoundIsNotNaN() {
    	//Tests the function combineIgnoringNaN(Range range1, Range range2)
    	Range input1 = new Range(-15, Double.NaN);
    	Range input2 = new Range(-10, Double.NaN);
    	Range test = Range.combineIgnoringNaN(input1, input2);
    	Range expected = new Range(-15, Double.NaN);
    	
    	
    	assertEquals("The combined range should be (-15, NaN) since the input ranges are (-15, NaN) and (10, NaN)",expected, test);
    }
    
    @Test
  public void testValidScale() {
  	Range ref = new Range(-1, 1);
  	Range test;
  	//apply scale method
  	test = Range.scale(ref,  10);
  	
  	//ensure upper bound matches expected value
  	assertEquals(10.0, test.getUpperBound(),  .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(-10.0, test.getLowerBound(),  .000000001d);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeScale() {
  	Range ref = new Range(-1, 1);
  	Range test;
  	
  	//apply scale method (should throw exception)
  	test = Range.scale(ref,  -10);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testScaleWithNullRange() {
  	Range ref = null;
  	Range test;
  	
  	//apply scale method (should throw exception)
  	test = Range.scale(ref,  -10);
  }
  
  @Test
  public void testPositiveShiftWithZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  5, true);
  	
  	//ensure upper bound matches expected value
  	assertEquals(4, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(6, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testNegativeShiftWithZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  -5, true);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-6, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(-4, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testZeroShiftWithZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  0, true);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-1, test.getLowerBound(),  .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(1, test.getUpperBound(),  .000000001d);
  }
  
  
  @Test
  public void testPositiveShiftWithoutZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  5, false);
  	
  	//ensure upper bound matches expected value
  	assertEquals(0, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(6, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testNegativeShiftWithoutZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  -5, false);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-6, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(0, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testZeroShiftWithoutZeroCross() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  0, false);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-1, test.getLowerBound(),  .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(1, test.getUpperBound(),  .000000001d);
  }
  
  @Test
  public void testZeroShiftZeroRangeWithoutZeroCross() {
  	Range ref = new Range (0, 0);
  	//apply shift method
  	Range test = Range.shift(ref,  0, false);
  	
  	//ensure upper bound matches expected value
  	assertEquals(0, test.getLowerBound(),  .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(0, test.getUpperBound(),  .000000001d);
  }
  
  @Test
  public void testPositiveShift() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  5);
  	
  	//ensure upper bound matches expected value
  	assertEquals(4, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(6, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testNegativeShift() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  -5);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-6, test.getLowerBound(), .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(-4, test.getUpperBound(), .000000001d);
  }
  
  @Test
  public void testZeroShift() {
  	Range ref = new Range (-1, 1);
  	//apply shift method
  	Range test = Range.shift(ref,  0);
  	
  	//ensure upper bound matches expected value
  	assertEquals(-1, test.getLowerBound(),  .000000001d);
  	
  	//ensure lower bound matches expected value
  	assertEquals(1, test.getUpperBound(),  .000000001d);
  }
  
  @Test
  public void testExpandUpperGreaterThanLower() {
  	Range testRange = new Range(10, 20);
  	double lowerMargin = 0.5;
  	double upperMargin = 0.5;
  	
  	Range newRange = testRange.expand(testRange, lowerMargin, upperMargin);
  	
  	Range expRange = new Range(5, 25);	
  	assertEquals("Range should be (5, 25)", expRange, newRange);
  }
  
  @Test
  public void testExpandLowerGreaterThanUpper() {
  	Range testRange = new Range(0, 1);
  	double lowerMargin = -0.5;
  	double upperMargin = -0.7;
  	
  	Range newRange = testRange.expand(testRange, lowerMargin, upperMargin);
  	Range expRange = new Range(0.4, 0.4);
  	
  	assertEquals("Range should be (0.4, 0.4)", expRange, newRange);
  }
  
  @Test
  public void testExpandToIncludeNullRange() {
  	Range testRange = null;
  	double value = 1.0;
  	
  	Range newRange = testRange.expandToInclude(testRange, value);
  	Range expRange = new Range(value, value);

  	assertEquals("Range should be (1.0, 1.0)", expRange, newRange);
  }
  
  @Test
  public void testExpandToIncludeValueLessThanLowerBound() {
  	Range testRange = new Range(2, 3);
  	double value = 1.0;
  	
  	Range newRange = testRange.expandToInclude(testRange, value);
  	Range expRange = new Range(1.0, 3.0);

  	assertEquals("Range should be (1.0, 3.0)", expRange, newRange);
  }
  
  @Test
  public void testExpandToIncludeValueGreaterThanUpperBound() {
  	Range testRange = new Range(1, 2);
  	double value = 3.0;
  	
  	Range newRange = testRange.expandToInclude(testRange, value);
  	Range expRange = new Range(1.0, 3.0);

  	assertEquals("Range should be (1.0, 3.0)", expRange, newRange);
  	
  }
  
  @Test
  public void testExpandToIncludeValueEqualToRange() {
  	Range testRange = new Range(3, 3);
  	double value = 3.0;
  	
  	Range newRange = testRange.expandToInclude(testRange, value);
  	Range expRange = new Range(3.0, 3.0);

  	assertEquals("Range should be (3.0, 3.0)", expRange, newRange);
  }
  
  @Test
  public void testMaxMinRange1LowerNaN() {
  	Range testRange1 = new Range(Double.NaN, 2);
  	Range testRange2 = new Range(2, 3);
  	
  	Range newRange = Range.combineIgnoringNaN(testRange1, testRange2);
  	Range expRange = new Range(2.0, 3.0);

  	assertEquals("Range should be (2,3)", expRange, newRange);
  }
  
  @Test
  public void testMaxMinRange1UpperNaN() {
  	Range testRange1 = new Range(2, Double.NaN);
  	Range testRange2 = new Range(2, 3);
  	
  	Range newRange = Range.combineIgnoringNaN(testRange1, testRange2);
  	Range expRange = new Range(2, 3);

  	assertEquals("Range should be (2,3)", expRange, newRange);
  	
  }
  
  @Test
  public void testMaxMinRange2UpperNaN() {
  	Range testRange1 = new Range(2, 3);
  	Range testRange2 = new Range(2, Double.NaN);
  	
  	Range newRange = Range.combineIgnoringNaN(testRange1, testRange2);
  	Range expRange = new Range(2, 3);
  	
  	assertEquals("Range should be (2,3)", expRange, newRange);
  }
  
  @Test
  public void testMaxMinRange2LowerNaN() {
  	Range testRange1 = new Range(2, 3);
  	Range testRange2 = new Range(Double.NaN, 3);
  	
  	Range newRange = Range.combineIgnoringNaN(testRange1, testRange2);
  	Range expRange = new Range(2, 3);
  	
  	assertEquals("Range should be (2,3)", expRange, newRange);
  }
  
  @Test
  public void testMaxMinValidRange() {
  	Range testRange1 = new Range(1, 2);
  	Range testRange2 = new Range(3, 4);
  	
  	Range newRange = Range.combineIgnoringNaN(testRange1, testRange2);
  	Range expRange = new Range(1, 4);
  	
  	assertEquals("Range should be (1,4)", expRange, newRange);
  }

    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
