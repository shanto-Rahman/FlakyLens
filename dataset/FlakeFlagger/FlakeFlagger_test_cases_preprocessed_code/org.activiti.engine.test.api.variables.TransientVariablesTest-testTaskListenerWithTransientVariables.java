@Deployment public void testTaskListenerWithTransientVariables(){
assertEquals("Task after",task.getName());
assertEquals("transientVar01transientVar02transientVar03",mergedResult);
}