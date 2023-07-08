<script setup lang="ts">

import FooterSection from '@/components/FooterSection.vue';
import {Ref} from "vue/dist/vue.js";
import axios from 'axios';
import {onBeforeMount, ref} from 'vue';
import router from "@/router";
interface BusinessItem {
  businessid: number; // 商家编号
  businessname: string; // 商家名称
  businessaddress: string; // 商家地址
  businessexplain: string; // 商家介绍
  businessimg: string; // 商家图片（base64）
  ordertypeid: number; // 点餐分类
  starprice: number; // 起送费
  deliveryprice: number; // 配送费
  remarks: string; // 备注
}
interface FoodItem {
  foodid: number; // 食品编号
  foodname: string; // 食品名称
  foodexplain: string; // 食品介绍
  foodimg: string; // 食品图片（base64）
  foodprice: number; // 食品价格
  businessid: number; // 商家编号
  remarks: string; // 备注

  quantity: number; // 食品数量
}
interface OrderItem{
  orderid:number;
  userid:string;
  businessid:number;
  orderdate:string;
  ordertotal:number;
  daid:number;
  orderstate:number;
  foodList:FoodItem[];
  business:BusinessItem;
  isShowDetailet:boolean;
}

const orderList : Ref<OrderItem[] | null> = ref(null);

onBeforeMount(()=>{
  axios.get('/orders/list').then((res)=>{
    let r = res.data;
    if(r.code == 0){
      orderList.value = r.data;
      if(orderList.value){
        for(let i = 0;i < orderList.value?.length;i++){
          axios.get('/orders/detailet/' + orderList.value[i].orderid).then((res) => {
            let a = res.data;
            if(a.code == 0){
              if(orderList.value){
                orderList.value[i] = a.data;
                orderList.value[i].isShowDetailet = false;
                console.log(orderList.value[i]);
              }
            }
          })
        }
      }
    }
  })
})



function detailetShow(item:OrderItem){
  item.isShowDetailet = !item.isShowDetailet;

}
function toPayment(orderid:number){
  router.push({name:'payment',params:{id:orderid}});
}
</script>

<template>
  <div class="wrapper">
    <el-container>
      <el-header>
        <!-- header部分 -->
        <header>
          <p>我的订单</p>
        </header>
      </el-header>
      <el-main style="padding-bottom: 14vw">
        <!-- 订单列表部分 -->
        <h3>未支付订单信息：</h3>
        <ul class="order">

          <li v-for="item in orderList" key="item.orderid">
            <div class="order-info" v-if="item.orderstate==0">
              <p>
                {{item.business.businessname}}
                <i v-show="item.isShowDetailet" class="fa fa-caret-up" @click="detailetShow(item)"></i>
                <i v-show="!item.isShowDetailet" class="fa fa-caret-down" @click="detailetShow(item)"></i>
              </p>
              <div class="order-info-right">
                <p>&#165;{{item.ordertotal}}</p>
                <div class="order-info-right-icon" @click="toPayment(item.orderid)">去支付</div>
              </div>
            </div>
            <ul class="order-detailet" v-show="item.isShowDetailet">
              <li v-for="odItem in item.foodList">
                <p>{{odItem.foodname}} x {{odItem.quantity}}</p>
                <p>&#165;{{odItem.foodprice*odItem.quantity}}</p>
              </li>
              <li>
                <p>配送费</p>
                <p>&#165;{{item.business.deliveryprice}}</p>
              </li>
            </ul>
          </li>
        </ul>

        <h3>已支付订单信息：</h3>
        <ul class="order"> <!-- v-if="item.commentState==1"-->
          <li v-for="item in orderList" >
            <div class="order-info" v-if="item.orderstate==1">
              <p>
                {{item.business.businessname}}
                <i v-show="item.isShowDetailet" class="fa fa-caret-up" @click="detailetShow(item)"></i>
                <i v-show="!item.isShowDetailet" class="fa fa-caret-down" @click="detailetShow(item)"></i>
              </p>
              <div class="order-info-right">
                <p>&#165;{{item.ordertotal}}</p>
                <div class="order-info-right-icon3" >已完成
                </div>
              </div>
            </div>
            <ul class="order-detailet" v-show="item.isShowDetailet">
              <li v-for="odItem in item.foodList">
                <p>{{odItem.foodName}} x {{odItem.quantity}}</p>
                <p>&#165;{{odItem.foodprice*odItem.quantity}}</p>
              </li>
              <li>
                <p>配送费</p>
                <p>&#165;{{item.business.deliveryprice}}</p>
              </li>
            </ul>
          </li>
        </ul>
      </el-main>
      <el-footer height="0">
        <!-- 底部菜单部分 -->
        <FooterSection />
      </el-footer>
    </el-container>





  </div>
</template>

<style scoped>
/****************** 总容器 ******************/
.wrapper {
  width: 100%;
  height: 100%;
}

/****************** header部分 ******************/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #0097FF;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;
}

/****************** 历史订单列表部分 ******************/
.wrapper h3 {
  margin-top: 12vw;
  box-sizing: border-box;
  padding: 4vw;
  font-size: 4vw;
  font-weight: 300;
  color: #999;
}

.wrapper .order {
  width: 100%;
}

.wrapper .order li {
  width: 100%;
}

.wrapper .order li .order-info {
  box-sizing: border-box;
  padding: 2vw 4vw;
  font-size: 4vw;
  color: #666;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order li .order-info .order-info-right {
  display: flex;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon {
  background-color: #f90;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon2 {
  background-color: #ffaaff;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-info .order-info-right .order-info-right-icon3 {
  background-color: #ddd;
  color: #fff;
  border-radius: 3px;
  margin-left: 2vw;
  user-select: none;
  cursor: pointer;
}

.wrapper .order li .order-detailet {
  width: 100%;
}

.wrapper .order li .order-detailet li {
  width: 100%;
  box-sizing: border-box;
  padding: 1vw 4vw;
  color: #666;
  font-size: 3vw;

  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
