public void testGetVariables(){
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
}