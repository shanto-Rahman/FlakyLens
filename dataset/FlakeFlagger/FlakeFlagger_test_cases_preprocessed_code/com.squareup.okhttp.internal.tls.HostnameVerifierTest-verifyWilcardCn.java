@Test public void verifyWilcardCn() throws Exception {
assertTrue(verifier.verify("foo.com",session));
assertTrue(verifier.verify("www.foo.com",session));
assertTrue(verifier.verify("\u82b1\u5b50.foo.com",session));
assertFalse(verifier.verify("a.b.foo.com",session));
}