@Test public void verifyMultipleCn() throws Exception {
assertFalse(verifier.verify("foo.com",session));
assertFalse(verifier.verify("a.foo.com",session));
assertFalse(verifier.verify("bar.com",session));
assertFalse(verifier.verify("a.bar.com",session));
assertTrue(verifier.verify("\u82b1\u5b50.co.jp",session));
assertFalse(verifier.verify("a.\u82b1\u5b50.co.jp",session));
}