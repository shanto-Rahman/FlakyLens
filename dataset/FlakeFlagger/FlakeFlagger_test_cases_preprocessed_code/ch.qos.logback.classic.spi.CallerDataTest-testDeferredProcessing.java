/** 
 * This test verifies that in case caller data cannot be extracted, CallerData.extract does not throw an exception
 */
@Test public void testDeferredProcessing(){
assertNotNull(cda);
assertEquals(0,cda.length);
}