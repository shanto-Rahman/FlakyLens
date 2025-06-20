@Test public void shouldRedirectWriter() throws Exception {
Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}