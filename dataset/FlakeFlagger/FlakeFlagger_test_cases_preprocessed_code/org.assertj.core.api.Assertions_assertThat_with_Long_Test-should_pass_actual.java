@Test public void should_pass_actual(){
AbstractLongAssert<?> assertions=Assertions.assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}