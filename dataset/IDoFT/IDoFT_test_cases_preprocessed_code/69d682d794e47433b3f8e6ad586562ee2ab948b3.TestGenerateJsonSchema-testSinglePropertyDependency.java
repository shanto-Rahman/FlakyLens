public void testSinglePropertyDependency() throws Exception {
assertNotNull(result);
assertEquals("{\"type\":\"object\"," + "\"id\":\"urn:jsonschema:com:fasterxml:jackson:module:jsonSchema:TestGenerateJsonSchema:SimpleBean\"," + "\"dependencies\":{\"property1\":[\"property2\"]},"+ "\"properties\":{\"property1\":{\"type\":\"integer\"}"+ ",\"property2\":{\"type\":\"string\"},"+ "\"property3\":{\"type\":\"array\",\"items\":{\"type\":\"string\"}},"+ "\"property4\":{\"type\":\"array\",\"items\":{\"type\":\"number\"}},"+ "\"property5\":{\"type\":\"string\",\"required\":true}}}",schemaString);
}