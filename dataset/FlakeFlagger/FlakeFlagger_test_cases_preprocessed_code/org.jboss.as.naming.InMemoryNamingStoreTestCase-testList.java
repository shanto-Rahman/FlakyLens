@Test public void testList() throws Exception {
assertEquals(4,results.size());
if ("test".equals(resultName) || "testTwo".equals(resultName) || "testThree".equals(resultName)) {
assertEquals(Object.class.getName(),result.getClassName());
if ("testContext".equals(resultName)) {
assertEquals(Context.class.getName(),result.getClassName());
fail("Unknown result name: " + resultName);
}
}
assertTrue("Not all expected results were returned",expected.isEmpty());
}