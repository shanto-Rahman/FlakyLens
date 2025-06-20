@Test public void testAllowNullSchema() throws JSONException {
Assert.assertEquals(jsonSchema.getSchemaInfo().getType(),SchemaType.JSON);
Assert.assertNotNull(field);
if (field.name().equals("field4")) {
Assert.assertNotNull(field.schema().getTypes().get(1).getField("field1"));
}
if (field.name().equals("fieldUnableNull")) {
Assert.assertNotNull(field.schema().getType());
}
}