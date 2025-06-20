@Test public void testDeclarationUndefinableType(){
  testDeclaration(OptionalPropertiesDeclaration.undefinableType,"interface Person {\n" + "    name: string;\n" + "    email: string | undefined;\n"+ "    age: number | undefined;\n"+ "}");
}
