@Test public void testEnumsWithClassEnumPattern(){
  final Settings settings=TestUtils.settings();
  settings.mapEnum=EnumMapping.asEnum;
  settings.jsonLibrary=JsonLibrary.jackson2;
  final ClassEnumExtension classEnumExtension=new ClassEnumExtension();
  classEnumExtension.setConfiguration(Collections.singletonMap("classEnumPattern","Enum"));
  settings.extensions.add(classEnumExtension);
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(DummyEnum.class,DummyClassEnum.class));
  final String expected=("\ndeclare const enum DummyClassEnum {\n" + "    ATYPE = 'ATYPE',\n" + "    BTYPE = 'BTYPE',\n"+ "    CTYPE = 'CTYPE',\n"+ "}\n"+ "\ndeclare const enum DummyEnum {\n"+ "    Red = 'Red',\n"+ "    Green = 'Green',\n"+ "    Blue = 'Blue',\n"+ "}\n").replace("'","\"");
  assertEquals(expected.trim(),output.trim());
}
