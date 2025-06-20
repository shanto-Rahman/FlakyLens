@Test public void testEnumAsUnion(){
  final Settings settings=TestUtils.settings();
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(AClass.class));
  final String expected=("\n" + "interface AClass {\n" + "    direction: Direction;\n"+ "}\n"+ "\n"+ "type Direction = 'North' | 'East' | 'South' | 'West';\n").replace("'","\"");
  assertEquals(expected,output);
}
