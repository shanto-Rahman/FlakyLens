@Test public void assertExecutionFailure(){
assertNotNull(failureEvent.getCompleteTime());
assertFalse(failureEvent.isSuccess());
assertThat(failureEvent.getFailureCause(),startsWith("java.lang.RuntimeException: failure"));
}