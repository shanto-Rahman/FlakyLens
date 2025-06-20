/** 
 * Basic test to prove detection of the ResponseHandler response.
 */
@Test public void testNoMechanisms() throws Exception {
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals(1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
}