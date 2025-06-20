@Test public void testSimple() throws Exception {
assertEquals(0,func.getFinishCount());//IT
assertEquals(1,func.getFinishCount());//IT
assertThat(Arrays.asList("k1=v1,v2","k2=v3"),is(func.getOutputs()));//IT
assertEquals(1,func.getFinishCount());//IT
assertEquals(2,func.getFinishCount());//IT
assertThat(Arrays.asList("k3=v4","k4=v5"),is(func.getOutputs()));//IT
}