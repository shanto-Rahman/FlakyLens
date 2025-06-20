/** 
 * Test that the custom 500 error page is seen for an exception
 * @throws Exception
 */
@Test @OperateOnDeployment("error-producer.war") public void testExceptionError(@ArquillianResource(ErrorGeneratorServlet.class) URL baseURL) throws Exception {
}