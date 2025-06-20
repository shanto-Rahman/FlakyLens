@Test(timeout=15000) public void testSlowNM() throws Exception {
Assert.assertEquals("Num tasks is not correct",1,tasks.size());
Assert.assertEquals("Num attempts is not correct",maxAttempts,attempts.size());
Assert.assertTrue(diagnostics.contains("Container launch failed for " + "container_0_0000_01_000000 : "));
Assert.assertTrue(diagnostics.contains("java.net.SocketTimeoutException: 3000 millis timeout while waiting for channel"));
}