@Test public void overrideMessageCodesFormat() throws Exception {
assertNotNull(this.context.getBean(WebMvcAutoConfigurationAdapter.class).getMessageCodesResolver());
}