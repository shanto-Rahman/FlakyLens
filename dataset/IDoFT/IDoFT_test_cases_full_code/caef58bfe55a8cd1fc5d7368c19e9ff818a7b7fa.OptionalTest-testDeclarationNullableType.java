@Test public void testDeclarationNullableType(){
  testDeclaration(OptionalPropertiesDeclaration.nullableType,"interface Person {\n" + "    name: string;\n" + "    email: string | null;\n"+ "    age: number | null;\n"+ "}");
}
