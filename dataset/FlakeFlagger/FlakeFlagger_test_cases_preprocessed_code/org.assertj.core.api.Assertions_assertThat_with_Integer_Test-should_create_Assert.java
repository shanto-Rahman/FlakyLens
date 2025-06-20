@Test public void should_create_Assert(){
AbstractIntegerAssert<?> assertions=Assertions.assertThat(zero);
assertThat(assertions).isNotNull();
}