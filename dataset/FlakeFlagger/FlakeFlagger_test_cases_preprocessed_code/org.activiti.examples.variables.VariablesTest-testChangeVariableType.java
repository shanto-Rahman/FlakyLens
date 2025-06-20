@Deployment(resources={"org/activiti/examples/variables/VariablesTest.testBasicVariableOperations.bpmn20.xml"}) public void testChangeVariableType(){
assertEquals(928374L,variables.get("longVar"));
assertEquals((short)123,variables.get("shortVar"));
assertEquals(1234,variables.get("integerVar"));
assertEquals("coca-cola",variables.get("stringVar"));
assertEquals(now,variables.get("dateVar"));
assertEquals(null,variables.get("nullVar"));
assertEquals(serializable,variables.get("serializableVar"));
assertTrue(Arrays.equals(bytes,(byte[])variables.get("bytesVar")));
assertEquals(8,variables.size());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals((short)222,variables.get("serializableVar"));
assertEquals(oldSerializableVarId,newSerializableVarId);
assertEquals((short)123,variables.get("longVar"));
assertEquals(oldLongVar,newLongVar);
}
}