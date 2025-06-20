@Test public void testDeclarationNullableAndUndefinableType(){
  testDeclaration(OptionalPropertiesDeclaration.nullableAndUndefinableType,"interface Person {\n" + "    name: string;\n" + "    email: string | null | undefined;\n"+ "    age: number | null | undefined;\n"+ "}");
}
