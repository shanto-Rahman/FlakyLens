@Test public void testIssue34_Scenario1() throws ScriptCPUAbuseException, ScriptException {
Assert.assertTrue(logger.getOutput().contains("loop cnt-0"));//IT
}