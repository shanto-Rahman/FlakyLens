@Test public void catchingTheException() throws ExecutionException, InterruptedException {
fail("should have thrown an exception");
assertTrue(ex.getCause() instanceof RuntimeException);
assertEquals("exception!",ex.getCause().getMessage());
}