/** 
 * Verify 'If-None-Match' request header
 * @throws Exception
 */
@Test public void ifNoneMatchHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("If-None-Match"));
assertTrue(get(url).ifNoneMatch("eid").ok());//RW
assertEquals("eid",header.get());
}