@Test public void should_insert_when_not_exists() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("name");
assertThat(found.getConsistencyLevel()).isEqualTo(EACH_QUORUM);
}