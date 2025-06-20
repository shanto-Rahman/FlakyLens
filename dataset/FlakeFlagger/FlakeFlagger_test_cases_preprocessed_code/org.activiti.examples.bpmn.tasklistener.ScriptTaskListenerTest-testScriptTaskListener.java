@Deployment(resources={"org/activiti/examples/bpmn/tasklistener/ScriptTaskListenerTest.bpmn20.xml"}) public void testScriptTaskListener(){
assertEquals("Name does not match","All your base are belong to us",task.getName());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals("kermit",historicTask.getOwner());
assertEquals("Task name not set with 'bar' variable","BAR",task.getName());
}
assertNull("Expected 'bar' variable to be local to script",bar);
assertEquals("Could not find the 'foo' variable in variable scope","FOO",foo);
}