@Test public void testSerialize() throws SerializationException {
assertEquals("{\"operation\":\"GetUserId\",\"infoField1\":\"nobody@amazon.com\",\"infoField2\":\"AMZN\"}",requestString);
}