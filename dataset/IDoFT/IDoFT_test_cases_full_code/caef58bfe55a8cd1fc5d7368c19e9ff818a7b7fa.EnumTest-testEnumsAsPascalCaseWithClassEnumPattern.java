@Test public void testEnumsAsPascalCaseWithClassEnumPattern(){
  final Settings settings=TestUtils.settings();
  settings.mapEnum=EnumMapping.asEnum;
  settings.enumMemberCasing=IdentifierCasing.PascalCase;
  settings.jsonLibrary=JsonLibrary.jackson2;
  final ClassEnumExtension classEnumExtension=new ClassEnumExtension();
  classEnumExtension.setConfiguration(Collections.singletonMap("classEnumPattern","Enum"));
  settings.extensions.add(classEnumExtension);
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(DummyEnum.class,DummyClassEnum.class,DummyMixedCaseEnum.class));
  final String expected=("\ndeclare const enum DummyClassEnum {\n" + "    Atype = 'ATYPE',\n" + "    Btype = 'BTYPE',\n"+ "    Ctype = 'CTYPE',\n"+ "}\n"+ "\ndeclare const enum DummyEnum {\n"+ "    Red = 'Red',\n"+ "    Green = 'Green',\n"+ "    Blue = 'Blue',\n"+ "}\n"+ "\ndeclare const enum DummyMixedCaseEnum {\n"+ "    CamelCaseType = 'camelCaseType',\n"+ "    PascalCaseType = 'PascalCaseType',\n"+ "    UpperCaseType = 'UPPER_CASE_TYPE',\n"+ "}\n").replace("'","\"");
  assertEquals(expected.trim(),output.trim());
}
