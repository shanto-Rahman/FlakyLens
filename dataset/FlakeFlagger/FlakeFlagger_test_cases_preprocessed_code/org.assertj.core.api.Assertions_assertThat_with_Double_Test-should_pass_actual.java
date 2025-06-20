@Test public void should_pass_actual(){
AbstractDoubleAssert<?> assertions=Assertions.assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}