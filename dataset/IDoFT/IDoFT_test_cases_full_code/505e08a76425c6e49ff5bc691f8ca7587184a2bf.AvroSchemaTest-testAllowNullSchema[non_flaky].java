@Test public void testAllowNullSchema() throws JSONException {
  AvroSchema<Foo> avroSchema=AvroSchema.of(SchemaDefinition.<Foo>builder().withPojo(Foo.class).build());
  assertEquals(avroSchema.getSchemaInfo().getType(),SchemaType.AVRO);
  Schema.Parser parser=new Schema.Parser();
  parser.setValidateDefaults(false);
  String schemaJson=new String(avroSchema.getSchemaInfo().getSchema());
  assertJSONEquals(schemaJson,SCHEMA_AVRO_ALLOW_NULL);
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
