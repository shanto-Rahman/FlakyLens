@Deployment public void testSimpleSubProcess(){
assertEquals("Task in subprocess",subProcessTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}