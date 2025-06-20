@Deployment public void testParallelUserTasksBasedOnCollection(){
assertEquals(5,tasks.size());
assertEquals("bubba",tasks.get(0).getAssignee());
assertEquals("fozzie",tasks.get(1).getAssignee());
assertEquals("gonzo",tasks.get(2).getAssignee());
assertEquals("kermit",tasks.get(3).getAssignee());
assertEquals("mispiggy",tasks.get(4).getAssignee());
assertEquals(0,taskService.createTaskQuery().count());//RW
}