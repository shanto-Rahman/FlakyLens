@Test public void verifyNonAsciiCn() throws Exception {
assertTrue(verifier.verify("\u82b1\u5b50.co.jp",session));
assertFalse(verifier.verify("a.\u82b1\u5b50.co.jp",session));
}