@Test public void test_no_abuse() throws ScriptCPUAbuseException, ScriptException {
  final NashornSandbox sandbox=NashornSandboxes.create();
  try {
    sandbox.setMaxMemory(MEMORY_LIMIT);
    sandbox.setExecutor(Executors.newSingleThreadExecutor());
    final String js="var o={},i=0; while(i<10) {o[i++] = 'abc';}";
    sandbox.eval(js);
  }
 catch (  final Exception e) {
    fail("No exception should be thrown");
  }
 finally {
    sandbox.getExecutor().shutdown();
  }
}
