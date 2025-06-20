@Test public void testWithoutLifeCycleRunning(){
assertThat(status.getLevel(),is(Status.Level.ERROR));
}