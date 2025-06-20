public void testUnwrapping() throws Exception {
  ObjectMapper mapper=new ObjectMapper();
  mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY,true);
  JsonSchemaGenerator generator=new JsonSchemaGenerator(mapper);
  JsonSchema schema=generator.generateSchema(UnwrappingRoot.class);
  String json=mapper.writeValueAsString(schema).replace('"','\'');
  String EXP="{'type':'object'," + "'id':'urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestUnwrapping:UnwrappingRoot'," + "'properties':{'age':{'type':'integer'},'name.first':{'type':'string'},'name.last':{'type':'string'}}}";
  assertEquals(EXP,json);
}
