<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
import router from '@/router';
import axios from 'axios';
import { ref } from 'vue';

interface DeliveryAddressItem {
  daid: number;
  contactname: string;
  contactsex: number;
  contacttel: string;
  address: string;
  userid: string;
}

const deliveryAddressList = ref<DeliveryAddressItem[]>([]);

function updateList() {
  axios.get('/daddress/list').then((res) => {
    let r = res.data;
    if (r.code == 0) {
      deliveryAddressList.value = r.data;
    }
  });
}
updateList();

function setDeliveryAddress(da: DeliveryAddressItem) {
  localStorage.setItem('daid', da.daid.toString());
  router.push({ name: 'order' });
}
function editUserAddress(da: DeliveryAddressItem) {
  router.push({ name: 'editAddress', params: { id: da.daid } });
}
function removeUserAddress(da: DeliveryAddressItem) {
  let daid = localStorage.getItem('daid');
  if (daid && parseInt(daid) == da.daid) {
    localStorage.setItem('daid', deliveryAddressList.value[0].daid.toString());
  }
  axios.delete('/daddress/' + da.daid).then((res) => {
    let r = res.data;
    if (r.code == 0) {
      ElMessage({
        message: '删除成功',
        type: 'success',
        center: true
      });
      updateList();
    } else {
      ElMessage({
        message: r.msg,
        type: 'warning'
      });
    }
  });
}
function toAddUserAddress() {
  router.push({ name: 'editAddress', params: { id: 0 } });
}
</script>

<template>
  <div class="wrapper">
    <!-- header部分 -->
    <header>
      <!-- <i class="fa fa-angle-left" @click="toindex()"></i> -->
      <p>地址管理</p>
    </header>

    <!-- 地址列表部分 -->
    <ul class="addresslist">
      <li v-for="item in deliveryAddressList" :key="item.daid">
        <div class="addresslist-left" @click="setDeliveryAddress(item)">
          <h3>
            {{ item.contactname }}{{ item.contactsex == 1 ? '先生' : '女士' }} {{ item.contacttel }}
          </h3>
          <p>{{ item.address }}</p>
        </div>
        <div class="addresslist-right">
          <i class="fa fa-edit" @click="editUserAddress(item)"></i>
          <i class="fa fa-remove" @click="removeUserAddress(item)"></i>
        </div>
      </li>
    </ul>

    <!-- 新增地址部分 -->
    <div class="addbtn" @click="toAddUserAddress">
      <i class="fa fa-plus-circle"></i>
      <p>新增收货地址</p>
    </div>

    <!-- 底部菜单部分 -->
    <FooterSection />
  </div>
</template>

<style scoped>
/*************** 总容器 ***************/
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #f5f5f5;
}

/*************** header ***************/
.wrapper header {
  width: 100%;
  height: 12vw;
  /* background-color: #0097FF; */
  background-color: #0097ff;

  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: left;
  align-items: center;
}

.wrapper header .fa-angle-left {
  color: #fff;
  margin-left: 2.5vw;
  font-weight: 600;
  font-size: 5.5vw;
}

.wrapper header p {
  margin-left: 36vw;
}

/*************** addresslist ***************/
.wrapper .addresslist {
  width: 100%;
  margin-top: 12vw;
  background-color: #fff;
}

.wrapper .addresslist li {
  width: 100%;
  box-sizing: border-box;
  border-bottom: solid 1px #ddd;
  padding: 3vw;
  display: flex;
}

.wrapper .addresslist li .addresslist-left {
  flex: 5;
  /*左边这块区域是可以点击的*/
  user-select: none;
  cursor: pointer;
}

.wrapper .addresslist li .addresslist-left h3 {
  font-size: 4.6vw;
  font-weight: 300;
  color: #666;
}

.wrapper .addresslist li .addresslist-left p {
  font-size: 4vw;
  color: #666;
}

.wrapper .addresslist li .addresslist-right {
  flex: 1;
  font-size: 5.6vw;
  color: #999;
  cursor: pointer;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

/*************** 新增地址部分 ***************/
.wrapper .addbtn {
  width: 100%;
  height: 14vw;
  border-top: solid 1px #ddd;
  border-bottom: solid 1px #ddd;
  background-color: #fff;
  margin-top: 4vw;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 4.5vw;
  color: #0097ff;
  user-select: none;
  cursor: pointer;
}

.wrapper .addbtn p {
  margin-left: 2vw;
}
</style>
