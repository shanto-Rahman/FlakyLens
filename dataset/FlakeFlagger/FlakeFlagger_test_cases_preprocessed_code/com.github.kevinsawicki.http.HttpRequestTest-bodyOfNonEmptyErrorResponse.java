/** 
 * Verify reading response body for non-empty 400
 * @throws Exception
 */
@Test public void bodyOfNonEmptyErrorResponse() throws Exception {
handler=new RequestHandler()//RW
assertEquals("error",get(url).body());//RW
}