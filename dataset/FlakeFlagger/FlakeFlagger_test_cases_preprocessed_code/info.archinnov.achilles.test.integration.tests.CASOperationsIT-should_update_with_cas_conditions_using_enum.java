@Test public void should_update_with_cas_conditions_using_enum() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("Helen");
assertThat(found.getConsistencyLevel()).isEqualTo(EACH_QUORUM);
}