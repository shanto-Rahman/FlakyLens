public void test_for_issue() throws Exception {
Assert.assertEquals("{1:10,2:4,3:5,4:5,37306:98,36796:9}",json);
Assert.assertEquals(map1.get(Integer.valueOf(1)),Integer.valueOf(10));
Assert.assertEquals(map1.get(Integer.valueOf(2)),Integer.valueOf(4));
Assert.assertEquals(map1.get(Integer.valueOf(3)),Integer.valueOf(5));
Assert.assertEquals(map1.get(Integer.valueOf(4)),Integer.valueOf(5));
Assert.assertEquals(map1.get(Integer.valueOf(37306)),Integer.valueOf(98));
Assert.assertEquals(map1.get(Integer.valueOf(36796)),Integer.valueOf(9));
Assert.assertEquals(map2.get(Integer.valueOf(1)),Integer.valueOf(10));
Assert.assertEquals(map2.get(Integer.valueOf(2)),Integer.valueOf(4));
Assert.assertEquals(map2.get(Integer.valueOf(3)),Integer.valueOf(5));
Assert.assertEquals(map2.get(Integer.valueOf(4)),Integer.valueOf(5));
Assert.assertEquals(map2.get(Integer.valueOf(37306)),Integer.valueOf(98));
Assert.assertEquals(map2.get(Integer.valueOf(36796)),Integer.valueOf(9));
}