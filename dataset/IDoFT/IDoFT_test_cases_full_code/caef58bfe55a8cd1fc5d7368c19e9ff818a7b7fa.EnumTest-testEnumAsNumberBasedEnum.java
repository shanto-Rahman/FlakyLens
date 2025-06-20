@Test public void testEnumAsNumberBasedEnum(){
  final Settings settings=TestUtils.settings();
  settings.mapEnum=EnumMapping.asNumberBasedEnum;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(AClass.class));
  final String expected=("\n" + "interface AClass {\n" + "    direction: Direction;\n"+ "}\n"+ "\n"+ "declare const enum Direction {\n"+ "    North,\n"+ "    East,\n"+ "    South,\n"+ "    West,\n"+ "}\n").replace("'","\"");
  assertEquals(expected,output);
}
