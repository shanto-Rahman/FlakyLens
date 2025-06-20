@Test public void testRemoveParam(){
Assert.assertTrue("The parameter should be removed successfully",params.removeParameter("param1"));
Assert.assertFalse("The parameter should not be present",params.removeParameter("param1"));
Assert.assertFalse("The parameter should not be present",params.removeParameter("param1"));
}