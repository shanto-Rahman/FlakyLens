@Test public void should_pass_actual(){
AbstractComparableAssert<?,SomeComparable> assertions=Assertions.assertThat(comparable);
assertSame(comparable,assertions.actual);
}