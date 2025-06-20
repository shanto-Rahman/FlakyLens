@Test void should_generate_member_index(){
  List<String> index=invokeStatic(OmniAccessor.class,"generateMemberIndex",DemoParent.class);
  assertEquals(34,index.size());
  HashSet<String> expected=new HashSet<String>(){
{
      add("/c{DemoChild}");
      add("/c{DemoChild}/gc{DemoGrandChild}");
      add("/c{DemoChild}/gc{DemoGrandChild}/i{int}");
      add("/c{DemoChild}/gc{DemoGrandChild}/l{long}");
      add("/c{DemoChild}/gc{DemoGrandChild}/si{Integer}");
      add("/c{DemoChild}/gc{DemoGrandChild}/sl{Long}");
      add("/c{DemoChild}/gcs{DemoGrandChild[]}");
      add("/c{DemoChild}/gcs{DemoGrandChild[]}/i{int}");
      add("/c{DemoChild}/gcs{DemoGrandChild[]}/l{long}");
      add("/c{DemoChild}/gcs{DemoGrandChild[]}/si{Integer}");
      add("/c{DemoChild}/gcs{DemoGrandChild[]}/sl{Long}");
      add("/cs{DemoChild[]}");
      add("/cs{DemoChild[]}/gc{DemoGrandChild}");
      add("/cs{DemoChild[]}/gc{DemoGrandChild}/i{int}");
      add("/cs{DemoChild[]}/gc{DemoGrandChild}/l{long}");
      add("/cs{DemoChild[]}/gc{DemoGrandChild}/si{Integer}");
      add("/cs{DemoChild[]}/gc{DemoGrandChild}/sl{Long}");
      add("/cs{DemoChild[]}/gcs{DemoGrandChild[]}");
      add("/cs{DemoChild[]}/gcs{DemoGrandChild[]}/i{int}");
      add("/cs{DemoChild[]}/gcs{DemoGrandChild[]}/l{long}");
      add("/cs{DemoChild[]}/gcs{DemoGrandChild[]}/si{Integer}");
      add("/cs{DemoChild[]}/gcs{DemoGrandChild[]}/sl{Long}");
      add("/sc{SubChild}");
      add("/sc{SubChild}/gc{DemoGrandChild}");
      add("/sc{SubChild}/gc{DemoGrandChild}/i{int}");
      add("/sc{SubChild}/gc{DemoGrandChild}/l{long}");
      add("/sc{SubChild}/gc{DemoGrandChild}/si{Integer}");
      add("/sc{SubChild}/gc{DemoGrandChild}/sl{Long}");
      add("/ssc{StaticSubChild}");
      add("/ssc{StaticSubChild}/gc{DemoGrandChild}");
      add("/ssc{StaticSubChild}/gc{DemoGrandChild}/i{int}");
      add("/ssc{StaticSubChild}/gc{DemoGrandChild}/l{long}");
      add("/ssc{StaticSubChild}/gc{DemoGrandChild}/si{Integer}");
      add("/ssc{StaticSubChild}/gc{DemoGrandChild}/sl{Long}");
    }
  }
;
  assertEquals(expected,new HashSet<String>(index));
}
