@Test public void should_create_Assert(){
AbstractByteAssert<?> assertions=Assertions.assertThat(zero);
assertThat(assertions).isNotNull();
}