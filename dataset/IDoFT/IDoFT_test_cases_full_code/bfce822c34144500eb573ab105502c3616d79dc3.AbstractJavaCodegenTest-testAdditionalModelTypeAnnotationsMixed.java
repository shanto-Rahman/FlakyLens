@Test public void testAdditionalModelTypeAnnotationsMixed() throws Exception {
  OpenAPI openAPI=TestUtils.createOpenAPI();
  final AbstractJavaCodegen codegen=new P_AbstractJavaCodegen();
  codegen.additionalProperties().put(AbstractJavaCodegen.ADDITIONAL_MODEL_TYPE_ANNOTATIONS," \t @Foo;\r\n@Bar  ;\n @Foobar  ");
  codegen.processOpts();
  codegen.preprocessOpenAPI(openAPI);
  final List<String> additionalModelTypeAnnotations=new ArrayList<String>();
  additionalModelTypeAnnotations.add("@Foo");
  additionalModelTypeAnnotations.add("@Bar");
  additionalModelTypeAnnotations.add("@Foobar");
  Assert.assertEquals(codegen.getAdditionalModelTypeAnnotations(),additionalModelTypeAnnotations);
}
