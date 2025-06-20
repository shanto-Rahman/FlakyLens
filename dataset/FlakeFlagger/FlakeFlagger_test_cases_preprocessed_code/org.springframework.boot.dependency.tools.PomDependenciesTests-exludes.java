@Test public void exludes() throws Exception {
assertThat(dependency.getExclusions().toString(),equalTo("[org.exclude:exclude01]"));
}