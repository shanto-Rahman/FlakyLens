@Test public void testDeployClearsObsoleteScheduledTasks(){
SingularityPendingTaskId taskIdOne=new SingularityPendingTaskId(requestId,firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),1,PendingType.IMMEDIATE,System.currentTimeMillis());
SingularityPendingTaskId taskIdTwo=new SingularityPendingTaskId(requestId,firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1),2,PendingType.IMMEDIATE,System.currentTimeMillis());
SingularityPendingTaskId taskIdThree=new SingularityPendingTaskId(requestId,secondDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),1,PendingType.IMMEDIATE,System.currentTimeMillis());
SingularityPendingTaskId taskIdFour=new SingularityPendingTaskId(requestId + "hi",firstDeployId,System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3),5,PendingType.IMMEDIATE,System.currentTimeMillis());
Assertions.assertTrue(!pendingTaskIds.contains(taskIdOne));
Assertions.assertTrue(!pendingTaskIds.contains(taskIdTwo));
Assertions.assertTrue(pendingTaskIds.contains(taskIdThree));
Assertions.assertTrue(pendingTaskIds.contains(taskIdFour));
}