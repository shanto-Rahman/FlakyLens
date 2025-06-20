@Test public void layoutInsteadOfEncoer() throws JoranException {
assertTrue(fileAppender.isStarted());
assertTrue(fileAppender.getEncoder() instanceof LayoutWrappingEncoder);
}