public void testExecuteWithError() throws Exception {
fail("Must throw ExecuteException");
assertEquals(1,e.getExitValue());
}