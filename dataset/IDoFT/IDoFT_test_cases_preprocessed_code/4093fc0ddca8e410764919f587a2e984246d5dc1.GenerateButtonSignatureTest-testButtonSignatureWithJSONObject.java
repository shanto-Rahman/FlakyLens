@Test public void testButtonSignatureWithJSONObject() throws Exception {
Assert.assertTrue(signature.verify(Base64.decode(signatureString)));
}