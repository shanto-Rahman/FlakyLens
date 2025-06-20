@Deployment public void testDefaultSequenceFlow(){
assertEquals(2,tasks.size());
assertEquals(0,expectedNames.size());
assertEquals("Input is three or one",task.getName());
assertEquals("Default input",task.getName());
}