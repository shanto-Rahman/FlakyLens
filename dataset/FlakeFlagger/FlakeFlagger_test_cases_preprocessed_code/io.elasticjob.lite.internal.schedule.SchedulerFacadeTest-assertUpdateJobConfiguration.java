@Test public void assertUpdateJobConfiguration(){
assertThat(schedulerFacade.updateJobConfiguration(jobConfig),is(jobConfig));
}