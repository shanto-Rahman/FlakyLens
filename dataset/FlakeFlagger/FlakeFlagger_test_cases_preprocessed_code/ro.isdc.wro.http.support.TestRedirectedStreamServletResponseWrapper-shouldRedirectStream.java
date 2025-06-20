@Test public void shouldRedirectStream() throws Exception {
Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}