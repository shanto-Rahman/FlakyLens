@Test public void should_pass_actual(){
AbstractShortAssert<?> assertions=Assertions.assertThat(eight);
assertThat(assertions.actual).isSameAs(eight);
}