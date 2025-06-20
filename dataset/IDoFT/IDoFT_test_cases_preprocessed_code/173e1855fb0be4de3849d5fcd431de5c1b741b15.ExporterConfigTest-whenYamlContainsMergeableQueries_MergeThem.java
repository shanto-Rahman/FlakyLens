@Test public void whenYamlContainsMergeableQueries_MergeThem(){
assertThat(config.toString(),equalTo(MERGED_CONFIG));
}