/** 
 * Test a class that defines an ivar pointing to itself.  This test was created to show that handling cyclical object resulted in a missing endFieldSeparator call.
 */
@Test public void testSelfInstanceTwoVarsReflectionObjectCycle(){
assertEquals(this.toBaseString(test) + "[otherType=" + test.getOtherType().toString()+ ",typeIsSelf="+ this.toBaseString(test)+ "]",test.toString());//IT
}