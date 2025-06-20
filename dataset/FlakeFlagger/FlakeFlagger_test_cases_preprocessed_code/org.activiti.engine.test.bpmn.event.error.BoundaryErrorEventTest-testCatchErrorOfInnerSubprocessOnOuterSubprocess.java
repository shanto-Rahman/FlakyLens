@Deployment public void testCatchErrorOfInnerSubprocessOnOuterSubprocess(){
assertEquals(2,tasks.size());
assertEquals("Inner subprocess task 1",tasks.get(0).getName());
assertEquals("Inner subprocess task 2",tasks.get(1).getName());
assertEquals("task outside subprocess",taskAfterError.getName());
}