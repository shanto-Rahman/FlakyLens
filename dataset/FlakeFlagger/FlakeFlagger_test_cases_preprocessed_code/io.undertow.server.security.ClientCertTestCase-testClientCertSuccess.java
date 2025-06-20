@Test public void testClientCertSuccess() throws Exception {
client.setSSLContext(clientSSLContext);//RW
assertEquals(200,result.getStatusLine().getStatusCode());
assertEquals("ProcessedBy Headers",1,values.length);
assertEquals("ResponseHandler",values[0].getValue());
assertEquals("AuthenticatedUser Headers",1,values.length);
assertEquals("CN=Test Client,OU=OU,O=Org,L=City,ST=State,C=GB",values[0].getValue());
}