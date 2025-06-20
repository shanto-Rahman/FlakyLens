public void testExecuteAsyncWithError() throws Exception {
Thread.sleep(2000);
assertEquals(1,handler.getExitValue());
assertTrue(handler.getException() instanceof ExecuteException);
assertEquals("FOO..",baos.toString().trim());
}