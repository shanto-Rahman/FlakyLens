@Deployment public void testNoIdOnSequenceFlow(){
assertEquals("Input is more than one",task.getName());
assertEquals(2,tasks.size());
assertEquals(0,expectedNames.size());
}