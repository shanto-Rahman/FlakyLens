@Test public void testMain() throws Exception {
assertEquals(o instanceof I1,true);
assertEquals(o instanceof I2,true);
assertEquals(o instanceof I3,true);
((I1)o).m1();//IT
((I2)o).m2();//IT
((I3)o).m3();//IT
}