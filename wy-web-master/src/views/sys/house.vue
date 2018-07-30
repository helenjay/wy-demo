<template>
	<div style="margin: 20px;">
        <div>
            <Row style="margin-bottom: 25px;">
                <Col span="8">房屋编码：
                    <!--<Select v-model="houseId" filterable clearable style="width: 200px">-->
                        <!--<Option v-for="item in houseList" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
                    <!--</Select>-->
                    <Input v-model="houseCode" placeholder="房屋编号或名称" style="width: 200px"/>
                </Col>
                <Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
            </Row>
        </div>            
        <div>
            <ul>
                <li>
                    <Button type="primary" icon="plus-round" @click="openNewModal()">新建</Button>
                    <Button type="success" icon="wrench" @click="openModifyModal()">修改</Button>
                    <Button type="error" icon="trash-a" @click="del()">删除</Button>
                </li>
                <li>
                    <div style="padding: 10px 0;">
                    	<Table border :columns="columns1" :data="data1" :height="400" @on-selection-change="s=>{change(s)}" @on-row-dblclick="s=>{dblclick(s)}"></Table>
                    </div> 
                </li>
                <li>
                    <div style="text-align: right;">
                        <Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
                    </div>  
                </li>
            </ul>
        </div>
        <!--添加modal-->  
        <Modal :mask-closable="false" :visible.sync="newModal" :loading = "loading" v-model="newModal" width="600" title="新建" @on-ok="newOk('houseNew')" @on-cancel="cancel()">
            <Form ref="houseNew" :model="houseNew" :rules="ruleNew" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="房屋编号:" prop="houseCode">
                            <Input v-model="houseNew.houseCode" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="所属楼号:" prop="buildingCode">
                            <!--<Input v-model="houseNew.buildingCode" style="width: 204px"/>-->
                            <Select v-model="houseNew.buildingCode" filterable clearable style="width: 200px">
                                <Option v-for="item in buildingList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                            </Select>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="销售面积:" prop="houseArea">
                            <Input v-model="houseNew.houseArea" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="室内面积:" prop="houseActual">
                            <Input v-model="houseNew.houseActual" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="房屋户型:" prop="houseType">
                            <Input v-model="houseNew.houseType" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="房屋朝向:" prop="face">
                            <Input v-model="houseNew.face" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="所在楼层:" prop="floor">
                            <Input v-model="houseNew.floor" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="房屋性质:" prop="type">
                            <Input v-model="houseNew.type" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
            </Form>
        </Modal>
        <!--修改modal-->  
        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('houseModify')" @on-cancel="cancel()">
            <Form ref="houseModify" :model="houseModify" :rules="ruleModify" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="房屋编号:" prop="name">
                            <Input v-model="houseModify.houseCode" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="所属楼号:" prop="buildingCode">
                            <Input v-model="houseModify.buildingCode" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="销售面积:" prop="houseArea">
                            <Input v-model="houseModify.houseArea" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="室内面积:" prop="houseActual">
                            <Input v-model="houseModify.houseActual" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="房屋户型:" prop="houseType">
                            <Input v-model="houseModify.houseType" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="房屋朝向:" prop="face">
                            <Input v-model="houseModify.face" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                    <Form-item label="所在楼层:" prop="floor">
                        <Input v-model="houseModify.floor" style="width: 204px"/>
                    </Form-item>
                    </Col>
                    <Col span="12">
                    <Form-item label="房屋性质:" prop="type">
                        <Input v-model="houseModify.type" style="width: 204px"/>
                    </Form-item>
                    </Col>
                </Row>
            </Form>
        </Modal>
    </div>
</template>
<script>
	export default {
        data () {
            return {
                /*用于查找的菜单id*/
                houseId:null,
                houseCode:null,
            	/*选择的数量*/
                count:null,
            	/*选中的组数据*/
                groupId:null,
            	/*新建modal的显示参数*/
                newModal:false,
                /*修改modal的显示参数*/
                modifyModal:false,
            	/*分页total属性绑定值*/
                total:0,
                /*loading*/
                loading: true,
                /*pageInfo实体*/
                pageInfo:{
                	page:0,
                	pageSize:10
                },
                /*house实体*/
                house:{                             
                    id:null,
                    buildingId:null,
                    villageCode:null,
                    buildingCode:null,
                    houseCode:null,
                    houseName:null,
                    floor:null,
                    houseType:null,
                    houseArea:null,
                    houseActual:null,
                    face:null,
                    type:null
                },
                /*用于添加的house实体*/
                houseNew:{
                	id:null,
                    buildingId:null,
                    villageCode:null,
                    buildingCode:null,
                    houseCode:null,
                    houseName:null,
                    floor:null,
                    houseType:null,
                    houseArea:null,
                    houseActual:null,
                    face:null,
                    type:null
                },
                /*用于修改的house实体*/
                houseModify:{
                    id:null,
                    buildingId:null,
                    villageCode:null,
                    buildingCode:null,
                    houseCode:null,
                    houseName:null,
                    floor:null,
                    houseType:null,
                    houseArea:null,
                    houseActual:null,
                    face:null,
                    type:null
                },
                /*新建验证*/
                ruleNew:{
                    houseCode: [
                        { type:'string',required: true, message: '输入房屋编号', trigger: 'blur' }
                    ],
                    floor: [
                        { type:'string',required: true, message: '输入房屋楼层', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value)) {
                                callback(new Error('请输入数字'));
                            } else {
                                callback();
                            }

                        }, trigger: 'blur'}
                    ],
                    houseArea: [
                        { required: true, message: '输入销售面积', trigger: 'blur' }
                    ],
                    houseActual: [
                        { required: true, message: '输入实际面积', trigger: 'blur' }
                    ]
                },
                /*修改验证*/
                ruleModify:{
                    houseCode: [
                        { type:'string',required: true, message: '输入房屋编号', trigger: 'blur' }
                    ],
                    floor: [
                        { type:'string',required: true, message: '输入房屋楼层', trigger: 'blur' },
                        {validator(rule, value, callback) {
                            if (!Number.isInteger(+value)) {
                                callback(new Error('请输入数字'));
                            } else {
                                callback();
                            }

                        }, trigger: 'blur'}
                    ],
                    houseArea: [
                        { required: true, message: '输入销售面积', trigger: 'blur' }
                    ],
                    houseActual: [
                        { required: true, message: '输入实际面积', trigger: 'blur' }
                    ]
                },
                /*楼栋列表*/
                buildingList:[],
            	/*生产类型表显示字段*/
            	columns1: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '房屋ID',
                        key: 'id'
                    },
                    {
                        title: '房屋编号',
                        key: 'houseCode'
                    },
                    {
                        title: '所属楼号',
                        key: 'buildingCode'
                    },
                    {
                        title: '销售面积',
                        key: 'houseArea'
                    },
                    {
                        title: '室内面积',
                        key: 'houseActual'
                    },
                    {
                        title: '房屋户型',
                        key: 'houseType'
                    },
                    {
                        title: '房屋朝向',
                        key: 'face'
                    },
                    {
                        title: '所在楼层',
                        key: 'floor'
                    },
                    {
                        title: '房屋性质',
                        key: 'type'
                    }
                ],
                /*生产类型表数据*/
                data1: []
            }
        },
        mounted(){
        	/*页面初始化调用方法*/
            this.getTable({
                "pageInfo":this.pageInfo,
                'houseId':this.houseId,
                'houseCode':this.houseCode
            });
            /*获取小区楼栋列表，key为楼栋，value为最高层级*/
            this.axios({
              method: 'get',
              url: '/buildingAll'
            }).then(function (response) {
                var listTemp = response.data;
                for (var i = 0; i < listTemp.length; i++) {
                    this.buildingList.push({
                        "value": listTemp[i].floorTotal,
                        "label": listTemp[i].buildingCode
                    });
                }
            }.bind(this)).catch(function (error) {
              alert(error);
            });
        },
        methods:{
        	/*pageInfo实体初始化*/
        	initPageInfo(){
        		this.pageInfo.page = 0;
        		this.pageInfo.pageSize = 10;
        	},
            /*house实体初始化*/
            initHouse(){
                this.house.id = null;
                this.house.buildingId = null;
                this.house.villageCode = null;
                this.house.buildingCode = null;
                this.house.houseCode = null;
                this.house.houseName = null;
                this.house.floor = null;
                this.house.houseType = null;
                this.house.houseArea = null;
                this.house.houseActual = null;
                this.house.face = null;
                this.house.type = null;
            },
            /*houseNew实体初始化*/
            initHouseNew(){
                this.houseNew.id = null;
                this.houseNew.buildingId = null;
                this.houseNew.villageCode = null;
                this.houseNew.buildingCode = null;
                this.houseNew.houseCode = null;
                this.houseNew.houseName = null;
                this.houseNew.floor = null;
                this.houseNew.houseType = null;
                this.houseNew.houseArea = null;
                this.houseNew.houseActual = null;
                this.houseNew.face = null;
                this.houseNew.type = null;
            },
            /*houseModify实体初始化*/
            initHouseModify(){
                this.houseModify.id = null;
                this.houseModify.buildingId = null;
                this.houseModify.villageCode = null;
                this.houseModify.buildingCode = null;
                this.houseModify.houseCode = null;
                this.houseModify.houseName = null;
                this.houseModify.floor = null;
                this.houseModify.houseType = null;
                this.houseModify.houseArea = null;
                this.houseModify.houseActual = null;
                this.houseModify.face = null;
                this.houseModify.type = null;
            },
            /*houseNew设置*/
            houseSet(e){
                this.house.id = e.id;
                this.house.buildingId = e.buildingId;
                this.house.villageCode = e.villageCode;
                this.house.buildingCode = e.buildingCode;
                this.house.houseCode = e.houseCode;
                this.house.houseName = e.houseName;
                this.house.floor = e.floor;
                this.house.houseType = e.houseType;
                this.house.houseArea = e.houseArea;
                this.house.houseActual = e.houseActual;
                this.house.face = e.face;
                this.house.type = e.type;
            },
            /*houseNew设置*/
            houseNewSet(e){
                this.houseNew.id = e.id;
                this.houseNew.buildingId = e.buildingId;
                this.houseNew.villageCode = e.villageCode;
                this.houseNew.buildingCode = e.buildingCode;
                this.houseNew.houseCode = e.houseCode;
                this.houseNew.houseName = e.houseName;
                this.houseNew.floor = e.floor;
                this.houseNew.houseType = e.houseType;
                this.houseNew.houseArea = e.houseArea;
                this.houseNew.houseActual = e.houseActual;
                this.houseNew.face = e.face;
                this.houseNew.type = e.type;
            },
            /*houseModify设置*/
            houseModifySet(e){
                this.houseModify.id = e.id;
                this.houseModify.buildingId = e.buildingId;
                this.houseModify.villageCode = e.villageCode;
                this.houseModify.buildingCode = e.buildingCode;
                this.houseModify.houseCode = e.houseCode;
                this.houseModify.houseName = e.houseName;
                this.houseModify.floor = e.floor;
                this.houseModify.houseType = e.houseType;
                this.houseModify.houseArea = e.houseArea;
                this.houseModify.houseActual = e.houseActual;
                this.houseModify.face = e.face;
                this.houseModify.type = e.type;
             },
            /*得到表数据*/
            getTable(e) {
                this.axios({
                  method: 'get',
                  url: '/houses',
                  params: {
                      'page':e.pageInfo.page,
                      'pageSize':e.pageInfo.pageSize,
                      'houseId':e.houseId,
                      'houseCode':e.houseCode
                  }
                }).then(function (response) {
                    this.data1=response.data.data;
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                  alert(error);
                });
            },
            /*搜索按钮点击事件*/
            search(){
                this.initPageInfo();
                this.getTable({
                    "pageInfo":this.pageInfo,
                    'houseId':this.houseId,
                    'houseCode':this.houseCode
                });   
            },
            /*分页点击事件*/
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.getTable({  
                    "pageInfo":this.pageInfo,
                    'houseId':this.houseId,
                    'houseCode':this.houseCode
                });
            },
            /*新建点击触发事件*/
            openNewModal(){
                this.newModal = true;
                this.initHouseNew();
                this.data1.sort();
                this.count = 0;
                this.groupId = null;
            },
            /*新建modal的newOk点击事件*/
            newOk (houseNew) { 
                this.$refs[houseNew].validate((valid) => {
                    if (valid) {
                        this.initHouse();
                        this.houseSet(this.houseNew);
                        this.axios({
                            method: 'post',
                            url: '/houses/house',
                            data: this.house
                        }).then(function (response) {
                            this.initHouseNew();
                            this.getTable({
                                "pageInfo":this.pageInfo,
                                'houseId':this.houseId,
                                'houseCode':this.houseCode
                            });
                            this.$Message.info('新建成功');
                        }.bind(this)).catch(function (error) {
                            alert(error);
                        });  
                        this.newModal = false;
                    }else {
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*点击修改时判断是否只选择一个*/
            openModifyModal(){
                if(this.count > 1 || this.count < 1){
                    this.modifyModal= false; 
                    this.$Message.warning('请至少选择一项(且只能选择一项)');  
                }else{
                    this.modifyModal = true;
                }
            },
            /*修改modal的modifyOk点击事件*/
             modifyOk (houseModify) { 
                this.$refs[houseModify].validate((valid) => {
                    if (valid) {
                        this.initHouse();
                        this.houseSet(this.houseModify);
                        this.axios({
                          method: 'put',
                          url: '/houses/'+this.house.id,
                          data: this.house
                        }).then(function (response) {
                            this.initHouseNew();
                            this.getTable({
                                "pageInfo":this.pageInfo,
                                'houseId':this.houseId,
                                'houseCode':this.houseCode
                            });
                            this.$Message.info('修改成功');
                        }.bind(this)).catch(function (error) {
                          alert(error);
                        });  
                        this.modifyModal = false;
                    }else {
                        this.$Message.error('表单验证失败!');
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*modal的cancel点击事件*/
            cancel () {
                this.$Message.info('点击了取消');
            },
            /*table选择后触发事件*/
            change(e){
                if(e.length==1){
                    this.houseModifySet(e['0']);
                }
                this.setGroupId(e);              
            },
            /*通过选中的行设置groupId的值*/
            setGroupId(e){
                this.groupId=[];
                this.count=e.length;
                for (var i = 0; i <= e.length - 1; i++) {
                    this.groupId.push(e[i].id);
                }
            },
            /*删除table中选中的数据*/
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                      method: 'delete',
                      url: '/houses',
                      data: this.groupId
                    }).then(function (response) {
                        this.getTable({
                            "pageInfo":this.pageInfo,
                            'houseId':this.houseId,
                            'houseCode':this.houseCode
                        });
                        this.groupId=null;
                        this.count=0;
                        this.$Message.info('删除成功');
                    }.bind(this)).catch(function (error) {
                        alert(error);
                    });
                }
            },
            /*表格中双击事件*/
            dblclick(e){
                this.houseModifySet(e);
                this.modifyModal = true;
                this.data1.sort();
            }
        }
    }
</script>