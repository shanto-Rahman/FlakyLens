/** 
 * Verify reading response body for empty 400
 * @throws Exception
 */
@Test public void bodyOfEmptyErrorResponse() throws Exception {
handler=new RequestHandler()//RW
assertEquals("",get(url).body());//RW
}