@Test public void should_pass_actual(){
AbstractFloatAssert<?> assertions=assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}