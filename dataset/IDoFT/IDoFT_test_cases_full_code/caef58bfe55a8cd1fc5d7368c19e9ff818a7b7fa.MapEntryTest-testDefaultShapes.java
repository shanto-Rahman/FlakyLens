@Test public void testDefaultShapes() throws Exception {
  final ObjectMapper objectMapper=Utils.getObjectMapper();
  final ClassWithEntries classWithEntries=new ClassWithEntries();
  final String json=objectMapper.writeValueAsString(classWithEntries);
  final String expectedJson=("" + "{\n" + "  'name': 'ClassWithEntries',\n"+ "  'entry1': {\n"+ "    'MyBean instance': 'NNN'\n"+ "  },\n"+ "  'entry2': {\n"+ "    'key': {\n"+ "      'f0': 'ooo',\n"+ "      'f1': true\n"+ "    },\n"+ "    'value': 'OOO'\n"+ "  },\n"+ "  'entry3': {\n"+ "    'MyBean instance': 'EEE'\n"+ "  }\n"+ "}").replace("'","\"");
  Assert.assertEquals(expectedJson,json);
  final Settings settings=TestUtils.settings();
  settings.setExcludeFilter(Arrays.asList(Serializable.class.getName(),AbstractMap.SimpleEntry.class.getName()),null);
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassWithEntries.class));
  Assert.assertTrue(output.contains("entry1: { [index: string]: string }"));
  Assert.assertTrue(output.contains("entry2: Entry2<MyBean, string>"));
  Assert.assertTrue(output.contains("" + "interface Entry2<K, V> {\n" + "    key: K;\n"+ "    value: V;\n"+ "}"));
  Assert.assertTrue(output.contains("entry3: { [index: string]: string }"));
}
