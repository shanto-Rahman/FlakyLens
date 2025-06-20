@Test public void testAdditionalModelTypeAnnotationsNewLineWindows() throws Exception {
  OpenAPI openAPI=TestUtils.createOpenAPI();
  final AbstractJavaCodegen codegen=new P_AbstractJavaCodegen();
  codegen.additionalProperties().put(AbstractJavaCodegen.ADDITIONAL_MODEL_TYPE_ANNOTATIONS,"@Foo\r\n@Bar");
  codegen.processOpts();
  codegen.preprocessOpenAPI(openAPI);
  final List<String> additionalModelTypeAnnotations=new ArrayList<String>();
  additionalModelTypeAnnotations.add("@Foo");
  additionalModelTypeAnnotations.add("@Bar");
  final List<String> sortedCodegenAdditionalModelTypeAnnotations=new ArrayList<>(codegen.getAdditionalModelTypeAnnotations());
  final List<String> sortedAdditionalModelTypeAnnotations=new ArrayList<>(codegen.getAdditionalModelTypeAnnotations());
  Collections.sort(sortedCodegenAdditionalModelTypeAnnotations);
  Collections.sort(sortedAdditionalModelTypeAnnotations);
  Assert.assertEquals(sortedCodegenAdditionalModelTypeAnnotations,sortedAdditionalModelTypeAnnotations);
}
