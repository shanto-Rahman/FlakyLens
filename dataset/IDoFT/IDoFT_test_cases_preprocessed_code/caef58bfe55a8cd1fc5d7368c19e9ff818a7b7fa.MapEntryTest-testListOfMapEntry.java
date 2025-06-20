@Test public void testListOfMapEntry() throws Exception {
Assert.assertEquals(expectedJson,json);
Assert.assertTrue(output.contains("entries1: { [index: string]: string }[]"));
Assert.assertTrue(output.contains("entries2: Entry2<string, string>[]"));
}