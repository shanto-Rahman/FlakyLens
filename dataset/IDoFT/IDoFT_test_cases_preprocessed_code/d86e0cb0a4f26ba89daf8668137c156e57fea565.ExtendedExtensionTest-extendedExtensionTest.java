@Test public void extendedExtensionTest() throws DeploymentException {
assertEquals(1,session.getNegotiatedExtensions().size());
assertEquals(EXTENDED_EXTENSION,extension);
assertTrue(messageLatch.await(1,TimeUnit.SECONDS));
assertEquals(2,EXTENDED_EXTENSION.incomingCounter.get());
assertEquals(2,EXTENDED_EXTENSION.outgoingCounter.get());
assertNotNull(EXTENDED_EXTENSION.onExtensionNegotiation);
assertNotNull(EXTENDED_EXTENSION.onHandshakeResponse);
assertEquals(1,EXTENDED_EXTENSION.onHandshakeResponse.size());
assertEquals("param1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getName());
assertEquals("value1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getValue());
assertEquals(EXTENDED_EXTENSION.getParameters().size(),EXTENDED_EXTENSION.onExtensionNegotiation.size());
assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getName(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getName());
assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getValue(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getValue());
}