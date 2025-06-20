@Test public void testDeclarationQuestionMarkAndNullableType(){
  testDeclaration(OptionalPropertiesDeclaration.questionMarkAndNullableType,"interface Person {\n" + "    name: string;\n" + "    email?: string | null;\n"+ "    age?: number | null;\n"+ "}");
}
