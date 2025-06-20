@Test public void testEquals2Annotations(){
BeanCacheKey a=new BeanCacheKey(true,String.class,null,it -> null,a12);//RW
BeanCacheKey b=new BeanCacheKey(true,String.class,null,it -> null,a12);//RW
Assert.assertEquals(a,b);
Assert.assertEquals(a.hashCode(),b.hashCode());
}