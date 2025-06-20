@Test public void verifySubjectAltOnly() throws Exception {
assertTrue(verifier.verify("foo.com",session));
assertFalse(verifier.verify("a.foo.com",session));
assertTrue(verifier.verify("foo.com",session));
assertFalse(verifier.verify("a.foo.com",session));
}