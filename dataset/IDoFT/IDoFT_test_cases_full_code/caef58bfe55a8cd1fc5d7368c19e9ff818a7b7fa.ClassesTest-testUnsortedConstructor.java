@Test public void testUnsortedConstructor(){
  final Settings settings=TestUtils.settings();
  settings.optionalAnnotations=Arrays.asList(Nullable.class);
  settings.outputFileType=TypeScriptFileType.implementationFile;
  settings.mapClasses=ClassMapping.asClasses;
  settings.generateConstructors=true;
  settings.sortDeclarations=false;
  final String output=new TypeScriptGenerator(settings).generateTypeScript(Input.from(FooBar.class));
  String unsortedPropertyAssignments="" + "        this.foo = data.foo;" + settings.newline + "        this.bar = data.bar;";
  Assert.assertTrue(output.contains(unsortedPropertyAssignments));
}
