public void testMultiplePropertyDependencies() throws Exception {
  JsonSchemaGenerator generator=new JsonSchemaGenerator(MAPPER);
  JsonSchema jsonSchema=generator.generateSchema(SimpleBean.class);
  ((ObjectSchema)jsonSchema).addSimpleDependency("property1","property2");
  ((ObjectSchema)jsonSchema).addSimpleDependency("property1","property3");
  ((ObjectSchema)jsonSchema).addSimpleDependency("property1","property2");
  ((ObjectSchema)jsonSchema).addSimpleDependency("property2","property3");
  Map<String,Object> result=writeAndMap(MAPPER,jsonSchema);
  assertNotNull(result);
  String schemaString=MAPPER.writeValueAsString(jsonSchema);
  assertEquals("{\"type\":\"object\"," + "\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:SimpleBean\"," + "\"dependencies\":{\"property1\":[\"property2\",\"property3\"],\"property2\":[\"property3\"]},"+ "\"properties\":{\"property1\":{\"type\":\"integer\"}"+ ",\"property2\":{\"type\":\"string\"},"+ "\"property3\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}},"+ "\"property4\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},"+ "\"property5\":{\"type\":\"string\",\"required\":true}}}",schemaString);
}
