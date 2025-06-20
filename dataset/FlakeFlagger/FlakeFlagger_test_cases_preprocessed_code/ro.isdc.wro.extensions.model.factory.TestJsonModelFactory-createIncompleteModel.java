/** 
 * Test the usecase when the resource has no type. For now, it is ok to have it null because you'll get a NPE exception during processing if no type is specified anyway.
 */
@Test public void createIncompleteModel(){
Assert.assertNotNull(model);
Assert.assertEquals(1,model.getGroups().size());
Assert.assertNull(group.getResources().get(0).getType());
}