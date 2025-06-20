@Deployment(resources={"org/activiti/examples/bpmn/executionlistener/ScriptExecutionListenerTest.bpmn20.xml"}) public void testScriptExecutionListener(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertTrue(varMap.containsKey("foo"));
assertEquals("FOO",varMap.get("foo"));
assertTrue(varMap.containsKey("var1"));
assertEquals("test",varMap.get("var1"));
assertFalse(varMap.containsKey("bar"));
assertTrue(varMap.containsKey("myVar"));
assertEquals("BAR",varMap.get("myVar"));
}
}