@Test public void should_return_same_manager_for_same_keyspace() throws Exception {
assertThat(manager1).isSameAs(manager2);
}