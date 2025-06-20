@Test public void setAuthenticatedSessionAttribute(){
assertSame(auth.getAccount(),capturedAuth.getValue().getAccount());
assertSame(auth.getMechanism(),capturedAuth.getValue().getMechanism());
assertSame(oldAccount,result.getAccount());
assertSame(HttpServletRequest.FORM_AUTH,result.getMechanism());
assertSame(auth.getAccount(),capturedAuth.getValue().getAccount());
assertSame(auth.getMechanism(),capturedAuth.getValue().getMechanism());
assertNull(result);
}