@Test public void verifyWilcardCnOnTld() throws Exception {
assertTrue(verifier.verify("foo.co.jp",session));
assertTrue(verifier.verify("\u82b1\u5b50.co.jp",session));
}