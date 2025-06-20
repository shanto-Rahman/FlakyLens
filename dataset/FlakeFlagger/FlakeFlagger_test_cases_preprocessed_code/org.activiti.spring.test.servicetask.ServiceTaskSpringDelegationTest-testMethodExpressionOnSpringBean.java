@Deployment public void testMethodExpressionOnSpringBean(){
assertEquals("ACTIVITI BPMN 2.0 PROCESS ENGINE",runtimeService.getVariable(procInst.getId(),"myVar"));
}