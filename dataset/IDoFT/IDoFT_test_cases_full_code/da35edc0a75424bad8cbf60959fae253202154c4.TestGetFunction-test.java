@Test public void test() throws ScriptCPUAbuseException, ScriptException {
  NashornSandbox sandbox=NashornSandboxes.create();
  sandbox.setMaxCPUTime(100);
  sandbox.setMaxMemory(50 * 1024);
  sandbox.allowNoBraces(false);
  sandbox.setMaxPreparedStatements(30);
  ExecutorService executor=Executors.newSingleThreadExecutor();
  sandbox.setExecutor(executor);
  sandbox.eval("function callMe() { return 42; };");
  final Object _get=sandbox.get("callMe");
  Assert.assertTrue(_get != null);
  executor.shutdown();
}
