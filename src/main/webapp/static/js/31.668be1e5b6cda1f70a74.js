webpackJsonp([31],{"3SWW":function(t,e,n){"use strict";var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"mainsee"},[n("v-head"),t._v(" "),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.newsList,border:""}},[n("el-table-column",{attrs:{prop:"ID",label:"ID","min-width":"33%"}}),t._v(" "),n("el-table-column",{attrs:{prop:"name",label:"名字","min-width":"33%"}}),t._v(" "),n("el-table-column",{attrs:{prop:"score",label:"分数","min-width":"54%"}})],1),t._v(" "),n("div",{staticClass:"mainbutton"},[n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.back()}}},[t._v("返回")])],1)],1)},s=[],r={render:a,staticRenderFns:s};e.a=r},"5T6C":function(t,e,n){"use strict";var a=n("mcOx");e.a={components:{vHead:a.a},data:function(){return{hostURL:"/VR",newsList:[{id:1,ID:"1",name:"zhangsan",score:"50"},{id:2,ID:"2",name:"李四",score:"89"},{id:3,ID:"1",name:"zhangsan",score:"98"},{id:4,ID:"1",name:"zhangsan",score:"100"}]}},methods:{getnewsList:function(t){},back:function(){self=this,self.$router.push("/teacher/registerScore")}},mounted:function(){var t=this,e=location.href.split("?");console.log(e[1]);var n=e[1];console.log(n),t.getnewsList(n)}}},Jwt3:function(t,e,n){"use strict";function a(t){n("pCv4")}Object.defineProperty(e,"__esModule",{value:!0});var s=n("5T6C"),r=n("3SWW"),i=n("VU/8"),o=a,c=i(s.a,r.a,!1,o,"data-v-175bd2b2",null);e.default=c.exports},cwh6:function(t,e,n){e=t.exports=n("FZ+f")(!0),e.push([t.i,".mainsee[data-v-175bd2b2]{//width:70%;//margin:50px 200px}.mainbutton[data-v-175bd2b2]{margin-top:50px;margin-left:0}.el-table[data-v-175bd2b2]{text-align:left}","",{version:3,sources:["C:/vue/Acase2/src/components/pages/teaSeeScore.vue"],names:[],mappings:"AACA,0BACE,YAAY,AACZ,mBAAoB,CACrB,AACD,6BACI,gBAAgB,AACnB,aAAgB,CAChB,AACD,2BACA,eAAgB,CACf",file:"teaSeeScore.vue",sourcesContent:["\n.mainsee[data-v-175bd2b2]{\r\n  //width:70%;\r\n  //margin:50px 200px;\n}\n.mainbutton[data-v-175bd2b2]{\r\n    margin-top:50px;\r\n\tmargin-left:0px;\n}\n.el-table[data-v-175bd2b2]{\r\ntext-align:left;\n}\r\n"],sourceRoot:""}])},pCv4:function(t,e,n){var a=n("cwh6");"string"==typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);n("rjj0")("51a64fc7",a,!0)}});
//# sourceMappingURL=31.668be1e5b6cda1f70a74.js.map