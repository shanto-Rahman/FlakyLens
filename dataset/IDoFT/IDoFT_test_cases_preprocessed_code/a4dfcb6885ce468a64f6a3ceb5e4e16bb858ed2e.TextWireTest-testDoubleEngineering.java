@Test public void testDoubleEngineering(){
assertEquals("!D {\n" + "  d: 1.0,\n" + "  n: -1.0\n"+ "}\n",new DoubleWrapper(1.0).toString());
assertEquals("!D {\n" + "  d: 11.0,\n" + "  n: -11.0\n"+ "}\n",new DoubleWrapper(11.0).toString());
assertEquals("!D {\n" + "  d: 101.0,\n" + "  n: -101.0\n"+ "}\n",new DoubleWrapper(101.0).toString());
assertEquals("!D {\n" + "  d: 1E3,\n" + "  n: -1E3\n"+ "}\n",new DoubleWrapper(1e3).toString());
assertEquals(1e3,dw.d,0);
assertEquals("!D {\n" + "  d: 10E3,\n" + "  n: -10E3\n"+ "}\n",new DoubleWrapper(10e3).toString());
assertEquals(10e3,dw2.d,0);
assertEquals("!D {\n" + "  d: 100E3,\n" + "  n: -100E3\n"+ "}\n",new DoubleWrapper(100e3).toString());
assertEquals(100e3,dw3.d,0);
assertEquals("!D {\n" + "  d: 1E6,\n" + "  n: -1E6\n"+ "}\n",new DoubleWrapper(1e6).toString());
assertEquals(1e6,dw4.d,0);
assertEquals("!D {\n" + "  d: 10E6,\n" + "  n: -10E6\n"+ "}\n",new DoubleWrapper(10e6).toString());
assertEquals(10e6,dw5.d,0);
}