public void testTokenBucket() throws Exception {
assertTrue("bucket did not increment",avail > last);
assertTrue("bucket updated too quickly",avail - last < 3);
Thread.sleep(2000);
assertTrue("bucket did not fill",last >= 10);
assertTrue("bucket overfilled",last == 10);
}