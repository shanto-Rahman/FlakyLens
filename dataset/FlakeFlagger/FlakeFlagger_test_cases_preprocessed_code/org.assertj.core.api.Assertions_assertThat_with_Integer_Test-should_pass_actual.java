@Test public void should_pass_actual(){
AbstractIntegerAssert<?> assertions=Assertions.assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}