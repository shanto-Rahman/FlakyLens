@Test public void testNonConstAnnotationEnum(){
  final Settings settings=TestUtils.settings();
  settings.outputFileType=TypeScriptFileType.implementationFile;
  settings.nonConstEnumAnnotations.add(SomeNonConstAnnotation.class);
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(SomeCode.class));
  Assert.assertEquals("enum SomeCode {\n" + "    VALUE0 = 10,\n" + "    VALUE1 = 11,\n"+ "}",output.trim());
}
