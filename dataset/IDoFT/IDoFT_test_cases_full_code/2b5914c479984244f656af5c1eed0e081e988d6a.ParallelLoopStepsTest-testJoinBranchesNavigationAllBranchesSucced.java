@Test public void testJoinBranchesNavigationAllBranchesSucced() throws Exception {
  RunEnvironment runEnvironment=new RunEnvironment();
  runEnvironment.getExecutionPath().down();
  Map<String,Value> variables=new HashMap<>();
  Context context=new Context(variables,Collections.<String,Value>emptyMap());
  runEnvironment.getStack().pushContext(context);
  final List<Output> stepPublishValues=newArrayList(new Output("outputName",ValueFactory.create("outputExpression")));
  Map<String,ResultNavigation> stepNavigationValues=new HashMap<>();
  ResultNavigation successNavigation=new ResultNavigation(0L,"CUSTOM_SUCCESS");
  ResultNavigation failureNavigation=new ResultNavigation(0L,"CUSTOM_FAILURE");
  stepNavigationValues.put(ScoreLangConstants.SUCCESS_RESULT,successNavigation);
  stepNavigationValues.put(ScoreLangConstants.FAILURE_RESULT,failureNavigation);
  final String nodeName="nodeName";
  Map<String,Serializable> runtimeContext1=new HashMap<>();
  Map<String,Serializable> runtimeContext2=new HashMap<>();
  Map<String,Serializable> runtimeContext3=new HashMap<>();
  runtimeContext1.put("branch1Output",1);
  runtimeContext2.put("branch2Output",2);
  runtimeContext3.put("branch3Output",3);
  ExecutionRuntimeServices executionRuntimeServices=createAndConfigureExecutionRuntimeServicesMock(runtimeContext1,runtimeContext2,runtimeContext3);
  parallelLoopSteps.joinBranches(runEnvironment,executionRuntimeServices,stepPublishValues,stepNavigationValues,nodeName);
  Assert.assertEquals(0,(long)runEnvironment.removeNextStepPosition());
  ReturnValues returnValues=runEnvironment.removeReturnValues();
  Assert.assertNotNull("return values not found in runtime environment",returnValues);
  Assert.assertEquals("CUSTOM_SUCCESS",returnValues.getResult());
}
