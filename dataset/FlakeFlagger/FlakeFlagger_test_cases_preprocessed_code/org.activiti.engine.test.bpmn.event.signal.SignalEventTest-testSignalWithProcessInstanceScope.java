@Deployment public void testSignalWithProcessInstanceScope(){
assertEquals("userTaskWithSignalCatch",taskService.createTaskQuery().processInstanceId(processInstanceCatch.getId()).singleResult().getName());
assertEquals("userTaskWithSignalCatch",taskService.createTaskQuery().processInstanceId(processInstanceCatch.getId()).singleResult().getName());
assertEquals("userTaskWithSignalCatch",taskService.createTaskQuery().processInstanceId(processInstanceCatch.getId()).singleResult().getName());
}