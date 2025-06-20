@Test public void should_return_null_and_not_wrapper_for_null_values() throws Exception {
assertThat(entity.getFriends()).isNotNull().isInstanceOf(ListWrapper.class).isEmpty();
assertThat(entity.getFollowers()).isNull();
assertThat(entity.getPreferences()).isNull();
assertThat(entity.getLabel()).isNull();
assertThat(entity.getAge()).isNull();
}