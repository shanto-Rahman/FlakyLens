@Test public void testListBindings() throws Exception {
assertEquals(4,results.size());
if ("test".equals(resultName)) {
assertEquals(Object.class.getName(),result.getClassName());
assertEquals(object,result.getObject());
if ("testTwo".equals(resultName)) {
assertEquals(Object.class.getName(),result.getClassName());
assertEquals(objectTwo,result.getObject());
if ("testThree".equals(resultName)) {
assertEquals(Object.class.getName(),result.getClassName());
assertEquals(objectThree,result.getObject());
if ("testContext".equals(resultName)) {
assertEquals(Context.class.getName(),result.getClassName());
fail("Unknown result name: " + resultName);
}
}
}
}
assertTrue("Not all expected results were returned",expected.isEmpty());
}