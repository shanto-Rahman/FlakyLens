@Test public void checkingTheException() throws ExecutionException, InterruptedException {
assertTrue(fut.isCompletedExceptionally());
assertTrue(ex instanceof RuntimeException);
assertEquals("exception!",ex.getMessage());
}