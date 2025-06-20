@Test public void testWithLifeCycleRunning(){
given(applicationLifeCycle.getConfigLocations()).willReturn(new String[]{"test1","test2"});//IT
assertThat(status.getLevel(),is(Status.Level.OK));
assertThat(status.getMessage(),is("test1,test2"));
}