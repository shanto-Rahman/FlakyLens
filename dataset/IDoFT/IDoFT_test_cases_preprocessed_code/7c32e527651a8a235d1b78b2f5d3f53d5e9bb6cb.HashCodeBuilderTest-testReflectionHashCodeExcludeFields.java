@Test public void testReflectionHashCodeExcludeFields(){
assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3,HashCodeBuilder.reflectionHashCode(x));
assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3,HashCodeBuilder.reflectionHashCode(x,(String[])null));
assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3,HashCodeBuilder.reflectionHashCode(x));
assertEquals(((17 * 37 + 1) * 37 + 2) * 37 + 3,HashCodeBuilder.reflectionHashCode(x,"xxx"));
assertEquals((17 * 37 + 1) * 37 + 3,HashCodeBuilder.reflectionHashCode(x,"two"));
assertEquals((17 * 37 + 1) * 37 + 2,HashCodeBuilder.reflectionHashCode(x,"three"));
assertEquals(17 * 37 + 1,HashCodeBuilder.reflectionHashCode(x,"two","three"));
assertEquals(17,HashCodeBuilder.reflectionHashCode(x,"one","two","three"));
assertEquals(17,HashCodeBuilder.reflectionHashCode(x,"one","two","three","xxx"));
}