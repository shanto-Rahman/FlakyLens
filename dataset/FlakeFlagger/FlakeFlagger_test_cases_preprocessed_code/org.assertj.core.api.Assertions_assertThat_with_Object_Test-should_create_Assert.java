@Test public void should_create_Assert(){
AbstractObjectAssert<?,Object> assertions=Assertions.assertThat(actual);
assertNotNull(assertions);
}