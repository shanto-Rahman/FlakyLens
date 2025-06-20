public void testUnwrapping() throws Exception {
  JsonSchema jsonSchema=MAPPER.generateJsonSchema(UnwrappingRoot.class);
  ObjectNode root=jsonSchema.getSchemaNode();
  JsonNode propertiesSchema=root.get("properties");
  String ageType=propertiesSchema.get("age").get("type").asText();
  String firstType=propertiesSchema.get("name.first").get("type").asText();
  String lastType=propertiesSchema.get("name.last").get("type").asText();
  String type=root.get("type").asText();
  assertEquals(type,"object");
  assertEquals(ageType,"integer");
  assertEquals(firstType,"string");
  assertEquals(lastType,"string");
}
