@Test public void should_find_by_slice_query() throws Exception {
assertThat(result).hasSize(3);
assertThat(result.get(0).getId().getName()).isEqualTo(name5);
assertThat(result.get(1).getId().getName()).isEqualTo(name4);
assertThat(result.get(2).getId().getName()).isEqualTo(name3);
}