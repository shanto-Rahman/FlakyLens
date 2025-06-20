/** 
 * Append params with null values
 * @throws Exception
 */
@Test public void appendWithNullMappedQueryParamValues() throws Exception {
assertEquals("http://test.com/1?a=&b=",HttpRequest.append("http://test.com/1",params));
}