@Test public void testAddBranchesEventsAreFired() throws Exception {
  ListLoopStatement parallelLoopStatement=new ListLoopStatement("varName","expression",new HashSet<ScriptFunction>(),new HashSet<String>(),true);
  RunEnvironment runEnvironment=new RunEnvironment();
  Map<String,Value> variables=new HashMap<>();
  Context context=new Context(variables,Collections.<String,Value>emptyMap());
  runEnvironment.getStack().pushContext(context);
  String nodeName="nodeName";
  String refId="branch_id";
  ExecutionRuntimeServices executionRuntimeServices=mock(ExecutionRuntimeServices.class);
  List<Value> expectedSplitData=newArrayList(ValueFactory.create(1),ValueFactory.create(2),ValueFactory.create(3));
  when(parallelLoopBinding.bindParallelLoopList(eq(parallelLoopStatement),eq(context),eq(runEnvironment.getSystemProperties()),eq(nodeName))).thenReturn(expectedSplitData);
  Long branchBeginStepId=0L;
  parallelLoopSteps.addBranches(parallelLoopStatement,runEnvironment,executionRuntimeServices,nodeName,1234L,5L,branchBeginStepId,refId);
  ArgumentCaptor<String> eventTypeArgumentCaptor=ArgumentCaptor.forClass(String.class);
  verify(executionRuntimeServices,times(4)).addEvent(eventTypeArgumentCaptor.capture(),any(LanguageEventData.class));
  List<String> expectedEventTypesInOrder=newArrayList(ScoreLangConstants.EVENT_SPLIT_BRANCHES,ScoreLangConstants.EVENT_BRANCH_START,ScoreLangConstants.EVENT_BRANCH_START,ScoreLangConstants.EVENT_BRANCH_START);
  List<String> actualEventTypesInOrder=eventTypeArgumentCaptor.getAllValues();
  Assert.assertEquals(expectedEventTypesInOrder,actualEventTypesInOrder);
  Assert.assertEquals(5,(long)runEnvironment.removeNextStepPosition());
}
