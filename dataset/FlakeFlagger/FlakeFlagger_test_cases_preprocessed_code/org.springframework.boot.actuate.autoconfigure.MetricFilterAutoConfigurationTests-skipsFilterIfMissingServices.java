@Test public void skipsFilterIfMissingServices() throws Exception {
assertThat(context.getBeansOfType(Filter.class).size(),equalTo(0));
}