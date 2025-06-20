@Test public void should_pass_actual(){
AbstractCharacterAssert<?> assertions=Assertions.assertThat(b);
assertSame(b,assertions.actual);
}