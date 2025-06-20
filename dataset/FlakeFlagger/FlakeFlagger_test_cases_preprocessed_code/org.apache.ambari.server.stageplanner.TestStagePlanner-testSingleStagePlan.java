@Test public void testSingleStagePlan(){
assertEquals(1,outStages.size());
assertEquals(stage.getExecutionCommands(hostname),outStages.get(0).getExecutionCommands(hostname));
}