@Deployment public void testTerminateNestedSubprocesses(){
assertEquals("A",tasks.get(0).getName());
assertEquals("B",tasks.get(1).getName());
assertEquals("D",tasks.get(2).getName());
assertEquals("E",tasks.get(3).getName());
assertEquals("F",tasks.get(4).getName());
assertNotNull(task);
assertNotNull(task);
assertNotNull(task);
assertNull(task);
assertNotNull(task);
}