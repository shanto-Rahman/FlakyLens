@Test public void renderingUndefinedPartialThrowsException() throws IOException {
fail("rendering undefined partial throws an exception");
assertNotNull(error);
assertEquals("The partial '/whatever.hbs' could not be found",error.reason);
}