@Deployment public void testSignalWithGlobalScope(){
assertEquals("userTaskWithSignalCatch",taskService.createTaskQuery().processInstanceId(processInstanceCatch.getId()).singleResult().getName());
assertEquals("userTaskAfterSignalCatch",taskService.createTaskQuery().processInstanceId(processInstanceCatch.getId()).singleResult().getName());
}