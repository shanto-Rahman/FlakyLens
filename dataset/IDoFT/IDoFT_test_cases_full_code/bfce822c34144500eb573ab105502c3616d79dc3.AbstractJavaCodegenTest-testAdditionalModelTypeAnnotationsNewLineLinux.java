@Test public void testAdditionalModelTypeAnnotationsNewLineLinux() throws Exception {
  OpenAPI openAPI=TestUtils.createOpenAPI();
  final AbstractJavaCodegen codegen=new P_AbstractJavaCodegen();
  codegen.additionalProperties().put(AbstractJavaCodegen.ADDITIONAL_MODEL_TYPE_ANNOTATIONS,"@Foo\n@Bar");
  codegen.processOpts();
  codegen.preprocessOpenAPI(openAPI);
  final List<String> additionalModelTypeAnnotations=new ArrayList<String>();
  additionalModelTypeAnnotations.add("@Foo");
  additionalModelTypeAnnotations.add("@Bar");
  Assert.assertEquals(codegen.getAdditionalModelTypeAnnotations(),additionalModelTypeAnnotations);
}
