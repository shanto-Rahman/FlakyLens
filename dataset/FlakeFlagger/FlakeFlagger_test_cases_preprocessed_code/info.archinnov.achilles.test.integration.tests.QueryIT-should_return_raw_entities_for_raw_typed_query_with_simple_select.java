@Test public void should_return_raw_entities_for_raw_typed_query_with_simple_select() throws Exception {
assertThat(actual).hasSize(2);
if (found1.getId().equals(entity1.getId())) {
assertThat(Factory.class.isAssignableFrom(found1.getClass())).isFalse();
assertThat(found1.getId()).isEqualTo(reference.getId());
assertThat(found1.getName()).isEqualTo(reference.getName());
assertThat(found1.getFriends()).containsAll(reference.getFriends());
assertThat(found1.getVersion()).isNull();
assertThat(Factory.class.isAssignableFrom(found2.getClass())).isFalse();
assertThat(found2.getId()).isEqualTo(reference.getId());
assertThat(found2.getName()).isEqualTo(reference.getName());
assertThat(found2.getFriends()).containsAll(reference.getFriends());
assertThat(found2.getVersion()).isNull();
assertThat(Factory.class.isAssignableFrom(found1.getClass())).isFalse();
assertThat(found1.getId()).isEqualTo(reference.getId());
assertThat(found1.getName()).isEqualTo(reference.getName());
assertThat(found1.getFriends()).containsAll(reference.getFriends());
assertThat(found1.getVersion()).isNull();
assertThat(Factory.class.isAssignableFrom(found2.getClass())).isFalse();
assertThat(found2.getId()).isEqualTo(reference.getId());
assertThat(found2.getName()).isEqualTo(reference.getName());
assertThat(found2.getFriends()).containsAll(reference.getFriends());
assertThat(found2.getVersion()).isNull();
}
}