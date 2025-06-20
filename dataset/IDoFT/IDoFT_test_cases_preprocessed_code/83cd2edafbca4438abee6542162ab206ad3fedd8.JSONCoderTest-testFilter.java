@Test public void testFilter(){
assertTrue("should contain 'str1'",result.contains("str1"));
assertTrue("should include 'testBean'",result.contains("testBean"));
assertTrue("should include 'ints'",result.contains("ints"));
assertTrue("should contain 'enumField2'",result.contains("enumField2"));
assertTrue("should 'str2'",result.contains("str2"));
assertTrue("shouldn't contain 'publicStrField'",!result.contains("publicStrField"));
assertTrue("should include str1 hashCode'",result.contains("\"strField\":\"hash:3541024\""));
assertTrue("should include str1 hashCode and len'",result.contains("\"strField\":\"[Masked:len=4,360820]\""));
assertTrue("shouldn't contain class TestBean",!result.contains("testBean"));
}