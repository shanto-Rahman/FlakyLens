@Test public void assertMisfireIfRunning(){
assertThat(liteJobFacade.misfireIfRunning(Arrays.asList(0,1)),is(true));
}