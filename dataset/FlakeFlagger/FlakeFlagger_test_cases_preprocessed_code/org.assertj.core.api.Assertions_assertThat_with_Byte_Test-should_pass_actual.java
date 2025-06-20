@Test public void should_pass_actual(){
AbstractByteAssert<?> assertions=Assertions.assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}