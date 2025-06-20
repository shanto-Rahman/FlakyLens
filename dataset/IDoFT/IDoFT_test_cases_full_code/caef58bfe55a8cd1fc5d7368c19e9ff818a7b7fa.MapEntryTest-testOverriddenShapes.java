@Test public void testOverriddenShapes() throws Exception {
  final ObjectMapper objectMapper=Utils.getObjectMapper();
  objectMapper.configOverride(Entry1.class).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.OBJECT));
  objectMapper.configOverride(Entry2.class).setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.NATURAL));
  final ClassWithEntries classWithEntries=new ClassWithEntries();
  final String json=objectMapper.writeValueAsString(classWithEntries);
  final String expectedJson=("" + "{\n" + "  'name': 'ClassWithEntries',\n"+ "  'entry1': {\n"+ "    'key': {\n"+ "      'f0': 'nnn',\n"+ "      'f1': true\n"+ "    },\n"+ "    'value': 'NNN'\n"+ "  },\n"+ "  'entry2': {\n"+ "    'MyBean instance': 'OOO'\n"+ "  },\n"+ "  'entry3': {\n"+ "    'MyBean instance': 'EEE'\n"+ "  }\n"+ "}").replace("'","\"");
  Assert.assertEquals(expectedJson,json);
  final Settings settings=TestUtils.settings();
  settings.jackson2Configuration=new Jackson2ConfigurationResolved();
  settings.jackson2Configuration.shapeConfigOverrides=new LinkedHashMap<>();
  settings.jackson2Configuration.shapeConfigOverrides.put(Entry1.class,JsonFormat.Shape.OBJECT);
  settings.jackson2Configuration.shapeConfigOverrides.put(Entry2.class,JsonFormat.Shape.NATURAL);
  settings.setExcludeFilter(Arrays.asList(Serializable.class.getName(),AbstractMap.SimpleEntry.class.getName()),null);
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(ClassWithEntries.class));
  Assert.assertTrue(output.contains("entry1: Entry1<MyBean, string>"));
  Assert.assertTrue(output.contains("entry2: { [index: string]: string }"));
  Assert.assertTrue(output.contains("" + "interface Entry1<K, V> {\n" + "    key: K;\n"+ "    value: V;\n"+ "}"));
  Assert.assertTrue(output.contains("entry3: { [index: string]: string }"));
}
