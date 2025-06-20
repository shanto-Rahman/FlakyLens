@Test public void assertExistExecutorOnS0(){
when(facadeService.loadExecutorInfo()).thenReturn(Collections.singletonList(new ExecutorStateInfo("foo-app@-@S0","S0")));//RW
assertThat(result.getResultMap().size(),is(2));
assertTrue(getAssignedTaskNumber(result) > 18);
}