/** 
 * Test that the custom 404 error page is seen
 * @throws Exception
 */
@Test @OperateOnDeployment("error-producer.war") public void test404Error(@ArquillianResource(ErrorGeneratorServlet.class) URL baseURL) throws Exception {
}