@Test public void testEquals2Annotations(){
  BeanCacheKey a=new BeanCacheKey(true,String.class,null,it -> null,a12);
  BeanCacheKey b=new BeanCacheKey(true,String.class,null,it -> null,a12);
  Assert.assertEquals(a,b);
  Assert.assertEquals(a.hashCode(),b.hashCode());
}
