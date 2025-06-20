public void testExecuteAsync() throws Exception {
Thread.sleep(2000);
assertEquals(0,handler.getExitValue());
assertEquals("FOO..",baos.toString().trim());
}