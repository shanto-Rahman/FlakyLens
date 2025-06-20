@Test public void should_throw_error_wrapping_catched_IOException() throws IOException {
fail("Expected a InputStreamsException to be thrown");
assertSame(cause,e.getCause());
}