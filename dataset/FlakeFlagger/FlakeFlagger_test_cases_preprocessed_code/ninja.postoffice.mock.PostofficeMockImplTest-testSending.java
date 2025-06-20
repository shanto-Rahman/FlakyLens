@Test public void testSending() throws Exception {
assertEquals(null,((PostofficeMockImpl)postoffice).getLastSentMail());
assertEquals("first mail",((PostofficeMockImpl)postoffice).getLastSentMail().getSubject());
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getTos().contains("to@localhost"));
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getFrom().equals("from@localhost"));
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getBodyText().equals("simple body text"));
assertEquals("second mail",((PostofficeMockImpl)postoffice).getLastSentMail().getSubject());
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getTos().contains("to@localhost"));
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getFrom().equals("from@localhost"));
assertTrue(((PostofficeMockImpl)postoffice).getLastSentMail().getBodyText().equals("simple body text"));
}