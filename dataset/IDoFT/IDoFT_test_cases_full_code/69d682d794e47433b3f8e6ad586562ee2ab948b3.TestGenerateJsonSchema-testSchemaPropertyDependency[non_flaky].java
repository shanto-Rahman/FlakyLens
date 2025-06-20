public void testSchemaPropertyDependency() throws Exception {
  ObjectMapper mapper=new ObjectMapper();
  mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
  JsonSchemaGenerator generator=new JsonSchemaGenerator(mapper);
  JsonSchema schemaPropertyDependency=generator.generateSchema(DependencySchema.class);
  JsonSchema simpleBeanSchema=generator.generateSchema(SimpleBean.class);
  ((ObjectSchema)simpleBeanSchema).addSchemaDependency("property1",schemaPropertyDependency);
  Map<String,Object> result=writeAndMap(mapper,simpleBeanSchema);
  assertNotNull(result);
  String schemaString=mapper.writeValueAsString(simpleBeanSchema);
  assertEquals("{\"type\":\"object\"," + "\"dependencies\":{\"property1\":{\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:DependencySchema\",\"properties\":{\"property2\":{\"type\":\"string\",\"required\":true}}}}," + "\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:SimpleBean\","+ "\"properties\":{\"property1\":{\"type\":\"integer\"}"+ ",\"property2\":{\"type\":\"string\"},"+ "\"property3\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}},"+ "\"property4\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},"+ "\"property5\":{\"type\":\"string\",\"required\":true}}}",schemaString);
}
