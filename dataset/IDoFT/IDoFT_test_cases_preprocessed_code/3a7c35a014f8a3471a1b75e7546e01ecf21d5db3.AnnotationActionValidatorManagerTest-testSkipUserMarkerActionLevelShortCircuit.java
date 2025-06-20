public void testSkipUserMarkerActionLevelShortCircuit(){
assertEquals(10,validatorList.size());
assertTrue(context.hasFieldErrors());
assertNotNull(l);
assertEquals(1,l.size());
assertEquals("Not a valid e-mail.",l.get(0));
assertNotNull(l);
assertEquals(2,l.size());
assertEquals("Not a valid e-mail2.",l.get(0));
assertEquals("Email2 not from the right company.",l.get(1));
assertTrue(context.hasActionErrors());
assertNotNull(l);
assertEquals(2,l.size());
assertEquals("Email does not start with mark",l.get(0));
fail("Validation error: " + ex.getMessage());
}