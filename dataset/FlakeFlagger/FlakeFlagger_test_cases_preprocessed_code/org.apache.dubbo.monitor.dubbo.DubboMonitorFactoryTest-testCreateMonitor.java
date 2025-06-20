@Test public void testCreateMonitor(){
assertThat(monitor,not(nullValue()));
assertThat(monitor,not(nullValue()));
assertThat(invoker.getUrl().getParameter(Constants.REFERENCE_FILTER_KEY),containsString("testFilter"));
}