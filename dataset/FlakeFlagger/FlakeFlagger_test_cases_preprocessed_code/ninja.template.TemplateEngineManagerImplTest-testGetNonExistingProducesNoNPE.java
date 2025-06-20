@Test public void testGetNonExistingProducesNoNPE(){
assertNull(manager.getTemplateEngineForContentType("non/existing"));
}