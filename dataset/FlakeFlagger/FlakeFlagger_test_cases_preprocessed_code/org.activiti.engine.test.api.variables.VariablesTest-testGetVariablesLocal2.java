public void testGetVariablesLocal2(){
assertFalse(processInstanceId.equals(executionId));
assertEquals(70,vars.size());
if (variableValue instanceof String) {
if (variableValue instanceof Integer) {
if (variableValue instanceof Boolean) {
if (variableValue instanceof Date) {
if (variableValue instanceof LocalDate) {
if (variableValue instanceof DateTime) {
if (variableValue instanceof TestSerializableVariable) {
}
}
}
}
}
}
}
assertEquals(10,nrOfStrings);
assertEquals(10,nrOfBooleans);
assertEquals(10,nrOfDates);
assertEquals(10,nrOfLocalDates);
assertEquals(10,nrOfDateTimes);
assertEquals(10,nrOfInts);
assertEquals(10,nrOfSerializable);
assertEquals("stringVarValue-1",vars.get("stringVar1"));
assertEquals("stringVarValue-2",vars.get("stringVar2"));
assertNull(vars.get("myVar"));
if (variableValue instanceof String) {
if (variableValue instanceof Integer) {
if (variableValue instanceof Boolean) {
if (variableValue instanceof Date) {
if (variableValue instanceof LocalDate) {
if (variableValue instanceof DateTime) {
if (variableValue instanceof TestSerializableVariable) {
}
}
}
}
}
}
}
assertEquals(11,nrOfStrings);
assertEquals(10,nrOfBooleans);
assertEquals(10,nrOfDates);
assertEquals(10,nrOfLocalDates);
assertEquals(10,nrOfDateTimes);
assertEquals(10,nrOfInts);
assertEquals(10,nrOfSerializable);
assertEquals("hello",vars.get("stringVar1"));
assertEquals("world",vars.get("stringVar2"));
assertEquals("test123",vars.get("myVar"));
}