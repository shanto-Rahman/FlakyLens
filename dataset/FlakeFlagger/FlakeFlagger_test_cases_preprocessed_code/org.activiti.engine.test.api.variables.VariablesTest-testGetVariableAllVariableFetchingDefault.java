@org.activiti.engine.test.Deployment public void testGetVariableAllVariableFetchingDefault(){
assertEquals(71,vars.size());
assertEquals("HELLO world",varValue);
}