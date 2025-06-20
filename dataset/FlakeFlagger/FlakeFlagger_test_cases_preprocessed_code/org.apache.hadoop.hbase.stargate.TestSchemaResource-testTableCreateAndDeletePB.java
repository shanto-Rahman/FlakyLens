public void testTableCreateAndDeletePB() throws IOException, JAXBException {
String schemaPath="/" + TABLE2 + "/schema";//RW
assertFalse(admin.tableExists(TABLE2));//RW
model=TestTableSchemaModel.buildTestModel(TABLE2);//RW
TestTableSchemaModel.checkModel(model,TABLE2);//RW
assertEquals(response.getCode(),201);
admin.enableTable(TABLE2);//RW
assertEquals(response.getCode(),200);
TestTableSchemaModel.checkModel(model,TABLE2);//RW
assertFalse(admin.tableExists(TABLE2));//RW
}