public void testSinglePropertyDependency() throws Exception {
  ObjectMapper mapper=new ObjectMapper();
  mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
  JsonSchemaGenerator generator=new JsonSchemaGenerator(mapper);
  JsonSchema jsonSchema=generator.generateSchema(SimpleBean.class);
  ((ObjectSchema)jsonSchema).addSimpleDependency("property1","property2");
  Map<String,Object> result=writeAndMap(mapper,jsonSchema);
  assertNotNull(result);
  String schemaString=mapper.writeValueAsString(jsonSchema);
  assertEquals("{\"type\":\"object\"," + "\"dependencies\":{\"property1\":[\"property2\"]}," + "\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:SimpleBean\","+ "\"properties\":{\"property1\":{\"type\":\"integer\"}"+ ",\"property2\":{\"type\":\"string\"},"+ "\"property3\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}},"+ "\"property4\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},"+ "\"property5\":{\"type\":\"string\",\"required\":true}}}",schemaString);
}
