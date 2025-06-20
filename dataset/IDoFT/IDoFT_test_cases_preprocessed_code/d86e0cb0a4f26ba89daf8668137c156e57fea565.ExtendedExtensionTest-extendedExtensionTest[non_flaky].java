@Test public void extendedExtensionTest() throws DeploymentException {
EXTENDED_EXTENSION=new MyExtendedExtension();//RW
extensions.add(EXTENDED_EXTENSION);//RW
assertEquals(1,session.getNegotiatedExtensions().size());
assertEquals(EXTENDED_EXTENSION,extension);//RW
assertTrue(messageLatch.await(1,TimeUnit.SECONDS));
assertEquals(2,EXTENDED_EXTENSION.incomingCounter.get());//RW
assertEquals(2,EXTENDED_EXTENSION.outgoingCounter.get());//RW
assertNotNull(EXTENDED_EXTENSION.onExtensionNegotiation);//RW
assertNotNull(EXTENDED_EXTENSION.onHandshakeResponse);//RW
assertEquals(1,EXTENDED_EXTENSION.onHandshakeResponse.size());//RW
assertEquals("param1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getName());//RW
assertEquals("value1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getValue());//RW
assertEquals(EXTENDED_EXTENSION.getParameters().size(),EXTENDED_EXTENSION.onExtensionNegotiation.size());//RW
assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getName(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getName());//RW
assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getValue(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getValue());//RW
}