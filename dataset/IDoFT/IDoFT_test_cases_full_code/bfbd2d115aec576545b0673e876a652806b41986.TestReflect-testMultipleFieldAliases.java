@Test public void testMultipleFieldAliases(){
  Schema expectedSchema=SchemaBuilder.record(ClassWithMultipleAliasesOnField.class.getSimpleName()).namespace("org.apache.avro.reflect.TestReflect").fields().name("primitiveField").aliases("alias1","alias2").type(Schema.create(org.apache.avro.Schema.Type.INT)).noDefault().endRecord();
  check(ClassWithMultipleAliasesOnField.class,expectedSchema.toString());
}
