@Test public void testDefaultShapes() throws Exception {
Assert.assertEquals(expectedJson,json);
Assert.assertTrue(output.contains("entry1: { [index: string]: string }"));
Assert.assertTrue(output.contains("entry2: Entry2<MyBean, string>"));
Assert.assertTrue(output.contains("" + "interface Entry2<K, V> {\n" + "    key: K;\n"+ "    value: V;\n"+ "}"));
Assert.assertTrue(output.contains("entry3: { [index: string]: string }"));
}