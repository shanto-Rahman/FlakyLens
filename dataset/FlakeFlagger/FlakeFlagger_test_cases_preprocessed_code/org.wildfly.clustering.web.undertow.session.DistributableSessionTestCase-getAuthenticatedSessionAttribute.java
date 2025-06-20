@Test public void getAuthenticatedSessionAttribute(){
assertSame(account,result.getAccount());
assertSame(HttpServletRequest.FORM_AUTH,result.getMechanism());
assertSame(expected,result);
}