/** 
 * Verify reading response body for empty 200
 * @throws Exception
 */
@Test public void streamOfEmptyOkResponse() throws Exception {
handler=new RequestHandler()//RW
assertEquals("",get(url).body());//RW
}