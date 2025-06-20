public void testTaskFormKeyWhenUsingIncludeVariables(){
assertNotNull(task);
assertEquals(vars.size(),task.getProcessVariables().size());
assertEquals("test123",task.getFormKey());
}