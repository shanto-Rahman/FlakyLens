@Deployment public void testSerializedVariablesBothAsync(){
assertNotNull(job);
assertNotNull(job);
assertTrue(isOkInDelegate2);//RW
assertTrue(isOkInDelegate3);//RW
}