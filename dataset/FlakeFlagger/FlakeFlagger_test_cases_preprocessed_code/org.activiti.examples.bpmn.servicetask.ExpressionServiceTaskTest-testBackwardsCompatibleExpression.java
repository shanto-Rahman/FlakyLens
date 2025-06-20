@Deployment public void testBackwardsCompatibleExpression(){
assertEquals("...---...",runtimeService.getVariable(pi.getId(),"result"));
}