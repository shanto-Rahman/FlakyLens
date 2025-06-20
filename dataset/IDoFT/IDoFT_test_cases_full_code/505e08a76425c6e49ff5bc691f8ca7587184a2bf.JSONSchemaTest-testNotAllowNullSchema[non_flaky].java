@Test public void testNotAllowNullSchema() throws JSONException {
  JSONSchema<Foo> jsonSchema=JSONSchema.of(SchemaDefinition.<Foo>builder().withPojo(Foo.class).withAlwaysAllowNull(false).build());
  Assert.assertEquals(jsonSchema.getSchemaInfo().getType(),SchemaType.JSON);
  Schema.Parser parser=new Schema.Parser();
  String schemaJson=new String(jsonSchema.getSchemaInfo().getSchema());
  assertJSONEqual(schemaJson,SCHEMA_JSON_NOT_ALLOW_NULL);
  Schema schema=parser.parse(schemaJson);
  for (  String fieldName : FOO_FIELDS) {
    Schema.Field field=schema.getField(fieldName);
    Assert.assertNotNull(field);
    if (field.name().equals("field4")) {
      Assert.assertNotNull(field.schema().getTypes().get(1).getField("field1"));
    }
    if (field.name().equals("fieldUnableNull")) {
      Assert.assertNotNull(field.schema().getType());
    }
  }
}
