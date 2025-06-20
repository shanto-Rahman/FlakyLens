@Test public void testOverriddenShapes() throws Exception {
Assert.assertEquals(expectedJson,json);
Assert.assertTrue(output.contains("entry1: Entry1<MyBean, string>"));
Assert.assertTrue(output.contains("entry2: { [index: string]: string }"));
Assert.assertTrue(output.contains("" + "interface Entry1<K, V> {\n" + "    key: K;\n"+ "    value: V;\n"+ "}"));
Assert.assertTrue(output.contains("entry3: { [index: string]: string }"));
}