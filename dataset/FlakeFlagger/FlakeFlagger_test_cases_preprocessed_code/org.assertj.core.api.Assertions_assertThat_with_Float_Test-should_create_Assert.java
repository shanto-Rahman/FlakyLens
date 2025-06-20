@Test public void should_create_Assert(){
AbstractFloatAssert<?> assertions=assertThat(zero);
assertThat(assertions).isNotNull();
}