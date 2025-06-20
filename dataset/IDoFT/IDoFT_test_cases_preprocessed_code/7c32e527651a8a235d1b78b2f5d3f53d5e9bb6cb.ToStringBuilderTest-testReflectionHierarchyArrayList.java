@Test public void testReflectionHierarchyArrayList(){
if (!expectedWithTransients.equals(toStringWithTransients)) {
assertEquals(expectedWithTransients,toStringWithTransients);
}
if (!expectedWithoutTransients.equals(toStringWithoutTransients)) {
assertEquals(expectedWithoutTransients,toStringWithoutTransients);
}
}