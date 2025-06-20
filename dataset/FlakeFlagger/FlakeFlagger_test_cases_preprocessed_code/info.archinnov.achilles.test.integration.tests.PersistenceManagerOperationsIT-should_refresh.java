@Test public void should_refresh() throws Exception {
assertThat(entity.getName()).isEqualTo("DuyHai_modified");
assertThat(entity.getFriends()).hasSize(3);
assertThat(entity.getFriends().get(2)).isEqualTo("qux");
}