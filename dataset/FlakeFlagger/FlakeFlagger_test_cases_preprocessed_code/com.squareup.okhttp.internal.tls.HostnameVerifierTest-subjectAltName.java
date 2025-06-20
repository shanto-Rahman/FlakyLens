@Test public void subjectAltName() throws Exception {
assertFalse(verifier.verify("foo.com",session));
assertTrue(verifier.verify("bar.com",session));
assertTrue(verifier.verify("baz.com",session));
assertFalse(verifier.verify("a.foo.com",session));
assertFalse(verifier.verify("quux.com",session));
}