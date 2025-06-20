@Test public void testAdvancedGenerics() throws Exception {
assertEquals(expected,actual);
assertEquals("IA<string, string>",TestUtils.compileType(settings,A.class.getField("x").getGenericType()).toString());
assertEquals("IA<IA<string, IB>, string[]>",TestUtils.compileType(settings,A.class.getField("y").getGenericType()).toString());
assertEquals("IA<{ [index: string]: V }, number[]>",TestUtils.compileType(settings,A.class.getField("z").getGenericType()).toString());
}