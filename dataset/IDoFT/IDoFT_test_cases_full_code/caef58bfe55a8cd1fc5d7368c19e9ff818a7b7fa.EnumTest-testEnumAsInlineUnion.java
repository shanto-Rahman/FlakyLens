@Test public void testEnumAsInlineUnion(){
  final Settings settings=TestUtils.settings();
  settings.quotes="'";
  settings.mapEnum=EnumMapping.asInlineUnion;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(AClass.class));
  final String expected="\n" + "interface AClass {\n" + "    direction: 'North' | 'East' | 'South' | 'West';\n"+ "}\n";
  assertEquals(expected,output);
}
