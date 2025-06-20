/** 
 * Invalid resources should be ignored, leaving the model unchanged.
 */
@Test public void testGroupWithInvalidResource(){
Assert.assertEquals(1,changedModel.getGroups().size());
}