@Test public void should_create_Assert(){
AbstractComparableAssert<?,SomeComparable> assertions=Assertions.assertThat(comparable);
assertNotNull(assertions);
}