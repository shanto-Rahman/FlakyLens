@Deployment public void testTransientVariableShadowsPersistentVariable(){
assertEquals("I am shadowed",varValue);
}