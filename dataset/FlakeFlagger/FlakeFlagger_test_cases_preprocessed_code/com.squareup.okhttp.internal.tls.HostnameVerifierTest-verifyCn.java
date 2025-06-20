@Test public void verifyCn() throws Exception {
assertTrue(verifier.verify("foo.com",session));
assertFalse(verifier.verify("a.foo.com",session));
assertFalse(verifier.verify("bar.com",session));
}