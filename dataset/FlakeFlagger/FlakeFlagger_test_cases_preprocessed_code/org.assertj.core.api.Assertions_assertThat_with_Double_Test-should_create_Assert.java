@Test public void should_create_Assert(){
AbstractDoubleAssert<?> assertions=Assertions.assertThat(zero);
assertThat(assertions).isNotNull();
}