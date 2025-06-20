@Test public void assertGetJobExecutorTwice(){
assertTrue(executor.hashCode() != anotherExecutor.hashCode());
}