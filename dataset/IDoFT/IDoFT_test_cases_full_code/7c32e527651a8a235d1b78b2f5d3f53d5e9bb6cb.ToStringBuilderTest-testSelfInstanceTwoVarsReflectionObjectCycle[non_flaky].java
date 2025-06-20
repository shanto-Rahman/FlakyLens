/** 
 * Test a class that defines an ivar pointing to itself.  This test was created to show that handling cyclical object resulted in a missing endFieldSeparator call.
 */
@Test public void testSelfInstanceTwoVarsReflectionObjectCycle(){
  final SelfInstanceTwoVarsReflectionTestFixture test=new SelfInstanceTwoVarsReflectionTestFixture();
  assertEquals(this.toBaseString(test) + "[otherType=" + test.getOtherType().toString()+ ",typeIsSelf="+ this.toBaseString(test)+ "]",test.toString());
}
