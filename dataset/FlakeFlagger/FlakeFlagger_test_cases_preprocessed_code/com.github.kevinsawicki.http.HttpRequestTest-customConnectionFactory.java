/** 
 * Verify custom connection factory
 */
@Test public void customConnectionFactory() throws Exception {
handler=new RequestHandler()//RW
return (HttpURLConnection)new URL(url).openConnection();//RW
ConnectionFactory factory=new ConnectionFactory()//RW
assertEquals(200,code);
}