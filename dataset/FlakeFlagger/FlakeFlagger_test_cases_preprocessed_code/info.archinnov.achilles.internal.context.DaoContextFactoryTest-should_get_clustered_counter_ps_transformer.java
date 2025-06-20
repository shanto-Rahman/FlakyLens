@Test public void should_get_clustered_counter_ps_transformer() throws Exception {
assertThat(result.get(0)).isSameAs(clusteredCounterQueryMap);
}