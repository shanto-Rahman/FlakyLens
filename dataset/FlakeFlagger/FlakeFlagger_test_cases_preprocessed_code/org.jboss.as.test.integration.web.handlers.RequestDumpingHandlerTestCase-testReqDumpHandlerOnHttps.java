/** 
 * Testing app has request dumper handler registered. This test checks that request dump over the HTTPS is generated correctly.
 */
@Test @OperateOnDeployment(DEPLOYMENT_DUMP) public void testReqDumpHandlerOnHttps(@ArquillianResource URL url) throws Exception {
new RequestDumpingHandlerTestImpl.HttpsRequestDumpingHandlerTestImpl(httpsUrl.toURI(),logFilePath,true);//RW
}