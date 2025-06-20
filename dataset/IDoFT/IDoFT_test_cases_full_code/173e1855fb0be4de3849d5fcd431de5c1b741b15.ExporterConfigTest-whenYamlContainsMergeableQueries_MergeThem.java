@Test public void whenYamlContainsMergeableQueries_MergeThem(){
  ExporterConfig config=loadFromString(MERGEABLE_CONFIG);
  assertThat(config.toString(),equalTo(MERGED_CONFIG));
}
