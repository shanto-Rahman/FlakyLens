@Test public void testSum(){
assertThat(allValues,not(nullValue()));
assertThat(allValues,hasItem(new CustomMatcher<URL>("Monitor count should greater than 1"){
  @Override public boolean matches(  Object item){
    URL url=(URL)item;
    return Integer.valueOf(url.getParameter(MonitorService.SUCCESS)) > 1;
  }
}
));
}