@Test public void testSkipDeployHealthchecks(){
  initRequest();
  final String deployId="deploy_test";
  SingularityDeployBuilder db=new SingularityDeployBuilder(requestId,deployId);
  db.setHealthcheckUri(Optional.of("http://uri"));
  db.setSkipHealthchecksOnDeploy(Optional.of(true));
  SingularityDeploy deploy=initDeploy(db,System.currentTimeMillis());
  deployChecker.checkDeploys();
  Assertions.assertTrue(!deployManager.getDeployResult(requestId,deployId).isPresent());
  launchTask(request,deploy,System.currentTimeMillis(),1,TaskState.TASK_RUNNING);
  deployChecker.checkDeploys();
  deployChecker.checkDeploys();
  Assertions.assertEquals(DeployState.SUCCEEDED,deployManager.getDeployResult(requestId,deployId).get().getDeployState());
}
