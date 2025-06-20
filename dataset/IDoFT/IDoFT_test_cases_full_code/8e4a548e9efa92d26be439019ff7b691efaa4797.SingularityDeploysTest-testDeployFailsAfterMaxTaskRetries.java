@Test public void testDeployFailsAfterMaxTaskRetries(){
  initRequest();
  SingularityDeployBuilder db=new SingularityDeployBuilder(requestId,firstDeployId);
  db.setMaxTaskRetries(Optional.of(1));
  SingularityDeploy deploy=initDeploy(db,System.currentTimeMillis());
  deployChecker.checkDeploys();
  Assertions.assertTrue(!deployManager.getDeployResult(requestId,firstDeployId).isPresent());
  SingularityTask task=launchTask(request,deploy,System.currentTimeMillis(),1,TaskState.TASK_FAILED);
  deployChecker.checkDeploys();
  Assertions.assertEquals(deployManager.getPendingDeploys().get(0).getCurrentDeployState(),DeployState.WAITING);
  SingularityTask taskTryTwo=launchTask(request,deploy,System.currentTimeMillis(),1,TaskState.TASK_FAILED);
  deployChecker.checkDeploys();
  Assertions.assertEquals(deployManager.getDeployResult(requestId,firstDeployId).get().getDeployState(),DeployState.FAILED);
}
