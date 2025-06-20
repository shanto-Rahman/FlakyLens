public void testQueryByInvalidBusinessKey(){
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceBusinessKey("invalid").count());
fail();
}