@Test public void subjectAltUsesLocalDomainAndIp() throws Exception {
assertEquals(new X500Principal("CN=localhost"),certificate.getSubjectX500Principal());
assertTrue(verifier.verify("localhost",session));
assertTrue(verifier.verify("localhost.localdomain",session));
assertFalse(verifier.verify("local.host",session));
assertTrue(verifier.verify("127.0.0.1",session));
assertFalse(verifier.verify("127.0.0.2",session));
}