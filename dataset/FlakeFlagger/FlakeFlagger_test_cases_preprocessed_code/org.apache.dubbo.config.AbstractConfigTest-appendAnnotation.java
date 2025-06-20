@Test @Config(interfaceClass=Greeting.class,filter={"f1, f2"},listener={"l1, l2"},parameters={"k1","v1","k2","v2"}) public void appendAnnotation() throws Exception {
TestCase.assertSame(Greeting.class,annotationConfig.getInterface());//IT
TestCase.assertEquals("f1, f2",annotationConfig.getFilter());//IT
TestCase.assertEquals("l1, l2",annotationConfig.getListener());//IT
TestCase.assertEquals(2,annotationConfig.getParameters().size());//IT
TestCase.assertEquals("v1",annotationConfig.getParameters().get("k1"));//IT
TestCase.assertEquals("v2",annotationConfig.getParameters().get("k2"));//IT
assertThat(annotationConfig.toString(),Matchers.containsString("filter=\"f1, f2\" "));
assertThat(annotationConfig.toString(),Matchers.containsString("listener=\"l1, l2\" "));
}