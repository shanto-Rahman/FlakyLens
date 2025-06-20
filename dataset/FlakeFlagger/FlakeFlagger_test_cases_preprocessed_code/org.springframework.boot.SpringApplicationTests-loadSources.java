@Test public void loadSources() throws Exception {
application.setUseMockLoader(true);//IT
assertThat(initialSources.toArray(),equalTo(sources));
}