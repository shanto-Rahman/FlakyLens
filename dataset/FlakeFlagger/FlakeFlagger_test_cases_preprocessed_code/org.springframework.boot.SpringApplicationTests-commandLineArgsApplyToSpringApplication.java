@Test public void commandLineArgsApplyToSpringApplication() throws Exception {
assertThat(application.getShowBanner(),is(false));//IT
}