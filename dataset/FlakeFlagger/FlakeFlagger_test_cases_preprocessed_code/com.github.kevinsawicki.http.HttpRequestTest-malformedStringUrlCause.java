/** 
 * Create request with malformed URL
 */
@Test public void malformedStringUrlCause(){
fail("Exception not thrown");
assertNotNull(e.getCause());
}