@Test public void testValidateSessionData() throws Exception {
assertNull(getOp.getAuthorizationContext());
assertEquals(authCtxSystemUser,getOp.getAuthorizationContext());
assertEquals(authCtxUser,getOp.getAuthorizationContext());
assertEquals(authCtxUser,getOp.getAuthorizationContext());
assertNull(getOp.getAuthorizationContext());
assertEquals(authCtxGuestUser,getOp.getAuthorizationContext());
}