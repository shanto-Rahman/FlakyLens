@Test public void testListOfMapEntry() throws Exception {
  final ObjectMapper objectMapper=Utils.getObjectMapper();
  final ClassWithListOfEntries classWithListOfEntries=new ClassWithListOfEntries();
  final String json=objectMapper.writeValueAsString(classWithListOfEntries);
  final String expectedJson=("" + "{\n" + "  'entries1': [\n"+ "    {\n"+ "      'key1': 'value1'\n"+ "    },\n"+ "    {\n"+ "      'key2': 'value2'\n"+ "    }\n"+ "  ],\n"+ "  'entries2': [\n"+ "    {\n"+ "      'key': 'key1',\n"+ "      'value': 'value1'\n"+ "    },\n"+ "    {\n"+ "      'key': 'key2',\n"+ "      'value': 'value2'\n"+ "    }\n"+ "  ]\n"+ "}").replace("'","\"");
  Assert.assertEquals(expectedJson,json);
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassWithListOfEntries.class));
  Assert.assertTrue(output.contains("entries1: { [index: string]: string }[]"));
  Assert.assertTrue(output.contains("entries2: Entry2<string, string>[]"));
}
