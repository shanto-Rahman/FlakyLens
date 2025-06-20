@Test public void should_initialize_lazy_properties() throws Exception {
assertThat(rawEntity.getName()).isEqualTo("name");
assertThat(rawEntity.getLabel()).isEqualTo("label");
assertThat(rawEntity.getAge()).isEqualTo(45L);
assertThat(rawEntity.getFriends()).containsExactly("foo","bar");
assertThat(rawEntity.getWelcomeTweet().getContent()).isEqualTo("welcome");
assertThat(rawEntity.getVersion()).isInstanceOf(InternalCounterImpl.class);
assertThat(rawEntity.getVersion().get()).isEqualTo(11L);
}