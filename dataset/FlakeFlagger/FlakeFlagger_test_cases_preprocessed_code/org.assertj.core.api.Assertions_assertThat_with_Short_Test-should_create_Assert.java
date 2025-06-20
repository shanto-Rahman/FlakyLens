@Test public void should_create_Assert(){
AbstractShortAssert<?> assertions=Assertions.assertThat(zero);
assertThat(assertions).isNotNull();
}