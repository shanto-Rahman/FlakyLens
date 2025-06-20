public void testIllegalUseOfResultVariableName(){
fail();
assertTrue(e.getMessage().contains("resultVariable"));
}