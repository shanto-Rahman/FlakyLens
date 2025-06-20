@Test public void should_remove_by_slice_query() throws Exception {
assertThat(result).hasSize(2);
assertThat(result.get(0).getId().getName()).isEqualTo(name1);
assertThat(result.get(1).getId().getName()).isEqualTo(name3);
}