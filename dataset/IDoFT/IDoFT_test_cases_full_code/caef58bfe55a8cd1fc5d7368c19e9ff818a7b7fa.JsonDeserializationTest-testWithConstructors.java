@Test public void testWithConstructors() throws IOException {
  final Settings settings=TestUtils.settings();
  settings.outputKind=TypeScriptOutputKind.module;
  settings.outputFileType=TypeScriptFileType.implementationFile;
  settings.mapClasses=ClassMapping.asClasses;
  settings.generateConstructors=true;
  settings.extensions.add(new JsonDeserializationExtension());
  final File actualFile=new File("target/JsonDeserializationTestWithConstructors-actual.ts");
  new TypeScriptGenerator(settings).generateTypeScript(Input.from(User.class),Output.to(actualFile));
  final List<String> actualLines=Files.readAllLines(actualFile.toPath(),StandardCharsets.UTF_8);
  final List<String> expectedLines=Utils.readLines(getClass().getResourceAsStream("JsonDeserializationTestWithConstructors-expected.ts"));
  int contentLines=0;
  int foundLines=0;
  final List<String> notFoundLines=new ArrayList<>();
  for (  String expectedLine : expectedLines) {
    if (!expectedLine.isEmpty() || !expectedLine.trim().equals("}")) {
      contentLines++;
      if (actualLines.contains(expectedLine)) {
        foundLines++;
      }
 else {
        notFoundLines.add(expectedLine);
      }
    }
  }
  System.out.println(String.format("Number of correctly generated content lines: %d/%d (%d%%).",foundLines,contentLines,100 * foundLines / contentLines));
  System.out.println("Following lines were not generated:");
  for (  String notFoundLine : notFoundLines) {
    System.out.println(notFoundLine);
  }
  Assert.assertEquals(0,notFoundLines.size());
}
