<script setup lang="ts">
import axios from 'axios';
import { ref } from 'vue';
import type { Ref } from 'vue/dist/vue.js';
import { useRoute } from 'vue-router';
import router from "@/router";

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

const businessid = route.params.id; // 商家编号
const business = ref<BusinessItem | null>(null); // 商家信息

// 根据商家编号获取商家信息
axios.get('/business/business/' + businessid).then((res) => {
  let r = res.data;
  if (r.code == 0) {
    business.value = r.data;
  } else {
    alert(r.msg);
  }
});

// 根据商家编号获取商家食品列表
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

const foodList: Ref<FoodItem[]> = ref([]); // 食品列表

axios.get('/food/business/' + businessid).then((res) => {
  let r = res.data;
  if (r.code == 0) {
    foodList.value = r.data;
    for (const food of foodList.value) {
      food.quantity = 0;
    }
  } else {
    alert(r.msg);
  }
});

const totalQuantity = ref(0); // 总数量
const totalPrice = ref(0); // 总价格
const totalSettle = ref(0); // 总结算价

// 刷新购物车
function updateCart() {
  axios.get('/cart/info/' + businessid).then((res) => {
    let r = res.data;
    if (r.code == 0) {
      totalQuantity.value = r.data.totalQuantity;
      totalPrice.value = r.data.totalPrice;
      totalSettle.value = r.data.totalSettle;
    } else {
      alert(r.msg);
    }
  });
}


axios.get('/cart/' + businessid).then((res) =>{
  let r = res.data;
  if (r.code == 0) {
    for (const cart of r.data) {
      let food = foodList.value.find((item) => item.foodid == cart.foodid);
      if(food){
        food.quantity = cart.quantity;
        console.log(food.foodid + ' ' + food.quantity);
      }
    }
    updateCart();
  } else {
    alert(r.msg);
  }
})

// 返回上一页
function goback() {
  history.back();
}

function updateQuantity(food: FoodItem){
  let param = {
    businessid: businessid,
    foodid: food.foodid,
    quantity: food.quantity
  };
  axios.put('/cart/update', param).then(res => {
    let r = res.data;
    if (r.code == 0) {
      console.log('更新成功');
      updateCart();
    } else {
      alert(r.msg);
    }
  });

}

// 添加食品
function add(food: FoodItem) {
  if (!food) {
    console.log('食品为空');
  }
  // 加数量
  food.quantity++;
  // 发请求
  updateQuantity(food);


}

// 减少食品
function minus(food: FoodItem) {
  if (!food) {
    console.log('食品为空');
  }
  // 减数量
  food.quantity--;
  // 发请求
  updateQuantity(food);
}

// const showStarPrice = ref(false);
// showStarPrice.value = totalSettle.value < business.value?.starprice;

function toOrder() {
  console.log('结算');
}
</script>

<template>
  <div class="wrapper">
    <!-- header部分 -->
    <header>
      <i class="fa fa-angle-left" @click="goback()"></i>
      <p>商家信息</p>
    </header>

    <!-- 商家信息部分 -->
    <div class="business-img-info">
      <div class="business-info">
        <div class="title-collection">
          <h1>{{ business?.businessname }}
            <!-- <i class="fa fa-heart" id="showColor1"></i> -->
            <!-- <button v-if="collectId == 0" @click="Collect()">收藏</button> -->
            <!-- <button v-if="collectId !== 0" @click="UnCollect()">收藏</button> -->
          </h1>
        </div>

        <!-- 评分部分 -->
        <!--
        <div class="commentScore">
          <p>{{ business.avscore.toFixed(1) }}分</p>
          <div class="Rating-gray">
            <i v-for="(item, index) in itemClasses" :key="index" class="fa" :class="item"></i>
          </div>
        </div>
        -->

        <div class="business-info-detail">
          <p>&#165;{{ business?.starprice }}起送 &#165;{{ business?.deliveryprice }}配送</p>
          <p>{{ business?.businessexplain }}</p>
        </div>

      </div>
      <!-- 商家logo部分 -->
      <div class="business-logo">
        <img :src="business?.businessimg">
      </div>
    </div>

    <!-- 食品列表部分 -->
    <ul class="food">
      <li v-for="food in foodList" :key="food.foodid">
        <div class="food-left">
          <img :src="food.foodimg">
          <div class="food-left-info">
            <h3>{{ food.foodname }}</h3>
            <p>{{ food.foodexplain }}</p>
            <p>&#165;{{ food.foodprice }}</p>
          </div>
        </div>
        <div class="food-right">
          <div>
            <i class="fa fa-minus-circle" @click="minus(food)" v-show="food.quantity > 0"></i>
          </div>
          <p><span v-show="food.quantity > 0">{{ food.quantity }}</span></p>
          <div>
            <i class="fa fa-plus-circle" @click="add(food)"></i>
          </div>
        </div>
      </li>
    </ul>

    <!-- 购物车部分 -->
    <div class="cart">
      <div class="cart-left">
        <div class="cart-left-icon"
          :style="totalQuantity == 0 ? 'background-color:#505051;' : 'background-color:#3190E8;'">
          <i class="fa fa-shopping-cart"></i>
          <div class="cart-left-icon-quantity" v-show="totalQuantity != 0">
            {{ totalQuantity }}
          </div>
        </div>
        <div class="cart-left-info">
          <p>&#165;{{ totalPrice }}</p>
          <p>另需配送费{{ business?.deliveryprice }}元</p>
        </div>
      </div>
      <div class="cart-right">
        <!-- 不够起送费 -->
        <div class="cart-right-item" v-show="totalSettle < business?.starprice!"
          style="background-color: #535356;cursor: default;">
          &#165;{{ business?.starprice }}起送
        </div>
        <!-- 达到起送费 -->
        <div class="cart-right-item" @click="toOrder" v-show="totalSettle >= business?.starprice!">
          去结算
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/****总容器部分***/
.wrapper {
  width: 100%;
  height: 100%;
  background: linear-gradient(#0097FF, #fff);
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

/****商家logo和信息部分***/
.wrapper .business-img-info {
  width: 96%;
  height: 36vw;
  background-color: #fff;
  box-sizing: border-box;
  padding: 2vw;
  margin-left: 2vw;
  margin-top: 12vw;
  margin-bottom: 0.5vw;
  border-radius: 2.5px;

  display: flex;
  justify-content: center;
  align-items: center;

}

/****商家logo部分***/
.wrapper .business-img-info .business-logo {
  width: 100%;
  height: 35vw;
  padding-top: 20vw;
  margin-bottom: 24vw;
  display: flex;
  justify-content: right;
  align-items: center;
}

.wrapper .business-img-info .business-logo img {
  width: 40vw;
  height: 28vw;
  border-radius: 5px;

}

/****商家信息部分***/
.wrapper .business-img-info .business-info {
  width: 100%;
  height: 20vw;
  margin-bottom: 4vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.wrapper .business-img-info .business-info .title-collection {
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business-img-info .business-info .title-collection h1 {
  font-size: 5vw;
}

/* .wrapper .business-img-info .business-info .title-collection h1 .fa-heart{
		color: hotpink;
		user-select: none;
		cursor: pointer;
	} */
.wrapper .business-img-info .business-info .title-collection h1 button {
  font-size: 3.5vw;
  color: #fff;
  background-color: #AAA;
  border: none;
  cursor: pointer;
  user-select: none;
  border-radius: 2.5px;
}

.wrapper .business-img-info .business-info .title-collection h1 button2 {
  font-size: 3.5vw;
  color: #fff;
  background-color: #FAD;
  border: none;
  cursor: pointer;
  user-select: none;
  border-radius: 2.5px;
}

.wrapper .business-img-info .business-info .commentScore {
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business-img-info .business-info .commentScore p {
  color: coral;
  margin-right: 1vw;
  font-weight: 700;
  font-size: 3vw;
  margin-top: 1vw;
  /* margin-left: -10vw; */

}

.wrapper .business-img-info .business-info .commentScore .fa-star {
  color: #FEC80E;
  margin-right: 0.5vw;
  margin-top: 1vw;
}

.wrapper .business-img-info .business-info .commentScore .fa-star-half-empty {
  color: #FEC80E;
  margin-right: 0.5vw;
  margin-top: 1vw;
}

.wrapper .business-img-info .business-info .business-info-detail p {
  font-size: 3vw;
  color: #666;
  margin-top: 1vw;

  display: flex;
  justify-content: center;
  align-items: center;
}

/****点餐评价部分***/
.wrapper .order-and-comment {
  width: 96%;
  height: 8vw;

  margin-left: 2vw;
  padding: 2vw;
  box-sizing: border-box;
  border-radius: 2.5px 2.5px 0 0;
  background-color: #fff;
  display: flex;
  justify-content: space-around;
  align-items: center;

}

.wrapper .order-and-comment li {
  font-size: 3.5vw;
  color: #555;
}

.wrapper .order-and-comment .order {
  width: 32%;
  box-sizing: border-box;
  border-bottom: solid 2px #AAA;
  font-weight: 600;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .order-and-comment .comment {
  width: 32%;
  box-sizing: border-box;
  /* border-bottom: solid 1px #0097EF; */
  font-weight: 600;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .order-and-comment .shop {
  width: 32%;
  box-sizing: border-box;
  /* border-bottom: solid 1px #0097EF; */
  font-weight: 600;
  display: flex;
  justify-content: center;
  align-items: center;
}

/****食品列表部分***/
.wrapper .food {
  width: 96%;
  margin-left: 2vw;
  padding-bottom: 14vw;
  background-color: #fff;
  box-sizing: border-box;
  border-radius: 0 0 2.5px 2.5px;
}

.wrapper .food li {
  width: 100%;
  box-sizing: border-box;
  border-radius: 5px;
  padding: 2.5vw;
  user-select: none;

  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: solid 1px #DDD;
}

.wrapper .food li .food-left {
  display: flex;
  align-items: center;
}

.wrapper .food li .food-left img {
  width: 20vw;
  height: 20vw;
}

.wrapper .food li .food-left .food-left-info {
  margin-left: 3vw;
}

.wrapper .food li .food-left .food-left-info h3 {
  font-size: 3.8vw;
  color: #555;
}

.wrapper .food li .food-left .food-left-info p {
  font-size: 3vw;
  color: #888;
  margin-top: 2vw;
}

.wrapper .food li .food-right {
  width: 16vw;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .food li .food-right .fa-minus-circle {
  font-size: 5.5vw;
  color: #999;
  cursor: pointer;
}

.wrapper .food li .food-right p:last-child {
  font-size: 3.6vw;
  color: #333;
}

.wrapper .food li .food-right .fa-plus-circle {
  font-size: 5.5vw;
  color: #0097EF;
  cursor: pointer;
}

/****购物车部分***/
.wrapper .cart {
  width: 100%;
  height: 14vw;

  position: fixed;
  left: 0;
  bottom: 0;

  display: flex;
}

.wrapper .cart .cart-left {
  flex: 2;
  background-color: #505051;
  display: flex;
}

.wrapper .cart .cart-left .cart-left-icon {
  width: 16vw;
  height: 16vw;
  box-sizing: border-box;
  border: solid 1.6vw #444;
  border-radius: 8vw;
  background-color: #3190E8;
  font-size: 7vw;
  color: #fff;

  display: flex;
  justify-content: center;
  align-items: center;

  margin-top: -4vw;
  margin-left: 3vw;
  position: relative;
}

.wrapper .cart .cart-left .cart-left-icon-quantity {
  width: 5vw;
  height: 5vw;
  border-radius: 2.5vw;
  background-color: red;
  color: #fff;

  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 3.6vw;

  position: absolute;
  right: -1.5vw;
  top: -1.5vw;
}

.wrapper .cart .cart-left .cart-left-info p:first-child {
  color: #fff;
  margin-top: 1vw;
  font-size: 4.5vw;
}

.wrapper .cart .cart-left .cart-left-info p:last-child {
  font-size: 2.8vw;
  color: #AAA;
}

.wrapper .cart .cart-right {
  flex: 1;

}

/****达到起送费时的样式****/
.wrapper .cart .cart-right .cart-right-item {
  width: 100%;
  height: 100%;
  background-color: #38CA73;
  color: #fff;
  font-size: 4.5vw;
  font-weight: 700;
  user-select: none;
  cursor: pointer;

  display: flex;
  justify-content: center;
  align-items: center;
}


.Rating-gray {
  margin-right: 1.066667vw;
  color: #ffbe00;
  display: inline-block;
}

/****不够起送费时的样式****/
/* .wrapper .cart .cart-right .cart-right-item{
		width: 100%;
		height: 100%;
		background-color: #535356;
		color:#fff;
		font-size: 4.5vw;
		font-weight: 700;
		user-select: none;
		
		
		display: flex;
		justify-content: center;
		align-items: center;
	} */
</style>
