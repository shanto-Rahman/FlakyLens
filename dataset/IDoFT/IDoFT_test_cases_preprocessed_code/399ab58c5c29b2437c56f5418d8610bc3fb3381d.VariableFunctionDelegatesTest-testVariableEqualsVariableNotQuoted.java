@Test @CmmnDeployment public void testVariableEqualsVariableNotQuoted(){
assertEquals("The Task",task.getName());
assertEquals(2,tasks.size());
assertEquals("Guarded Task",tasks.get(0).getName());
assertEquals("The Task",tasks.get(1).getName());
}