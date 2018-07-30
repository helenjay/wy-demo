<template>
    <WtDataTable :url="url" :checkBox="checkBox" :cols="cols">
    </WtDataTable>
    <!--<Select v-model="menuId" filterable clearable style="width: 200px">-->
        <!--<Option v-for="item in menuList" :value="item.value" :key="item.value">{{ item.label }}</Option>-->
    <!--</Select>-->
</template>


<script>
	export default {
        data () {
            return {
                url:'/buildings',
                checkBox:false,
                cols:[
                    {
                        title: 'ID',
                        key: 'id'
                    },
                    {
                        title: '项目ID',
                        key: 'projectId'
                    },
                    {
                        title: '项目编码',
                        key: 'villageCode'
                    },
                    {
                        title: '楼栋编号',
                        key: 'buildingCode'
                    },
                    {
                        title: '楼栋名称',
                        key: 'buildingName'
                    },
                    {
                        title: '楼层总数',
                        key: 'floorTotal'
                    },
                    {
                        title: '总户数',
                        key: 'houseTotal'
                    },
                    {
                        title: '坐标类型',
                        key: 'coordType'
                    },
                    {
                        title: '楼栋描述',
                        key: 'note'
                    },
                    {
                        title: '经度',
                        key: 'lon'
                    },
                    {
                        title: '纬度',
                        key: 'lat'
                    },
                    {
                        title: '建筑年代',
                        key: 'architecturalAge'
                    },
                    {
                        title: '产权性质',
                        key: 'propertyRights'
                    },
                    {
                        title: '房屋类型',
                        key: 'buildingLevel'
                    },
                    {
                        title: '是否有电梯',
                        key: 'hasLeft'
                    },
                    {
                        title: '小区平面图',
                        key: 'image1'
                    }
                ]
            };
        }
    };
</script>