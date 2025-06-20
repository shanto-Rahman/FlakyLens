public void testTableCreateAndDeleteXML() throws IOException, JAXBException {
String schemaPath="/" + TABLE1 + "/schema";//RW
assertFalse(admin.tableExists(TABLE1));//RW
model=TestTableSchemaModel.buildTestModel(TABLE1);//RW
TestTableSchemaModel.checkModel(model,TABLE1);//RW
assertEquals(response.getCode(),201);
admin.enableTable(TABLE1);//RW
assertEquals(response.getCode(),200);
TestTableSchemaModel.checkModel(model,TABLE1);//RW
assertFalse(admin.tableExists(TABLE1));//RW
}