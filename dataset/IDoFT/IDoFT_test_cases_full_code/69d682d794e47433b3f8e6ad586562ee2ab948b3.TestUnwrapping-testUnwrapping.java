public void testUnwrapping() throws Exception {
  JsonSchemaGenerator generator=new JsonSchemaGenerator(MAPPER);
  JsonSchema schema=generator.generateSchema(UnwrappingRoot.class);
  String json=MAPPER.writeValueAsString(schema).replace('"','\'');
  String EXP="{'type':'object'," + "'id':'urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestUnwrapping:UnwrappingRoot'," + "'properties':{'age':{'type':'integer'},'name.first':{'type':'string'},'name.last':{'type':'string'}}}";
  assertEquals(EXP,json);
}
