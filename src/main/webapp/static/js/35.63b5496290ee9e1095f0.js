webpackJsonp([35],{FJDq:function(t,e,n){var a=n("NPjV");"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);n("rjj0")("25c69423",a,!0)},NPjV:function(t,e,n){e=t.exports=n("FZ+f")(!0),e.push([t.i,".mainbatch[data-v-07ba8f08]{//width:90%;//margin:50px 200px}.mainbutton[data-v-07ba8f08]{margin-top:50px;margin-left:0}.el-table[data-v-07ba8f08]{text-align:left}","",{version:3,sources:["C:/vue/Acase2/src/components/pages/teaBatchScore.vue"],names:[],mappings:"AACA,4BACE,YAAY,AACZ,mBAAoB,CACrB,AACD,6BACI,gBAAgB,AACnB,aAAgB,CAChB,AACD,2BACA,eAAgB,CACf",file:"teaBatchScore.vue",sourcesContent:["\n.mainbatch[data-v-07ba8f08]{\r\n  //width:90%;\r\n  //margin:50px 200px;\n}\n.mainbutton[data-v-07ba8f08]{\r\n    margin-top:50px;\r\n\tmargin-left:0px;\n}\n.el-table[data-v-07ba8f08]{\r\ntext-align:left;\n}\r\n"],sourceRoot:""}])},ZagY:function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"mainbatch"},[n("v-head"),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.newsList,border:""}},[n("el-table-column",{attrs:{prop:"ID",label:"ID","min-width":"33%"}}),t._v(" "),n("el-table-column",{attrs:{prop:"name",label:"名字","min-width":"33%"}}),t._v(" "),n("el-table-column",{attrs:{label:"分数","min-width":"54%"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("div",{attrs:{slot:"reference"},slot:"reference"},[n("el-input",{attrs:{placeholder:"",number:""},model:{value:e.row.score,callback:function(n){t.$set(e.row,"score",n)},expression:"scope.row.score"}})],1)]}}])})],1),t._v(" "),n("div",{staticClass:"mainbutton"},[n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.submit()}}},[t._v("提交")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.back()}}},[t._v("返回")])],1)],1)},s=[],r={render:a,staticRenderFns:s};e.a=r},bjjN:function(t,e,n){"use strict";function a(t){n("FJDq")}Object.defineProperty(e,"__esModule",{value:!0});var s=n("jKkV"),r=n("ZagY"),o=n("VU/8"),i=a,c=o(s.a,r.a,!1,i,"data-v-07ba8f08",null);e.default=c.exports},jKkV:function(t,e,n){"use strict";var a=n("mcOx");e.a={components:{vHead:a.a},data:function(){return{hostURL:"/VR",newsList:[{id:1,ID:"1",name:"zhangsan",score:""},{id:2,ID:"2",name:"李四",score:""},{id:3,ID:"1",name:"zhangsan",score:""},{id:4,ID:"1",name:"zhangsan",score:""}]}},methods:{getnewsList:function(t){},back:function(){self=this,self.$router.push("/teacher/registerScore")},submit:function(){for(var t=this,e=!0,n=0;n<t.newsList.length;n++)if(t.newsList[n].score<0||t.newsList[n].score>100||""==t.newsList[n].score){e=!1;break}e?this.$confirm("确定录入？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}):alert("内容填写不正确，所填分数应在0-100之间！")}},mounted:function(){var t=this,e=location.href.split("?");console.log(e[1]);var n=e[1];console.log(n),t.getnewsList(n)}}}});
//# sourceMappingURL=35.63b5496290ee9e1095f0.js.map