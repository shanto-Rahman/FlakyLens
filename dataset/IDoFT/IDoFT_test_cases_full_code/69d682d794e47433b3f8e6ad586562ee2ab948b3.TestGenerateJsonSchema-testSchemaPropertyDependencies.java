public void testSchemaPropertyDependencies() throws Exception {
  JsonSchemaGenerator generator=new JsonSchemaGenerator(MAPPER);
  JsonSchema schemaPropertyDependency=generator.generateSchema(DependencySchema.class);
  JsonSchema simpleBeanSchema=generator.generateSchema(SimpleBean.class);
  ((ObjectSchema)simpleBeanSchema).addSchemaDependency("property1",schemaPropertyDependency);
  ((ObjectSchema)simpleBeanSchema).addSchemaDependency("property3",schemaPropertyDependency);
  Map<String,Object> result=writeAndMap(MAPPER,simpleBeanSchema);
  assertNotNull(result);
  String schemaString=MAPPER.writeValueAsString(simpleBeanSchema);
  assertEquals("{" + "\"type\":\"object\"," + "\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:SimpleBean\","+ "\"dependencies\":{"+ "\"property1\":{\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:DependencySchema\",\"properties\":{\"property2\":{\"type\":\"string\",\"required\":true}}},"+ "\"property3\":{\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:DependencySchema\",\"properties\":{\"property2\":{\"type\":\"string\",\"required\":true}}}},"+ "\"properties\":{"+ "\"property1\":{\"type\":\"integer\"}"+ ",\"property2\":{\"type\":\"string\"},"+ "\"property3\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}},"+ "\"property4\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},"+ "\"property5\":{\"type\":\"string\",\"required\":true}"+ "}"+ "}",schemaString);
}
