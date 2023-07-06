<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import { ref } from 'vue';
import type { Ref } from 'vue/dist/vue.js';
const route = useRoute();

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

const ordertypeid = route.params.type; // 点餐分类编号
const businessList: Ref<BusinessItem[] | null> = ref([]); // 商家列表

// 根据点餐分类编号获取商家列表
axios.get('/business/ordertype/' + ordertypeid).then((res) => {
  let r = res.data;
  if (r.code == 0) {
    businessList.value = r.data;

  } else {
    alert(r.msg);
  }
});

// 跳转到商家详情页
function toBusinessInfo(businessid: number) {
  // 跳转到商家详情页
}

</script>

<template>
  <div class="wrapper">
    <!-- header部分 -->
    <header>
      <p>商家列表</p>
    </header>

    <!-- 商家列表部分 -->
    <ul class="business">
      <li v-for="item in businessList" :key="item.businessid" @click="toBusinessInfo(item.businessid)">
        <div class="business-img">
          <img :src="item.businessimg">
        </div>
        <div class="business-info">
          <h3>{{ item.businessname }}</h3>
          <p>&#165;{{ item.starprice }}起送 | &#165;{{ item.deliveryprice }}配送</p>
          <p>{{ item.businessexplain }}</p>
        </div>
      </li>
    </ul>

    <!-- 底部菜单部分 -->
    <FooterSection />
  </div>
</template>

<style scoped>
/****总容器部分***/
.wrapper {
  width: 100%;
  height: 100%;
}

/****header部分***/
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

/******商家列表部分*****/
.wrapper .business {
  width: 100%;
  margin-top: 12vw;
  padding-bottom: 14vw;
}

.wrapper .business li {
  width: 100%;
  box-sizing: border-box;
  padding: 2.5vw;
  border-bottom: solid 1px #DDD;
  user-select: none;
  cursor: pointer;

  display: flex;
  align-items: center;
}

.wrapper .business li .business-img {
  position: relative;
}

.wrapper .business li .business-img img {
  width: 20vw;
  height: 20vw;
}

.wrapper .business li .business-img .business-img-quantity {
  width: 5vw;
  height: 5vw;
  background-color: red;
  color: #fff;
  font-size: 3.6vw;
  border-radius: 2.5vw;

  display: flex;
  justify-content: center;
  align-items: center;

  position: absolute;
  right: -1.5vw;
  top: -1.5vw;
}

.wrapper .business li .business-info {
  margin-left: 3vw;
}

.wrapper .business li .business-info h3 {
  font-size: 3.8vw;
  color: #555;
  margin-bottom: 3.4vw;
}

.wrapper .business li .business-info p {
  font-size: 3vw;
  color: #888;
  margin-top: 2vw;
}
</style>
