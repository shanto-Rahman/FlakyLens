@Deployment public void testTriggerWithTransientVars(){
assertEquals("persistentValue02persistentValue01transientValue",result);
assertNull(runtimeService.getVariable(processInstance.getId(),"transientVar"));
}