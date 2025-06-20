@Test public void testExternalAndInternalTagLib() throws Exception {
Assert.assertTrue(result,result.contains("External Tag!"));
Assert.assertTrue(result,result.contains("Internal Tag!"));
}