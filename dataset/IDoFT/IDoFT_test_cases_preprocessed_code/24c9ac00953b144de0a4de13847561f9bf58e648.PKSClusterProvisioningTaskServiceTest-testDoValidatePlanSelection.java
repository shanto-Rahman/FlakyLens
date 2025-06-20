@Test public void testDoValidatePlanSelection(){
fail("Should have thrown an exception because " + wrongPlan + " is not assigned");
assertEquals(expectedError,ex.getMessage());
}