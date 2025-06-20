@Test public void assertExistExecutorOnS0(){
  when(facadeService.loadExecutorInfo()).thenReturn(Collections.singletonList(new ExecutorStateInfo("foo-app@-@S0","S0")));
  AppConstraintEvaluator.getInstance().loadAppRunningState();
  SchedulingResult result=taskScheduler.scheduleOnce(getTasks(),Arrays.asList(getLease(0,INSUFFICIENT_CPU,INSUFFICIENT_MEM),getLease(1,INSUFFICIENT_CPU,INSUFFICIENT_MEM)));
  assertThat(result.getResultMap().size(),is(2));
  assertTrue(getAssignedTaskNumber(result) > 18);
}
