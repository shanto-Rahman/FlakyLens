@Test public void verifySubjectAlt() throws Exception {
assertFalse(verifier.verify("foo.com",session));
assertFalse(verifier.verify("a.foo.com",session));
assertTrue(verifier.verify("bar.com",session));
assertFalse(verifier.verify("a.bar.com",session));
}