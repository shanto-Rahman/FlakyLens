@Test public void encoderCharset() throws JoranException, IOException, InterruptedException {
assertNotNull(consoleAppender);
assertEquals("UTF-8",encoder.getCharset().displayName());
}