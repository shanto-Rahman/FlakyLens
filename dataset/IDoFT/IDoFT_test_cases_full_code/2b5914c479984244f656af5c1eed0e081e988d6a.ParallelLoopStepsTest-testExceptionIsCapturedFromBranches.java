@Test public void testExceptionIsCapturedFromBranches() throws Exception {
  RunEnvironment runEnvironment=new RunEnvironment();
  runEnvironment.getExecutionPath().down();
  Map<String,Value> variables=new HashMap<>();
  Context context=new Context(variables,Collections.<String,Value>emptyMap());
  runEnvironment.getStack().pushContext(context);
  ExecutionRuntimeServices executionRuntimeServices=createExecutionRuntimeServicesMockWithBranchException();
  RuntimeException exception=assertThrows(RuntimeException.class,() -> parallelLoopSteps.joinBranches(runEnvironment,executionRuntimeServices,new ArrayList<Output>(0),new HashMap<String,ResultNavigation>(),"nodeName"));
  Assert.assertEquals("Error running: 'nodeName': \n" + "Error running branch: \n" + "Exception details placeholder",exception.getMessage());
}
