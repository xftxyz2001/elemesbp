<script setup lang="ts">
import router from '@/router';
import axios from 'axios';
import { onBeforeMount, ref } from 'vue';

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
interface DeliveryAddressItem {
  daid: number; // 收货地址编号
  contactname: string; // 联系人姓名
  contactsex: number; // 联系人性别
  contacttel: string; // 联系人电话
  address: string; // 收货地址
  userid: number; // 用户编号
}
interface FoodItem {
  foodid: number;
  foodname: string;
  foodexplain: string;
  foodimg: string;
  foodprice: number;
  businessid: number;
  remarks: string;
}
interface CartItem {
  cartid: number; // 购物车编号
  foodid: number; // 菜品编号
  businessid: number; // 商家编号
  userid: number; // 用户编号
  quantity: number; // 数量
  food: FoodItem;
}

const lbid = localStorage.getItem('businessid');
const daid = localStorage.getItem('daid'); //送货地址编号
const businessid = lbid && parseInt(lbid); // 商家编号
const business = ref<BusinessItem | null>(null); // 商家信息

const deliveryaddress = ref<DeliveryAddressItem | null>(null); // 收货地址

const totalQuantity = ref(0); // 总数量
const totalPrice = ref(0); // 总价格
const totalSettle = ref(0); // 总结算价

const cartList = ref<CartItem[]>([]); // 购物车列表

onBeforeMount(() => {
  // 根据商家编号获取商家信息
  axios.get('/business/business/' + businessid).then((res) => {
    let r = res.data;
    if (r.code == 0) {
      business.value = r.data;
    } else {
      ElMessage({
        message: r.msg,
        type: 'warning'
      });
    }
  });
  if (daid) {
    axios.get('/daddress/' + daid).then((res) => {
      let r = res.data;
      if (r.code == 0) {
        deliveryaddress.value = r.data;
      } else {
        ElMessage({
          message: r.msg,
          type: 'warning'
        });
      }
    });
  }

  // 刷新购物车
  axios.get('/cart/info/' + businessid).then((res) => {
    let r = res.data;
    if (r.code == 0) {
      totalQuantity.value = r.data.totalQuantity;
      totalPrice.value = r.data.totalPrice;
      totalSettle.value = r.data.totalSettle;
    } else {
      ElMessage({
        message: r.msg,
        type: 'warning'
      });
    }
  });
  getCartList();
});

// 返回上一页
function goback() {
  history.back();
}

// 添加收货地址
function toUserAddress() {
  console.log('添加收货地址');
  router.push({ name: 'userAddress' });
}

// 去支付
function toPayment() {
  if (localStorage.getItem('daid') != null) {
    let param = {
      businessid: localStorage.getItem('businessid'),
      daid: localStorage.getItem('daid')
    };
    axios.post('/orders/new', param).then((res) => {
      let r = res.data;
      if (r.code == 0) {
        console.log(r);
        router.push({ name: 'payment', params: { id: r.data.orderid } });
      }
    });
  } else {
    ElMessage({
      message: '请选择收货地址',
      type: 'warning'
    });
  }
}

function getCartList() {
  axios.get('/cart/business/' + businessid + '/with/food').then((res) => {
    let r = res.data;
    if (r.code == 0) {
      cartList.value = r.data;
    } else {
      ElMessage({
        message: r.msg,
        type: 'warning'
      });
    }
  });
}
</script>

<template>
  <div class="wrapper">
    <!-- header部分 -->
    <header>
      <i class="fa fa-angle-left" @click="goback()"></i>
      <p class="head-title">确认订单</p>
    </header>
    <!-- 订单信息部分 -->
    <div class="order-info">
      <h5>订单配送至：</h5>
      <div class="order-info-address" @click="toUserAddress">
        <p>{{ deliveryaddress != null ? deliveryaddress.address : '请选择送货地址' }}</p>
        <i class="fa fa-angle-right"></i>
      </div>
      <p>
        {{ deliveryaddress != null ? deliveryaddress.contactname : '' }}
        {{ deliveryaddress != null ? (deliveryaddress.contactsex == 1 ? '先生' : '女士') : '' }}
        {{ deliveryaddress != null ? deliveryaddress.contacttel : '' }}
      </p>
    </div>
    <h3>{{ business?.businessname }}</h3>

    <!-- 订单明细部分 -->
    <ul class="order-detailed">
      <li v-for="cart in cartList" :key="cart.cartid">
        <div class="order-detailed-left">
          <img :src="cart.food.foodimg" />
          <p>{{ cart.food.foodname }} x {{ cart.quantity }}</p>
        </div>
        <p>&#165;{{ (cart.food.foodprice * cart.quantity).toFixed(2) }}</p>
      </li>
    </ul>
    <div class="order-deliveryfee">
      <p>配送费</p>
      <p>&#165;{{ business?.deliveryprice }}</p>
    </div>

    <!-- 合计部分 -->
    <div class="total">
      <div class="total-left">&#165;{{ totalSettle }}</div>
      <div class="total-right" @click="toPayment">去支付</div>
    </div>
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
  background-color: #0097ff;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  /*justify-content: center;*/
  align-items: center;
}
.wrapper header .head-title {
  margin: 0 auto;
}
.wrapper header .fa-angle-left {
  color: #fff;
  margin-left: 10px;
  font-weight: 600;
  font-size: 5.5vw;
}

/****************** 订单信息部分 ******************/
.wrapper .order-info {
  /*注意这里，不设置高，靠内容撑开。因为地址有可能折行*/
  width: 100%;
  margin-top: 12vw;
  background-color: #0097ef;
  box-sizing: border-box;
  padding: 2vw;
  color: #fff;
}

.wrapper .order-info h5 {
  font-size: 3vw;
  font-weight: 300;
}

.wrapper .order-info .order-info-address {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;

  font-weight: 700;
  user-select: none;
  cursor: pointer;
  margin: 1vw 0;
}

.wrapper .order-info .order-info-address p {
  width: 90%;
  font-size: 5vw;
}

.wrapper .order-info .order-info-address i {
  font-size: 6vw;
}

.wrapper .order-info p {
  font-size: 3vw;
}

.wrapper h3 {
  box-sizing: border-box;
  padding: 3vw;
  font-size: 4vw;
  color: #666;
  border-bottom: solid 1px #ddd;
}

/****************** 订单明细部分 ******************/
.wrapper .order-detailed {
  width: 100%;
}

.wrapper .order-detailed li {
  width: 100%;
  height: 16vw;
  box-sizing: border-box;
  padding: 3vw;
  color: #666;

  display: flex;
  justify-content: space-between;
  align-items: center;
}
.wrapper .order-detailed li .order-detailed-left {
  display: flex;
  align-items: center;
}

.wrapper .order-detailed li .order-detailed-left img {
  width: 10vw;
  height: 10vw;
}

.wrapper .order-detailed li .order-detailed-left p {
  font-size: 3.5vw;
  margin-left: 3vw;
}

.wrapper .order-detailed li p {
  font-size: 3.5vw;
}

.wrapper .order-deliveryfee {
  width: 100%;
  height: 16vw;
  box-sizing: border-box;
  padding: 3vw;
  color: #666;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 3.5vw;
}

/****************** 订单合计部分 ******************/
.wrapper .total {
  width: 100%;
  height: 14vw;

  position: fixed;
  left: 0;
  bottom: 0;

  display: flex;
}

.wrapper .total .total-left {
  flex: 2;
  background-color: #505051;
  color: #fff;
  font-size: 4.5vw;
  font-weight: 700;
  user-select: none;

  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .total .total-right {
  flex: 1;
  background-color: #38ca73;
  color: #fff;
  font-size: 4.5vw;
  font-weight: 700;

  user-select: none;
  cursor: pointer;

  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
