@Test public void testDeclarationQuestionMark(){
  testDeclaration(OptionalPropertiesDeclaration.questionMark,"interface Person {\n" + "    name: string;\n" + "    email?: string;\n"+ "    age?: number;\n"+ "}");
}
