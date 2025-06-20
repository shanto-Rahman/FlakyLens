@Test public void expectedSocialBeansCreated() throws Exception {
assertNotNull(this.context.getBean(Twitter.class));
}