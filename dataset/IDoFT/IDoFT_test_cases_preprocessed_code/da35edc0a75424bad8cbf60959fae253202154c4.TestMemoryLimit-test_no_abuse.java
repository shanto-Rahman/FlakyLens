@Test public void test_no_abuse() throws ScriptCPUAbuseException, ScriptException {
sandbox.setExecutor(Executors.newSingleThreadExecutor());
fail("No exception should be thrown");
}