@Test public void should_create_Assert(){
AbstractLongAssert<?> assertions=Assertions.assertThat(zero);
assertThat(assertions).isNotNull();
}